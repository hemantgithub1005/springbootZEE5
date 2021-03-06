package com.zee.zee5app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect //its a container where we hold all our aop code
public class UserServiceAspect {
	
	//point cut expression - criteria of execution
	//joinpoint - method executed or called like addUser
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(@org.springframework.stereotype.Repository *) "+
	"|| within(@org.springframework.stereotype.Service *) "+
	"|| within(@org.springframework.web.bind.annotation.RestController *)")
	
	public void springPointCutExp() 
	{
		
		
	}
	
	
	@Pointcut("within(com.zee.zee5app.controller..*) " +
			"|| within(com.zee.zee5app.service.impl..*)")
			public void springPointCutExp2() {
	}
	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e){
		log.error("exception {}.{}() with cause {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause()!=null ? e.getCause():"NULL");
	}
	
	
	
     //    @Around(value = )
	//@Around is an advice type, which ensures that an advice can run before and after the method execution.
	
	
	
	
	
	

	
	
   
   
   //if we add get like this it will only come for get methods
	@Before(value = "execution(* com.zee.zee5app.service.impl.*.get*(..))")
	public void beforeAllServiceMethods(JoinPoint joinPoint) {
		//action - advice(all @before,@after,@around are advice)
		System.out.println("hello");
		System.out.println(joinPoint.getTarget());
	}
	
//	@After(value = "execution(* com.zee.zee5app.service.Impl.*.*(..))")
//	public void afterAllServiceMethods(JoinPoint joinPoint) {
//		//action - advice
//		System.out.println(" hello");
//		System.out.println(joinPoint.getTarget());
//	}

}