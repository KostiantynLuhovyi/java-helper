package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and
 * implements it's contract. The class provides functionality to fill an object
 * of the {@link Array} class and classical arrays with an object of the {@link
 * Point} class with numeric coordinates of type {@link Double} using the data
 * read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints}
 * interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */
//TODO review documentation
public class FillingArrayPoints2DReadDoubles
        extends FillingArrayPointsReadValues<Point2D<Double>, Double> {

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDoubles} class,
     * initializing an object of {@link Reader} class encapsulated in parent
     * class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an
     * object {@link Reader} class encapsulated in parent class to read data to
     * fill array.
     */
    public FillingArrayPoints2DReadDoubles(@NotNull final Reader reader) {
        super(reader);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link
     * Point} class with numeric coordinates of type {@link Double} using the
     * data read by the object of the class {@link Reader} encapsulated in
     * parent class.
     *
     * @param array The object of class {@link Array} to be filled.
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
     * Fills an array of objects of the {@link Point} class with numeric
     * coordinates of type {@link Double} using the data read by the object of
     * the class {@link Reader} encapsulated in parent class.
     *
     * @param array The array to be filled.
     * @throws NullPointerException The argument array is null.
     */
    @Override
    public void fill(@NotNull final Point2D<Double>[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArrayPoints(array);
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric
     * coordinates of type {@link Double} using the data read by the object of
     * the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of "lengthArray" is less than "0" or is greatest than
     * "32767".
     *
     * @param lengthArray The length(size) of the array to be filled.
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
     * Point} class with numeric coordinates of type {@link Double} in the range
     * from "0" to "boundValue" parameter, using the data read by the object of
     * the class {@link Reader} encapsulated in parent class. If the value of
     * the "boundValue" argument is a negative number, then the range value for
     * filling the array from "0" to {@link }
     *
     * @param array The object of the {@link Array} class to be filled.
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
    }

    /**
     * Fills an array with objects of the {@link Point} class with numeric
     * coordinates of type {@link Double} in the range from "0" to "boundValue"
     * parameter, using the data read by the object of the class {@link Reader}
     * encapsulated in parent class. If the value of the "boundValue" argument
     * is a negative number, then the range value for filling the array from "0"
     * to {@link }.
     *
     * @param points The array to be filled.
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
     * Fills an array with objects of the {@link Point} class with numeric
     * coordinates of type {@link Double}  in the range from "0" to "boundValue"
     * parameter, using the data read by the object of the class {@link Reader}
     * encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of the "boundValue" argument is a negative number,
     * then the range value for filling the array from "0" to {@link }.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array of objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     */
    @Override
    public Point2D<Double>[] fill(final int lengthArray,
                                  @NotNull final Double boundCoor) {
        CheckerArray.check(lengthArray, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(boundCoor, Double.MAX_VALUE);
        Point2D<Double>[] points = this.instanceArrayPoints(lengthArray);
        this.fillArrayPointsFromZeroToBound(points, boundCoor);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with numeric coordinates of type {@link Double} in the range
     * from "lowerBoundCoordinate" to "upperBoundCoordinate", using the data
     * read by the object of the class {@link Reader} encapsulated in parent
     * class. If the value of the argument "lowerBoundCoordinate" is greater
     * than the value of "upperBoundCoordinate" or if one of the arguments is in
     * the range from -32768 to 32768, then the values {@link } and {@link }
     * respectively.
     *
     * @param array The object of the {@link Array} class to be filled.
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
     * Fills an array with objects of the {@link Point} class with numeric
     * coordinates of type {@link Double} in the range from
     * "lowerBoundCoordinate" to "upperBoundCoordinate", using the data read by
     * the object of the class {@link Reader} encapsulated in parent class. If
     * the value of the argument "lowerBoundCoordinate" is greater than the
     * value of "upperBoundCoordinate" or if one of the arguments is in the
     * range from -32768 to 32768, then the values {@link } and {@link }
     * respectively.
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
     * Fills an array with objects of the {@link Point} class with numeric
     * coordinates of type {@link Double} in the range from
     * "lowerBoundCoordinate" to "upperBoundCoordinate" parameter, using the
     * data read by the object of the class {@link Reader} encapsulated in
     * parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of "lengthArray" is less than "0" or is greatest than
     * "32767", created array of length {@link }.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "lowerBoundCoordinate" to the
     * value of the "upperBoundCoordinate" parameters. If the value of the
     * argument "lowerBoundCoordinate" is greater than the value of
     * "upperBoundCoordinate" or if one of the arguments is in the range from
     * -32768 to 32768, then the values {@link } and {@link } respectively.
     *
     * @param lengthArray The length(size) of the array to be filled.
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

    private void fillArrayPointsFromZeroToBound(final Point2D<Double>[] points,
                                                final double boundCoor) {
        this.fillArrayPointsFromLowerToUpper(points,
                                             BigDecimal.ZERO.doubleValue(),
                                             boundCoor);
    }

    private void fillArrayPointsFromLowerToUpper(final Point<Double>[] points,
                                                 final double lowerBoundCoor,
                                                 final double upperBoundCoor) {
        double xCoor = 0;
        double yCoor = 0;
        for (int i = 0; i < points.length; i++) {
            while (super.getReader().hasNextDouble()) {
                xCoor = super.getReader().nextDouble();
                CheckerBoundNumber.checkInRange(xCoor, lowerBoundCoor,
                                                upperBoundCoor);
            }
            while (super.getReader().hasNextDouble()) {
                yCoor = super.getReader().nextDouble();
                CheckerBoundNumber.checkInRange(yCoor, lowerBoundCoor,
                                                upperBoundCoor);
            }
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
