package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the array with numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @param <T> The type of the array and, accordingly, the type of numeric data (values) by which the array will be filled.
 */
//todo Проверить документацию и корректность интерфейса.
public interface FillableArrayNumbers<T extends Number> extends FillableArray<T> {

    /**
     * <p>
     * The method fills the array with numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with numeric data (values).
     */
    T[] fill(T[] array, T bound);

    /**
     * <p>
     * The method fills array the numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with numeric data (values).
     */
    T[] fill(int lengthArray, T bound);

    /**
     * <p>
     * The method fills an array the numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with numeric data (values).
     */
    T[] fill(T[] array, T minBound, T maxBound);

    /**
     * <p>
     * The method fills array the numeric values in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with numeric data (values).
     */
    T[] fill(int lengthArray, T minBound, T maxBound);

}