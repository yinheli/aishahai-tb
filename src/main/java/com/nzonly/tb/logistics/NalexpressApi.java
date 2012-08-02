package com.nzonly.tb.logistics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.taobao.api.internal.util.WebUtils;

/**
 * 新西兰新亚物流
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-3 上午12:20:01
 * @version V1.0
 */
@Component
public class NalexpressApi implements LogisticsApi {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String API_URI = "http://www.nalexpress.co.nz/customer/search";
	
	/**
	 * 连接超时(毫秒)
	 */
	private static final int CONNECTION_TIMEOUT = 5000;
	
	/**
	 * 读取超时(毫秒)
	 */
	private static final int READ_TIMEOUT = 80000;
	
	/**
	 * 追踪运单号
	 * 
	 * 通过 HTTP 请求解析网页, 获取结果. 这是一个比较费时的操作
	 * 谨慎使用
	 * 
	 * @param outId
	 * @return
	 * @throws IOException
	 * @author yinheli
	 * @date 2012-8-3 上午12:23:01
	 */
	@Override
	public String trace(String outId) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("code", outId);
		String result = WebUtils.doPost(API_URI, param, CONNECTION_TIMEOUT, READ_TIMEOUT);

		Document doc = Jsoup.parse(result);
		Elements es = doc.select("table.list tbody");
		
		if (es == null || es.isEmpty()) {
			log.warn("新西兰新亚物流 -- 运单号:{}, 没有找到匹配的数据", outId);
			return null;
		}
		return es.text();
	}
	
	/**
	 * @see com.nzonly.tb.logistics.LogisticsApi#isCustomsPass(java.lang.String)   
	 */
	@Override
	public boolean isCustomsPass(String trace) {
		return trace.indexOf("清关完毕") > 0;
	}

}
