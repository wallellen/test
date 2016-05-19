package com.wallellen.test.hibernate.turorial14;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/13/16.
 */
public class AuditInterceptor extends EmptyInterceptor {
    private int updates;
    private int creates;
    private int loads;

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable) {
            updates++;


            for (int i = 0; i < propertyNames.length; i++) {
                if ("lastUpdatedAt".equals(propertyNames[i])) {
                    currentState[i] = new Date();
                    return true;
                }
            }
        }
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable) {
            loads++;
        }

        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable) {
            for (int i = 0; i < propertyNames.length; i++) {
                creates++;
                if ("createdAt".equals(propertyNames[i])) {
                    state[i] = new Date();
                    return true;
                }
            }
        }

        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        if (tx.wasCommitted()) {
            System.err.println("creates " + creates + ", updates: " + updates + ", loads: " + loads);
        }

        //super.afterTransactionCompletion(tx);
        updates = 0;
        creates = 0;
        loads = 0;
    }
}
