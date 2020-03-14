package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The class provides a container for storing and using (delegates execution)
 * the implementation of the functionality declared in the {@link FillingArray} interface,
 * for filling an array or object of the {@link Array} class with data.
 * <p>The implementation of filling an array or object of the {@link Array} class will be obtained
 * from a specific object, which will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> Type of data to fill arrays or elements encapsulated in the object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filler
 */
//TODO edit  doc's
public abstract class FillerArray<T> extends Filler<Array<T>> {

    protected FillerArray() {
    }

    /**
     * Constructs a new object of this class by initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArray} interface.
     *
     * @param fillingArray The object implements the contract declared in the {@link FillingArray} interface.
     */
    protected FillerArray(FillingArray<T> fillingArray) {
        super(fillingArray);
    }

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array from argument {@code tArray} with data.
     *
     * @param tArray The array to fill with data.
     */
    public void fill(T[] tArray) {
        ((FillingArray<T>) super.getFilling()).fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the {@code lengthArray} parameter.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link } will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with data.
     */
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>) super.getFilling()).fill(lengthArray);
    }

    @Override
    public void setFilling(Filling<Array<T>> fillingArray) {
        super.setFilling(fillingArray);
    }

}
