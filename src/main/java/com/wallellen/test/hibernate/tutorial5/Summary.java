package com.wallellen.test.hibernate.tutorial5;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
@Subselect("select item.name, max(bid.amount), count(*)" +
        " from item " +
        " join bid on bid.item_id=item.id" +
        " group by item.name")
@Synchronize({"item", "bid"})
@Immutable
public class Summary {
}
