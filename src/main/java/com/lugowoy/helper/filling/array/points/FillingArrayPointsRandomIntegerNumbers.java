package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH_ARRAY;

/**
 * The class implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */
public class FillingArrayPointsRandomIntegerNumbers implements FillingArrayPoints<Integer> {

    //todo come up with and implement a variant of the methods without using the annotation SupressWarning.

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
            array.setArray(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Integer}.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class
     * are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthOfArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthOfArray) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
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
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points, bound);
                array.setArray(points);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                        POSITIVE_INTEGER_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Integer}.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException The argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(points)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points, bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     *
     * @param lengthOfArray The length(size) of the array to be filled with objects of the {@link Point} class
     *                    with random numeric coordinates of type {@link Integer}.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthOfArray, Integer bound) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                                                                                                                     bound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                    POSITIVE_INTEGER_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException The argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound,
                                                                                                                            endBound);
                array.setArray(points);
            } else {
                    this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                            NEGATIVE_INTEGER_BOUND,
                            POSITIVE_INTEGER_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param points     The array to be filled with objects of the {@link Point} class
     *                   with random numeric coordinates of type {@link Integer}.
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
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound,
                                                                                                                            endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                        NEGATIVE_INTEGER_BOUND,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param lengthOfArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthOfArray, Integer startBound, Integer endBound) {
        //todo check or add relevant checks.
        Point<Integer>[] points;
        if (checkLengthArray(lengthOfArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthOfArray);
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                        NEGATIVE_INTEGER_BOUND,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                        startBound,
                                                                                                                        endBound);
        }
        return points;
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.create(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(Point<Integer>[] points,
                                                                                                           int bound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.create(GeneratorRandomNumber.generateInt(bound), GeneratorRandomNumber.generateInt(bound));
        }
    }

    private void fillArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromStartBoundToEndBound(Point<Integer>[] points,
                                                                                                                    int startBound,
                                                                                                                    int endBound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.create(GeneratorRandomNumber.generateInt(startBound, endBound), GeneratorRandomNumber.generateInt(startBound, endBound));
        }
    }

}
