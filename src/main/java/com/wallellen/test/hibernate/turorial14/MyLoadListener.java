package com.wallellen.test.hibernate.turorial14;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/13/16.
 */
public class MyLoadListener implements LoadEventListener {
    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
        //if(MySecu)
    }
}
