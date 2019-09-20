package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.Array;

/**
 * The class provides a container for storing and using (delegates execution)
 * the implementation of the functionality declared in the {@link FillingArrayNumbers} interface,
 * for filling an array or object of the {@link Array} class with numeric data.
 * <p>The implementation of filling an array or object of the {@link Array} class will be taken (received)
 * from a specific object, which will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> The type of the numerical data stored and filled into an array or object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructs a new object initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArrayNumbers} interface to fill with numeric data.
     *
     * @param fillingArrayNumbers The object implements the contract declared in the {@link FillingArrayNumbers} interface.
     */
    private FillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        super(fillingArrayNumbers);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     *
     * @param array The object of the {@link Array} class to fill with numeric data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array with numeric data.
     *
     * @param tArray The array to fill with numeric data.
     */
    @Override
    public void fill(T[] tArray) {
        super.fill(tArray);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @return Created and filled array with numeric data.
     */
    @Override
    public T[] fill(int lengthArray) {
        return super.fill(lengthArray);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param upperBound The value of the upper bound to fill with numeric data.
     */
    public void fill(Array<T> array, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, upperBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param tArray     The array to fill with numeric data with numeric data.
     * @param upperBound The value of the upper bound to fill with numeric data.
     */
    public void fill(T[] tArray, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, upperBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from 0 to the value of the upper bound parameter.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @param upperBound  The value of the upper bound to fill with numeric data.
     * @return Created and filled an array.
     */
    public T[] fill(int lengthArray, T upperBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, upperBound);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param array      The object of the {@link Array} class to fill with numeric data.
     * @param lowerBound The value of the lower bound to fill with numeric data.
     * @param upperBound The value of the upper bound to fill with numeric data.
     */
    public void fill(Array<T> array, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBound, upperBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param tArray     The array to fill with numeric data.
     * @param lowerBound The value of the lower bound to fill with numeric data.
     * @param upperBound The value of the upper bound to fill with numeric data.
     */
    public void fill(T[] tArray, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, lowerBound, upperBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from lower bound to the value of the upper bound parameters.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @param lowerBound  The value of the lower bound to fill with numeric data.
     * @param upperBound  The value of the upper bound to fill with numeric data.
     * @return Created and filled an array.
     */
    public T[] fill(int lengthArray, T lowerBound, T upperBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, lowerBound, upperBound);
    }

    /**
     * Creates a new object of {@link FillerArrayNumbers} class initializing it with a concrete implementation
     * of the contract declared in the {@link FillingArrayNumbers} interface to fill with numeric data.
     *
     * @param fillingArrayNumbers The object that implements the {@link FillingArrayNumbers} interface contract to fill with numeric data.
     * @return Сreated object of this class.
     */
    public static <T extends Number> FillerArrayNumbers<T> getFillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<>(fillingArrayNumbers);
    }

}
