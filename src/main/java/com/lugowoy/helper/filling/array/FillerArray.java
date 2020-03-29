package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
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
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public abstract class FillerArray<T> extends Filler<Array<T>> {

    /**
     * Constructs a new object, initializing the implementation of the functionality to fill.
     * The implementation of functionality provided by class objects that implement the {@link FillingArray} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public FillerArray(FillingArray<T> filling) {
        super(filling);
    }

    /**
     * Fills the {@code tArray} array with data.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param tArray the array to fill with data.
     */
    public void fill(T[] tArray) {
        ((FillingArray<T>) super.getFilling()).fill(tArray);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * The functionality execution delegated through an object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     */
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>) super.getFilling()).fill(lengthArray);
    }

    /**
     * Gets the object encapsulated in this class and implements the {@link FillingArray} interface to fill
     * objects of the {@link Array} class or arrays of different reference data types.
     *
     * @return the object that implements of functionality to fill.
     */
    @Override
    protected FillingArray<T> getFilling() {
        return (FillingArray<T>) super.getFilling();
    }

    /**
     * Sets the implementation of functionality for filling objects of the {@link Array} class or
     * arrays of different reference data types.
     * The implementation of functionality provided by the object of the classes that implement the {@link FillingArray} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     *
     * @return new object of this class initialized by the functionality provided by the {@code filling} object from the argument.
     */
    @Override
    protected abstract FillerArray<T> setFilling(Filling<Array<T>> filling);

}
