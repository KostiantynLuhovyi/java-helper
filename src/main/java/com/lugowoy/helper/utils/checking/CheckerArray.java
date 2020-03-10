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

    private static final int ARRAY_HEADER = 8;

    private static final String MSG_EXCEPTION_ARRAY_IS_NULL = "Array is null.";
    private static final String MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE =
                                        "Length array out of range (0 - " + (Integer.MAX_VALUE - ARRAY_HEADER) + ").";

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
     * Check the {@code array} for null and that the {@code array} attribute length(size) in range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     *
     * @param array the {@code array} to check.
     *
     * @throws NullPointerException if the {@code array} null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static void checkLengthInArray(AbstractArray array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arraySize = array.size();
        if (isIncorrectLength(arraySize, UPPER_BOUND_LENGTH_ARRAY)) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
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
    public static void checkLengthInArray(AbstractArray array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arraySize = array.size();
        if (isIncorrectLength(arraySize, upperBoundLength)) {
            throw new LengthArrayOutOfRangeException(getMsgExceptionLengthOutOfRange(upperBoundLength));
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
    public static <T> void checkLengthInArray(T[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, UPPER_BOUND_LENGTH_ARRAY)) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
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
    public static <T> void checkLengthInArray(T[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, upperBoundLength)) {
            throw new LengthArrayOutOfRangeException(getMsgExceptionLengthOutOfRange(upperBoundLength));
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
    public static void checkLengthInArray(int[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, UPPER_BOUND_LENGTH_ARRAY)) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
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
    public static void checkLengthInArray(int[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, upperBoundLength)) {
            throw new LengthArrayOutOfRangeException(getMsgExceptionLengthOutOfRange(upperBoundLength));
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
    public static void checkLengthInArray(double[] array) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, UPPER_BOUND_LENGTH_ARRAY)) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
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
    public static void checkLengthInArray(double[] array, int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXCEPTION_ARRAY_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        int arrayLength = array.length;
        if (isIncorrectLength(arrayLength, upperBoundLength)) {
            throw new LengthArrayOutOfRangeException(getMsgExceptionLengthOutOfRange(upperBoundLength));
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
    public static void checkLengthArray(int lengthArray) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        if (isIncorrectLength(lengthArray, UPPER_BOUND_LENGTH_ARRAY)) {
            throw new LengthArrayOutOfRangeException(MSG_EXCEPTION_LENGTH_OUT_OF_DEFAULT_RANGE);
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
    public static void checkLengthArray(int lengthArray, int upperBoundLength) {
        CheckerBound.isCorrectBound(lengthArray, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        CheckerBound.isCorrectBound(upperBoundLength, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY);
        if (isIncorrectLength(lengthArray, upperBoundLength)) {
            throw new LengthArrayOutOfRangeException(getMsgExceptionLengthOutOfRange(upperBoundLength));
        }
    }

    private static boolean isIncorrectLength(int lengthArray, int upperBoundLength) {
        boolean isIncorrectLength = false;
        if ((lengthArray < LOWER_BOUND_LENGTH_ARRAY) || (lengthArray > upperBoundLength)) {
            isIncorrectLength = true;
        }
        return isIncorrectLength;
    }

    private static String getMsgExceptionLengthOutOfRange(int upperBoundLength) {
        return "Length array out of range (0 - " + upperBoundLength + ").";
    }

}
