package com.nzonly.tb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.entity.TaobaoTrade;
import com.nzonly.tb.persistence.BaseDao;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-22 上午11:11:47
 * @version V1.0
 */
@Component
@Transactional(readOnly = true)
public class TaobaoTradeService {
	
	@Autowired
	private BaseDao dao;
	
	public Page<TaobaoTrade> getByPage(PageRequest pageRequest) {
		return dao.getByPage("TaobaoTrade.getByPage", pageRequest);
	}

	/**
	 * @param tid
	 * @return
	 * @author yinheli
	 * @date 2012-7-29 下午11:42:21
	 */
	public TaobaoTrade getByTid(Long tid) {
		return dao.getOne("TaobaoTrade.getByTid", tid);
	}

	/**
	 * @param trade
	 * @author yinheli
	 * @date 2012-7-29 下午11:44:30
	 */
	@Transactional(readOnly = false)
	public void update(TaobaoTrade trade) {
		dao.update("TaobaoTrade.updateByPrimaryKeySelective", trade);
	}

	/**
	 * @param trade
	 * @author yinheli
	 * @date 2012-7-29 下午11:46:18
	 */
	@Transactional(readOnly = false)
	public void save(TaobaoTrade trade) {
		dao.insert("TaobaoTrade.insertSelective", trade);
	}

}
