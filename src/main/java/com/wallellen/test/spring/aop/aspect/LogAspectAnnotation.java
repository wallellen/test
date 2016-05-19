package com.wallellen.test.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
@Aspect
public class LogAspectAnnotation {
    @Pointcut("execution(* com.wallellen.test.spring.aop.service.*.*(..))")
    public void allMethod() {

    }

    @Before("execution(* com.wallellen.test.spring.aop.service.*.*(..))")
    public void before() {
        System.err.println("before executing ...");
    }

    @AfterThrowing("allMethod()")
    public void afterThrowing() {
        System.err.println("after throwing");
    }
}
