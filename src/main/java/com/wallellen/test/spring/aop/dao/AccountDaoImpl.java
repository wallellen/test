package com.wallellen.test.spring.aop.dao;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save(String loginName, String password) {
        System.err.println("save " + loginName + " with " + password);
    }
}
