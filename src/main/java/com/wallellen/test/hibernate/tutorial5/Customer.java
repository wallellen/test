package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity

public class Customer {
    @EmbeddedId
    private CustomerId id;
    private boolean preferredCustomer;
}
