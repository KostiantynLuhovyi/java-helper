package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * <p>
 * The class implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Double}.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
//todo edit doc's
public class FillingArrayPoints2DRandomDoubles implements FillingArrayPoints<Point2D<Double>, Double> {

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
    @Override
    public void fill(Array<Point2D<Double>> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            this.fillArrayPointsRandomDouble(points);
            array.setArray(points);
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
    public void fill(Point2D<Double>[] points) {
        if (CheckerArray.checkLengthInArray(points)) {
            this.fillArrayPointsRandomDouble(points);
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
    public Point2D<Double>[] fill(int lengthArray) {
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            this.fillArrayPointsRandomDouble(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}
     *
     * @param array           The object of the {@link Array} class to be filled
     *                        with an object of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double boundCoordinate) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE)) {
                this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
                array.setArray(points);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link }.
     *
     * @param points          The array to be filled with objects of the {@link Point} class
     *                        with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double boundCoordinate) {
        if (CheckerArray.checkLengthInArray(points)) {
            if (CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE)) {
                this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}.
     *
     * @param lengthArray     The length(size) of the array to be filled with objects of the {@link Point} class
     *                        with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray, Double boundCoordinate) {
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE)) {
                this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
            }
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "lowerBound" to "upperBound".
     * If the value of the argument "lowerBound" is greater than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param array                The object of the {@link Array} class to be filled
     *                             with an object of the {@link Point} class random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsRandomDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                    array.setArray(points);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "lowerBound" to to "upperBound".
     * If the value of the argument "lowerBound" is greater than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param points               The array to be filled with objects of the {@link Point} class
     *                             with random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        if (CheckerArray.checkLengthInArray(points)) {
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsRandomDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
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
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param lengthArray          The length(size) of the array to be filled
     *                             with objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
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
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsRandomDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
        return points;
    }

    private void fillArrayPointsRandomDouble(Point2D<Double>[] points) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble();
            yCoor = GeneratorRandomNumber.generateDouble();
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomDoubleFromZeroToPositiveBound(Point<Double>[] points, double bound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble(bound);
            yCoor = GeneratorRandomNumber.generateDouble(bound);
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomDoubleFromLowerBoundToUpperBound(Point<Double>[] points, double lowerBound, double upperBound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateDouble(lowerBound, upperBound);
            yCoor = GeneratorRandomNumber.generateDouble(lowerBound, upperBound);
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

}
