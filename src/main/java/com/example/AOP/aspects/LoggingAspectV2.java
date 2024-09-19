package com.example.AOP.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodPointCut()")
    public void beforeServiceMethodCalls(){
        log.info("Before service method call");
    }

//  @AfterReturning - similar to @After but it runs ony after a normal execution(no exception)

    @AfterReturning(value = "allServiceMethodPointCut()", returning = "returnedObj")
    public void afterServiceMethodCalls(JoinPoint joinPoint, Object returnedObj){
        log.info("After returning advice method call, {}", joinPoint.getSignature());
        log.info("After returning returned value, {}", returnedObj);
    }

//  @AfterThrowing - similar to @After, but it runs ony after an exception

    @AfterThrowing(value = "allServiceMethodPointCut()")
    public void afterServiceMethodCallsThrows(JoinPoint joinPoint){
        log.info("After throwing advice method call, {}", joinPoint.getSignature());
    }

//    By calling proceed(), you are telling Spring to continue the intercepted method's execution,
//    essentially allowing the method to "proceed" as it normally would.
//    The method call that is intercepted by the aspect will not execute unless proceed() is invoked.

    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        Long diff = endTime - startTime;
        log.info("Time taken for {} is {}", proceedingJoinPoint.getSignature(), diff);
        return returnedValue;
    }

    @Pointcut("execution(* com.example.AOP.services.impl.*.*(..))")
    public void allServiceMethodPointCut(){}
}
