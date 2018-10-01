package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The interface that declares a contract to filling an object or data structure with data.
 *
 * @param <T> The type of objects that are filled with different data.
 */

public interface Filling<T> {

    /**
     * Fills an object or data structure with data.
     *
     * @param t The object or data structure to be filled with data.
     */
    void fill(T t);

}
