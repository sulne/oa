package com.hxzycs.oa.pojo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hxzycs.oa.entity.Log;
import com.hxzycs.oa.service.LogService;
import com.hxzycs.oa.utils.DateUtils;

@Aspect
@Component
@SuppressWarnings("rawtypes")
public class LogAspect {

	private LogService logService;

	@Resource(name = "logService")
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	private Long userId;

	/**
	 * ��¼��־�����
	 */
	@Pointcut("@annotation(com.hxzycs.oa.pojo.Logging)")
	public void logAspect() {
	}
	
	/*@Pointcut("execution(* com.hxzycs.oa.service.*.*(..))")
	public void test() {
		
	}*/

	@AfterReturning("logAspect()")
	public void doLogging(JoinPoint joinPoint) throws SecurityException, ClassNotFoundException {
		if (null == userId) {
			/*
			 * HttpServletRequest request = ((ServletRequestAttributes)
			 * RequestContextHolder.getRequestAttributes()).getRequest(); userId = (Long)
			 * request.getSession().getAttribute("userId");
			 */
			userId = 10001L;
		}

		// �жϲ���
		if (joinPoint.getArgs() == null) {// û�в���
			return;
		}
		// ��ȡ������
		String methodName = joinPoint.getSignature().getName();
		// ��������
		List<Object> list = new ArrayList<>();

		Object[] arguments = joinPoint.getArgs();

		for (Object object : arguments) {
			list.add(object);
		}
		
		Log log = new Log();
		// ��ȡ��������
		log.setContent(getInfo(joinPoint, methodName, arguments));
		log.setUserId(userId);
		log.setOperation(methodName);
		log.setCreateDate(DateUtils.now());
		log.setParameters(list.toString());
		logService.create(log);
	}

	private String getInfo(JoinPoint joinPoint, String methodName, Object[] arguments)
			throws SecurityException, ClassNotFoundException {
		String temp = "";
		Method[] methods = Class.forName(joinPoint.getTarget().getClass().getName()).getMethods();

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					String description = method.getAnnotation(Logging.class).description();
					String Type = method.getAnnotation(Logging.class).type();
					String table = method.getAnnotation(Logging.class).table();
					temp = "����:" + Type + ", ������:" + table + ", ����:" + description;
					break;
				}
			}
		}
		return temp;
	}
}
