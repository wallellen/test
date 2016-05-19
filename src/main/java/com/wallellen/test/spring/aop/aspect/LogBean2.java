package com.wallellen.test.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
public class LogBean2 {
    public void before(JoinPoint call) {
        String clazz = call.getTarget().getClass().getName();

        String name = call.getSignature().getName();

        System.out.println("Call method " + clazz + "." + name);
    }

    public void after(JoinPoint call) {
        String clazz = call.getTarget().getClass().getName();

        String name = call.getSignature().getName();

        System.out.println("Called method " + clazz + "." + name);
    }

    public void afterReturn() {
        System.err.println("after return ...");
    }

    public void afterThrowing(JoinPoint call) {
        System.err.println("Throwing a exception ");
    }

    public void process(ProceedingJoinPoint call) throws Throwable {
        before(call);

        Object value = null;

        try {
            call.proceed();
            afterReturn();
        } catch(Throwable throwable) {
            afterThrowing(call);
            throw  throwable;
        }finally {
            after(call);
        }

    }
}
