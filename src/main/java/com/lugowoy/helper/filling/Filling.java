package com.lugowoy.helper.filling;

/**
 * The interface declares the contract for filling the object or storage (data structures) with data.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill the object or storage(data structure).
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface Filling<T> {

    /**
     * Fills the {@code t} object with data.
     *
     * @param t the object or storage(data structure) to fill.
     */
    void fill(T t);

}
