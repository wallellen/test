package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
@Entity
public class Order {
    @Id
    private Integer id;
}
