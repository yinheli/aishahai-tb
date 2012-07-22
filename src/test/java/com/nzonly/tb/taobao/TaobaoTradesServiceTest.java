package com.nzonly.tb.taobao;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午4:31:45
 * @version V1.0
 */
public class TaobaoTradesServiceTest extends BaseTestNoWeb implements TestConstants {
	
	@Autowired
	private TaobaoTradesService service;
	
	/**
	 * 提交异步查询任务
	 * 
	 * @throws Exception
	 * @author yinheli
	 * @date 2012-7-21 下午11:03:03
	 */
	@Test
	@Rollback(false)
	public void testTopatsTradesSoldGet() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		service.topatsTradesSoldGet(sdf.parse("20120716"), sdf.parse("20120720"), session);
	}
	
	/**
	 * 查询异步任务结果
	 * 
	 * @throws Exception
	 * @author yinheli
	 * @date 2012-7-21 下午11:03:15
	 */
	@Test
	@Rollback(false)
	public void testTopatsTesultGet() throws Exception {
		System.out.println(service.topatsTesultGet(32142490L));
	}
	
	@Test
	public void testFullinfoGet() throws Exception {
		service.fullinfoGet(197520245908547L, session);
	}

}
