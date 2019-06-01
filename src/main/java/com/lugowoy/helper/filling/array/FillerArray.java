package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.models.Array;

/**
 * This class is a container (delegates the execution of functionality) for the implementation of the contract declared
 * in the {@link FillingArray} interface.
 * This class uses contract implementations declared in the {@link FillingArray} interface to perform functionality
 * for filling arrays with data.
 * The methods of this class are delegated to the execution of a specific implementation of the contract declared
 * in the {@link FillingArray} interface transferred during the creation of an instance of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> Type of arrays and data elements to fill.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public class FillerArray<T> extends Filler<Array<T>> {

    /**
     * Constructs a new object initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArray} interface.
     * Used superclass constructor.
     *
     * @param fillingArray The object realizing the contract declared in the {@link FillingArray} interface.
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
     * <p>The array is created based on the lengthArray parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with data.
     */
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>) super.getFilling()).fill(lengthArray);
    }

    /**
     * Creates a new {@link FillerArray} class object by invoking the sole constructor of this class.
     *
     * @param fillingArray The object realizing the contract declared in the {@link FillingArray} interface.
     * @return Created object of this class.
     */
    public static <T> FillerArray<T> getFillerArray(FillingArray<T> fillingArray) {
        return new FillerArray<>(fillingArray);
    }

}
