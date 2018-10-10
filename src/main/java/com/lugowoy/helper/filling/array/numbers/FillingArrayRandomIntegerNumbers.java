package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 *
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with random numeric data of type {@link Integer}.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArrayRandomIntegerNumbers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayElementsRandomIntegerNumbers(integers);
            array.setArray(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers The array to be filled with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            this.fillArrayElementsRandomIntegerNumbers(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkArrayLength(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayElementsRandomIntegerNumbers(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomIntegerNumbers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>The object of the {@link Array} class is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled with random numeric data of the type {@link Integer}.
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
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is filled with numeric data from 0 to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     * @param integers The array to be filled with random numeric data of the type {@link Integer}.
     * @param bound The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Integer}.
     * @param bound The value of the border for filling the array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkArrayLength(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>The object of the {@link Array} class is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param array The object of the {@link Array} class that must be filled with random numeric data of the type {@link Integer}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class
     *                 with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers,
                                                                                         DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                         DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is filled with numeric data from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param integers The array to be filled with random numeric data of the type {@link Integer}.
     * @param startBound The value of the start bound for filling an array with random numeric data of the type {@link Integer}.
     * @param endBound The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers,
                                                                                         DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                         DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_INTEGER_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Integer}.
     * @param startBound The value of the start bound for filling an array with random numeric data of the type {@link Integer}.
     * @param endBound The value of the end bound for filling an array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkArrayLength(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers,
                                                                                         DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                         DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(integers,
                                                                                     DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return integers;
    }

    private void fillArrayElementsRandomIntegerNumbers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt();
        }
    }

    private void fillArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(Integer[] integers, int bound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(bound);
        }
    }

    private void fillArrayElementsRandomIntegerNumbersFromStartBoundToEndBound(Integer[] integers,
                                                                               int startBound,
                                                                               int endBound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(startBound, endBound);
        }
    }

}
