package com.wallellen.test.jpa01;

import com.wallellen.test.AbstractTest;
import com.wallellen.test.jpa1.Account;
import com.wallellen.test.jpa1.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/6/16.
 */
public class AccountServiceTest extends AbstractTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void saveAccount() {
        Account account = accountService.save(new Account());

        assertThat(account.getId(), is(notNullValue()));
    }
}
