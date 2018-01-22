package com.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.demo.entity.SysUser;

/**
 * 使用spring data-jpa自动创建sql语句<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
@Component
public interface SysUserDao extends JpaRepository<SysUser, String>{
	
	/**
	 * 通过用户名查找
	 * @param userName
	 * @return
	 */
	SysUser findByUsername(String userName);
	
	
}
