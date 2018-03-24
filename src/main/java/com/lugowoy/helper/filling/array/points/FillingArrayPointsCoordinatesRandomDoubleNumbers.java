package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_POSITIVE_BOUND;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 *
 * The class implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Double}.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */

public class FillingArrayPointsCoordinatesRandomDoubleNumbers implements FillingArrayPoints<Double> {

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are in the range from {@link GeneratorRandomNumber#START_DOUBLE_BOUND}
     * to {@link GeneratorRandomNumber#END_DOUBLE_BOUND}.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbers(points);
            array.setArray(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are in the range from {@link GeneratorRandomNumber#START_DOUBLE_BOUND}
     * to {@link GeneratorRandomNumber#END_DOUBLE_BOUND}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Double}.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbers(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are in the range from {@link GeneratorRandomNumber#START_DOUBLE_BOUND}
     * to {@link GeneratorRandomNumber#END_DOUBLE_BOUND}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthArray) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbers(points);
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
                array.setArray(points);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                            DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Double}.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                            DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     *
     * @param lengthArray The length(size) of the array to be filled with objects of the {@link Point} class
     *                    with random numeric coordinates of type {@link Double}.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthArray, Double bound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                            DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(points,
                                                                                                                        DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class random numeric coordinates of type {@link Double}.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @throws  IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           startBound,
                                                                                                                           endBound);
                array.setArray(points);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                           DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled with objects of the {@link Point} class
     *                   with random numeric coordinates of type {@link Double}.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           startBound,
                                                                                                                           endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                           DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Double>[] fill(int lengthArray, Double startBound, Double endBound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           startBound,
                                                                                                                           endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                           DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                           DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                       DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                       DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbers(Point<Double>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(),
                                    GeneratorRandomNumber.generateDouble());
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromZeroToPositiveBound(Point<Double>[] points,
                                                                                                                        double bound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(bound),
                                    GeneratorRandomNumber.generateDouble(bound));
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomDoubleNumbersFromStartBoundToEndBound(Point<Double>[] points,
                                                                                                                         double startBound,
                                                                                                                         double endBound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateDouble(startBound, endBound),
                                    GeneratorRandomNumber.generateDouble(startBound, endBound));
        }
    }

}
