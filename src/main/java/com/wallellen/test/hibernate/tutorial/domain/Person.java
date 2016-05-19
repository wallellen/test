package com.wallellen.test.hibernate.tutorial.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/9/16.
 */
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;

    private Set<Event> events = new HashSet();
    private Set<String> emails = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}
