package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
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
     * @param bound
     *
     * @return
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_INTEGER_BOUND));
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
     * @param bound
     *
     * @return
     * */
    @Override
    public Integer[] fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_BOUND);
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
     * @param bound
     *
     * @return
     * */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], bound);
            } else {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], DEFAULT_INTEGER_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromZeroToPositiveBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_BOUND);
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                        && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(array.getArray(), minBound, maxBound));
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
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(Integer[] integers, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(integers, minBound, maxBound);
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
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                integers = this.initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], minBound, maxBound);
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

    private Integer[] initializeArrayElementsSequentialAscendingIntegerNumbersFromMinBoundToMaxBound(final Integer[] integers, final int minBound, final int maxBound) {
        int value = minBound;
        for (int i = 0; i < integers.length; i++, value++) {
            if (value <= maxBound) {
                integers[i] = value;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
        return integers;
    }


}
