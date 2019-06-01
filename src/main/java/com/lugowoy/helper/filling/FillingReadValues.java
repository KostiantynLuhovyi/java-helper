package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * The abstract class provides a contract for the implementation (at this level of the hierarchy, only the initial representation)
 * for filling an object or storage(data structure) with data read by a specified method or from the source.
 * The method or source of reading data for filling is determined by the arguments passed during
 * the creation of the object extending the contract (implements) of this class.
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
     * @param reader The object of the {@link Reader} class to read data to fill.
     */
    public FillingReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * Constructs a new object, initializing with the object implementing the contract declared in the {@link Reading} interface
     * to fill an object or storage.
     *
     * @param reading The object implementation {@link Reading} interface to fill to object or storage.
     */
    public FillingReadValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * Get a concrete implementation of reading data from a source to fill an object
     * or a storage with which the object was initialized at creation.
     *
     * @return The concrete implementation of reading data from a source by which the object is initialized at creation.
     */
    public Reader getReader() {
        return reader;
    }

}
