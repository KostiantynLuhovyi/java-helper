package com.lugowoy.helper.filling;

/**
 * The interface that declares a contract to filling an object or data structure with data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> The type of objects that are filled with different data.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface Filling<T> {

    /**
     * Fills an object or data structure with data.
     *
     * @param t The object or data structure to be filled with data.
     */
    void fill(T t);

}
