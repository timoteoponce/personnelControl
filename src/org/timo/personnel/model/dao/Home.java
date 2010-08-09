/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.model.dao;

import java.lang.reflect.Method;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author timoteo
 */
public class Home<T> {

    private Object id;
    private T instance;
    private final Class<T> entityClass;
    private final EntityManager entityManager;

    /**
     * 
     * @param entityClass
     * @param entityManager
     */
    public Home(final Class<T> entityClass, final EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalStateException("EntityManager is null");
        }

        if (entityClass == null) {
            throw new IllegalStateException("EntityClass is null");
        }
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    public T getInstance() {
        if (this.instance == null) {
            initInstance();
        }
        return this.instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Object getId() {
        return id;
    }

    /**
     *
     */
    public void clearInstance() {
        setId(null);
        setInstance(null);
    }

    public void setId(Object id) {
        this.id = id;
    }

    public boolean isIdDefined() {
        return (this.id != null);
    }

    public boolean isManaged() {
        return (getInstance() != null && getEntityManager().contains(getInstance()));
    }

    public void update() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().flush();
        et.commit();
    }

    public void persist() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().persist(getInstance());
        getEntityManager().flush();
        setId(getIdProperty(getInstance()));
        et.commit();
    }

    public void remove() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().remove(getInstance());
        getEntityManager().flush();
        et.commit();
    }

    public T find() {
        T result = null;
        if(getEntityManager().isOpen() ){
            result = getEntityManager().find(entityClass, getId());
        }
        return result;
    }

    public void initInstance() {
        if (isIdDefined()) {
            setInstance(find());
        } else {
            setInstance(createInstance());
        }
    }

    public T createInstance() {
        T newInstance = null;
        try {
            newInstance = this.entityClass.newInstance();
        } catch (Exception ex) {
            //TODO replace with a custom exception
            throw new RuntimeException(ex);
        }
        return newInstance;
    }

    public static Object getIdProperty(Object entity) {
        Object id = null;
        try {
            final Method method = entity.getClass().getMethod("getId");
            id = method.invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
