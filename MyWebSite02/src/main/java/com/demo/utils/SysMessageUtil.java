package com.demo.utils;

import com.demo.message.Status;
import com.demo.message.SysMessage;

/**
 * 系统内消息的工厂方法<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
public class SysMessageUtil {
	
	public static SysMessage success(String message){
		return new SysMessage(Status.success, message);
	}
	
	public static SysMessage error(String message){
		return new SysMessage(Status.danger, message);
	}
	
	public static boolean matchSuccess(SysMessage sysMessage){
		return sysMessage.getStatus().equals(Status.success);
	}
	
	public static boolean matchError(SysMessage sysMessage){
		return sysMessage.getStatus().equals(Status.danger);
	}
	
}
