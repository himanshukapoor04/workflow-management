package com.nagarro.cwms.dal.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.nagarro.cwms.dal.BaseDAO;

/**
 * Base DAO class. It implements all the data access methods
 * 
 * @param <T> entity class
 * @param <PK> Primary key field
 */
public class BaseDAOImpl<T, PK extends Serializable> implements BaseDAO<T, PK> {

    /**
     * Class for which DAO is created
     */
    private Class<T> persistentClass;

    /**
     * Entity MAnager, It is not mapped to the persistence.xml. Will be done in future.
     */
    protected EntityManager entityManager;


    /**
     * No arg constructor
     */
    public BaseDAOImpl() {

    }


    /**
     * Constructor for class.
     * 
     * @param persistentClass
     */
    public BaseDAOImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }


    @Override
    public T save(T object) {
        entityManager.persist(object);
        return object;
    }


    @SuppressWarnings("unchecked")
    @Override
    public T get(T object) {
        return (T) entityManager.find(object.getClass(), object);
    }


    @Override
    public void update(T object) {
        entityManager.merge(object);

    }


    @Override
    public void delete(T object) {
        entityManager.remove(object);

    }


    /**
     * Getter for entitymanager
     * 
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }


    /**
     * Setter for entity manager.
     * 
     * @param entityManager
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * Getter for persistence class.
     * 
     * @return
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

}
