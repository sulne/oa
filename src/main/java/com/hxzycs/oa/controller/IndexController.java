package com.hxzycs.oa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hxzycs.oa.entity.User;
import com.hxzycs.oa.utils.WebUtils;

@Controller
public class IndexController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	//public User user = new User();
	
	@ModelAttribute
	public void setParams() {
		/*user.setId(10001L);
		user.setUsername("张三");*/
	}
	
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/index");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		if(user != null) {
			logger.info("用户："+ user.getId()+"已登录");
		} else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}

	@RequestMapping(value = { "/home" })
	public String home() {
		return "home";
	}

	@RequestMapping(value = { "/unauthorized" })
	public String unauthorized() {
		return "unauthorized";
	}

	/*
	 * // 登录失败或者未登录shiro会请求/login
	 * 
	 * @RequestMapping("/login") public String login(HttpServletRequest request,
	 * Model model) { String error = null; //
	 * shiro会将异常的类名添加进request的shiroLoginFailure里 String exceptionClassName =
	 * (String) request.getAttribute("shiroLoginFailure"); if
	 * (UnknownAccountException.class.getName().equals(exceptionClassName)) { error
	 * = "用户名不存在"; } else if
	 * (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
	 * error = "用户名/密码错误"; } else if (exceptionClassName != null) { error = "登录异常" +
	 * exceptionClassName; } // 通过model返回错误信息给页面 model.addAttribute("error", error);
	 * return "login"; }
	 */

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		ModelAndView mav = new ModelAndView();
		if(null != user.getId()) {
			user = userService.find(user.getId());
			if(null != user) {
				request.getSession().setAttribute("user", user);
				WebUtils.issueRedirect(request, response, "/index");
				return null;
			}
			WebUtils.issueRedirect(request, response, "/login");
		} else {
			mav.setViewName("login");
		}
		return mav;
	}
}
