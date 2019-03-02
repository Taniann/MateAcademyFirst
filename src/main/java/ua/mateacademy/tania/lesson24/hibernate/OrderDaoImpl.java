package ua.mateacademy.tania.lesson24.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ua.mateacademy.tania.lesson22.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Tania Nebesna on 28.02.2019
 */
public class OrderDaoImpl implements OrderDao {
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);

        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Order.class);
        configObj.addAnnotatedClass(Customer.class);
        configObj.addAnnotatedClass(Office.class);
        configObj.addAnnotatedClass(Product.class);
        configObj.addAnnotatedClass(Salesrep.class);
        configObj.configure(new File("src\\main\\resources\\hibernate.cfg.xml"));

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    @Override
    public Set<Order> getAllOrder() {
        Set<Order> orders = new HashSet<>();
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            orders = new HashSet<>(sessionObj.createQuery("FROM Order").list());
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.warn("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return orders;
    }

    @Override
    public Order findOrderById(BigDecimal id) {
        Order order = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            order = sessionObj.get(Order.class, id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean insertOrder(Order order) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            sessionObj.save(order);

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\nSuccessfully Created Records In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            sessionObj.update(order);
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully Updated In The Database!\n", order.getOrderNum());
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) {
        boolean result = false;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            sessionObj.delete(sessionObj.load(Order.class, id));

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\nOrder With Id={} Is Successfully deleted from The Database!\n", id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

}
