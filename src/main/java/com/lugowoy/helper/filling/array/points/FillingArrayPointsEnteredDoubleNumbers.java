package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsEnteredValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * */

public class FillingArrayPointsEnteredDoubleNumbers extends FillingArrayPointsEnteredValues<Double>
                                                                implements FillingArrayPointsWithNumbersCoordinates<Double> {

    /**
     * <p></p>
     *
     * @param reader
     * */
    public FillingArrayPointsEnteredDoubleNumbers(Reader reader) {
        super(reader);
    }

    /**
     * <p></p>
     *
     * @param reading
     * */
    public FillingArrayPointsEnteredDoubleNumbers(Reading reading) {
        super(reading);
    }

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
                array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinates(array.getArray()));
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
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinates(points);
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
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinates(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinates(points);
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
    public Array<Point<Double>> fill(final Array<Point<Double>> array, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkBoundValueIsPositive(endBound)) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND));
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
    public Point<Double>[] fill(Point<Double>[] points, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(endBound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(points, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
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
    public Point<Double>[] fill(int lengthArray, Double endBound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(endBound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(points, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
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
    public Array<Point<Double>> fill(final Array<Point<Double>> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
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
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(points ,startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(points, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(points, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(points, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinates(Point<Double>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(super.getReader().readDouble(), super.getReader().readDouble());
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromZeroToBound(final Point<Double>[] points, final double endBound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoorX = checkEnteredValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, endBound);
            double valueCoorY = checkEnteredValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, endBound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
        return points;
    }

    private Point<Double>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredDoubleCoordinatesFromStartBoundToEndBound(final Point<Double>[] points, final double startBound, final double endBound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoorX = checkEnteredValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            double valueCoorY = checkEnteredValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
        return points;
    }

    private double checkEnteredValueIsInRange(final double enteredValue, final double startBound, final double endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_DOUBLE_VALUE;
    }

}
