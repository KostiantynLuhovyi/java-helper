package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayPoints;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * */

public class FillingArrayOfPointsRandomDoubleNumbers implements FillingArrayOfPoints<Double> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     * */
    @Override
    public Array<Point<Double>> fill(final Array<Point<Double>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinates(array.getArray()));
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
    public Point<Double>[] fill(Point<Double>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinates(points);
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
    public Point<Double>[] fill(int lengthArray) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinates(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinates(points);
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param bound
     * @return
     */
    @Override
    public Array<Point<Double>> fill(final Array<Point<Double>> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND));
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
     * @param bound
     * @return
     */
    @Override
    public Point<Double>[] fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(points, bound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
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
     * @param bound
     * @return
     */
    @Override
    public Point<Double>[] fill(int lengthArray, Double bound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(bound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(points, bound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param minBound
     * @param maxBound
     * @return
     */
    @Override
    public Array<Point<Double>> fill(final Array<Point<Double>> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                        && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(array.getArray(), minBound, maxBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
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
    public Point<Double>[] fill(Point<Double>[] points, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(points, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
    public Point<Double>[] fill(int lengthArray, Double startBound, Double endBound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(points, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(points, startBound, endBound);
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinates(final Point<Double>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(), GeneratorRandomNumber.generateDouble());
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromZeroToBound(final Point<Double>[] points, final double bound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(bound), GeneratorRandomNumber.generateDouble(bound));
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledRandomDoubleCoordinatesFromMinBoundToMaxBound(final Point<Double>[] points, final double minBound, final double maxBound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(minBound, maxBound), GeneratorRandomNumber.generateDouble(minBound, maxBound));
        }
        return points;
    }

}
