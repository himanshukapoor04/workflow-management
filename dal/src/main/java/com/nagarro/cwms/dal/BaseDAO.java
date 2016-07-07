package com.nagarro.cwms.dal;

import java.io.Serializable;

/**
 * 
 * Base DAO interface for all DAO related operations.
 * 
 * @param <T> Class
 * @param <PK> Primary key
 */
public interface BaseDAO<T, PK extends Serializable> {

    /**
     * Save an object to database.
     * 
     * @param object which needs to be returned back.
     * @return Saved Object
     */
    T save(T object);


    /**
     * Get an object from database.
     * 
     * @param object which needs to be searched
     * @return return an object
     */
    T get(T object);


    /**
     * Update an object on the database.
     * 
     * @param object which needs to be saved.
     */
    void update(T object);


    /**
     * Delete an object from the database.
     * 
     * @param object
     */
    void delete(T object);

}
