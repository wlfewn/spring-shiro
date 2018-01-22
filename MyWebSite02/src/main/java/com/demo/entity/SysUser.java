package com.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



/**
 * 系统用户类<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
@Entity
public class SysUser extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	
	private String username;//用户名
	private String password;//密码
	private String loginIp;//最后登陆ip
	private Date loginDate;//最后登陆时间
	private boolean loginStatus;//是否可登陆,true可以,false不可以
	private String remarks;//信息备注
	//一个用户，拥有哪些角色
	//private Set<SysRole> roleSet = new HashSet<>();//用户对应角色
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	//配置用户与角色多对多查询
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="sys_user_role",
//		joinColumns={
//			@JoinColumn(name = "user_id",referencedColumnName="id")
//		},
//		inverseJoinColumns ={//关联的
//			@JoinColumn(name="role_id",referencedColumnName="id",updatable=false)
//	})
//	public Set<SysRole> getRoleSet() {
//		return roleSet;
//	}
//	public void setRoleSet(Set<SysRole> roleSet) {
//		this.roleSet = roleSet;
//	}
}
