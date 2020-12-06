package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * The class is a container that encapsulates the functionality for filling
 * objects of the {@link Array} class or arrays of reference data types of
 * descendants of the {@link Number} class. The execution of functionality
 * delegated through classes objects implementing the {@link FillingArray}
 * interface.
 * <p> Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> the data type to fill arrays.
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
//TODO review documentation
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructs a new object, initializing the implementation of the
     * functionality to fill. The implementation of functionality provided by
     * class objects that implement the {@link FillingArrayNumbers} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public FillerArrayNumbers(@NotNull final FillingArrayNumbers<T> filling) {
        super(filling);
    }

    /**
     * Fills the {@code array} object with numeric data. Numeric values to fill
     * in the range from {@link } to {@code bound} argument. The functionality
     * execution delegated through an object encapsulated in an object of this
     * class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the lower or upper bound numeric values to fill.
     */
    public void fill(@NotNull final Array<T> array, @NotNull final T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, bound);
    }

    /**
     * Fills the {@code array} array with numeric data. Numerical values to fill
     * in the range from {@link } to {@code bound} argument. The functionality
     * execution delegated through an object encapsulated in an object of this
     * class.
     *
     * @param array the array to fill.
     * @param bound the upper or lower bound numeric values to fill.
     */
    public void fill(@NotNull final T[] array, @NotNull final T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, bound);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@link } to {@code bound}
     * argument. The functionality execution delegated through an object
     * encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the lower or upper bound numeric values to fill.
     * @return the array created and filled with data.
     */
    public T[] fill(final int lengthArray, final T bound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray,
                                                                  bound);
    }

    /**
     * Fills the {@code array} object with numeric data. Numeric values to fill
     * in the range from {@code lowerBound} to {@code upperBound} argument. The
     * functionality execution delegated through an object encapsulated in an
     * object of this class.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    public void fill(@NotNull final Array<T> array, @NotNull final T lowerBound,
                     @NotNull final T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBound,
                                                           upperBound);
    }

    /**
     * Fills the {@code array} array with numeric data. Numerical values to fill
     * in the range from {@code lowerBound} to {@code upperBound} argument. The
     * functionality execution delegated through an object encapsulated in an
     * object of this class.
     *
     * @param array the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     */
    public void fill(@NotNull final T[] array, @NotNull final T lowerBound,
                     @NotNull final T upperBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, lowerBound,
                                                           upperBound);
    }

    /**
     * Creates an array of length {@code lengthArray} and fills it with data.
     * Numerical values to fill in the range from {@code lowerBound} to {@code
     * upperBound} argument. The functionality execution delegated through an
     * object encapsulated in an object of this class.
     *
     * @param lengthArray the length(size) of the created array to fill with
     * data.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     */
    public T[] fill(final int lengthArray, @NotNull final T lowerBound,
                    @NotNull final T upperBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray,
                                                                  lowerBound,
                                                                  upperBound);
    }

}
