package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see FillingArrayOfPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */

public class FillingArrayOfPointsReadIntegerNumbers extends FillingArrayOfPointsReadValues<Integer> {

    /**
     * <p></p>
     *
     * @param reader
     * */
    public FillingArrayOfPointsReadIntegerNumbers(Reader reader) {
        super(reader);
    }

    /**
     * <p></p>
     *
     * @param reading
     * */
    public FillingArrayOfPointsReadIntegerNumbers(Reading reading) {
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
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinates(array.getArray()));
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
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinates(points);
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
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinates(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinates(points);
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
    public Array<Point<Integer>> fill(final Array<Point<Integer>> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(array.getArray(), DEFAULT_INTEGER_POSITIVE_BOUND));
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
    public Point<Integer>[] fill(Point<Integer>[] points, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(points, bound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
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
    public Point<Integer>[] fill(int lengthArray, Integer bound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(bound)) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(points, bound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(points, DEFAULT_INTEGER_POSITIVE_BOUND);
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
    public Array<Point<Integer>> fill(Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayPoints(array.getArray())) {
                if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
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
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(points, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
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
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(points, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            points = this.initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(points, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinates(Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(super.getReader().readInt(), super.getReader().readInt());
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromZeroToBound(final Point<Integer>[] points, final int endBound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoorX = checkEnteredValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, endBound);
            int valueCoorY = checkEnteredValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, endBound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
        return points;
    }

    private Point<Integer>[] initializeArrayElementsToObjectOfPointsWithFilledEnteredIntegerCoordinatesFromStartBoundToEndBound(final Point<Integer>[] points, final int startBound, final int endBound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoorX = checkEnteredValueIsInRange(super.getReader().readInt(), startBound, endBound);
            int valueCoorY = checkEnteredValueIsInRange(super.getReader().readInt(), startBound, endBound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
        return points;
    }

    private int checkEnteredValueIsInRange(final int enteredValue, final int startBound, final int endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_INTEGER_VALUE;
    }

}
