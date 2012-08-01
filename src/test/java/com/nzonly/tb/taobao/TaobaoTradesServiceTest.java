package com.nzonly.tb.taobao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	 * 搜索当前会话用户作为卖家已卖出的交易数据 
	 * 
	 * @throws Exception
	 * @author yinheli
	 * @date 2012-7-24 上午7:23:44
	 */
	@Test
	@Rollback(false)
	public void testTradesSoldGet() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sdf.parse("2012-07-21 00:00:00");
		Date end =  sdf.parse("2012-07-29 23:59:59");
		PageRequest page = new PageRequest(0, 40);
		service.tradesSoldGet(start, end, page, session);
	}
	
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
		System.out.println(service.topatsTesultGet(33042787L));
	}
	
	@Test
	public void testFullinfoGet() throws Exception {
		service.fullinfoGet(144424580058621L, session);
	}

}
