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
		user.setUsername("����");*/
	}
	
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/index");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		if(user != null) {
			logger.info("�û���"+ user.getId()+"�ѵ�¼");
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
	 * // ��¼ʧ�ܻ���δ��¼shiro������/login
	 * 
	 * @RequestMapping("/login") public String login(HttpServletRequest request,
	 * Model model) { String error = null; //
	 * shiro�Ὣ�쳣��������ӽ�request��shiroLoginFailure�� String exceptionClassName =
	 * (String) request.getAttribute("shiroLoginFailure"); if
	 * (UnknownAccountException.class.getName().equals(exceptionClassName)) { error
	 * = "�û���������"; } else if
	 * (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
	 * error = "�û���/�������"; } else if (exceptionClassName != null) { error = "��¼�쳣" +
	 * exceptionClassName; } // ͨ��model���ش�����Ϣ��ҳ�� model.addAttribute("error", error);
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
