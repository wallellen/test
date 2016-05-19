package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address {
    private String street1;
    private String hashCode;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }
}
