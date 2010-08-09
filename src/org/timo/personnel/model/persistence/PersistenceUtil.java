/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author timoteo
 */
public class PersistenceUtil {

    private static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("personnelControlPU");
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = managerFactory.createEntityManager();
        }
        return entityManager;
    }
}

