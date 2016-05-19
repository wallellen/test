package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
public class Flight7 implements Serializable {

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company7 company7;
}
