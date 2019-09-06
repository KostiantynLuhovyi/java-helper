package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Double}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPointsNumbers} interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPointsNumbers
 */
//todo edit doc's
public class FillingArrayPoints2DReadDouble extends FillingArrayPointsReadValues<Double> {

    //todo come up with and implement a variant of the methods without using the annotation SupressWarning.

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDouble} class,
     * initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPoints2DReadDouble(Reader reader, int dimensionPoint) {
        super(reader, dimensionPoint);
    }

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDouble} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPoints2DReadDouble(Reading reading, int dimensionPoint) {
        super(reading, dimensionPoint);
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
    public void fill(Array<Point<Double>> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.fillArrayPointsReadDoubleNumbers(points);
            array.setArray(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
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
    public void fill(Point<Double>[] points) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(points)) {
            this.fillArrayPointsReadDoubleNumbers(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
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
    public Point<Double>[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            this.fillArrayPointsReadDoubleNumbers(points);
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsReadDoubleNumbers(points);
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
    public void fill(Array<Point<Double>> array, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isPositiveBound(bound)) {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
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
    public void fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(points)) {
            if (isPositiveBound(bound)) {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
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
    public Point<Double>[] fill(int lengthArray, Double bound) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isPositiveBound(bound)) {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
                array.setArray(points);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param points     The array to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(points)) {
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthArray, Double startBound, Double endBound) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
        }
        return points;
    }

    private void fillArrayPointsReadDoubleNumbers(Point<Double>[] points) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            Point<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsReadDoubleNumbersFromZeroToPositiveBound(Point<Double>[] points, double bound) {
        this.fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(points, START_BOUND, bound);
    }

    private void fillArrayPointsReadDoubleNumbersFromStartBoundToEndBound(Point<Double>[] points, double startBound, double endBound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            double xCoorReadValue = super.getReader().readDouble();
            xCoor = isReadValueIsInRange(xCoorReadValue, startBound, endBound) ? xCoorReadValue : DOUBLE_VALUE;
            double yCoorReadValue = super.getReader().readDouble();
            yCoor = isReadValueIsInRange(yCoorReadValue, startBound, endBound) ? yCoorReadValue : DOUBLE_VALUE;
            Point<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private boolean isReadValueIsInRange(double value, double startBound, double endBound) {
        return (value >= startBound) && (value <= endBound);
    }

}
