package com.wallellen.test.jpa1.service;

import com.wallellen.test.jpa1.Account;
import com.wallellen.test.jpa1.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/6/16.
 */
@Repository
@Transactional(readOnly = true)
public class AccountServiceImple implements AccountService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Account save(Account account) {
        if (account.getId() == null) {
            em.persist(account);
            return account;
        } else {
            return em.merge(account);
        }
    }

    @Override
    public List<Account> findByCustomer(Customer customer) {
        Query query = em.createQuery("from Account a where a.customer.id=:customerId", Account.class)
                .setParameter("customerId", customer.getId());
        return query.getResultList();
    }
}
