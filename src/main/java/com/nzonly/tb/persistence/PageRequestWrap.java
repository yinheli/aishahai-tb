package com.nzonly.tb.persistence;

import org.springframework.data.domain.PageRequest;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-7-26 下午10:19:51
 * @version V1.0
 */
public class PageRequestWrap {
	
	public PageRequest pageRequest;
	
	public Object param;
	
	public long total;

	public PageRequestWrap(PageRequest pageRequest, Object param) {
		this.pageRequest = pageRequest;
		this.param = param;
	}

}
