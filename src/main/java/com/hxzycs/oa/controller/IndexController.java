package com.hxzycs.oa.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
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

	// 登录失败或者未登录shiro会请求/login
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String error = null;
		// shiro会将异常的类名添加进request的shiroLoginFailure里
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名不存在";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (exceptionClassName != null) {
			error = "登录异常" + exceptionClassName;
		}
		// 通过model返回错误信息给页面
		model.addAttribute("error", error);
		return "login";
	}
}
