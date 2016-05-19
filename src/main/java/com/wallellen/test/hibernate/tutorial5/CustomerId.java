package com.wallellen.test.hibernate.tutorial5;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Embeddable
public class CustomerId implements Serializable {
    UserId userId;
    String customerNumber;


}
