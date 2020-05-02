package com.lugowoy.helper.checkers;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

import java.util.Objects;

/**
 * The class contains functionality for checking various types of arrays and
 * its attributes.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.9
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
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static void check(final AbstractArray array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.size(), UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     */
    public static void check(final AbstractArray array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(array.size(), upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     *
     * @param <T> the type of the {@code array} to check.
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static <T> void check(final T[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.length, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     *
     * @param <T> the type of the {@code array} to check.
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     */
    public static <T> void check(final T[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static void check(final int[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        if (isIncorrectLength(array.length, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     */
    public static void check(final int[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the {@code array} in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static void check(final double[] array) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value
     * of the array in range from {@link CheckerArray#LOWER_BOUND_LENGTH}
     * to {@code upperBoundLength}.
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthArrayOutOfRangeException if the length value of
     * the {@code array} out of range ​​from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     */
    public static void check(final double[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBound.isInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(array.length, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     *
     * @param lengthArray the {@code lengthArray} value to check.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value
     * out of range ​​from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static void checkLength(final int lengthArray) {
        CheckerBound.isInRange(lengthArray, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(lengthArray, UPPER_BOUND_LENGTH)) {
            throwExceptionLengthOutRange(UPPER_BOUND_LENGTH);
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from
     * {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code upperBoundLength}.
     *
     * @param lengthArray the {@code lengthArray} value to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@link CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@code upperBoundLength}.
     */
    public static void checkLength(final int lengthArray,
                                   final int upperBoundLength) {
        CheckerBound.isInRange(lengthArray, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        CheckerBound.isInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                               UPPER_BOUND_LENGTH);
        if (isIncorrectLength(lengthArray, upperBoundLength)) {
            throwExceptionLengthOutRange(upperBoundLength);
        }
    }

    private static boolean isIncorrectLength(final int lengthArray,
                                             final int upperLength) {
        return lengthArray < LOWER_BOUND_LENGTH || lengthArray > upperLength;
    }

    private static void throwExceptionLengthOutRange(final int upperLength) {
        String msgExc =
                "Length array out of range (" + CheckerArray.LOWER_BOUND_LENGTH
                        + " - " + upperLength + ").";
        throw new LengthArrayOutOfRangeException(msgExc);
    }

}
