package ua.mateacademy.tania.lesson22;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Locale;

public class OfficeDaoImpl implements OfficeDao {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

    private EntityManager entityManager = factory.createEntityManager();
    @Override
    public boolean insert(Office office) {
        LOG.debug("persisting Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
            LOG.debug("persist successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("persist failed", re);
            throw re;
        }
    }

    @Override
    public boolean update(Office office) {
        LOG.debug("merging Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(office);
            entityManager.getTransaction().commit();
            LOG.debug("merge successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public boolean delete(BigDecimal id) {
        LOG.debug("removing Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Office.class, id));
            entityManager.getTransaction().commit();
            LOG.debug("remove successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("remove failed", re);
            throw re;
        }
    }
}
