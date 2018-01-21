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
 */

public abstract class FillingArrayEnteredValues<T> implements FillingArray<T> {

    private Reader reader;

    public FillingArrayEnteredValues(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayEnteredValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    protected Reader getReader() {
        return reader;
    }

}
