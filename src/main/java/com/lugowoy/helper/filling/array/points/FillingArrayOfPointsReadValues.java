package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @author Konsytantin Lugowoy
 * @version 1.0
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * */

public abstract class FillingArrayOfPointsReadValues<T extends Number> implements FillingArrayOfPoints<T> {

    private Reader reader;

    /**
     * <p></p>
     *
     * @param reader
     * */
    public FillingArrayOfPointsReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * <p></p>
     *
     * @param reading
     * */
    public FillingArrayOfPointsReadValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * <p></p>
     *
     * @return
     * */
    protected Reader getReader() {
        return reader;
    }
}
