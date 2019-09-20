package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.Array;

/**
 * The interface declares a contract to implement the functionality for filling an array
 * or object of the {@link Array} class with numeric data.
 *
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of numeric data and an array or object of the {@link Array} class to fill.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * Fills an object of the {@link Array} class with numeric data.
     *
     * @param array The object of the {@link Array} class to fill with numeric data.
     */
    @Override
    void fill(Array<T> array);

    /**
     * Fills an array with numeric data.
     *
     * @param tArray The array to fill with numeric data.
     */
    @Override
    void fill(T[] tArray);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @return Created and filled array with numeric data.
     */
    @Override
    T[] fill(int lengthArray);

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param upperBound The value of the upper bound to fill an object with numeric data.
     */
    void fill(Array<T> array, T upperBound);

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param tArray     The array to fill with numeric data.
     * @param upperBound The value of the upper bound to fill an array with numeric data.
     */
    void fill(T[] tArray, T upperBound);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @param upperBound  The value of the upper bound to fill with numeric data.
     * @return Created and filled an array with numeric data.
     */
    T[] fill(int lengthArray, T upperBound);

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param lowerBound The value of the lower bound to fill an object with numeric data.
     * @param upperBound The value of the upper bound to fill an object with numeric data.
     */
    void fill(Array<T> array, T lowerBound, T upperBound);

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param tArray     The array to fill with numeric data.
     * @param lowerBound The value of the lower bound to fill an array with numeric data.
     * @param upperBound The value of the upper bound to fill an array with numeric data.
     */
    void fill(T[] tArray, T lowerBound, T upperBound);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @param lowerBound  The value of the lower bound to fill an array with numeric data.
     * @param upperBound  The value of the upper bound ещ fill an array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    T[] fill(int lengthArray, T lowerBound, T upperBound);

}
