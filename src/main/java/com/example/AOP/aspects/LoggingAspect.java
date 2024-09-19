package com.example.AOP.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    Types of point cut -
//    1.execution
//    2.within
//    3.@annotation

//    * - any return type
//    orderPackage - any method in application by this name
//    orderPackage(..) - any parameters
//    should execute advice before/after <method> which takes (..) parameter and has * return type

//    @Before("execution(* orderPackage(..))")
//    public void beforeOrderPackage(){
//        log.info("Before orderPackage called from LoggingAspect");
//    }

//    "execution(* com.example.AOP.services.impl.ShipmentServiceImpl.orderPackage(..))" - precise method
//    "execution(* com.example.AOP.services.impl.ShipmentServiceImpl.*.*(..))" - any method inside this package

    @Before("execution(* com.example.AOP.services.impl.ShipmentServiceImpl.orderPackage(..))")
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before called from LoggingAspect, {}", joinPoint.getKind());
        log.info("Before called from LoggingAspect, {}", joinPoint.getSignature());
    }

//  should execute advice for any method inside any class under this package
    @Before("within(com.example.AOP.services.impl.*)")
    public void beforeServiceImplCalls(){
        log.info("Service Impl calls");
    }

//  should excecute advice before specified annotation
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotationCalls(){
        log.info("Before Transactional annotation calls");
    }
}
