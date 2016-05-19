package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
