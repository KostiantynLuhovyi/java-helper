package com.lugowoy.helper.checkers;

import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class contains functionality for checking various types of arrays and its
 * attributes.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 2.0
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
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link CheckerArray#LOWER_BOUND_LENGTH}
     * (inclusive) to {@code upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@code upperBoundLength}.
     */
    public static void check(@NotNull final AbstractArray array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                                        UPPER_BOUND_LENGTH);
        if (array.size() > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range(" + LOWER_BOUND_LENGTH
                    + "-" + upperBoundLength + ").");
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link CheckerArray#LOWER_BOUND_LENGTH}
     * (inclusive) to {@code upperBoundLength}(inclusive).
     *
     * @param <T> the type of the {@code array} to check.
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@code upperBoundLength}.
     */
    public static <T> void check(@NotNull final T[] array,
                                 final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                                        UPPER_BOUND_LENGTH);
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range(" + LOWER_BOUND_LENGTH
                    + "-" + upperBoundLength + ").");
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link CheckerArray#LOWER_BOUND_LENGTH}
     * (inclusive) to {@code upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@code upperBoundLength}.
     */
    public static void check(@NotNull final int[] array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                                        UPPER_BOUND_LENGTH);
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range(" + LOWER_BOUND_LENGTH
                    + "-" + upperBoundLength + ").");
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the array in range from {@link CheckerArray#LOWER_BOUND_LENGTH}(inlusive)
     * to {@code upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link CheckerArray#LOWER_BOUND_LENGTH} to
     * {@code upperBoundLength}.
     */
    public static void check(@NotNull final double[] array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_EXC_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                                        UPPER_BOUND_LENGTH);
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range(" + LOWER_BOUND_LENGTH
                    + "-" + upperBoundLength + ").");
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link
     * CheckerArray#LOWER_BOUND_LENGTH}(inclusive) to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}(inclusive).
     *
     * @param lengthArray the {@code lengthArray} value to check.
     *
     * @throws LengthOutOfRangeException if the {@code lengthArray} value out of
     * range ​​from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static void checkLength(final int lengthArray) {
        if (lengthArray < LOWER_BOUND_LENGTH
            || lengthArray > UPPER_BOUND_LENGTH) {
            throw new LengthOutOfRangeException(
                    "Length value out of range(" + LOWER_BOUND_LENGTH + "-"
                    + UPPER_BOUND_LENGTH + ").");
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link
     * CheckerArray#LOWER_BOUND_LENGTH}(inclusive) to {@code
     * upperBoundLength}(inclusive).
     *
     * @param lengthArray the {@code lengthArray} value to check.
     * @param upperBoundLength the upper bound value of the length to check.
     *
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws LengthOutOfRangeException if the {@code lengthArray} value out of
     * range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code
     * upperBoundLength}.
     */
    public static void checkLength(final int lengthArray,
                                   final int upperBoundLength) {
        CheckerBoundNumber.checkInRange(upperBoundLength, LOWER_BOUND_LENGTH,
                                        UPPER_BOUND_LENGTH);
        if (lengthArray < LOWER_BOUND_LENGTH
            || lengthArray > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length value out of range(" + LOWER_BOUND_LENGTH + "-"
                    + upperBoundLength + ").");
        }
    }

}
