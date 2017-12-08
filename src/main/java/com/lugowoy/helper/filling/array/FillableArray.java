package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Fillable;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the array with values.
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @param <T> The type of the elements of the array, which is filling with values.
 */

public interface FillableArray<T> extends Fillable<T[]> {

    /**
     * <p>
     * The method fills the array. An array is created based on the "length" parameter.
     * </p>
     * @param lengthArray The length of the array to create and fill values.
     *                          The value of the length of the array to fill in the values must be a positive number.
     * @return A reference to the array created and filled with values.
     */
    T[] fill(int lengthArray);

}
