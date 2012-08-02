package com.nzonly.tb.logistics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.taobao.api.internal.util.WebUtils;

/**
 * 程光快递, API
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-2 下午11:47:18
 * @version V1.0
 */
@Component
public class FlywayApi implements LogisticsApi {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * HTML 运单结果正则
	 */
	private static final Pattern MAIN_HTML_RESULT_PATTERN = Pattern.compile("的查询结果:\\s</b>(.*)感谢您使用程光快递服务");
	
	/**
	 * HTML TAG 正则
	 */
	private static final String HTML_TAG_REG = "<[^>]+>";
	
	private static final String HTML_SPACE = "(&nbsp;)*";
	
	private static final String API_URI = "http://www.flyway.co.nz/?p=5";
	
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
	 * @param outId 运单号
	 * @return 网页提取的运单结果
	 * @author yinheli
	 * @throws IOException 
	 * @date 2012-8-2 下午11:48:44
	 */
	@Override
	public String trace(String outId) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("shipping_code", outId);
		String result = WebUtils.doPost(API_URI, param, CONNECTION_TIMEOUT, READ_TIMEOUT);
		
		Matcher matchHTML = MAIN_HTML_RESULT_PATTERN.matcher(result);
		String traceHTML = null;
		if (matchHTML.find()) {
			traceHTML = matchHTML.group(1);
		} else {
			log.warn("运单号:{}, 没有找到匹配的数据", outId);
			return null;
		}
		
		String trace = traceHTML.replaceAll(HTML_TAG_REG, "").replaceAll(HTML_SPACE, "");
		
		return StringUtils.trimToNull(trace);
	}
	
	/**
	 * @see com.nzonly.tb.logistics.LogisticsApi#isCustomsPass(java.lang.String)   
	 */
	@Override
	public boolean isCustomsPass(String trace) {
		return trace.indexOf("取货成功") > 0;
	}

}
