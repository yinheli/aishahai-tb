package com.nzonly.tb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.persistence.BaseDao;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午2:09:16
 * @version V1.0
 */
@Component
@Transactional(readOnly = true)
public class AuthInfoService {
	
	@Autowired
	private BaseDao dao;
	
	public AuthInfo getById(Long id) {
		return dao.getById("AuthInfo.selectByPrimaryKey", id);
	}
	
	public AuthInfo getByTaobaoUserId(String taobaoUserId) {
		return dao.getOne("AuthInfo.getByTaobaoUserId", taobaoUserId);
	}

	/**
	 * @param info
	 * @author yinheli
	 * @date 2012-7-21 下午2:19:36
	 */
	@Transactional(readOnly = false)
	public void save(AuthInfo info) {
		if (info.getId() == null) {
			dao.insert("AuthInfo.insertSelective", info);
		} else {
			dao.update("AuthInfo.updateByPrimaryKeySelective", info);
		}
	}

}
