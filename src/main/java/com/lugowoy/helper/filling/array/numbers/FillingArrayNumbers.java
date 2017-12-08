package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;
import com.lugowoy.helper.filling.array.FillingArray;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * The class is encapsulating the interface to implementation of the array filling with numeric values.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see FillingArray
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @see FillableArrayNumbers
 * @param <T> The type of the elements of the array, which is filling with numeric values.
 */

public abstract class FillingArrayNumbers<T extends Number> extends FillingArray<T> implements FillableArrayNumbers<T>{

    /**
     * <p>
     * A method fills an array the numeric values in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill with numeric values.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with numeric values.
     */
    @Override
    public abstract T[] fill(T[] array, T bound);

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
    @Override
    public abstract T[] fill(int lengthArray, T bound);

    /**
     * <p>
     * A method fills an array the numeric values in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill with numeric values.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array filled with numeric values.
     */
    @Override
    public abstract T[] fill(T[] array, T minBound, T maxBound);

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
    @Override
    public abstract T[] fill(int lengthArray, T minBound, T maxBound);

}
