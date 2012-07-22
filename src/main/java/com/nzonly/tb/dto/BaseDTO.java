package com.nzonly.tb.dto;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午1:44:15
 * @version V1.0
 */
public abstract class BaseDTO {
	
	public void copyProperties(Object dest) {
		try {
			BeanUtils.copyProperties(dest, this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * toString 
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
