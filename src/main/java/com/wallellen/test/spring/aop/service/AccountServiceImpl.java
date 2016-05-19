package com.wallellen.test.spring.aop.service;

import com.wallellen.test.spring.aop.dao.AccountDao;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/17/16.
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Override
    public void save(String loginName, String password) {
        accountDao.save(loginName, password);

        throw new RuntimeException("There is a exception...");
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
