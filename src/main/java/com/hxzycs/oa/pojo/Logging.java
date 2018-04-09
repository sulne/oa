package com.hxzycs.oa.pojo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})      
@Retention(RetentionPolicy.RUNTIME)      
@Documented 
public @interface Logging {
	/**
	 * 日志描述
	 */
	String description() default "";

	/**
	 * 操作表类型
	 */
	String type() default "";
	
	/**
	 * 表格
	 */
	String table() default "";
}
