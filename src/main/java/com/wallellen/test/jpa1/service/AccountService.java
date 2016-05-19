package com.wallellen.test.jpa1.service;

import com.wallellen.test.jpa1.Account;
import com.wallellen.test.jpa1.Customer;

import java.util.List;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/6/16.
 */
public interface AccountService {
    public Account save(Account account);

    public List<Account> findByCustomer(Customer customer);
}
