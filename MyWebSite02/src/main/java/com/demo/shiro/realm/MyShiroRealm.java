package com.demo.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.dao.SysMenuDao;
import com.demo.dao.SysRoleDao;
import com.demo.dao.SysUserDao;
import com.demo.entity.SysRole;
import com.demo.entity.SysUser;


/**
 * shiro 自定义授权机制
 * (1)、使用Subject currentUser = SecurityUtils.getSubject()获取,  
 * 调用currentUser.login之后，
 * shiro会将token传递给自定义realm,
 * 此时realm会先调用doGetAuthenticationInfo(AuthenticationToken authcToken )登录验证的方法，
 * 验证通过后会接着调用 doGetAuthorizationInfo(PrincipalCollection principals)获取角色和权限的方法（授权），
 * 最后返回视图。   
 * (2)、当其他请求进入shiro时，
 * shiro会调用doGetAuthorizationInfo(PrincipalCollection principals)去获取授权信息，
 * 若是没有权限或角色，会跳转到未授权页面，若有权限或角色，shiro会放行，ok，此时进入真正的请求方法……
 * 到此shiro的认证及授权便完成了
 */
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private SysUserDao sysUserDao;//用户
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;//加密算法
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 因为在正常情况下，如果在方法上面加了@RequiresPermissions（“XXXX”）注释，
	 * 系统会直接进入doGetAuthorizationInfo方法进行权限验证，
	 * 如果没有权限，那么就会抛出 org.apache.shiro.authz.UnauthorizedException: Subject does not have permission异常
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		String userName = (String) getAvailablePrincipal(principals);
		//通过用户名获得用户的所有资源，并把资源存入info中通过用户名获得用户的所有资源，并把资源存入info中
		//通过用户名获取用户
		SysUser sysUser = sysUserDao.findByUsername(userName);
		if( null == sysUser ){//用户未找到
			return null;
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
		info.setRoles(sysRoleDao.findUserRole(userName));
		//获取用户权限
		info.setStringPermissions(sysMenuDao.findUserPermission(sysUser.getId()));
		
		return info;
	}

	/**
	 * 这是认证方法,currentUser.login 登陆时调用这个方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		//获得用户名与密码  
	    String userName = upToken.getUsername();  
	    String password = String.valueOf(upToken.getPassword());
		//根据用户名查找用户
		SysUser sysUser = sysUserDao.findByUsername(userName);
		if( null == sysUser ){
			throw new AuthenticationException("用户名不存在");
		}
		
		//匹配密码,成功返回true
		if(!bCryptPasswordEncoder.matches(password, sysUser.getPassword()) ){
			throw new AuthenticationException("用户名密码不匹配"); 
		}
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = 
				new SimpleAuthenticationInfo(userName, password,this.getName());
		
		return simpleAuthenticationInfo;
	}

}
