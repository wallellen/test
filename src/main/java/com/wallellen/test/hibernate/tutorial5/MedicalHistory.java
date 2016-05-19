package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
public class MedicalHistory {
    @Id
    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;
}
