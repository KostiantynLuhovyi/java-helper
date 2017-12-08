package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the array with numeric values.
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @param <T> The type of numeric elements in the array, which is filling with values.
 */

public interface FillableArrayNumbers<T extends Number> extends FillableArray<T> {

    /**
     * <p>
     * A method fills an array the numeric values in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill with numeric values.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with numeric values.
     */
    T[] fill(T[] array, T bound);

    /**
     * <p>
     * A method fills array the values in the range from 0 to the "border",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill values.
     *                          The value of the length of the array to fill in the values must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an the array created and filled with numeric values.
     */
    T[] fill(int lengthArray, T bound);

    /**
     * <p>
     * A method fills an array the numeric values in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill with numeric values.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array filled with numeric values.
     */
    T[] fill(T[] array, T minBound, T maxBound);

    /**
     * <p>
     * A method fills array the numeric values in the range from "minBound" to the "maxBound",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill numeric values.
     *                          The value of the length of the array to fill in the values must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array created and filled with numeric values.
     */
    T[] fill(int lengthArray, T minBound, T maxBound);

}
