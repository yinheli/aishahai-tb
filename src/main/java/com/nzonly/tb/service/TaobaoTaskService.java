package com.nzonly.tb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.entity.TaobaoTask;
import com.nzonly.tb.persistence.BaseDao;
import com.nzonly.tb.service.exception.DbServiceException;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午10:11:44
 * @version V1.0
 */
@Component
@Transactional(readOnly = true)
public class TaobaoTaskService {
	
	@Autowired
	private BaseDao dao;
	
	/**
	 * 通过任务id获取任务
	 * 
	 * @param taskId
	 * @return
	 * @author yinheli
	 * @date 2012-7-21 下午10:13:47
	 */
	public TaobaoTask getByTaskId(Long taskId) {
		return dao.getOne("TaobaoTask.selectByPrimaryKey", taskId);
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(TaobaoTask task) {
		if ((Long)dao.getOne("TaobaoTask.countTaskByTaskId", task.getTaskId()) > 0) {
			dao.update("TaobaoTask.updateByPrimaryKeySelective", task);
		} else {
			save(task);
		}
	}
	
	@Transactional(readOnly = false)
	public void save(TaobaoTask task) {
		dao.insert("TaobaoTask.insertSelective", task);
	}
	
	@Transactional(readOnly = false)
	public void update(TaobaoTask task) {
		if ((Long)dao.getOne("TaobaoTask.countTaskByTaskId", task.getTaskId()) > 0) {
			dao.update("TaobaoTask.updateByPrimaryKeySelective", task);
		} else {
			throw new DbServiceException("task id not found! update fail!");
		}
	}

	/**
	 * 分页获取
	 * 
	 * @param pageRequest
	 * @return
	 * @author yinheli
	 * @date 2012-7-22 上午10:50:07
	 */
	public Page<TaobaoTask> getByPage(PageRequest pageRequest) {
		return dao.getByPage("TaobaoTask.getByPage", pageRequest);
	}

}
