package com.lugowoy.helper.filling;

/**
 * The interface is the root of the hierarchy of declaring a contract for filling object or storage (data structures) data.
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
