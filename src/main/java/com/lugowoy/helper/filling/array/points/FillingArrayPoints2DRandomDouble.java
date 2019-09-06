package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * <p>
 * The class implements the contract declared by the {@link FillingArrayPointsNumbers} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Double}.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPointsNumbers
 */
//todo edit doc's
public class FillingArrayPoints2DRandomDouble extends FillingArrayPointsNumbers<Double> {

    //todo come up with and implement a variant of the methods without using the annotation SupressWarning.

    public FillingArrayPoints2DRandomDouble(int dimensionPoint) {
        super(dimensionPoint);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Double>> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Point<Double>[] points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.fillArrayPointsRandomDoubleNumbers(points);
            array.setArray(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Double}.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(points)) {
            this.fillArrayPointsRandomDoubleNumbers(points);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
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
            this.fillArrayPointsRandomDoubleNumbers(points);
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsRandomDoubleNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Double}.
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
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
                array.setArray(points);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Double}.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(points)) {
            if (isPositiveBound(bound)) {
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
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
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isPositiveBound(bound)) {
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(points, POSITIVE_DOUBLE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to be filled
     *                   with an object of the {@link Point} class random numeric coordinates of type {@link Double}.
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
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
                array.setArray(points);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
                array.setArray(points);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param points     The array to be filled with objects of the {@link Point} class
     *                   with random numeric coordinates of type {@link Double}.
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
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "startBound" to "endBound" parameter.
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
        //todo check or add relevant checks.
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            points = (Point<Double>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH);
            this.fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(points, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
        }
        return points;
    }

    private void fillArrayPointsRandomDoubleNumbers(Point<Double>[] points) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble();
            yCoor = GeneratorRandomNumber.generateDouble();
            Point<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomDoubleNumbersFromZeroToPositiveBound(Point<Double>[] points, double bound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble(bound);
            yCoor = GeneratorRandomNumber.generateDouble(bound);
            Point<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomDoubleNumbersFromStartBoundToEndBound(Point<Double>[] points, double startBound, double endBound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble(startBound, endBound);
            yCoor = GeneratorRandomNumber.generateDouble(startBound, endBound);
            Point<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

}
