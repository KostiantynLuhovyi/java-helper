package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * The class implements the contract declared by the {@link FillingArrayOfPoints} interface.
 * <p>The class fills an objects of the {@link Array} class
 * and classical arrays of object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayOfPoints
 */

public class FillingArrayOfPointsWithCoordinatesRandomIntegerNumbers implements FillingArrayOfPoints<Integer> {

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are
     * in the range from {@link GeneratorRandomNumber#MIN_INT_BOUND}
     * to {@link GeneratorRandomNumber#MAX_INT_BOUND}.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with random numeric coordinates of type {@link Double}.
     */
    @Override
    public void fill(Array<Point<Integer>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(array.getArray());
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class are in the range from {@link GeneratorRandomNumber#MIN_INT_BOUND}
     * to {@link GeneratorRandomNumber#MAX_INT_BOUND}.
     *
     * @param points The array to be filled with the objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Integer}.
     */
    @Override
    public void fill(Point<Integer>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * Numerical values for coordinates of object of {@link Point} class
     * are in the range from {@link GeneratorRandomNumber#MIN_INT_BOUND} to {@link GeneratorRandomNumber#MAX_INT_BOUND}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Integer}.
     */
    @Override
    public Point<Integer>[] fill(int lengthArray) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Array<Point<Integer>> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(array.getArray(),
                                                                                                                     bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(array.getArray(),
                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to to "bound".
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     * @param points The array to be filled with objects of the {@link Point} class
     *               with random numeric coordinates of type {@link Integer}.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     *
     * @param lengthArray The length(size) of the array to be filled with objects of the {@link Point} class
     *                    with random numeric coordinates of type {@link Integer}.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer bound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                                                                                                                     bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(points,
                                                                                                                 DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(array.getArray(),
                                                                                                                            startBound,
                                                                                                                            endBound);
            } else {
                    this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(array.getArray(),
                                                                                                                                               DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                                               DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with random numeric coordinates of type {@link Integer} in the range from "startBound" to to "endBound".
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled with objects of the {@link Point} class
     *                   with random numeric coordinates of type {@link Integer}.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(points,
                                                                                                                            startBound,
                                                                                                                            endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(points,
                                                                                                                                     DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
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
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(lengthArray).getArray();
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(points,
                                                                                                                            startBound,
                                                                                                                            endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(points,
                                                                                                                                     DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = FactoryArray.getFactoryArray(new CreatorArrayPoints<Integer>()).create(DEFAULT_LENGTH_ARRAY).getArray();
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(points,
                                                                                                                        startBound,
                                                                                                                        endBound);
        }
        return points;
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbers(Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(), GeneratorRandomNumber.generateInt());
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromZeroToBound(Point<Integer>[] points, final int bound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(bound), GeneratorRandomNumber.generateInt(bound));
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesRandomIntegerNumbersFromMinBoundToMaxBound(Point<Integer>[] points,
                                                                                                                        int minBound,
                                                                                                                        int maxBound) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(GeneratorRandomNumber.generateInt(minBound, maxBound), GeneratorRandomNumber.generateInt(minBound, maxBound));
        }
    }

}
