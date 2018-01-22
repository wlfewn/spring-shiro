package com.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demo.entity.SysUser;
import com.demo.message.AjaxSysMessage;
import com.demo.message.Status;
import com.demo.message.SysMessage;
import com.demo.service.SysUserService;
import com.demo.utils.SysMessageUtil;

/**
 * 登陆controller<br>
 * <b>公众号"夜说时间鱼"提供</b>
 */
@Controller
public class LoginController extends BaseController{

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 到首页
	 */
	@RequestMapping(value="/index")
	public String index(SysMessage sysMessage,Model model){
		model.addAttribute("sysMessage", sysMessage);
		return "index";
	}
	
	/**
	 * 去注册页面
	 * @return
	 */
	@RequestMapping(value="/register")
	public String register(){
		return "register";
	}
	
	/**
	 * 登陆成功
	 * @return
	 */
	@RequiresPermissions("user:base:view")
	@RequestMapping(value="/success")
	public String success(Model model){
		List<SysUser> sysUserList = sysUserService.findAll();
		model.addAttribute("sysUserList", sysUserList);
		return "success";
	} 
	
	/**
	 * 用户登陆处理
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody//返回json数据，spring会自动把实体类转成json数据
	public AjaxSysMessage login(HttpServletRequest request,SysUser sysUser){

		String username = sysUser.getUsername();
		String password = sysUser.getPassword();
		SysMessage sysMessage = null;
	    String url = request.getRequestURI();
	    
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		token.setRememberMe(false);  
		//获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject(); 
        //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
        //所以这一步在调用login(token)方法时,它会走到自定义realm的doGetAuthenticationInfo()方法中
        try { 
        	currentUser.login(token);
        	 //登录认证通过
            if(currentUser.isAuthenticated()){
            	url = url.replace("/login", "/success");//登陆成功访问链接
            	sysMessage = SysMessageUtil.success("登陆认证成功");
            }else{  
                token.clear();  
            } 
        }catch(UnknownAccountException uae){
        	log.error( username + ",未知账户");
        	sysMessage = SysMessageUtil.error("未知账户");
        }catch(IncorrectCredentialsException ice){  
        	log.error( username + ",密码不正确");
        	sysMessage = SysMessageUtil.error("密码不正确");
        }catch(LockedAccountException lae){ 
        	log.error( username + ",账户已锁定");
        	sysMessage = SysMessageUtil.error("账户已锁定");
        }catch(ExcessiveAttemptsException eae){  
        	log.error( username + ",用户名或密码错误次数过多");
        	sysMessage = SysMessageUtil.error("用户名或密码错误次数过多");
        }catch(AuthenticationException ae){  
        	//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景 
        	log.error(username + ",进行登录验证..验证未通过,堆栈轨迹如下",ae);
        	sysMessage = SysMessageUtil.error("用户名或密码不正确");
        }
        return new AjaxSysMessage(url, sysMessage);
	}
	
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/registerUser")
	public String register(SysUser sysUser,Model model){
		SysMessage sysMessage = sysUserService.regiset(sysUser);
		//注册成功,返回首页
		if(sysMessage.getStatus().equals(Status.success)){
			//可以直接调用去首页方法
			return index(sysMessage, model);
		}else{//这是失败，返回注册页面
			model.addAttribute("message", sysMessage.getMessage());
			model.addAttribute("sysUser", sysUser);
			return "register";
		}
	}
	
}
