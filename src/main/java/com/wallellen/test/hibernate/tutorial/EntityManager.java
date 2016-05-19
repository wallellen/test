package com.wallellen.test.hibernate.tutorial;

import com.wallellen.test.hibernate.tutorial.domain.Event;
import com.wallellen.test.hibernate.tutorial.domain.Person;
import com.wallellen.test.hibernate.tutorial.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/9/16.
 */
public class EntityManager {
    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();

        if (Objects.equals(args[0], "store")) {
            entityManager.createAndStoreEvent("event_test_1", new Date());
        } else if (Objects.equals(args[0], "list")) {
            List<Event> events = entityManager.listEvents();
            System.err.println(events + "=======");
            events.forEach(e -> System.err.println("Event: " + e.getTitle() + " Time:" + e.getDate()));
        } else if (Objects.equals(args[0], "addpersontoevent")) {
            String eventId = entityManager.createAndStoreEvent("eventtitle", new Date());
            String personId = entityManager.createAndStorePerson("FirstName", "lastName");

            entityManager.addPersonToEvent(personId, eventId);
        }

        HibernateUtil.getSessionFactory().close();
    }

    private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.err.println(session + "--1---");
        session.beginTransaction();

        List list = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return list;
    }

    public String createAndStoreEvent(String title, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.err.println(session + "-----");

        session.beginTransaction();

        Event event = new Event();
        //  event.setId(1);
        event.setDate(date);
        event.setTitle(title);

        session.save(event);

        session.getTransaction().commit();

        return event.getId();
    }

    public String createAndStorePerson(String firstName, String lastName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.err.println(session + "---2--");

        session.beginTransaction();
        Person person = new Person();
        person.setAge(100);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        session.save(person);
        session.getTransaction().commit();

        return person.getId();
    }

    public void addPersonToEvent(String personId, String eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person person = (Person) session.load(Person.class, personId);
        Event event = (Event) session.load(Event.class, eventId);

        person.getEvents().add(event);

        session.getTransaction().commit();

        System.err.println("add event " + eventId + " 2 person " + personId);
    }

    public void addEmailToPerson(String personId, String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person person = (Person) session.load(Person.class, personId);
        person.getEmails().add(email);

        session.getTransaction().commit();
    }
}
