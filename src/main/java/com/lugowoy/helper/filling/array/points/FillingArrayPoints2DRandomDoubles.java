package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 * <p>
 * The class implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Double}.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
//TODO edit doc's
public class FillingArrayPoints2DRandomDoubles implements FillingArrayPoints<Point2D<Double>, Double> {

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of class {@link Array} to be filled
     * with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     *
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array) {
        CheckerArray.checkLengthInArray(array);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsRandomDouble(points);
        array.setArray(points);
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     *
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points) {
        CheckerArray.checkLengthInArray(points);
        this.fillArrayPointsRandomDouble(points);
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
     * with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     *
     * @return Created and filled array of the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsRandomDouble(points);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}
     *
     * @param array The object of the {@link Array} class to be filled
     * with an object of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double boundCoordinate) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
        array.setArray(points);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link }.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double boundCoordinate) {
        CheckerArray.checkLengthInArray(points);
        CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE);
        this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}.
     *
     * @param lengthArray The length(size) of the array to be filled with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * @param boundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray, Double boundCoordinate) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(boundCoordinate, Long.MAX_VALUE);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsRandomDoubleFromZeroToPositiveBound(points, boundCoordinate);
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
     * @param array The object of the {@link Array} class to be filled
     * with an object of the {@link Point} class random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsRandomDoubleFromLowerToUpperBounds(points, lowerBoundCoordinate, upperBoundCoordinate);
        array.setArray(points);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double} in the range from "lowerBound" to to "upperBound".
     * If the value of the argument "lowerBound" is greater than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        CheckerArray.checkLengthInArray(points);
        CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        this.fillArrayPointsRandomDoubleFromLowerToUpperBounds(points, lowerBoundCoordinate, upperBoundCoordinate);
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
     * @param lengthArray The length(size) of the array to be filled
     * with objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsRandomDoubleFromLowerToUpperBounds(points, lowerBoundCoordinate, upperBoundCoordinate);
        return points;
    }

    private void fillArrayPointsRandomDouble(Point2D<Double>[] points) {
        this.fillArrayPointsRandomDoubleFromLowerToUpperBounds(points, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayPointsRandomDoubleFromZeroToPositiveBound(Point<Double>[] points, double bound) {
        this.fillArrayPointsRandomDoubleFromLowerToUpperBounds(points, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillArrayPointsRandomDoubleFromLowerToUpperBounds(Point<Double>[] points, double lowerBound, double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = randomNumber.generateDouble(lowerBound, upperBound);
            yCoor = randomNumber.generateDouble(lowerBound, upperBound);
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

}
