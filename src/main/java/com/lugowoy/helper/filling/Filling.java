package com.lugowoy.helper.filling;

/**
 * The interface the root of the hierarchy of declaring a contract
 * for filling object or storage (data structures) with data.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the type data to fill storage(data structure) or the object.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface Filling<T> {

    /**
     * Fills {@code t} with data.
     *
     * @param t the object or storage(data structure) to fill.
     */
    void fill(T t);

}
