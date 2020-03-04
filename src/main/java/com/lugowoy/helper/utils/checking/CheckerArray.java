package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

import java.util.Objects;

/**
 * The class contains static functionality for checking various values ​​associated with the use of various types of arrays.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.6.6
 */
public final class CheckerArray {

    private static final int ARRAY_HEADER = 8;

    private static final String MSG_EXCEPTION_ARRAY_IS_NULL = "Array is null.";
    private static final String MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE =
                                       "Length array is out of range (0 - " + (Integer.MAX_VALUE - ARRAY_HEADER) + ").";

    /**
     * The lower (starting) value of the boundary of the length of the array.
     */
    public static final int LOWER_BOUND_LENGTH_ARRAY = 0;
    /**
     * The upper (finishing) value of the boundary of the length of the array.
     */
    public static final int UPPER_BOUND_LENGTH_ARRAY = Integer.MAX_VALUE - ARRAY_HEADER;

    private CheckerArray() {
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array Object of the class {@link AbstractArray} whose length(size) will be checked.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLengthInArray(AbstractArray array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arraySize = array.size();
        if (arraySize < LOWER_BOUND_LENGTH_ARRAY || arraySize > UPPER_BOUND_LENGTH_ARRAY) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array            Object of the class {@link AbstractArray} whose length(size) will be checked.
     * @param upperBoundLength Numeric upper bound valid value of the length of the array to check.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws BoundOutOfRangeException       If the argument value {@code upperBoundLength} out of range values
     *                                        from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void checkLengthInArray(AbstractArray array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arraySize = array.size();
        if (arraySize < LOWER_BOUND_LENGTH_ARRAY || array.size() > upperBoundLength) {
            throw new LengthArrayOutOfRangeException("Length array is out of range (0 - " + upperBoundLength + ").");
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array Array whose length(size) will be checked.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static <T> void checkLengthInArray(T[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > UPPER_BOUND_LENGTH_ARRAY) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array            Array whose length(size) will be checked.
     * @param upperBoundLength Numeric upper bound valid value of the length of the array to check.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws BoundOutOfRangeException       If the argument value {@code upperBoundLength} out of range values
     *                                        from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static <T> void checkLengthInArray(T[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > upperBoundLength) {
            throw new LengthArrayOutOfRangeException("Length array is out of range (0 - " + upperBoundLength + ").");
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array Array whose length(size) will be checked.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLengthInArray(int[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > UPPER_BOUND_LENGTH_ARRAY) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array            Array whose length(size) will be checked.
     * @param upperBoundLength Numeric upper bound valid value of the length of the array to check.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws BoundOutOfRangeException       If the argument value {@code upperBoundLength} out of range values
     *                                        from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void checkLengthInArray(int[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > upperBoundLength) {
            throw new LengthArrayOutOfRangeException("Length array is out of range (0 - " + upperBoundLength + ").");
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array Array whose length(size) will be checked.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLengthInArray(double[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > UPPER_BOUND_LENGTH_ARRAY) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
        }
    }

    /**
     * Checks that the length(size) of the {@code array} argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array            Array whose length(size) will be checked.
     * @param upperBoundLength Numeric upper bound valid value of the length of the array to check.
     * @throws NullPointerException           If the argument {@code array} is null.
     * @throws BoundOutOfRangeException       If the argument value {@code upperBoundLength} out of range values
     *                                        from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY}
     *                                        to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void checkLengthInArray(double[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (arrayLength < LOWER_BOUND_LENGTH_ARRAY || arrayLength > upperBoundLength) {
            throw new LengthArrayOutOfRangeException("Length array is out of range (0 - " + upperBoundLength + ").");
        }
    }

    /**
     * Checks that the length(size) value argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param lengthArray Length(size) value to check.
     * @throws LengthArrayOutOfRangeException If the argument {@code lengthArray} is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLengthArray(int lengthArray) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        if (lengthArray < LOWER_BOUND_LENGTH_ARRAY || lengthArray > UPPER_BOUND_LENGTH_ARRAY) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
        }
    }

    /**
     * Checks that the length(size) value argument is in the valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param lengthArray      Length(size) value to check.
     * @param upperBoundLength Numeric upper bound valid value of the length to check.
     * @throws BoundOutOfRangeException       If the argument value {@code upperBoundLength} out of range values
     *                                        from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException If the argument {@code array} length(size) of the argument is out of range of valid values
     *                                        ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void checkLengthArray(int lengthArray, int upperBoundLength) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        if (lengthArray < LOWER_BOUND_LENGTH_ARRAY || lengthArray > upperBoundLength) {
            throw new LengthArrayOutOfRangeException("Length array is out of range (0 - " + upperBoundLength + ").");
        }
    }

}
