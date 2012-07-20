package com.nzonly.tb.persistence;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午8:57:20
 * @version V1.0
 */
@Component
public class BaseDao extends SqlSessionDaoSupport {

	/**
	 * 根据数据库ID获取唯一记录
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param id
	 *            主键
	 * @return 唯一记录
	 */
	@SuppressWarnings("unchecked")
	public <T> T getById(String key, Serializable id) {
		return (T) getSqlSession().selectOne(key, id);
	}

	/**
	 * 插入新记录到数据库
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param params
	 *            数据库字段数据
	 */
	public int insert(String key, Object params) {
		return getSqlSession().insert(key, params);
	}

	/**
	 * 插入新记录到数据库
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param params
	 *            数据库字段数据，生成的sql_map中有现成的更新语句可以自动判断为空的值，跟据主ID进行少量参数修改。这样可以少传参数提高开发效率和性能
	 */
	public int update(String key, Object params) {
		return getSqlSession().update(key, params);
	}

	/**
	 * 根据条件查询唯一记录，如根据ID查询记录详情等操作
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param params
	 *            查询参数
	 * @return 唯一记录
	 */
	@SuppressWarnings("unchecked")
	public <T> T getOne(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}

	/**
	 * 获取多条数据
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param params
	 *            查询参数
	 * @return 多条数据集
	 */
	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}

	/**
	 * 无参数获取多条数据
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @return 多条数据集
	 */
	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	/**
	 * 根据数据库主键ID删除数据库记录
	 * 
	 * @param key
	 *            mapper中sql语句对应的ID
	 * @param id
	 *            数据库主键
	 */
	public int delete(String key, Serializable id) {
		return getSqlSession().delete(key, id);
	}

	public long getTotalCount() {
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = getSqlSession().getConnection().prepareStatement("select found_rows()");
			st.execute();
			rs = st.getResultSet();
			rs.next();
			return rs.getLong(1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				// ignore
			}
		}

	}

}
