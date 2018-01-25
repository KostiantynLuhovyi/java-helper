package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArraySequentialAscendingIntegerNumbers implements FillingArrayNumbers<Integer> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbers(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param integers
     *
     * @return
     * */
    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     * */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbers(new Integer[lengthArray]);
        } else {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbers(new Integer[DEFAULT_LENGTH_ARRAY]);
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param endBound
     *
     * @return
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(endBound)) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_INTEGER_POSITIVE_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param integers
     * @param endBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(Integer[] integers, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(endBound)) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(integers, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param endBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(int lengthArray, Integer endBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(endBound)) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], endBound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param integers
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(integers, startBound, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], startBound, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialAscendingIntegerNumbers(final Integer[] integers) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value += integerDigit;
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(final Integer[] integers, final int bound) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value <= bound) {
                integers[i] = value;
                value += integerDigit;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(final Integer[] integers, final int startBound, final int endBound) {
        int value = startBound;
        for (int i = 0; i < integers.length; i++, value++) {
            if (value <= endBound) {
                integers[i] = value;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
        return integers;
    }


}
