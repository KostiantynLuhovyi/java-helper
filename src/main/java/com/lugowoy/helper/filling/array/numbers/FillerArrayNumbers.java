package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.Array;

/**
 * The class provides a container for storing and using (delegates execution)
 * the implementation of the functionality declared in the {@link FillingArrayNumbers} interface,
 * for filling an array or object of the {@link Array} class with numeric data.
 * <p>The implementation of filling an array or object of the {@link Array} class will be obtained
 * from a specific object, which will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> Type of numerical data to fill arrays or elements encapsulated in the object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructs a new object of this class by initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArrayNumbers} interface.
     *
     * @param fillingArrayNumbers The object implements the contract declared in the {@link FillingArrayNumbers} interface.
     */
    private FillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        super(fillingArrayNumbers);
    }

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     *
     * @param array The object of the {@link Array} class to fill with numerical data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array from argument {@code tArray} with numerical data.
     *
     * @param tArray The array to fill with numerical data.
     */
    @Override
    public void fill(T[] tArray) {
        super.fill(tArray);
    }

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
    public T[] fill(int lengthArray) {
        return super.fill(lengthArray);
    }

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param array The object of the {@link Array} class to fill with numeric data.
     * @param bound The upper bound numeric value of the numbers to fill.
     */
    public void fill(Array<T> array, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, bound);
    }

    /**
     * Fills an array from argument {@code tArray} with data.
     * <p>Numerical values for filling will be in the range from 0 to {@code bound} argument.
     *
     * @param tArray The array to fill with numerical data.
     * @param bound  The upper bound numeric value of the numbers to fill.
     */
    public void fill(T[] tArray, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, bound);
    }

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
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with numerical data.
     * <p>Numerical values for filling will be in the range from {@code lowerBound} to {@code upperBound} argument.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param lowerBound The lower bound numeric value of the numbers to fill.
     * @param upperBound The upper bound numeric value of the numbers to fill.
     */
    public void fill(Array<T> array, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBound, upperBound);
    }

    /**
     * Fills an array from argument {@code tArray} with data.
     * <p>Numerical values for filling will be in the range from {@code lowerBound} to {@code upperBound} argument.
     *
     * @param tArray     The array to fill with numerical data.
     * @param lowerBound The lower bound numeric value of the numbers to fill.
     * @param upperBound the upper bound numeric value of the numbers to fill.
     */
    public void fill(T[] tArray, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, lowerBound, upperBound);
    }

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
    public T[] fill(int lengthArray, T lowerBound, T upperBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, lowerBound, upperBound);
    }

}
