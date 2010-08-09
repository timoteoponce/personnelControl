/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.model.dao;

import java.lang.reflect.Method;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Generic DAO component for handling
 * JPA entities.
 * @param <T> Entity type
 * @author Timoteo Ponce
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

    /**
     * Returns current instance, if instance
     * is null, it will try to create a new one.
     * @return
     */
    public T getInstance() {
        if (this.instance == null) {
            initInstance();
        }
        return this.instance;
    }

    /**
     * Sets working entity instance,
     * you can use this to perform
     * further operations: UPDATE,REMOVE
     * @param instance
     */
    public void setInstance(T instance) {
        this.instance = instance;
    }

    /**
     * Return current entity class.
     * @return
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * Returns working EntityManager
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Returns entity's ID, supposing
     * that all IDs are retrieved with
     * 'getId' operation.
     * @return
     */
    public Object getId() {
        return id;
    }

    /**
     * Clears current instance setting
     * all to null.
     */
    public void clearInstance() {
        setId(null);
        setInstance(null);
    }

    /**
     * Sets current entity ID, you
     * use this before calling 'find'
     * operation.
     * @param id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * Verifies if entity's ID is set.
     * @return
     */
    public boolean isIdDefined() {
        return (this.id != null);
    }

    /**
     * Verifies if current instance is
     * being managed by persistence
     * context.
     * @return
     */
    public boolean isManaged() {
        return (getInstance() != null && getEntityManager().contains(getInstance()));
    }

    /**
     * Writes entity changes to database.
     */
    public void update() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().flush();
        et.commit();
    }

    /**
     * Persists current entity
     * into database.
     */
    public void persist() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().persist(getInstance());
        getEntityManager().flush();
        setId(getIdProperty(getInstance()));
        et.commit();
    }

    /**
     * Removes current instance from
     * database.
     */
    public void remove() {
        final EntityTransaction et = getEntityManager().getTransaction();
        et.begin();
        getEntityManager().remove(getInstance());
        getEntityManager().flush();
        et.commit();
    }

    /**
     * Looks for an entity with that
     * matches with current ID.
     * @return
     */
    public T find() {
        T result = null;
        if(getEntityManager().isOpen() ){
            result = getEntityManager().find(entityClass, getId());
        }
        return result;
    }

    /**
     *
     */
    public void initInstance() {
        if (isIdDefined()) {
            setInstance(find());
        } else {
            setInstance(createInstance());
        }
    }

    /**
     *
     * @return
     */
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

    /**
     * 
     * @param entity
     * @return
     */
    public Object getIdProperty(Object entity) {
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
