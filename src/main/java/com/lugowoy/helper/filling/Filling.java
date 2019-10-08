package com.lugowoy.helper.filling;

/**
 * The interface is the root of the hierarchy of declaring a contract for filling object or storage (data structures) with data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data to fill storage(data structure) or the object.
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface Filling<T> {

    /**
     * Fills an object or data structure from argument {@code t} with data.
     *
     * @param t The object or storage(data structure) to fill with data.
     */
    void fill(T t);

}
