package com.nzonly.tb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nzonly.tb.entity.User;
import com.nzonly.tb.persistence.BaseDao;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午10:31:40
 * @version V1.0
 */
@Component
public class UserService {
	
	@Autowired
	private BaseDao dao;
	
	public User getByUid(String uid) {
		return dao.getOne("user.getByUid", uid);
	}

}
