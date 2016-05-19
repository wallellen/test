package com.wallellen.test.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
public class LogAspect {
    public void before(JoinPoint call) {
        String className = call.getTarget().getClass().getName();

        String methodName = call.getSignature().getName();

        System.err.println("Before class " + className + " method " + methodName + " executing!");
    }

    public void afterReturn() {
        System.err.println("after successfully executed method ...");
    }

    public void after() {
        System.err.println("after method executed ...");
    }

    public void afterThrowing() {
        System.err.println("after method throws exception ...");
    }

    public Object around(ProceedingJoinPoint call) throws Throwable {
        Object result;

        this.before(call);
        try {
            result = call.proceed();
            afterReturn();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            afterThrowing();

            throw throwable;
        } finally {
            after();
        }

        return result;
    }
}
