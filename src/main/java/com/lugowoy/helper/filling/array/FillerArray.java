package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.models.Array;

/**
 * The class provides a container for storing and using (delegates execution)
 * the implementation of the functionality declared in the {@link FillingArray} interface,
 * for filling an array or object of the {@link Array} class with data.
 * <p>The implementation of filling an array or object of the {@link Array} class will be taken (received)
 * from a specific object, which will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> Type of data elements and an array or object of the {@link Array} class to fill.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filler
 */
public class FillerArray<T> extends Filler<Array<T>> {

    /**
     * Constructs a new object initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArray} interface to fill with data.
     *
     * @param fillingArray The object implements the contract declared in the {@link FillingArray} interface.
     */
    protected FillerArray(FillingArray<T> fillingArray) {
        super(fillingArray);
    }

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array with data.
     *
     * @param tArray The array to fill with data.
     */
    public void fill(T[] tArray) {
        ((FillingArray<T>) super.getFilling()).fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with data.
     */
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>) super.getFilling()).fill(lengthArray);
    }

    /**
     * Creates a new object {@link FillerArray} class.
     *
     * @param fillingArray The object implements the contract declared in the {@link FillingArray} interface.
     * @return Created object of this class.
     */
    public static <T> FillerArray<T> getFillerArray(FillingArray<T> fillingArray) {
        return new FillerArray<>(fillingArray);
    }

}
