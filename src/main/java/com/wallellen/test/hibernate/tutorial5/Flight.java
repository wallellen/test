package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
public class Flight implements Serializable {
    Long id;

    @Version
    private Integer version;

    @Version
    private Date lastUpdateTime;

    public transient int counter;

    private String firstName;

    @Transient
    String getLengthInMeter() {
        return null;
    }

    @Basic
    int getLength() {
        return -1;
    }

    @Basic
    String getDetailComment() {
        return null;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date getDepartureTime() {
        return null;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(updatable = false, name = "flight_name", nullable = false, length = 50)
    public String getName() {
        return null;
    }
}
