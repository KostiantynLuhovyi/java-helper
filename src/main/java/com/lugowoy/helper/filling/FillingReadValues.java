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
 * @version 1.2
 */
public abstract class FillingReadValues {

    private Reader reader;

    //TODO add the constructors that accept objects from the standard java.io library

    /**
     * Constructs a new object, initializing by the implementation of reading data to fill.
     * The implementation of data reading provided by an object of the {@link Reader} class or its subclasses.
     *
     * @param reader the implementation of data reading to fill.
     */
    protected FillingReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * Constructs a new object, initialize by the implementation of reading to fill.
     * The implementation of data reading provided by a class object that implementation the {@link Reading} interface.
     *
     * @param reading the implementation of data reading to fill.
     */
    protected FillingReadValues(Reading reading) {
//        if (reading == null) {
//            throw new NullPointerException("Reading is null");
//        }
        this.reader = new Reader(reading);
    }

    /**
     * Get the encapsulated implementation of reading data to fill.
     *
     * @return the implementation of reading data to fill.
     */
    public Reader getReader() {
        return reader;
    }

}
