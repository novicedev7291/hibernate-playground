package org.example.em;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@TestInstance(PER_CLASS)
public class EntityManagerTest {
    private EntityManagerFactory entityManagerFactory;

    @BeforeAll
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("com.example.h2.persistence");
    }

    @Test
    void junitDependencyTest() {
        assertEquals(1, 1);
    }

    @Test
    void entityManagerTest() {
        EntityManager em = entityManagerFactory.createEntityManager();
        assertNotNull(em);
        em.close();
    }

    @AfterAll
    public void tearDown() {
        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }

    protected void doInTransaction(Consumer<EntityManager> executeInTransaction) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        executeInTransaction.accept(em);

        em.getTransaction().commit();
        em.close();
    }

}
