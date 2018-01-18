package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillingArrayPointsEnteredDoubleNumbers implements FillingArray<Point<Double>> {

    private Reader reader;

    public FillingArrayPointsEnteredDoubleNumbers(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayPointsEnteredDoubleNumbers(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    @Override
    public Array<Point<Double>> fill(final Array<Point<Double>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            for (int i = 0; i < array.getArray().length; i++) {
                array.getArray()[i] = new Point<>(this.reader.readDouble(), this.reader.readDouble());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Point<Double>[] fill(Point<Double>[] points) throws IllegalArgumentException {
        if (points != null) {
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(this.reader.readDouble(), this.reader.readDouble());
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    @Override
    public Point<Double>[] fill(int lengthArray) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(this.reader.readDouble(), this.reader.readDouble());
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(this.reader.readDouble(), this.reader.readDouble());
            }
        }
        return points;
    }

}
