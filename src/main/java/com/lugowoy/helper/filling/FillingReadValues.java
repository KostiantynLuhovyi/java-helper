package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * The abstract class encapsulates and provides functionality to fill objects or
 * storages (data structures) with data read from some source.
 * The data reading for filling uses objects of {@link Reader} classes (or subclasses),
 * as well as class objects implementing the {@link Reading} interface.
 * <p> Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 */
public abstract class FillingReadValues {

    private Reader reader;

    //TODO add the constructors that accept objects from the standard java.io library

    /**
     * Constructs a new object, initializing the implementation of reading data to fill.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    protected FillingReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * Constructs a new object, initializing the implementation of reading data to fill.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    protected FillingReadValues(Reading reading) {
        this.reader = new Reader(reading);
    }

    /**
     * Sets the implementation of reading data to fill.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * Set the implementation of reading data to fill.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public void setReader(Reading reading) {
        this.reader = new Reader(reading);
    }

    /**
     * Gets an object encapsulated in an object of this class and implements of reading data to fill.
     *
     * @return the object implementation of reading data to fill.
     */
    public Reader getReader() {
        return reader;
    }

}
