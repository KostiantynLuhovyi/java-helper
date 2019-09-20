package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

/**
 * This abstract class is a superclass for all classes that fill an array or object of the {@link Array} class
 * with data read from a specific source which.
 * <p>The implementation for reading data for filling is taken (received) from the specific implementation that will be transferred
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
     * Constructs a new object, initializing with a {@link Reader} class object to read data to fill with data.
     *
     * @param reader The object of the {@link Reader} class to read data to fill with data.
     */
    public FillingArrayReadValues(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing with the object implementing
     * of the contract declared in the {@link Reading} interface to fill with data.
     *
     * @param reading The object that implements the {@link Reading} interface to fill with data.
     */
    public FillingArrayReadValues(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with read data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    public abstract void fill(Array<T> array);

    /**
     * Fills an array with read data.
     *
     * @param tArray The array to fill with data.
     */
    @Override
    public abstract void fill(T[] tArray);

    /**
     * Fills an array with read data.
     * <p>The array is created based on the length an array parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with data.
     * @return Created and filled array with read data.
     */
    @Override
    public abstract T[] fill(int lengthArray);

}
