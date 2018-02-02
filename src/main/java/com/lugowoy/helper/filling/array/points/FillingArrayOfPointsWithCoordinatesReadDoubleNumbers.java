package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * The class is the heir of the {@link FillingArrayOfPointsWithCoordinatesReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Double}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayOfPoints} interface.
 *
 * @see com.lugowoy.helper.filling.array.points.FillingArrayOfPointsWithCoordinatesReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayOfPoints
 */

public class FillingArrayOfPointsWithCoordinatesReadDoubleNumbers extends FillingArrayOfPointsWithCoordinatesReadValues<Double>
                                                                  implements FillingArrayOfPoints<Double> {

    /**
     * Constructs a new object {@link FillingArrayOfPointsWithCoordinatesReadDoubleNumbers} class,
     *  initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayOfPointsWithCoordinatesReadDoubleNumbers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayOfPointsWithCoordinatesReadDoubleNumbers} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayOfPointsWithCoordinatesReadDoubleNumbers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     */
    @Override
    public void fill(Array<Point<Double>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(array.getArray());
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Double} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     */
    @Override
    public void fill(Point<Double>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Double}
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
    @Override
    public Point<Double>[] fill(int lengthArray) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Array<Point<Double>> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(array.getArray(), bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Point<Double>[] points, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @Override
    public Point<Double>[] fill(int lengthArray, Double bound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(points, DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Array<Point<Double>> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(array.getArray(), startBound, endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(array.getArray(),
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Point<Double>[] points, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points ,startBound, endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Double} in the range from "startBound" to "endBound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
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
     * @param lengthArray The length(size) of the array to be filled.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    public Point<Double>[] fill(int lengthArray, Double startBound, Double endBound) {
        Point<Double>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(lengthArray).getArray();
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points, startBound, endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                              DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(points,
                                                                                                                          DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                                                          DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return points;
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbers(Point<Double>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(super.getReader().readDouble(), super.getReader().readDouble());
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadDoubleNumbersFromZeroToPositiveBound(Point<Double>[] points,
                                                                                                                      double bound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoorX = checkReadValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, bound);
            double valueCoorY = checkReadValueIsInRange(super.getReader().readDouble(), DEFAULT_START_BOUND, bound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesEnteredDoubleNumbersFromStartBoundToEndBound(Point<Double>[] points,
                                                                                                                          double startBound,
                                                                                                                          double endBound) {
        for (int i = 0; i < points.length; i++) {
            double valueCoorX = checkReadValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            double valueCoorY = checkReadValueIsInRange(super.getReader().readDouble(), startBound, endBound);
            points[i] = new Point<>(valueCoorX, valueCoorY);
        }
    }

    private double checkReadValueIsInRange(final double enteredValue, final double startBound, final double endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_DOUBLE_VALUE;
    }

}
