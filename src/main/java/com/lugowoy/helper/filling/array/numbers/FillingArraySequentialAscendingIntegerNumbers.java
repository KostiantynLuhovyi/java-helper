package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 */

public class FillingArraySequentialAscendingIntegerNumbers implements FillingArrayNumbers<Integer> {

    @Override
    public Array<Integer> fill(final Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            this.initializeArrayIntegerElementsWithSuccessiveAscendingValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            this.initializeArrayIntegerElementsWithSuccessiveAscendingValues(integers);
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.initializeArrayIntegerElementsWithSuccessiveAscendingValues(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayIntegerElementsWithSuccessiveAscendingValues(integers);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(array.getArray(), bound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(array.getArray(), DEFAULT_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(integers, bound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(integers, DEFAULT_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(integers, bound);
            } else {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(integers, DEFAULT_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(integers, DEFAULT_INTEGER_BOUND);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(array.getArray(), minBound, maxBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(integers, minBound, maxBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(integers, minBound, maxBound);
            } else {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

    private void initializeArrayIntegerElementsWithSuccessiveAscendingValues(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
    }

    private void initializeArrayIntegerElementsWithSuccessiveAscendingValuesToBoundary(Integer[] integers, Integer bound) {
        for (int i = 0; i < integers.length; i++) {
            if (i <= bound) {
                integers[i] = i;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
    }

    private void initializeArrayIntegerElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(Integer[] integers, Integer minBound, Integer maxBound) {
        for (int i = 0; i < integers.length; i++, minBound++) {
            if (minBound <= maxBound) {
                integers[i] = minBound;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
    }

}
