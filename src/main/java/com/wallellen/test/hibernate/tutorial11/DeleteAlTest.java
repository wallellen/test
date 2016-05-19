package com.wallellen.test.hibernate.tutorial11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/13/16.
 */
public class DeleteAlTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Order order1 = new Order();
        order1.setName("order1");

        Order order2 = new Order();
        order2.setName("order2");

        Customer customer = new Customer();
        customer.setName("customer");
        customer.setOrders(Arrays.asList(order1, order2));

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        session.beginTransaction();
        session.save(customer);
        session.save(order1);
        session.save(order2);

        session.getTransaction().commit();
//        session.close();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //  Customer load = (Customer) session.load(Customer.class, customer.getId());

        //System.err.println(load.toString());

        List customers = session.createQuery("from Customer").list();
        List orders = session.createQuery("from Order").list();

        customers.forEach(System.err::println);
        orders.forEach(System.err::println);
        customers.forEach(session::delete);

        session.getTransaction().commit();

        System.err.println("-----------------------------");

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        customers = session.createQuery("from Customer").list();
        orders = session.createQuery("from Order").list();

        customers.forEach(System.err::println);
        orders.forEach(System.err::println);



        System.exit(0);
    }
}
