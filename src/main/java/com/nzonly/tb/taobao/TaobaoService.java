package com.nzonly.tb.taobao;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nzonly.tb.service.TaobaoTaskService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午4:26:01
 * @version V1.0
 */
@Component
public class TaobaoService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${app.reset_uri}")
	protected String appResetUri;
	
	@Value("${app.key}")
	protected String appKey;
	
	@Value("${app.secret}")
	protected String appSecret;
	
	protected final TaobaoClient client = new DefaultTaobaoClient(appResetUri, appKey, appSecret);
	
	@Autowired
	protected TaobaoTaskService taskService;
	
	protected String dump(Object obj) {
		return ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE);
	}

}
