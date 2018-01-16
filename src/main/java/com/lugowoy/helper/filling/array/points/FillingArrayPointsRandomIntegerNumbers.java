package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.filling.array.FillingArrayChecker;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 */

public class FillingArrayPointsRandomIntegerNumbers implements FillingArray<Point<Integer>> {

    @Override
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array) throws IllegalArgumentException {
        if (FillingArrayChecker.checkNonNullArrayObject(array)) {
            for (int i = 0; i < array.getArray().length; i++) {
                array.getArray()[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Point<Integer>[] fill(Point<Integer>[] points) throws IllegalArgumentException {
        if (points != null) {
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    @Override
    public Point<Integer>[] fill(int lengthArray) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray().create(new CreatorArrayPoints<Integer>(lengthArray), lengthArray).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
            }
        } else {
            points = FactoryArray.getFactoryArray().create(new CreatorArrayPoints<Integer>(DEFAULT_LENGTH_ARRAY), DEFAULT_LENGTH_ARRAY).getArray();
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
            }
        }
        return points;
    }

}
