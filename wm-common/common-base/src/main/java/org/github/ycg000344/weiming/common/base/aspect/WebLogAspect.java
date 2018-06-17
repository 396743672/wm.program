/** 
 * Project Name:common-base 
 * File Name:WebLogAspect.java 
 * Package Name:org.github.ycg000344.weiming.common.base 
 * Date:2018年6月17日上午10:38:44 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.base.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:WebLogAspect <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月17日 上午10:38:44 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
	
	private ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Pointcut("execution(public * org.github.ycg000344.weiming.*.*.controller..*.*(..))")
    public void webLog(){}

	@Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("***weiming专用log***URL : 【{}】*** ", request.getRequestURL().toString());
        log.info("***weiming专用log***HTTP_METHOD : 【{}】***",request.getMethod());
        log.info("***weiming专用log***IP : 【{}】***",request.getRemoteAddr());
        log.info("***weiming专用log***CLASS_METHOD : 【{}】***",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("***weiming专用log***ARGS : 【{}】***",Arrays.toString(joinPoint.getArgs()));

    }
	@AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
		log.info("***weiming专用log***RESPONSE : 【{}】***",ret);
		log.info("***weiming专用log***SPEND TIME : 【{}】***",(System.currentTimeMillis() - startTime.get()));
    }
}
  