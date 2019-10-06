package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.Array;

/**
 * The interface declares a contract for filling an array or object of the {@link Array} class with numerical data.
 *
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of numerical data to fill arrays or elements encapsulated in the object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     *
     * @param array The object of the {@link Array} class to fill with numerical data.
     */
    @Override
    void fill(Array<T> array);

    /**
     * Fills an array from argument {@code tArray} with numerical data.
     *
     * @param tArray The array to fill with numerical data.
     */
    @Override
    void fill(T[] tArray);

    /**
     * Fills an array with numerical data.
     * <p>The array is created based on the {@code lengthArray} argument.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link com.lugowoy.helper.other.LengthValueOutOfRangeException} will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with numerical data.
     * @return Created and filled array with numerical data.
     */
    @Override
    T[] fill(int lengthArray);

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param array The object of the {@link Array} class to fill with numeric data.
     * @param bound The upper bound numeric value of the numbers to fill.
     */
    void fill(Array<T> array, T bound);

    /**
     * Fills an array from argument {@code tArray} with data.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param tArray The array to fill with numerical data.
     * @param bound  The upper bound numeric value of the numbers to fill.
     */
    void fill(T[] tArray, T bound);

    /**
     * Fills an array with numerical data.
     * <p>The array is created based on the {@code lengthArray} argument.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link com.lugowoy.helper.other.LengthValueOutOfRangeException} will be thrown.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param lengthArray The length(size) of the array to fill with numerical data.
     * @param bound       The upper bound numeric value of the numbers to fill.
     * @return Created and filled an array with numerical data.
     */
    T[] fill(int lengthArray, T bound);

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     * <p>Numerical values for filling will be in the range from {@code lowerBound} to {@code upperBound} argument.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param lowerBound The lower bound numeric value of the numbers to fill.
     * @param upperBound The upper bound numeric value of the numbers to fill.
     */
    void fill(Array<T> array, T lowerBound, T upperBound);

    /**
     * Fills an array from argument {@code tArray} with data.
     * <p>Numerical values for filling will be in the range from {@code lowerBound} to {@code upperBound} argument.
     *
     * @param tArray     The array to fill with numerical data.
     * @param lowerBound The lower bound numeric value of the numbers to fill.
     * @param upperBound the upper bound numeric value of the numbers to fill.
     */
    void fill(T[] tArray, T lowerBound, T upperBound);

    /**
     * Fills an array with numerical data.
     * <p>The array is created based on the {@code lengthArray} argument.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link com.lugowoy.helper.other.LengthValueOutOfRangeException} will be thrown.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param lengthArray The length(size) of the array to fill with numerical data.
     * @param lowerBound  The lower bound numeric value of the numbers to fill.
     * @param upperBound  The upper bound numeric value of the numbers to fill.
     * @return Created and filled an array with numerical data.
     */
    T[] fill(int lengthArray, T lowerBound, T upperBound);

}
