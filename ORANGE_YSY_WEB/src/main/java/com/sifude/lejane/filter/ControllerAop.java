package com.sifude.lejane.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sifude.tool.util.AESUtil;
import com.sifude.tool.util.entity.ResultBean;
/**
 * 
 * @author jinghao.liang
 * 
 */
@Aspect
@Component
public class ControllerAop {
	private static Logger log = LogManager.getLogger(ControllerAop.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Pointcut("execution(* com.sifude.lejane.controller..*.*(..)) && !@annotation(org.springframework.web.bind.annotation.InitBinder)")
	private void anyMethod() {
	}// 定义一个切入点

	@Before("anyMethod()")
	public void doAccessCheck(JoinPoint jp) {
		String message = "请求方法:" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + "(";
		
		for(Object arg : jp.getArgs()) {
			try {
				message += objectMapper.writeValueAsString(arg) + ",";
			} catch (JsonProcessingException e) {
				
			}
		}
		message = message.substring(0, message.length() - 1) + ")";
		log.info(message);
	}
	
	@AfterReturning(pointcut = "anyMethod()",returning = "retVal")
	public void logInfo(Object retVal) throws JsonProcessingException  
    {  
		if(retVal instanceof ResultBean) {
			log.debug("退出方法:" + (new ObjectMapper()).writeValueAsString(retVal));
		}
    }
	
	@Around("anyMethod() && @annotation(com.sifude.annotations.EncResponse)")
	public Object encResultResponse(ProceedingJoinPoint pjp)
			throws Throwable {
		Object result = pjp.proceed();
		
		if (result instanceof ResultBean) {
			ResultBean rb = (ResultBean) result;
			rb.setResult(AESUtil.encrypt((new ObjectMapper()).writeValueAsString(rb.getResult())));
			return rb;
		}

		return result;
	}
/*    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	log.info("进入环绕通知:" + StringUtils.join(pjp.getArgs(), ","));
        Object object = pjp.proceed();// 执行该方法
        return object;
    }*/
    
   /* 
    public void doAfter() {
        System.out.println("后置通知");
    }
 
    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }
 
    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }
 
*/
}