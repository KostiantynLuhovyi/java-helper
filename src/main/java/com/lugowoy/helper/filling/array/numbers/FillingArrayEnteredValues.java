package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *
 * @param <T>
 */

public abstract class FillingArrayEnteredValues<T> implements FillingArray<T> {

    private Reader reader;

    /**
     * <p></p>
     *
     * @param reader
     */
    public FillingArrayEnteredValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * <p></p>
     *
     * @param reading
     */
    public FillingArrayEnteredValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * <p></p>
     *
     * @return
     */
    protected Reader getReader() {
        return reader;
    }

}
