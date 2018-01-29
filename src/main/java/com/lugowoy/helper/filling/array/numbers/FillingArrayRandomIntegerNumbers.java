package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 * */

public class FillingArrayRandomIntegerNumbers implements FillingArrayNumbers<Integer> {

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
                array.setArray(this.initializeArrayElementsRandomIntegerNumbers(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
            integers = this.initializeArrayElementsRandomIntegerNumbers(integers);
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
            integers = this.initializeArrayElementsRandomIntegerNumbers(new Integer[lengthArray]);
        } else {
            integers = this.initializeArrayElementsRandomIntegerNumbers(new Integer[DEFAULT_LENGTH_ARRAY]);
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
                    array.setArray(this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_INTEGER_POSITIVE_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
    public Integer[] fill(Integer[] integers, Integer bound) {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                integers = this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
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
                integers = this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], bound);
            } else {
                integers = this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_POSITIVE_BOUND);
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
                    array.setArray(this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
                integers = this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(integers, startBound, endBound);
            } else {
                integers = this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
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
                integers = this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], startBound, endBound);
            } else {
                integers = this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

    private Integer[] initializeArrayElementsRandomIntegerNumbers(final Integer[] integers) {
        return Arrays.stream(integers).mapToInt(value -> GeneratorRandomNumber.generateInt()).boxed().toArray(Integer[]::new);
    }

    private Integer[] initializeArrayElementsRandomIntegerNumbersFromZeroToPositiveBound(final Integer[] integers, final int bound) {
        return Arrays.stream(integers).mapToInt(value -> GeneratorRandomNumber.generateInt(bound)).boxed().toArray(Integer[]::new);
    }

    private Integer[] initializeArrayElementsRandomIntegerNumbersFromMinBoundToMaxBound(final Integer[] integers,
                                                                                                        final int minBound, final int maxBound) {
        return Arrays.stream(integers).mapToInt(value -> GeneratorRandomNumber.generateInt(minBound, maxBound)).boxed().toArray(Integer[]::new);
    }

}
