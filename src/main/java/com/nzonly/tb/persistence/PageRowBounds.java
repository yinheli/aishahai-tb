package com.nzonly.tb.persistence;

import java.sql.Connection;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-7-27 下午10:28:37
 * @version V1.0
 */
public class PageRowBounds extends RowBounds {

	private long total;

	private String oriSQL;

	private Connection connection;

	private ParameterHandler parameterHandler;

	public PageRowBounds() {
		super();
	}

	public PageRowBounds(int offset, int limit) {
		super(offset, limit);
	}

	/**
	 * @return
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total set total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * get oriSQL
	 * @return  oriSQL
	 */
	public String getOriSQL() {
		return oriSQL;
	}

	/**
	 * @param oriSQL set oriSQL
	 */
	public void setOriSQL(String oriSQL) {
		this.oriSQL = oriSQL;
	}

	/**
	 * get connection
	 * @return  connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection set connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * get parameterHandler
	 * @return  parameterHandler
	 */
	public ParameterHandler getParameterHandler() {
		return parameterHandler;
	}

	/**
	 * @param parameterHandler set parameterHandler
	 */
	public void setParameterHandler(ParameterHandler parameterHandler) {
		this.parameterHandler = parameterHandler;
	}

}
