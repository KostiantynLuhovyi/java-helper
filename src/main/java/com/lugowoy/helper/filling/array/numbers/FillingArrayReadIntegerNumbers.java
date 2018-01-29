package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

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
 * @see FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArrayReadIntegerNumbers extends FillingArrayReadValues<Integer> implements FillingArrayNumbers<Integer> {

    /**
     * <p></p>
     *
     * @param reader
     */
    public FillingArrayReadIntegerNumbers(Reader reader) {
        super(reader);
    }

    /**
     * <p></p>
     *
     * @param reading
     */
    public FillingArrayReadIntegerNumbers(Reading reading) {
        super(reading);
    }

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     */
    @Override
    public Array<Integer> fill(final Array<Integer> array) {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                array.setArray(this.initializeArrayElementsEnteredIntegerNumbers(array.getArray()));
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
     */
    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            integers = this.initializeArrayElementsEnteredIntegerNumbers(integers);
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
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = this.initializeArrayElementsEnteredIntegerNumbers(new Integer[lengthArray]);
        } else {
            integers = this.initializeArrayElementsEnteredIntegerNumbers(new Integer[DEFAULT_LENGTH_ARRAY]);
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
     */
    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_INTEGER_POSITIVE_BOUND));
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
     */
    @Override
    public Integer[] fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, DEFAULT_INTEGER_POSITIVE_BOUND);
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
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], bound);
            } else {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(new Integer[lengthArray], DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_POSITIVE_BOUND);
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
                    array.setArray(this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array passed by the parameter is null."));
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
     */
    @Override
    public Integer[] fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(integers, startBound, endBound);
            } else {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
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
     */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], startBound, endBound);
            } else {
                integers = this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(new Integer[lengthArray], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = this.initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(new Integer[DEFAULT_LENGTH_ARRAY], DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

    private Integer[] initializeArrayElementsEnteredIntegerNumbers(final Integer[] integers) {
        return Arrays.stream(integers).mapToInt(value -> super.getReader().readInt()).boxed().toArray(Integer[]::new);
    }

    private Integer[] initializeArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(final Integer[] integers, final int bound) {
        return Arrays.stream(integers).mapToInt(value -> {
            value = super.getReader().readInt();
            if ((value >= DEFAULT_START_BOUND) && (value <= bound)) {
                return value;
            } else {
                return DEFAULT_INTEGER_VALUE;
            }
        }).boxed().toArray(Integer[]::new);
    }

    private Integer[] initializeArrayElementsEnteredIntegerNumbersFromMinBoundToMaxBound(final Integer[] integers,
                                                                                                final int minBound, final int maxBound) {
        return Arrays.stream(integers).mapToInt(value -> {
            value = super.getReader().readInt();
            if ((value >= minBound) && (value <= maxBound)) {
                return value;
            } else {
                return DEFAULT_INTEGER_VALUE;
            }
        }).boxed().toArray(Integer[]::new);
    }

}
