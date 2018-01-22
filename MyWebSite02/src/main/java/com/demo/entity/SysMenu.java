package com.demo.entity;

import javax.persistence.Entity;


@Entity
public class SysMenu extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String permission;//权限
	private String href;//跳转链接
	private String name;//菜单名称
	
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
