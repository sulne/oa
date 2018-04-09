package com.hxzycs.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	/*
	 * // ��¼ʧ�ܻ���δ��¼shiro������/login
	 * 
	 * @RequestMapping("/login") public String login(HttpServletRequest request,
	 * Model model) { String error = null; //
	 * shiro�Ὣ�쳣���������ӽ�request��shiroLoginFailure�� String exceptionClassName =
	 * (String) request.getAttribute("shiroLoginFailure"); if
	 * (UnknownAccountException.class.getName().equals(exceptionClassName)) { error
	 * = "�û���������"; } else if
	 * (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
	 * error = "�û���/�������"; } else if (exceptionClassName != null) { error = "��¼�쳣" +
	 * exceptionClassName; } // ͨ��model���ش�����Ϣ��ҳ�� model.addAttribute("error", error);
	 * return "login"; }
	 */

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, Long userId) {
		request.getSession().setAttribute("userId", userId);
		return request.getSession().getAttribute("userId").toString();
	}
}