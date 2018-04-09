package com.hxzycs.oa.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.sf.json.JSONObject;

@ControllerAdvice
public class DefaultExceptionHandler {
	@ExceptionHandler({ UnauthorizedException.class })
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public void processUnauthenticatedException(UnauthorizedException e, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/unauthorized";
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.setHeader("REDIRECT", "REDIRECT");
			response.setHeader("CONTENTPATH", basePath);
			response.setStatus(HttpServletResponse.SC_OK);
			Map<String, Object> result = new HashMap<String, Object>();
        	result.put("flag", false);
        	result.put("msg", "您没有权限访问，请联系管理员");
        	response.setCharacterEncoding("UTF-8");
        	response.setContentType("application/json");
        	System.out.println(JSONObject.fromObject(result).toString());
        	response.getWriter().write(JSONObject.fromObject(result).toString());
		} else {
			response.sendRedirect(basePath);
		}
	}
	
	
	@ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIOException(NullPointerException ex) {
		System.out.println("handleIOException");
        return ClassUtils.getShortName(ex.getClass()) + ex.getMessage();
    }
}
