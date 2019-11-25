package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Integer}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */

//todo refactoring code
//todo edit doc's

public class FillingArrayPoints2DReadInteger extends FillingArrayPointsReadValues<Point2D<Integer>, Integer> {

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadInteger} class,
     * initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPoints2DReadInteger(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadInteger} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPoints2DReadInteger(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     * @throws NullPointerException The argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            this.fillArrayPointsReadInteger(points);
            array.setArray(points);
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Integer>[] points) {
        if (CheckerArray.checkLengthInArray(points)) {
            this.fillArrayPointsReadInteger(points);
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Integer}
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @return Created and filled array of the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Integer>[] fill(int lengthArray) {
        Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            this.fillArrayPointsReadInteger(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultNumericValues}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array, Integer bound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadIntegerFromZeroToBound(points, bound);
                array.setArray(points);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultNumericValues}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Integer>[] points, Integer bound) {
        if (CheckerArray.checkLengthInArray(points)) {
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadIntegerFromZeroToBound(points, bound);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultNumericValues}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Integer>[] fill(int lengthArray, Integer bound) {
        Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadIntegerFromZeroToBound(points, bound);
            }
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultNumericValues}
     * and {@link DefaultNumericValues} respectively.
     *
     * @param array                The object of the {@link Array} class to be filled.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null;
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array, Integer lowerBoundCoordinate, Integer upperBoundCoordinate) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                    array.setArray(points);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultNumericValues}
     * and {@link DefaultNumericValues} respectively.
     *
     * @param points               The array to be filled.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException The argument array is null.
     */
    @Override
    public void fill(Point2D<Integer>[] points, Integer lowerBoundCoordinate, Integer upperBoundCoordinate) {
        if (CheckerArray.checkLengthInArray(points)) {
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "lowerBoundCoordinate" to the value of the "upperBoundCoordinate" parameters.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultNumericValues}
     * and {@link DefaultNumericValues} respectively.
     *
     * @param lengthArray          The length(size) of the array to be filled.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Integer>[] fill(int lengthArray, Integer lowerBoundCoordinate, Integer upperBoundCoordinate) {
        Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
        return points;
    }

    private void fillArrayPointsReadInteger(Point2D<Integer>[] points) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readInt();
            yCoor = super.getReader().readInt();
            Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsReadIntegerFromZeroToBound(Point2D<Integer>[] points, int bound) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readInt();
            yCoor = super.getReader().readInt();
            if ((xCoor >= INT_ZERO && xCoor <= bound) && (yCoor >= INT_ZERO && yCoor <= bound)) {
                Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Value read is not a int number or is out of range (from 0 to " + bound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

    private void fillArrayPointsReadIntegerFromLowerBoundToUpperBound(Point<Integer>[] points, int lowerBound, int upperBound) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readInt();
            yCoor = super.getReader().readInt();
            if ((xCoor >= lowerBound && xCoor <= upperBound) && (yCoor >= lowerBound && yCoor <= upperBound)) {
                Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Value read is not a int number or is out of range (from " + lowerBound + " to " + upperBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

}
