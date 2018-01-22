package com.demo.message;


/**
 * ajax请求返回页面的数据<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
public class AjaxSysMessage {
	
	public AjaxSysMessage(String url, SysMessage sysMessage) {
		super();
		this.url = url;
		this.sysMessage = sysMessage;
	}

	private String url; //ajax处理成功后需要访问的url,可以为null
	private SysMessage sysMessage;//系统消息
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SysMessage getSysMessage() {
		return sysMessage;
	}

	public void setSysMessage(SysMessage sysMessage) {
		this.sysMessage = sysMessage;
	}
}
