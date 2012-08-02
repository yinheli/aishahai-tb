package com.nzonly.tb.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import com.nzonly.tb.entity.Logistics;
import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-1 下午11:42:02
 * @version V1.0
 */
public class LogisticsServiceTest extends BaseTestNoWeb {
	@Autowired
	private LogisticsService logisticsService;
	
	/**
	 * 测试分页获取
	 * 
	 * @throws Exception
	 * @author yinheli
	 * @date 2012-8-1 下午11:45:08
	 */
	@Test
	public void testGetbyPage() throws Exception {
		logisticsService.getByPage(new PageRequest(0, 10));
	}
	
	/**
	 * 测试更新或保存
	 * 
	 * @throws Exception
	 * @author yinheli
	 * @date 2012-8-1 下午11:45:16
	 */
	@Test
	@Rollback(false)
	public void testSaveOrUpdate() throws Exception {
		Logistics logistics = new Logistics();
		logistics.setTid(1L);
		logistics.setCompanyName("测试专用");
		logistics.setItemTitle("测试物品, 小心轻放");
		logisticsService.saveOuUpdate(logistics);
	}

}
