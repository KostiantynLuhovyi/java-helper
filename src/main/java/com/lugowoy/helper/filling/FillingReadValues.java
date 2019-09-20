package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * This abstract class is a superclass for all classes that fill an object or data structure with data read from a specific source which.
 * <p>The implementation for reading data for filling is taken (received) from the specific implementation that will be transferred
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
     * Constructs a new object, initializing with a {@link Reader} class object to read data to fill the object or storage.
     *
     * @param reader The object of the {@link Reader} class to fill with data.
     */
    public FillingReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * Constructs a new object, initializing with the object implementing the contract declared in the {@link Reading} interface
     * to fill an object or storage with data.
     *
     * @param reading The object implementation {@link Reading} interface to fill with data.
     */
    public FillingReadValues(Reading reading) {
        this.reader = Reader.getReader(reading);
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
