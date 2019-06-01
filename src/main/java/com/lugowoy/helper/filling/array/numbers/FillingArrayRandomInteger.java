package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class fills an object of the {@link Array} class and a classic array with random numeric data of type {@link Integer}.
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to perform functionality
 * for filling arrays with integer numeric data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomInteger implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Array<Integer> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayRandomInteger(integers);
            array.setArray(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers The array to fill with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers) throws IllegalArgumentException {
        //todo check or add relevant checks.

        if (CheckerFillingArray.checkNonNullArray(integers)) {
            this.fillArrayRandomInteger(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter lengthArray determines the length(size) of the created array.
     * If the value of lengthArray is less than 0 or is greatest than 32767, created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayRandomInteger(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomInteger(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     * If the value of the bound argument is a negative number,
     * then the range value for filling the array from 0 to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param array The object of the {@link Array} class to fill with random numeric data of the type {@link Integer}.
     * @param bound The value of the bound for filling an object of the {@link Array} class
     *              with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            } else {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     * If the value of the bound argument is a negative number,
     * then the range value for filling the array from 0 to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param integers The array to fill with random numeric data of the type {@link Integer}.
     * @param bound    The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter lengthArray determines the length(size) of the created array.
     * If the value of lengthArray is less than 0 or is greatest than 32767,
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     * If the value of the bound argument is a negative number,
     * then the range value for filling the array from 0 to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Integer}.
     * @param bound       The value of the border for filling the array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomIntegerFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>The object of the {@link Array} class to fill with numeric data from the value startBound to the value of the endBound parameters.
     * If the value of the argument startBound is greater than the value of endBound
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to be filled with random numeric data of the type {@link Integer}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @param endBound   The value of the end bound for filling an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, startBound, endBound);
                array.setArray(integers);
            } else {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is filled with numeric data from startBound to the value of the endBound parameter.
     * If the value of the argument startBound is greater than the value of endBound
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param integers   The array to be filled with random numeric data of the type {@link Integer}.
     * @param startBound The value of the start bound for filling an array with random numeric data of the type {@link Integer}.
     * @param endBound   The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter lengthArray determines the length(size) of the created array.
     * If the value of lengthArray is less than 0 or is greatest than 32767, created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from the value startBound to the value of the endBound parameters.
     * If the value of the argument startBound is greater than the value of endBound
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Integer}.
     * @param startBound  The value of the start bound for filling an array with random numeric data of the type {@link Integer}.
     * @param endBound    The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomIntegerFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
        }
        return integers;
    }

    private void fillArrayRandomInteger(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt();
        }
    }

    private void fillArrayRandomIntegerFromZeroToPositiveBound(Integer[] integers, int bound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(bound);
        }
    }

    private void fillArrayRandomIntegerFromStartBoundToEndBound(Integer[] integers, int startBound, int endBound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(startBound, endBound);
        }
    }

}
