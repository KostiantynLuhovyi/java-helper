package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.filling.array.FillingArrayChecker;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_VALUE;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_VALUE;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObj;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 */

public class FillingArraySequentialDescendingIntegerNumbers implements FillingArray<Integer>, FillingArrayNumbers<Integer> {

    @Override
    public Array<Integer> fill(final Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            this.initializeArrayIntegerElementsWithSuccessiveDescendingValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArray(integers)) {
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
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
    }


}
