package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.models.Array;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with sequential descending
 * of numeric data of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

//todo refactoring code
//todo edit doc's

public class FillingArrayDescendingInteger implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with sequential descending of numeric data of type {@link Integer}.
     * Filling starts at "0" and decreases by "1".
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayElementsSequentialDescendingIntegerNumbers(integers);
            array.setArray(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * Filling starts at "0" and decreases by "1".
     *
     * @param integers The array to be filled with sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArray(integers)) {
            this.fillArrayElementsSequentialDescendingIntegerNumbers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * Filling starts at "0" and decreases by "1".
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with sequential descending of numeric data of type {@link Integer}.
     * @return Created and filled an array with sequential descending of numeric data of type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayElementsSequentialDescendingIntegerNumbers(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsSequentialDescendingIntegerNumbers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending of numeric data of type {@link Integer}.
     * <p>The object of the {@link Array} class is filled
     * with numeric data from "0" (decreases by "1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}.
     *
     * @param array The object of the {@link Array} class to be filled
     *              with sequential descending of numeric data of type {@link Integer}.
     * @param bound The value of the bound for filling an object of the {@link Array} class
     *              with sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isNegativeBound(bound)) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers, bound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers,
                        NEGATIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * <p>The array is filled with numeric data from "0" (decreases by "1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}.
     *
     * @param integers The array to be filled with sequential descending of numeric data of type {@link Integer}.
     * @param bound    The value of the end bound for filling an array with sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArray(integers)) {
            if (isNegativeBound(bound)) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers, bound);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers,
                        NEGATIVE_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from "0" (decreases by "1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with
     *                    sequential descending of numeric data of type {@link Integer}.
     * @param bound       The value of the border for filling the array with sequential descending of numeric data of type {@link Integer}.
     * @return Created and filled an array with sequential descending of numeric data of type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isNegativeBound(bound)) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers, bound);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers,
                        NEGATIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(integers,
                    NEGATIVE_INTEGER_BOUND);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending of numeric data of type {@link Integer}.
     * <p>The object of the {@link Array} class is filled
     * with numeric data (decreases by "1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is less than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#START_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class that must be filled
     *                   with sequential descending of numeric data of type {@link Integer}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with sequential descending of numeric data of type {@link Integer}.
     * @param endBound   The value of the end bound for filling an object of the {@link Array} class
     *                   with sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundGreaterOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers,
                        startBound, endBound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers,
                        POSITIVE_INTEGER_BOUND,
                        NEGATIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * <p>The array is filled with numeric data (decreases by "1") from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is less than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND} respectively.
     *
     * @param integers   The array to be filled with sequential descending of numeric data of type {@link Integer}.
     * @param startBound The value of the start bound for filling an array
     *                   with sequential descending of numeric data of type {@link Integer}.
     * @param endBound   The value of the end bound for filling an array
     *                   with sequential descending of numeric data of type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArray(integers)) {
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundGreaterOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers,
                        POSITIVE_INTEGER_BOUND,
                        NEGATIVE_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Integer}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data (decreases by "1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is less than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with sequential descending of numeric data of type {@link Integer}.
     * @param startBound  The value of the start bound for filling an array
     *                    with sequential descending of numeric data of type {@link Integer}.
     * @param endBound    The value of the end bound for filling an array
     *                    with sequential descending of numeric data of type {@link Integer}.
     * @return Created and filled an array with sequential descending of numeric data of type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isLowerBoundGreaterThanUpperBound(startBound, endBound)
                    && (isCorrectRangeBound(startBound) && isCorrectRangeBound(endBound))) {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers,
                        POSITIVE_INTEGER_BOUND,
                        NEGATIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(integers,
                    POSITIVE_INTEGER_BOUND,
                    NEGATIVE_INTEGER_BOUND);
        }
        return integers;
    }

    private void fillArrayElementsSequentialDescendingIntegerNumbers(Integer[] integers) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value -= integerDigit;
        }
    }

    private void fillArrayElementsSequentialDescendingIntegerNumbersFromZeroToNegativeBound(Integer[] integers,
                                                                                            int bound) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= bound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                integers[i] = INTEGER_VALUE;
            }
        }
    }

    private void fillArrayElementsSequentialDescendingIntegerNumbersFromStartBoundToEndBound(Integer[] integers,
                                                                                             int startBound,
                                                                                             int endBound) {
        int value = startBound, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= endBound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                integers[i] = INTEGER_VALUE;
            }
        }
    }

}
