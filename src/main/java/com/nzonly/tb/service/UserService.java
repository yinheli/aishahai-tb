package com.nzonly.tb.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.entity.User;
import com.nzonly.tb.persistence.BaseDao;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午10:31:40
 * @version V1.0
 */
@Component
@Transactional(readOnly = true)
public class UserService {
	
	@Autowired
	private BaseDao dao;
	
	public User getByUid(String uid) {
		return dao.getOne("User.getByUid", uid);
	}
	
	public User getByAuthUserId(String authUserId, String from) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("authUserId", authUserId);
		param.put("from", from);
		return dao.getOne("User.getByAuthUserId", param);
	}

	/**
	 * @param user
	 * @author yinheli
	 * @date 2012-7-21 下午3:03:08
	 */
	@Transactional(readOnly = false)
	public void save(User user) {
		if (user.getId() == null) {
			dao.insert("User.insertSelective", user);
		} else {
			dao.update("User.updateByPrimaryKeySelective", user);
		}
	}

}
