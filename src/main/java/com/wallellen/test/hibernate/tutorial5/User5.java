package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
@Entity
public class User5 {
    @Id
    private Long id;
    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
