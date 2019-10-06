package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.Array;

/**
 * The interface declares a contract for filling an array or object of the {@link Array} class with data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data to fill arrays or elements encapsulated in the object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 */
public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    void fill(Array<T> array);

    /**
     * Fills an array from argument {@code tArray} with data.
     *
     * @param tArray The array to fill with data.
     */
    void fill(T[] tArray);

    /**
     * Fills an array with data.
     * <p>The array is created based on the {@code lengthArray} parameter.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link com.lugowoy.helper.other.LengthValueOutOfRangeException} will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with data.
     */
    T[] fill(int lengthArray);

}
