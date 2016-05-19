package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
@DiscriminatorValue("D")
public class DemoCat extends Cat {

    private String name;
}
