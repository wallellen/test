package com.wallellen.test.spring.p01;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/16/16.
 */
public class PointCutTest {
    @Pointcut("execution(* tranfer(...))")
    public void anyOldtransfer() {
        System.err.println("any old transfer executing ...");
    }
}
