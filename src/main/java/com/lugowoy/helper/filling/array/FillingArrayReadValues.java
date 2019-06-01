package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

/**
 * The abstract class provides a contract for the implementation of filling the array with the data read
 * by the specified method from the source.
 * The method or source of reading data for filling is determined by the arguments passed during
 * the creation of the object extending the contract (implements) of this class.
 * <p>Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @param <T> Type of read data to fill an array.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public abstract class FillingArrayReadValues<T> extends FillingReadValues implements FillingArray<T> {

    /**
     * Constructs a new object, initializing with a {@link Reader} class object to read data to fill the array.
     *
     * @param reader Object of the {@link Reader} class to read data to fill.
     */
    public FillingArrayReadValues(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing with the object implementing the contract declared in the {@link Reading} interface
     * to fill an array.
     *
     * @param reading Object that implements the {@link Reading} interface to fill an array.
     */
    public FillingArrayReadValues(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with read data.
     *
     * @param array Object of the {@link Array} class to fill.
     */
    @Override
    public abstract void fill(Array<T> array);

    /**
     * Fills an array with read data.
     *
     * @param tArray Array to fill.
     */
    @Override
    public abstract void fill(T[] tArray);

    /**
     * Fills an array with read data.
     * The array is created based on the lengthArray parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray Length(size) of the array to fill.
     * @return Created and filled array with read data.
     */
    @Override
    public abstract T[] fill(int lengthArray);

}
