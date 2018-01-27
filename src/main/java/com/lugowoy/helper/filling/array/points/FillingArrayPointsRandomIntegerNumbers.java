package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */

public class FillingArrayPointsRandomIntegerNumbers implements FillingArray<Point<Integer>>, FillingArrayPointsWithNumbersCoordinates<Integer> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     * */
    @Override
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinates(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param points
     *
     * @return
     * */
    @Override
    public Point<Integer>[] fill(Point<Integer>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinates(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     * */
    @Override
    public Point<Integer>[] fill(int lengthArray) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinates(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinates(points);
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param endBound
     * @return
     */
    @Override
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkBoundValueIsPositive(endBound)) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(array.getArray(), DEFAULT_INTEGER_POSITIVE_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param points
     * @param endBound
     * @return
     */
    @Override
    public Point<Integer>[] fill(Point<Integer>[] points, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(endBound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(points, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param endBound
     * @return
     */
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer endBound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(endBound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(points, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param startBound
     * @param endBound
     * @return
     */
    @Override
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param points
     * @param startBound
     * @param endBound
     * @return
     */
    @Override
    public Point<Integer>[] fill(Point<Integer>[] points, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param startBound
     * @param endBound
     * @return
     */
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound) && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(points, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinates(final Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromZeroToBound(final Point<Integer>[] points, final int bound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(bound), GeneratorRandomNumber.generateInt(bound));
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledRandomIntegerCoordinatesFromMinBoundToMaxBound(final Point<Integer>[] points, final int minBound, final int maxBound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(minBound, maxBound), GeneratorRandomNumber.generateInt(minBound, maxBound));
        }
        return points;
    }

}
