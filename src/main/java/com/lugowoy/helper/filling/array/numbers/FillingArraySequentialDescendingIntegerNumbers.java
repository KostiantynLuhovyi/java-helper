package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
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
 * */

public class FillingArraySequentialDescendingIntegerNumbers implements FillingArrayNumbers<Integer> {

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
                this.initializeArrayElementsSequentialDescendingIntegerValues(array.getArray());
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
            this.initializeArrayElementsSequentialDescendingIntegerValues(integers);
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
            integers = this.initializeArrayElementsSequentialDescendingIntegerValues(new Integer[lengthArray]);
        } else {
            integers = this.initializeArrayElementsSequentialDescendingIntegerValues(new Integer[DEFAULT_LENGTH_ARRAY]);
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
                if (checkBoundValueIsNegative(endBound)) {
                    array.setArray(this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(array.getArray(), DEFAULT_INTEGER_NEGATIVE_BOUND));
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
            if (checkBoundValueIsNegative(endBound)) {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(integers, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(integers, DEFAULT_INTEGER_NEGATIVE_BOUND);
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
            if (checkBoundValueIsNegative(endBound)) {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(new Integer[lengthArray], endBound);
            } else {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(new Integer[lengthArray], DEFAULT_INTEGER_NEGATIVE_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_NEGATIVE_BOUND);
        }
        return integers;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param startBound
     * @param endBound
     * */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(array.getArray(), DEFAULT_INTEGER_MAX_BOUND, DEFAULT_INTEGER_MIN_BOUND));
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
            if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(integers, DEFAULT_INTEGER_MAX_BOUND, DEFAULT_INTEGER_MIN_BOUND);
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
            if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(new Integer[lengthArray], startBound, endBound);
            } else {
                integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(new Integer[lengthArray], DEFAULT_INTEGER_MAX_BOUND, DEFAULT_INTEGER_MIN_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_MAX_BOUND, DEFAULT_INTEGER_MIN_BOUND);
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialDescendingIntegerValues(final Integer[] integers) {
        int value = integers.length - 1, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value -= integerDigit;
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialDescendingIntegerValuesFromZeroToNegativeBound(final Integer[] integers, final int endBound) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= endBound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
        return integers;
    }

    private Integer[] initializeArrayElementsSequentialDescendingIntegerValuesFromStartBoundToEndBound(final Integer[] integers, final int startBound, final int endBound) {
        int value = startBound, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= endBound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                integers[i] = DEFAULT_INTEGER_VALUE;
            }
        }
        return integers;
    }

}
