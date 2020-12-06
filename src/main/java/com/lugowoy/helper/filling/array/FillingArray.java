package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * The interface declares a contract for filling objects of the {@link Array}
 * class or arrays of different reference data types.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filling
 */
//TODO review documentation
public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * Fills the {@code array} array with data.
     *
     * @param array the array to fill with data.
     */
    void fill(@NotNull T[] array);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray);

}
