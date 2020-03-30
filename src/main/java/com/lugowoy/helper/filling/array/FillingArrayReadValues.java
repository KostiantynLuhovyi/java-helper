package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

/**
 * The abstract class encapsulates and provides functionality to fill objects of the {@link Array} class and
 * arrays of reference data types of descendants of the {@link Number} class.
 * The data reading for filling uses objects of {@link Reader} classes (or subclasses),
 * as well as class objects implementing the {@link Reading} interface.
 * <p> Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @param <T> the data type to fill.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public abstract class FillingArrayReadValues<T> extends FillingReadValues implements FillingArray<T> {

    /**
     * Constructs a new object, initializing the implementation of reading data to fill.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadValues(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing the implementation of reading data to fill.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public FillingArrayReadValues(Reading reading) {
        super(reading);
    }

}
