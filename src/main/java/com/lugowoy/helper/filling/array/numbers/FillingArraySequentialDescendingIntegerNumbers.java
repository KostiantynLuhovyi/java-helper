package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 */

public class FillingArraySequentialDescendingIntegerNumbers implements FillingArrayNumbers<Integer> {

    @Override
    public Array<Integer> fill(final Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValues(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValues(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValues(integers);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer startBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(array.getArray(), startBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(array.getArray(), DefaultValuesOfArray.DEFAULT_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer startBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(integers, startBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(integers, DefaultValuesOfArray.DEFAULT_INTEGER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer startBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(integers, startBound);
            } else {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(integers, DefaultValuesOfArray.DEFAULT_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(integers, DefaultValuesOfArray.DEFAULT_INTEGER_BOUND);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(array.getArray(), minBound, maxBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(array.getArray(), DefaultValuesOfArray.DEFAULT_INTEGER_MIN_BOUND, DefaultValuesOfArray.DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(integers, minBound, maxBound);
            } else {
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(integers, DefaultValuesOfArray.DEFAULT_INTEGER_MIN_BOUND, DefaultValuesOfArray.DEFAULT_INTEGER_MAX_BOUND);
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
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(integers, minBound, maxBound);
            } else {
                integers = new Integer[lengthArray];
                this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(integers, DefaultValuesOfArray.DEFAULT_INTEGER_MIN_BOUND, DefaultValuesOfArray.DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(integers, DefaultValuesOfArray.DEFAULT_INTEGER_MIN_BOUND, DefaultValuesOfArray.DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

    private void initializeArrayIntegerElementsWithSuccessiveDescendingValues(Integer[] integers) {
        int value = integers.length - 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value--;
        }
    }

    private void initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromBoundary(Integer[] integers, Integer startBound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = startBound;
            startBound--;
        }
    }

    private void initializeArrayIntegerElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(Integer[] integers, Integer minBound, Integer maxBound) {
        for (int i = 0; i < integers.length; i++) {
            if (maxBound >= minBound) {
                integers[i] = maxBound;
                maxBound--;
            } else {
                integers[i] = DefaultValuesOfArray.DEFAULT_INTEGER_VALUE;
            }
        }
    }

}
