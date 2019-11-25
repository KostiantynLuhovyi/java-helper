package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

/**
 * The class implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
public class FillingArrayPoints2DRandomInteger implements FillingArrayPoints<Point2D<Integer>, Integer> {

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.size());
            this.fillArrayPointsRandomInteger(points);
            array.setArray(points);
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Integer}.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Integer>[] points) {
        if (CheckerArray.checkLengthInArray(points)) {
            this.fillArrayPointsRandomInteger(points);
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class
     * are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @return Created and filled array of the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Integer>[] fill(int lengthArray) {
        Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            this.fillArrayPointsRandomInteger(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "boundCoordinate".
     * If the value of the "boundCoordinate" argument is a negative number,
     * then the range value for filling the array from "0" to {@link com.lugowoy.helper.filling.DefaultNumericValues}
     *
     * @param array           The object of the {@link Array} class to be filled
     *                        with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array, Integer boundCoordinate) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(boundCoordinate, Integer.MAX_VALUE)) {
                this.fillArrayPointsRandomIntegerFromZeroToBound(points, boundCoordinate);
                array.setArray(points);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to to "boundCoordinate".
     * If the value of the "boundCoordinate" argument is a negative number,
     * then the range value for filling the array from "0" to {@link com.lugowoy.helper.filling.DefaultNumericValues}.
     *
     * @param points          The array to be filled with objects of the {@link Point} class
     *                        with random numeric coordinates of type {@link Integer}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException The argument array is null.
     */
    @Override
    public void fill(Point2D<Integer>[] points, Integer boundCoordinate) {
        if (CheckerArray.checkLengthInArray(points)) {
            if (CheckerBound.isCorrectBound(boundCoordinate, Integer.MAX_VALUE)) {
                this.fillArrayPointsRandomIntegerFromZeroToBound(points, boundCoordinate);
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link com.lugowoy.helper.filling.DefaultNumericValues}.
     *
     * @param lengthArray     The length(size) of the array to be filled with objects of the {@link Point} class
     *                        with random numeric coordinates of type {@link Integer}.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Integer>[] fill(int lengthArray, Integer boundCoordinate) {
        Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, 0);
        if (CheckerArray.checkLengthArray(lengthArray)) {
            points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
            if (CheckerBound.isCorrectBound(boundCoordinate, Integer.MAX_VALUE)) {
                this.fillArrayPointsRandomIntegerFromZeroToBound(points, boundCoordinate);
            }
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate".
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link com.lugowoy.helper.filling.DefaultNumericValues}
     * and {@link com.lugowoy.helper.filling.DefaultNumericValues} respectively.
     *
     * @param array                The object of the {@link Array} class to be filled
     *                             with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @throws NullPointerException The argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Integer>> array, Integer lowerBoundCoordinate, Integer upperBoundCoordinate) {
        if (CheckerArray.checkLengthInArray(array)) {
            Point2D<Integer>[] points = (Point2D<Integer>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
            if (CheckerBound.isCorrectBound(lowerBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBoundCoordinate, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundCoordinate, upperBoundCoordinate)) {
                    this.fillArrayPointsRandomIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                    array.setArray(points);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "lowerBoundCoordinate" to to "upperBoundCoordinate".
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link com.lugowoy.helper.filling.DefaultNumericValues}
     * and {@link com.lugowoy.helper.filling.DefaultNumericValues} respectively.
     *
     * @param points               The array to be filled with objects of the {@link Point} class
     *                             with random numeric coordinates of type {@link Integer}.
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
                    this.fillArrayPointsRandomIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link com.lugowoy.helper.filling.DefaultNumericValues}
     * and {@link com.lugowoy.helper.filling.DefaultNumericValues} respectively.
     *
     * @param lengthArray          The length(size) of the array to be filled
     *                             with objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
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
                    this.fillArrayPointsRandomIntegerFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
                }
            }
        }
        return points;
    }

    private void fillArrayPointsRandomInteger(Point2D<Integer>[] points) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateInt();
            yCoor = GeneratorRandomNumber.generateInt();
            Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomIntegerFromZeroToBound(Point2D<Integer>[] points, int bound) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateInt(bound);
            yCoor = GeneratorRandomNumber.generateInt(bound);
            Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsRandomIntegerFromLowerBoundToUpperBound(Point2D<Integer>[] points, int lowerBound, int upperBound) {
        int xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = GeneratorRandomNumber.generateInt(lowerBound, upperBound);
            yCoor = GeneratorRandomNumber.generateInt(lowerBound, upperBound);
            Point2D<Integer> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

}
