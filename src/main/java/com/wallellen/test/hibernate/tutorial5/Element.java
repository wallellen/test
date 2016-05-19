package com.wallellen.test.hibernate.tutorial5;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/11/16.
 */
public class Element {
    @NotFound(action = NotFoundAction.EXCEPTION)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Element parent;
}
