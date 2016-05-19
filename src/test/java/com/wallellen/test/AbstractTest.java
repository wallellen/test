package com.wallellen.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/6/16.
 */
@SpringApplicationConfiguration(classes = AbstractTest.TestConfig.class)
public class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
    public static class TestConfig {
    }

    @BeforeTransaction
    public void setupData() {
        deleteFromTables("account", "customer");
        executeSqlScript("classpath:data.sql", false);
    }
}
