package com.nzonly.tb.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.FastResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 分页插件 (支持 oracle 和 mysql)
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-26 下午4:45:44
 * @version V1.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args={Connection.class}),
	@Signature(type = StatementHandler.class, method = "query", args={Statement.class, ResultHandler.class}),
	@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PagePlugin implements Interceptor {

	private Dialect dialect;

	/**
	 * 拦截器实现
	 * 
	 * 在调用 prepare, query 方法前拦截 
	 * 1, 修改内置 SQL, 添加分页SQL
	 * 2, 在 Query 之后查询总数
	 * intercept 
	 */
	@Override
	public Object intercept(Invocation iv) throws Throwable {

		String method = iv.getMethod().getName();

		if (method.equals("handleResultSets")) {
			FastResultSetHandler fsh = (FastResultSetHandler) iv.getTarget();
			MetaObject fshMeta = MetaObject.forObject(fsh);
			RowBounds rb = (RowBounds) fshMeta.getValue("rowBounds");
			if (rb instanceof PageRowBounds) {
				MetaObject rbMeta = MetaObject.forObject(rb);
				rbMeta.setValue("offset", RowBounds.NO_ROW_OFFSET);
				rbMeta.setValue("limit", RowBounds.NO_ROW_LIMIT);
				fshMeta.setValue("rowBounds", rb);
				return iv.proceed();
			}
			return iv.proceed();
		}

		StatementHandler sh = (StatementHandler) iv.getTarget();
		Object result = null;
		MetaObject shMeta = MetaObject.forObject(sh);
		ParameterHandler dph = (ParameterHandler) shMeta.getValue("delegate.parameterHandler");

		RowBounds rb = (RowBounds) shMeta.getValue("delegate.rowBounds");


		if (!(rb instanceof PageRowBounds)) {
			return iv.proceed();
		}

		PageRowBounds prb = (PageRowBounds) rb;
		BoundSql boundSql = sh.getBoundSql();
		if (method.equals("prepare")) {
			String sql = boundSql.getSql();
			prb.setOriSQL(sql);
			prb.setConnection((Connection) iv.getArgs()[0]);
			prb.setParameterHandler(dph);
			shMeta.setValue("delegate.boundSql.sql", 
					dialect.getLimitSqlString(sql, (long)prb.getOffset(), (long)prb.getLimit()));
			result = iv.proceed();
		} else {
			result = iv.proceed();
			prb.setTotal(dialect.getTotal(prb.getOriSQL(), prb.getConnection(), prb.getParameterHandler()));
		}

		return result;
	}

	/**
	 * plugin 
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * setProperties 
	 */
	@Override
	public void setProperties(Properties properties) {
		String dialectConf = properties.getProperty("dialect", Dialect.MySQL);
		if (dialectConf.equals(Dialect.MySQL)) {
			dialect = new MySQLDialect();
		} else if (dialectConf.equals(Dialect.Oracle)) {
			dialect = new OracleDialect();
		}
	}

	private interface Dialect {
		String MySQL = "MySQL";
		String Oracle = "Oracle";

		String getLimitSqlString(String sql, Long offset, Long size);

		long getTotal(String sql, Connection connection,
				ParameterHandler dph);
	}

	private class MySQLDialect implements Dialect {

		@Override
		public String getLimitSqlString(String sql, Long offset, Long size) {
			StringBuilder sb = new StringBuilder();
			sb.append(sql).append(" limit ").append(offset).append(", ").append(size);
			return sb.toString();
		}

		@Override
		public long getTotal(String sql, Connection connection,
				ParameterHandler dph) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = connection.prepareStatement("select found_rows()");
				ps.execute();
				rs = ps.getResultSet();
				rs.next();
				return rs.getLong(1);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	private class OracleDialect implements Dialect {

		@Override
		public String getLimitSqlString(String sql, Long offset, Long size) {
			sql = sql.trim();
			boolean isForUpdate = false;
			if ( sql.toLowerCase().endsWith(" for update") ) {
				sql = sql.substring( 0, sql.length()-11 );
				isForUpdate = true;
			}

			StringBuilder sb = new StringBuilder( sql.length()+100 );
			sb.append("select * from ( select page_.*, rownum rownum_ from ( ");
			sb.append(sql);
			sb.append(" ) page_ ) where rownum_ < ").append(offset + size).append(" and rownum_ >= ").append(offset);

			if ( isForUpdate ) {
				sb.append( " for update" );
			}

			return sb.toString();
		}

		@Override
		public long getTotal(String sql, Connection connection,
				ParameterHandler dph) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("select count(0) from (").append(sql).append(")");
				ps = connection.prepareStatement(sb.toString());
				dph.setParameters(ps);
				ps.execute();
				rs = ps.getResultSet();
				rs.next();
				return rs.getLong(1);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}
}