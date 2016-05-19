package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
@Embeddable
public class Address6 implements Serializable {
    String city;
    Country nationality;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}
