package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The interface declares a contract for filling objects of the {@link Array} class and
 * arrays of reference data types of descendants of the {@link Number} class.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * Fills the {@code array} object with numeric data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to the argument {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     */
    void fill(Array<T> array, T bound);

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to the argument {@code bound}.
     *
     * @param tArray the array to fill.
     * @param bound the upper bound numeric value to fill.
     */
    void fill(T[] tArray, T bound);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numeric values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to the argument {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray, T bound);

    /**
     * Fills the {@code array} object with numeric data.
     * Numeric values to fill in the range from {@code lowerBound} to the argument {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    void fill(Array<T> array, T lowerBound, T upperBound);

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@code lowerBound} to the {@code upperBound}.
     *
     * @param tArray the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    void fill(T[] tArray, T lowerBound, T upperBound);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numeric values to fill in the range from {@code lowerBound} to the argument {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray, T lowerBound, T upperBound);

}
