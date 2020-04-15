package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The class is a container that encapsulates the functionality for filling objects of the {@link Array} class or
 * arrays of reference data types of descendants of the {@link Number} class.
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
     * Numeric values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param boundValue the lower or upper bound numeric values to fill.
     */
    public void fill(Array<T> array, T boundValue) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, boundValue);
    }

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param tArray the array to fill.
     * @param boundValue the upper or lower bound numeric values to fill.
     */
    public void fill(T[] tArray, T boundValue) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, boundValue);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param boundValue the lower or upper bound numeric values to fill.
     *
     * @return the array created and filled with data.
     */
    public T[] fill(int lengthArray, T boundValue) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, boundValue);
    }

    /**
     * Fills the {@code array} object with numeric data.
     * Numeric values to fill in the range from {@code lowerBoundValue} to {@code upperBoundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     */
    public void fill(Array<T> array, T lowerBoundValue, T upperBoundValue) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBoundValue, upperBoundValue);
    }

    /**
     * Fills the {@code tArray} array with numeric data.
     * Numerical values to fill in the range from {@code lowerBoundValue} to {@code upperBoundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param tArray the array to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     */
    public void fill(T[] tArray, T lowerBoundValue, T upperBoundValue) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, lowerBoundValue, upperBoundValue);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@code lowerBoundValue} to {@code upperBoundValue} argument.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill with data.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     */
    public T[] fill(int lengthArray, T lowerBoundValue, T upperBoundValue) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, lowerBoundValue, upperBoundValue);
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
