package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.DOUBLE_ZERO;
import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Double}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
//todo edit doc's
public class FillingArrayPoints2DReadDouble extends FillingArrayPointsReadValues<Point2D<Double>, Double> {

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDouble} class,
     * initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPoints2DReadDouble(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDouble} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPoints2DReadDouble(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array) {
        if (checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            this.fillArrayPointsReadDouble(points);
            array.setArray(points);
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     * @throws NullPointerException The argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points) {
        if (checkLengthInArray(points)) {
            this.fillArrayPointsReadDouble(points);
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Double}
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
    public Point2D<Double>[] fill(int lengthArray) {
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            this.fillArrayPointsReadDouble(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double bound) {
        if (checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double bound) {
        if (checkLengthInArray(points)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray, Double bound) {
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
            }
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param array                The object of the {@link Array} class to be filled.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        if (checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (isCorrectBounds(lowerBoundCoordinate) && isCorrectBounds(upperBoundCoordinate)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                    array.setArray(points);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param points               The array to be filled.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        if (checkLengthInArray(points)) {
            if (isCorrectBounds(lowerBoundCoordinate) && isCorrectBounds(upperBoundCoordinate)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "lowerBoundCoordinate" to the value of the "upperBoundCoordinate" parameters.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
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
    public Point2D<Double>[] fill(int lengthArray, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (isCorrectBounds(lowerBoundCoordinate) && isCorrectBounds(upperBoundCoordinate)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
        return points;
    }

    private void fillArrayPointsReadDouble(Point2D<Double>[] points) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsReadDoubleFromZeroToBound(Point2D<Double>[] points, double bound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            if ((xCoor >= DOUBLE_ZERO && xCoor <= bound) && (yCoor >= DOUBLE_ZERO && yCoor <= bound)) {
                Point2D<Double> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Value read is not a double number or is out of range (from 0.0 to " + bound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

    private void fillArrayPointsReadDoubleFromLowerBoundToUpperBound(Point<Double>[] points, double startBound, double endBound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            if ((xCoor >= startBound && xCoor <= endBound) && (yCoor >= startBound && yCoor <= endBound)) {
                Point2D<Double> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Value read is not a double number or is out of range (from " + startBound + " to " + endBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

}
