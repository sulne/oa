package com.hxzycs.oa.pojo;

import javax.xml.bind.ValidationException;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * �������쳣
	 */
	@ExceptionHandler({BindException.class, ValidationException.class})
    public String bindException() {  
        return "error/400";
    }
	
	/**
	 * ��Ȩ��¼�쳣
	 */
	@ExceptionHandler({AuthenticationException.class})
    public String authenticationException() {  
        return "error/403";
    }
}
