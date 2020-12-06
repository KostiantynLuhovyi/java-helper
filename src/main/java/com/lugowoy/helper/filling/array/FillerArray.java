package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * The class is a container that encapsulates the functionality for filling
 * objects of the {@link Array} class or arrays of different reference data
 * types. The execution of functionality delegated through classes objects
 * implementing the {@link FillingArray} interface.
 * <p> Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.Filler
 */
//TODO review documentation
public class FillerArray<T> extends Filler<Array<T>> {

    /**
     * Constructs a new object, initializing the implementation of the
     * functionality to fill. The implementation of functionality provided by
     * class objects that implement the {@link FillingArray} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public FillerArray(@NotNull final FillingArray<T> filling) {
        super(filling);
    }

    /**
     * Fills the {@code array} array with data. The functionality execution
     * delegated through an object encapsulated in an object of this class.
     *
     * @param array the array to fill with data.
     */
    public void fill(@NotNull final T[] array) {
        ((FillingArray<T>) super.getFilling()).fill(array);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * The functionality execution delegated through an object encapsulated in
     * an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     */
    public T[] fill(final int lengthArray) {
        return ((FillingArray<T>) super.getFilling()).fill(lengthArray);
    }

}
