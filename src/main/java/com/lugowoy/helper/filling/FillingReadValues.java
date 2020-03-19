package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * The abstract class the root of the hierarchy of classes providing functionality for filling an object or
 * data structure with data that read from a specific source.
 * To read data for filling used objects of the class {@link Reader} (or subclasses) or
 * objects of classes implementing the {@link Reading} interface.
 * <p> Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public abstract class FillingReadValues {

    private Reader reader;

    /**
     * Constructs a new object, initializing by the implementation of reading data to fill.
     * The implementation of data reading provided by an object of the {@link Reader} class or its subclasses.
     *
     * @param reader the implementation of data reading to fill.
     */
    public FillingReadValues(Reader reader) {
        if (reader != null) {
            this.reader = reader;
        } else {
            throw new NullPointerException("Reader argument is null.");
        }
    }

    /**
     * Constructs a new object, initialize by the implementation of reading to fill.
     * The implementation of data reading provided by a class object that implementation the {@link Reading} interface.
     *
     * @param reading the implementation of data reading to fill.
     */
    public FillingReadValues(Reading reading) {
        if (reading != null) {
            this.reader = new Reader(reading);
        } else {
            throw new NullPointerException("Reading argument is null.");
        }
    }

    /**
     * Get the encapsulated implementation of reading data to fill.
     *
     * @return the implementation of reading data to fill.
     */
    protected Reader getReader() {
        return reader;
    }

}

//TODO add the constructors that accept objects from the standard java.io library