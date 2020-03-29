package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The class is a container that encapsulates the functionality for filling objects of the {@link Array} class or
 * arrays of different reference data types.
 * The execution of functionality delegated through classes objects implementing the {@link FillingArray} interface.
 * <p> Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructs a new object, initializing the implementation of the functionality to fill.
     * The implementation of functionality provided by class objects that implement the {@link FillingArrayNumbers} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public FillerArrayNumbers(FillingArrayNumbers<T> filling) {
        super(filling);
    }

    /**
     * Fills the {@code array} object with numeric data.
     * Numeric values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     */
    public void fill(Array<T> array, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, bound);
    }

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param tArray the array to fill.
     * @param bound the upper bound numeric value to fill.
     */
    public void fill(T[] tArray, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, bound);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     */
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * Fills the {@code array} object with numeric data.
     * Numeric values to fill in the range from {@code lowerBound} to {@code upperBound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    public void fill(Array<T> array, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBound, upperBound);
    }

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@code lowerBound} to {@code upperBound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param tArray the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    public void fill(T[] tArray, T lowerBound, T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, lowerBound, upperBound);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@code lowerBound} to {@code upperBound} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill with data.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     */
    public T[] fill(int lengthArray, T lowerBound, T upperBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, lowerBound, upperBound);
    }

    /**
     * Gets the object encapsulated in this class and implements the {@link FillingArrayNumbers} interface to fill
     * objects of the {@link Array} class or arrays of different reference data types.
     *
     * @return the object that implements of functionality to fill.
     */
    @Override
    public FillingArrayNumbers<T> getFilling() {
        return (FillingArrayNumbers<T>) super.getFilling();
    }

    /**
     * Sets the implementation of functionality for filling objects of the {@link Array} class or
     * arrays of different reference data types.
     * The implementation of functionality provided by the object of the classes that implement the {@link FillingArrayNumbers} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     *
     * @return new object of this class initialized by the functionality provided by the {@code filling} object from the argument.
     */
    @Override
    public FillerArrayNumbers<T> setFilling(Filling<Array<T>> filling) {
        return new FillerArrayNumbers<>((FillingArrayNumbers<T>) filling);
    }

}
