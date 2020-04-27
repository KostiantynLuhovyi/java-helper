package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

import java.util.Objects;

/**
 * The class contains functionality for checking various types of arrays and its attributes.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @since 1.6.6
 */
public final class CheckerArray {

    /**
     * The lower boundary value of the length of the array.
     */
    public static final int LOWER_BOUND_LENGTH = 0;

    /**
     * The upper boundary value of the length of the array.
     */
    public static final int UPPER_BOUND_LENGTH;

    private static final int ARRAY_HEADER = 8;
    private static final String MSG_EXC_ARRAY_IS_NULL = "Array is null.";

    static {
        UPPER_BOUND_LENGTH = Integer.MAX_VALUE - ARRAY_HEADER;
    }

    private CheckerArray() {
    }

    /**
     * Check the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void check(final AbstractArray array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.size(), UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound length value to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} out range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void check(final AbstractArray array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                array.size(), upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static <T> void check(final T[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.length, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound length value to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws BoundOutOfRangeException if {@code upperBoundLength} out of range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * of valid values ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static <T> void check(final T[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void check(final int[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.length, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} for null and the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound length value to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} out of range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void check(final int[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void check(final double[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        int arrayLength = array.length; if (isIncorrectLength(arrayLength,
                                                              UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} for null and the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound length value to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} out of range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void check(final double[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY}
     * to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param lengthArray the {@code lengthArray} value to check.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLength(final int lengthArray) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                lengthArray, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     *
     * @param lengthArray the {@code lengthArray} value to check.
     * @param upperBoundLength the upper bound length value to check.
     *
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} out of range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static void checkLength(final int lengthArray,
                                   final int upperBoundLength) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH,
                                    UPPER_BOUND_LENGTH); if (isIncorrectLength(
                lengthArray, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    private static boolean isIncorrectLength(final int lengthArray,
                                             final int upperLength) {
        return lengthArray < LOWER_BOUND_LENGTH || lengthArray > upperLength;
    }

    private static void throwExceptionLengthOutRange(final int upperLength) {
        String msgExc = "Length array out of range (0 - " + upperLength + ").";
        throw new LengthArrayOutOfRangeException(msgExc);
    }

}
