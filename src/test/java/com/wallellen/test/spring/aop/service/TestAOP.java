package com.wallellen.test.spring.aop.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
public class TestAOP {

    @Test
    public void testWithXML() {
        context = new ClassPathXmlApplicationContext("aopXML.xml");

        AccountService service = context.getBean(AccountService.class);
        service.save("wallellen", "password");
    }

    @Test
    public void testWithXML2() {
        context = new ClassPathXmlApplicationContext("aopXML2.xml");

        AccountService service = context.getBean(AccountService.class);
        service.save("wallellen", "password");
    }

    @Test
    public void testWithXML3() {
        context = new ClassPathXmlApplicationContext("aopXML_annotation.xml");

        AccountService service = context.getBean(AccountService.class);
        service.save("wallellen", "password");
    }

    private ApplicationContext context;
}
