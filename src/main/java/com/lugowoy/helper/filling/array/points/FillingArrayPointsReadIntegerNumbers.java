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
 * with an object of the {@link Point} class with numeric coordinates of type {@link Integer}
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
public class FillingArrayPointsReadIntegerNumbers extends FillingArrayPointsReadValues<Integer> implements FillingArrayPoints<Integer> {

    //todo come up with and implement a variant of the methods without using the annotation SupressWarning.

    /**
     * Constructs a new object {@link FillingArrayPointsReadIntegerNumbers} class,
     *  initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPointsReadIntegerNumbers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPointsReadIntegerNumbers} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPointsReadIntegerNumbers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     * @throws IllegalArgumentException The argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
            array.setArray(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Integer}
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           bound);
                array.setArray(points);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo check or add relevant checks.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer bound) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                       DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null;
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
                array.setArray(points);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException The argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
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
    public Point<Integer>[] fill(int lengthArray, Integer startBound, Integer endBound) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                        DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                        DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(super.getReader().readInt(), super.getReader().readInt());
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(Point<Integer>[] points,
                                                                                                                 int bound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoordinateX = checkReadValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, bound);
            int valueCoordinateY = checkReadValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, bound);
            points[i] = new Point<>(valueCoordinateX, valueCoordinateY);
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(Point<Integer>[] points,
                                                                                                                  int startBound,
                                                                                                                  int endBound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoordinateX = checkReadValueIsInRange(super.getReader().readInt(), startBound, endBound);
            int valueCoordinateY = checkReadValueIsInRange(super.getReader().readInt(), startBound, endBound);
            points[i] = new Point<>(valueCoordinateX, valueCoordinateY);
        }
    }

    private int checkReadValueIsInRange(final int enteredValue, final int startBound, final int endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_INTEGER_VALUE;
    }

}
