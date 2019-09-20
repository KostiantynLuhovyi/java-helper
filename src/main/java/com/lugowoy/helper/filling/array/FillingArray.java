package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.Array;

/**
 * The interface declares a contract to implement the functionality for filling an array
 * or object of the {@link Array} class with data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data elements and an array or object of the {@link Array} class to fill.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 */
public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    void fill(Array<T> array);

    /**
     * Fills an array with data.
     *
     * @param tArray The array to fill with data.
     */
    void fill(T[] tArray);

    /**
     * Fills an array with data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with data.
     */
    T[] fill(int lengthArray);

}
