package com.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SysRole extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;//角色名称
	//一个角色对应哪些用户
	private Set<SysUser> sysUserSet = new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade={CascadeType.REFRESH})
	@JoinTable(name="sys_user_role",
		joinColumns={
			@JoinColumn(name = "role_id",referencedColumnName="id")
		},
		inverseJoinColumns ={//关联的
			@JoinColumn(name="user_id",referencedColumnName="id",updatable=false)
	})
	public Set<SysUser> getSysUserSet() {
		return sysUserSet;
	}
	public void setSysUserSet(Set<SysUser> sysUserSet) {
		this.sysUserSet = sysUserSet;
	}
}
