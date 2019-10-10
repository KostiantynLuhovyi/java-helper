package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * This abstract class is the root of the hierarchy of classes providing functionality for filling an object
 * or data structure with data that is read from a specific source.
 * <p>The implementation for reading data for filling is obtained from the specific implementation that will be transferred
 * when creating object of this class. To read data for filling, class objects are used that are subclasses of the {@link Reader} class
 * or class objects that implement the {@link Reading} interface.
 * <p>Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public abstract class FillingReadValues {

    private Reader reader;

    /**
     * Constructs a new object, initializing it with an object of the {@link Reader} class to read data
     * with which the object or storage will be filled.
     *
     * @param reader An object of the {@link Reader} class for reading data that will be used for filling.
     * @throws NullPointerException If the {@code reader} argument is null.
     */
    public FillingReadValues(Reader reader) {
        if (reader != null) {
            this.reader = reader;
        } else {
            throw new NullPointerException("Reader argument is null.");
        }
    }

    /**
     * Constructs a new object, initializing it with an object implementing the contract declared in the {@link Reading} interface
     * to read data with which the object or storage will be filled.
     *
     * @param reading An object implementation {@link Reading} interface for reading data that will be used for filling.
     * @throws NullPointerException If the {@code reading} argument is null.
     */
    public FillingReadValues(Reading reading) {
        if (reading != null) {
            this.reader = new Reader(reading);
        } else {
            throw new NullPointerException("Reading argument is null.");
        }
    }

    /**
     * Get a concrete implementation of reading data from a source to fill an object
     * or a storage with which the object was initialized at creation.
     *
     * @return The concrete implementation of reading data to fill with data.
     */
    protected Reader getReader() {
        return reader;
    }

}
