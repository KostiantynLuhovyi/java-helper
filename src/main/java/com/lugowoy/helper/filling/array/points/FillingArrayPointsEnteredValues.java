package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point;

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

public abstract class FillingArrayPointsEnteredValues<T extends Number> implements FillingArray<Point<T>> {

    private Reader reader;

    /**
     * <p></p>
     *
     * @param reader
     * */
    public FillingArrayPointsEnteredValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * <p></p>
     *
     * @param reading
     * */
    public FillingArrayPointsEnteredValues(Reading reading) {
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
