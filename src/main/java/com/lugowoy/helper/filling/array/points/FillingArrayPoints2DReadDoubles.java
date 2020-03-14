package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_ZERO;

/**
 * The class is the heir of the {@link FillingArrayPointsReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Double}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints} interface.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayPoints
 */
//TODO edit doc's
public class FillingArrayPoints2DReadDoubles extends FillingArrayPointsReadValues<Point2D<Double>, Double> {

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDoubles} class,
     * initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     * encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPoints2DReadDoubles(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPoints2DReadDoubles} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     * encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPoints2DReadDoubles(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     *
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array) {
        CheckerArray.checkLengthInArray(array);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsReadDouble(points);
        array.setArray(points);
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     *
     * @throws NullPointerException The argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points) {
        CheckerArray.checkLengthInArray(points);
        this.fillArrayPointsReadDouble(points);
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Double}
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     *
     * @return Created and filled array of the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsReadDouble(points);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link }
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point2D<Double>> array, Double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}.
     *
     * @param points The array to be filled.
     * @param bound The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @throws NullPointerException If argument array is null.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double bound) {
        CheckerArray.checkLengthInArray(points);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link ValuesToFilling}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound The value of the end of the range boundary
     * of numerical values by which the coordinates of points in the array will be initialized.
     *
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point2D<Double>[] fill(int lengthArray, Double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsReadDoubleFromZeroToBound(points, bound);
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param array The object of the {@link Array} class to be filled.
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
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, array.size());
        this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
        array.setArray(points);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     */
    @Override
    public void fill(Point2D<Double>[] points, Double lowerBoundCoordinate, Double upperBoundCoordinate) {
        CheckerArray.checkLengthInArray(points);
        CheckerBound.isCorrectBound(lowerBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundCoordinate, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "lowerBoundCoordinate" to "upperBoundCoordinate" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "lowerBoundCoordinate" to the value of the "upperBoundCoordinate" parameters.
     * If the value of the argument "lowerBoundCoordinate" is greater than the value of "upperBoundCoordinate"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link ValuesToFilling}
     * and {@link ValuesToFilling} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled.
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
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundCoordinate, upperBoundCoordinate);
        Point2D<Double>[] points = (Point2D<Double>[]) java.lang.reflect.Array.newInstance(Point2D.class, lengthArray);
        this.fillArrayPointsReadDoubleFromLowerBoundToUpperBound(points, lowerBoundCoordinate, upperBoundCoordinate);
        return points;
    }

    private void fillArrayPointsReadDouble(Point2D<Double>[] points) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            Point2D<Double> point = new Point2D<>(xCoor, yCoor);
            points[i] = point;
        }
    }

    private void fillArrayPointsReadDoubleFromZeroToBound(Point2D<Double>[] points, double bound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            if ((xCoor >= DOUBLE_ZERO && xCoor <= bound) && (yCoor >= DOUBLE_ZERO && yCoor <= bound)) {
                Point2D<Double> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Read value not a double number or out of range (0.0 - " + bound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

    private void fillArrayPointsReadDoubleFromLowerBoundToUpperBound(Point<Double>[] points, double startBound, double endBound) {
        double xCoor, yCoor;
        for (int i = 0; i < points.length; i++) {
            xCoor = super.getReader().readDouble();
            yCoor = super.getReader().readDouble();
            if ((xCoor >= startBound && xCoor <= endBound) && (yCoor >= startBound && yCoor <= endBound)) {
                Point2D<Double> point = new Point2D<>(xCoor, yCoor);
                points[i] = point;
            } else {
                String msgEx = "Read value not a double number or out of range (" + startBound + " - " + endBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

}
