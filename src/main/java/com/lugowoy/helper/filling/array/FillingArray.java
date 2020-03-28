package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The interface declares a contract for filling objects of the {@link Array} class or
 * arrays of different reference data types.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 */
public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * Fills the {@code tArray} array with data.
     *
     * @param tArray the array to fill with data.
     */
    void fill(T[] tArray);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray);

}
