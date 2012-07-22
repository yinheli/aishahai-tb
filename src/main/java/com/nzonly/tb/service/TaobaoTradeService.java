package com.nzonly.tb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
		List<TaobaoTrade> list = dao.getList("TaobaoTrade.getByPage", pageRequest);
		return new PageImpl<TaobaoTrade>(list, pageRequest, dao.getTotalCount());
	}

}
