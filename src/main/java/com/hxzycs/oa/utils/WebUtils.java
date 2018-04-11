package com.hxzycs.oa.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {
	/**
	 * �ж��Ƿ�ajax����
	 * */
	public static boolean isAjax(HttpServletRequest request) {
		String requestedWith = request.getHeader("x-requested-with");
		if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
			return true;
		}
		return false;
	}
	
	/**
	 * �ض���ҳ��
	 * */
	public static void issueRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + url;
		if(isAjax(request)){
			//����ajax�����ض���
            response.setHeader("REDIRECT", "REDIRECT");
            //����ajax���ض����·��
            response.setHeader("CONTENTPATH", basePath);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            response.sendRedirect(basePath);
        }
	}
}
