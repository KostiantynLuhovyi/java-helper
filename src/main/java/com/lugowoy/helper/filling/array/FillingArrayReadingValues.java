package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadingValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * The class is the root of the class hierarchy that implements the contract declared in the {@link FillingArray} interface
 * of the filling of objects of {@link Array} class and classical arrays using the data read by the object of the class {@link Reader}
 * encapsulated in this class.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *
 * @param <T> The type of read data to be filling of object of the {@link Array} class or the classic array.
 */

public abstract class FillingArrayReadingValues<T> extends FillingReadingValues implements FillingArray<T> {

    /**
     * Constructs a new class object,
     *  initializing an object of {@link Reader} class encapsulated in that class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in this class to read data to fill array.
     */
    public FillingArrayReadingValues(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new class object,
     *  initializing an object of {@link Reader} class
     *  encapsulated in that class of the concrete implementation of the contract declared in the interface {@link Reading}
     *  to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface
     *                to initialize an object of the {@link Reader} class encapsulated in this class
     *                to read the data to be fill array.
     */
    public FillingArrayReadingValues(Reading reading) {
        super(reading);
    }

    @Override
    public abstract void fill(Array<T> array);

    @Override
    public abstract void fill(T[] tArray);

    @Override
    public abstract T[] fill(int lengthArray);

}
