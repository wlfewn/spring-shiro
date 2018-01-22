package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.demo.dao.SysUserDao;
import com.demo.entity.SysUser;
import com.demo.message.Status;
import com.demo.message.SysMessage;
import com.demo.utils.SysMessageUtil;
import com.demo.utils.ValidatorUtil;

/**
 * service层,使用事务<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
//默认事务只读
@Service
@Transactional(readOnly=true)
public class SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder; //加密算法类
	
	/**
	 * 用户登陆
	 * @return
	 */
	public SysMessage login(SysUser sysUser){
		//参数验证
		boolean result = ValidatorUtil
				.ValidateEmpty(sysUser.getPassword(),sysUser.getPassword());
		if(result){
			return SysMessageUtil.error("用户名或密码错误");
		}
		//查找用户
		SysUser findSysUser = sysUserDao.findByUsername(sysUser.getUsername());
		if( null == findSysUser ){
			return SysMessageUtil.error("查无此用户名");
		}
		//验证密码,加密前与加密后
		if(cryptPasswordEncoder.matches(sysUser.getPassword(),findSysUser.getPassword()))
			return SysMessageUtil.success("登陆成功");
		else
			return SysMessageUtil.error("用户名或密码错误");
	}
	
	/**
	 * 用户注册
	 * @param sysUser
	 * @return
	 */
	@Transactional(readOnly=false)
	public SysMessage regiset(SysUser sysUser){
		//验证用户名或密码为空
		if( StringUtils.isEmpty(sysUser.getUsername()) 
				|| StringUtils.isEmpty(sysUser.getPassword()) ){
			return new SysMessage(Status.danger, "用户名或者错误");
		}
		//用户名存在不允许注册
		SysUser findSysUser = sysUserDao.findByUsername(sysUser.getUsername());
		if( null != findSysUser ){
			return new SysMessage(Status.danger, "用户名已存在");
		}
		//密码加密
		String entryPwd = cryptPasswordEncoder.encode(sysUser.getPassword());
		sysUser.setPassword(entryPwd);
		sysUserDao.save(sysUser);
		
		return new SysMessage(Status.success, "注册成功");
	}
	
	/**
	 * 查找全部用户
	 * @return
	 */
	public List<SysUser> findAll(){
		return sysUserDao.findAll();
	}
}
