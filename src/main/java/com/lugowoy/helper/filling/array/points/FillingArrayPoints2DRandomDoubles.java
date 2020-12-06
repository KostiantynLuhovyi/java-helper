package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 * <p>The class implements the contract declared by the {@link
 * FillingArrayPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric
 * coordinates of type {@link Double}.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
//TODO review documentation
public class FillingArrayPoints2DRandomDoubles
        implements FillingArrayPoints<Point2D<Double>, Double> {

    /**
     * Fills an object of class {@link Array} with the objects of the {@link
     * Point} class with random numeric coordinates of type {@link Double}.
     * Numerical values for coordinates of object of {@link Point} class are in
     * the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param array The object of class {@link Array} to be filled with the
     * objects of the {@link Point} class with random numeric coordinates of
     * type {@link Double}.
     * @throws NullPointerException If argument object is null.
     */
    @Override
    public void fill(@NotNull final Array<Point2D<Double>> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Point2D<Double>[] points = this.instanceArrayPoints(array.size());
        this.fillArrayPoints(points);
        array.setArray(points);
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric
     * coordinates of type {@link Double}. Numerical values for coordinates of
     * object of {@link Point} class are in the range from {@link
     * Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param array The array to be filled with the objects of the {@link Point}
     * class with random numeric coordinates of type {@link Double}.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(@NotNull final Point2D<Double>[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArrayPoints(array);
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random
     * numeric coordinates of type {@link Double}. Numerical values for
     * coordinates of object of {@link Point} class are in the range from {@link
     * Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of "lengthArray" is less than "0" or is greatest than
     * "32767", created array of length {@link Array#DEFAULT_CAPACITY}.
     *
     * @param lengthArray The length(size) of the array to be filled with the
     * objects of the {@link Point} class with random numeric coordinates of
     * type {@link Double}.
     * @return Created and filled array of the objects of the {@link Point}
     * class with random numeric coordinates of type {@link Double}.
     */
    @Override
    public Point2D<Double>[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        Point2D<Double>[] points = this.instanceArrayPoints(lengthArray);
        this.fillArrayPoints(points);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with random numeric coordinates of type {@link Double} in
     * the range from "0" to "bound". If the value of the "bound" argument is a
     * negative number, then the range value for filling the array from "0" to
     * {@link }
     *
     * @param array The object of the {@link Array} class to be filled with an
     * object of the {@link Point} class with random numeric coordinates of type
     * {@link Double}.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     * @throws NullPointerException If argument object is null.
     */
    @Override
    public void fill(@NotNull final Array<Point2D<Double>> array,
                     @NotNull final Double boundCoor) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(boundCoor, Double.MAX_VALUE);
        Point2D<Double>[] points = this.instanceArrayPoints(array.size());
        this.fillArrayPointsFromZeroToBound(points, boundCoor);
        array.setArray(points);
    }

    /**
     * Fills an array with objects of the {@link Point} class with random
     * numeric coordinates of type {@link Double} in the range from "0" to to
     * "bound". If the value of the "bound" argument is a negative number, then
     * the range value for filling the array from "0" to {@link }.
     *
     * @param points The array to be filled with objects of the {@link Point}
     * class with random numeric coordinates of type {@link Double}.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(@NotNull final Point2D<Double>[] points,
                     @NotNull final Double boundCoor) {
        CheckerArray.check(points, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(boundCoor, Double.MAX_VALUE);
        this.fillArrayPointsFromZeroToBound(points, boundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with random
     * numeric coordinates of type {@link Double} in the range from "0" to
     * "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of the "bound" argument is a negative number, then
     * the range value for filling the array from "0" to {@link }.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with random numeric coordinates of
     * type {@link Double}.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array of objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     */
    @Override
    public Point2D<Double>[] fill(final int lengthArray,
                                  @NotNull final Double boundCoor) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(boundCoor, Double.MAX_VALUE);
        Point2D<Double>[] points = this.instanceArrayPoints(lengthArray);
        this.fillArrayPointsFromZeroToBound(points, boundCoor);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with random numeric coordinates of type {@link Double} in
     * the range from "lowerBound" to "upperBound". If the value of the argument
     * "lowerBound" is greater than the value of "upperBound" or if one of the
     * arguments is in the range from -32768 to 32768, then the values {@link }
     * and {@link } respectively.
     *
     * @param array The object of the {@link Array} class to be filled with an
     * object of the {@link Point} class random numeric coordinates of type
     * {@link Double}.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @throws NullPointerException If argument object is null.
     */
    @Override
    public void fill(@NotNull final Array<Point2D<Double>> array,
                     @NotNull final Double lowerBoundCoor,
                     @NotNull final Double upperBoundCoor) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundCoor,
                                                      upperBoundCoor);
        Point2D<Double>[] points = this.instanceArrayPoints(array.size());
        this.fillArrayPointsFromLowerToUpper(points, lowerBoundCoor,
                                             upperBoundCoor);
        array.setArray(points);
    }

    /**
     * Fills an array with objects of the {@link Point} class with random
     * numeric coordinates of type {@link Double} in the range from "lowerBound"
     * to to "upperBound". If the value of the argument "lowerBound" is greater
     * than the value of "upperBound" or if one of the arguments is in the range
     * from -32768 to 32768, then the values {@link } and {@link }
     * respectively.
     *
     * @param points The array to be filled with objects of the {@link Point}
     * class with random numeric coordinates of type {@link Double}.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(@NotNull final Point2D<Double>[] points,
                     @NotNull final Double lowerBoundCoor,
                     @NotNull final Double upperBoundCoor) {
        CheckerArray.check(points, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundCoor,
                                                      upperBoundCoor);
        this.fillArrayPointsFromLowerToUpper(points, lowerBoundCoor,
                                             upperBoundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with random
     * numeric coordinates of type {@link Double} in the range from "startBound"
     * to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of "lengthArray" is less than "0" or is greatest than
     * "32767", created array of length {@link Array#DEFAULT_CAPACITY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of
     * the "endBound" parameters. If the value of the argument "startBound" is
     * greater than the value of "endBound" or if one of the arguments is in the
     * range from -32768 to 32768, then the values {@link } and {@link }
     * respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with random numeric coordinates of
     * type {@link Double}.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array of objects of the {@link Point} class
     * with numerical coordinates.
     */
    @Override
    public Point2D<Double>[] fill(final int lengthArray,
                                  @NotNull final Double lowerBoundCoor,
                                  @NotNull final Double upperBoundCoor) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundCoor, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundCoor,
                                                      upperBoundCoor);
        Point2D<Double>[] points = this.instanceArrayPoints(lengthArray);
        this.fillArrayPointsFromLowerToUpper(points, lowerBoundCoor,
                                             upperBoundCoor);
        return points;
    }

    private void fillArrayPoints(final Point2D<Double>[] points) {
        this.fillArrayPointsFromLowerToUpper(points, Double.MIN_VALUE,
                                             Double.MAX_VALUE);
    }

    private void fillArrayPointsFromZeroToBound(final Point<Double>[] points,
                                                final double boundCoor) {
        this.fillArrayPointsFromLowerToUpper(points,
                                             BigDecimal.ZERO.doubleValue(),
                                             boundCoor);
    }

    private void fillArrayPointsFromLowerToUpper(final Point<Double>[] points,
                                                 final double lowerBoundCoor,
                                                 final double upperBoundCoor) {
        RandomNumber randomNumber = new RandomNumber();
        double xCoor;
        double yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = randomNumber.generateDouble(lowerBoundCoor, upperBoundCoor);
            yCoor = randomNumber.generateDouble(lowerBoundCoor, upperBoundCoor);
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    @SuppressWarnings("unchecked") //Type safety when casting.
    private Point2D<Double>[] instanceArrayPoints(final int lengthArray) {
        return (Point2D<Double>[]) java.lang.reflect.Array.newInstance(
                Point2D.class, lengthArray);
    }

}
