package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.filling.array.FillingArrayChecker;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillingArrayPointsRandomDoubleNumbers implements FillingArray<Point<Double>> {

    @Override
    public Array<Point<Double>> fill(final Array<Point<Double>> array) throws IllegalArgumentException {
        if (FillingArrayChecker.checkNonNullArrayObject(array)) {
            for (int i = 0; i < array.getArray().length; i++) {
                array.getArray()[i] = new Point<>(GeneratorRandomNumber.generateDouble(), GeneratorRandomNumber.generateDouble());
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
                points[i] = new Point<>(GeneratorRandomNumber.generateDouble(), GeneratorRandomNumber.generateDouble());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    @Override
    public Point<Double>[] fill(int lengthArray) {
        Point<Double>[] points;
        if (FillingArrayChecker.checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray().create(new CreatorArrayPoints<Double>(lengthArray), lengthArray).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(GeneratorRandomNumber.generateDouble(), GeneratorRandomNumber.generateDouble());
            }
        } else {
            points = FactoryArray.getFactoryArray().create(new CreatorArrayPoints<Double>(DEFAULT_LENGTH_ARRAY), DEFAULT_LENGTH_ARRAY).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(GeneratorRandomNumber.generateDouble(), GeneratorRandomNumber.generateDouble());
            }
        }
        return points;
    }

}
