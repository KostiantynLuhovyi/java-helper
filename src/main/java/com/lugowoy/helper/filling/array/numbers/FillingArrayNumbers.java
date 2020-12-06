package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * The interface declares a contract for filling objects of the {@link Array}
 * class and arrays of reference data types of descendants of the {@link Number}
 * class.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
//TODO review documentation
public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * Fills the {@code array} object with numeric data. Numerical values to
     * fill in the range from {@link } to the argument {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     */
    void fill(@NotNull Array<T> array, @NotNull T bound);

    /**
     * Fills the {@code array} array with numeric data. Numerical values to fill
     * in the range from {@link } to the argument {@code bound}.
     *
     * @param array the array to fill.
     * @param bound the upper bound numeric value to fill.
     */
    void fill(@NotNull T[] array, @NotNull T bound);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numeric values to fill in the range from {@link } to the argument {@code
     * bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray, @NotNull T bound);

    /**
     * Fills the {@code array} object with numeric data. Numeric values to fill
     * in the range from {@code lowerBound} to the argument {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    void fill(@NotNull Array<T> array, @NotNull T lowerBound,
              @NotNull T upperBound);

    /**
     * Fills the {@code array} array with numeric data. Numerical values to fill
     * in the range from {@code lowerBound} to the {@code upperBound}.
     *
     * @param array the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    void fill(@NotNull T[] array, @NotNull T lowerBound, @NotNull T upperBound);

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numeric values to fill in the range from {@code lowerBound} to the
     * argument {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     */
    T[] fill(int lengthArray, @NotNull T lowerBound, @NotNull T upperBound);

}
