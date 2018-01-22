package com.demo.message;

/**
 * 系统信息<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
public class SysMessage {
	
	private Status status;//枚举类型
	private String message;//内容
	
	public SysMessage() {
		super();
	}

	public SysMessage(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
