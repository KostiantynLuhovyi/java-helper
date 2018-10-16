package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH_ARRAY;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Double}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */
public class FillingArrayPointsReadDoubleNumbers extends FillingArrayPointsReadValues<Double> implements FillingArrayPoints<Double> {

    //todo come up with and implement a variant of the methods without using the annotation SupressWarning.

    /**
     * Constructs a new object {@link FillingArrayPointsReadDoubleNumbers} class,
     *  initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPointsReadDoubleNumbers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPointsReadDoubleNumbers} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPointsReadDoubleNumbers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
            array.setArray(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     * @throws IllegalArgumentException The argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Double}
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthOfArray The length(size) of the array to be filled.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthOfArray) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                          DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                          DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     *
     * @param lengthOfArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthOfArray, Double bound) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                          DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                      DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              startBound,
                                                                                                                              endBound);
                array.setArray(points);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              startBound,
                                                                                                                              endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param lengthOfArray The length(size) of the array to be filled.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthOfArray, Double startBound, Double endBound) {
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              startBound,
                                                                                                                              endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                          DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                          DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(Point<Double>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.create(super.getReader().readDouble(), super.getReader().readDouble());
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(Point<Double>[] points,
                                                                                                                double bound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoordinateX = checkReadValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, bound);
            double valueCoordinateY = checkReadValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, bound);
            points[i] = Point.create(valueCoordinateX, valueCoordinateY);
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(Point<Double>[] points,
                                                                                                                    double startBound,
                                                                                                                    double endBound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoordinateX = checkReadValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            double valueCoordinateY = checkReadValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            points[i] = Point.create(valueCoordinateX, valueCoordinateY);
        }
    }

    private double checkReadValueIsInRange(double enteredValue, double startBound, double endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_DOUBLE_VALUE;
    }

}
