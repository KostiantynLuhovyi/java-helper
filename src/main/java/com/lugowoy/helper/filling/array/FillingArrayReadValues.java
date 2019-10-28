package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * This abstract class providing functionality for filling an array or object of the {@link Array} class
 * with data that is read from a specific source.
 * <p>The implementation for reading data for filling is obtained from the specific implementation that will be transferred
 * when creating object of this class. To read data for filling, class objects are used that are subclasses of the {@link Reader} class
 * or class objects that implement the {@link Reading} interface.
 * <p>Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @param <T> Type of read data to fill an array or object of the {@link Array} class.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public abstract class FillingArrayReadValues<T> extends FillingReadValues implements FillingArray<T> {

    /**
     * Constructs a new object, initializing it with an object of the {@link Reader} class to read data
     * with which an array or object of the {@link Array} class will be filled.
     *
     * @param reader An object of the {@link Reader} class for reading data that will be used for filling.
     * @throws NullPointerException If the {@code reader} argument is null.
     */
    public FillingArrayReadValues(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing it with an object implementing the contract declared in the {@link Reading} interface
     * to read data with which the object or storage will be filled.
     *
     * @param reading An object implementation {@link Reading} interface for reading data that will be used for filling.
     * @throws NullPointerException If the {@code reading} argument is null;
     */
    public FillingArrayReadValues(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class from argument {@code array} with read data.
     *
     * @param array The object of the {@link Array} class to fill with read data.
     */
    @Override
    public abstract void fill(Array<T> array);

    /**
     * Fills an array from argument {@code tArray} with read data.
     *
     * @param tArray The array to fill with read data.
     */
    @Override
    public abstract void fill(T[] tArray);

    /**
     * Fills an array with read data.
     * <p>The array is created based on the {@code lengthArray} parameter.
     * The value of the argument {@code lengthArray} must be in the range of values from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link LengthArrayValueOutOfRangeException} will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data.
     * @return Created and filled array with read data.
     */
    @Override
    public abstract T[] fill(int lengthArray);

}
