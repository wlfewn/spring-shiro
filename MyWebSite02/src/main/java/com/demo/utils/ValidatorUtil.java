package com.demo.utils;

import org.springframework.util.StringUtils;

/**
 * 系统验证工具类<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
public class ValidatorUtil {

	/**
	 * 验证null类型或者空字符串
	 * @param value
	 * @return true 有一项为验证不通过 | false 全部通过
	 */
	public static boolean ValidateEmpty(String... value){
		for (String str : value) {
			if( StringUtils.isEmpty(str)){
				return true;
			}
		}
		return false;
	}
	
}
