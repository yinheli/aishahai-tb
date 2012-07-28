package com.nzonly.tb.persistence;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

	/**
	 * 分页查询
	 * 
	 * @param statementId Mapper id
	 * @param pageRequest 分页请求
	 * @param param 参数
	 * @return
	 * @author yinheli
	 * @param param2 
	 * @date 2012-7-26 下午2:59:07
	 */
	public <T> Page<T> getByPage(String statementId, PageRequest pageRequest, Object param) {
		PageRowBounds rb = new PageRowBounds(pageRequest.getOffset(), pageRequest.getPageSize());
		List<T> list = getSqlSession().selectList(statementId, param, rb);
		return new PageImpl<T>(list, pageRequest, rb.getTotal());
	}
	
	/**
	 * 分页查询
	 * 
	 * @param statementId
	 * @param pageRequest
	 * @return
	 * @author yinheli
	 * @date 2012-7-27 上午9:39:30
	 */
	public <T> Page<T> getByPage(String statementId, PageRequest pageRequest) {
		return getByPage(statementId, pageRequest, null);
	}

}
