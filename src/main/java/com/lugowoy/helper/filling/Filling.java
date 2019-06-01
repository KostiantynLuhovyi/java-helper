package com.lugowoy.helper.filling;

/**
 * The interface declares a contract to implement the functionality for filling storage(data structure) with data.
 * This interface is a root of the hierarchy that represent this functionality.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data elements and storage(data structure) or the object to fill.
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface Filling<T> {

    /**
     * Fills the object or storage(data storage) with data.
     *
     * @param t The object or storage(data structure) to fill.
     */
    void fill(T t);

}
