package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingData;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */

public abstract class FillingArrayUserInputCoordinatesOfPoints<T extends Number> extends FillingArrayPoints<T> {

    private Reader reader;

    public FillingArrayUserInputCoordinatesOfPoints(ReadingData readingData) {
        this.reader = new Reader(readingData);
    }

    @Override
    public abstract Point<T>[] fill(Point<T>[] points);

    @Override
    public abstract Point<T>[] fill(int lengthArray);

    public Reader getReader() {
        return reader;
    }

}
