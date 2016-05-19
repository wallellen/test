package com.wallellen.test.jpa1.after.repository;

import com.wallellen.test.jpa1.Account;
import com.wallellen.test.jpa1.Customer;
import com.wallellen.test.jpa1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/6/16.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired AccountRepository accountRepository;

    @PersistenceContext
    EntityManager em;


    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findByCustomer(Customer customer) {
        return accountRepository.findByCustomer(customer);
    }
}
