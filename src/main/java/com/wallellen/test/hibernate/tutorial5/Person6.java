package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
@Entity
public class Person6 implements Serializable {
    Address homeAddress;

    Country bornIn;
}
