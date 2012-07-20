package com.nzonly.tb.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午9:50:47
 * @version V1.0
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6957202135701792873L;
	
	/**
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
