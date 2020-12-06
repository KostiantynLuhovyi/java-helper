package com.lugowoy.helper.checkers;

import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.Capacity;
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
 * @version 2.3
 * @since 1.6.6
 */
//TODO review documentation
public final class CheckerArray {

    private static final String MSG_ARRAY_IS_NULL = "Array is null";

    private CheckerArray() {
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link Capacity#LOWER}(inclusive) to
     * {@code upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public static void check(@NotNull final AbstractArray array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (array.size() > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range from "
                    + Capacity.LOWER.get() + " to " + upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link Capacity#LOWER}(inclusive) to
     * {@code upperBoundLength}(inclusive).
     *
     * @param <T> the type of the {@code array} to check.
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public static <T> void check(@NotNull final T[] array,
                                 final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range from "
                    + Capacity.LOWER.get() + " to " + upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the {@code array} in range from {@link Capacity#LOWER}(inclusive) to
     * {@code upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public static void check(@NotNull final int[] array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range from "
                    + Capacity.LOWER.get() + " to " + upperBoundLength);
        }
    }

    /**
     * Checks the {@code array} is not {@code null} and that the length value of
     * the array in range from {@link Capacity#LOWER}(inclusive) to {@code
     * upperBoundLength}(inclusive).
     *
     * @param array the {@code array} to check.
     * @param upperBoundLength the upper bound value of the length to check.
     * @throws NullPointerException if the {@code array} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws LengthOutOfRangeException if the length value of the {@code
     * array} out of range ​​from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public static void check(@NotNull final double[] array,
                             final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (array.length > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length of the array out of range from "
                    + Capacity.LOWER.get() + " to " + upperBoundLength);
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link
     * Capacity#LOWER}(inclusive) to {@link Capacity#UPPER}(inclusive).
     *
     * @param lengthArray the {@code lengthArray} value to check.
     * @throws LengthOutOfRangeException if the {@code lengthArray} value out of
     * range ​​from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    public static void check(final int lengthArray) {
        if (lengthArray < Capacity.LOWER.get()
                || lengthArray > Capacity.UPPER.get()) {
            throw new LengthOutOfRangeException(
                    "Length value " + lengthArray + " out of range from "
                    + Capacity.LOWER.get() + " to " + Capacity.UPPER.get());
        }
    }

    /**
     * Checks the {@code lengthArray} value in range from {@link
     * Capacity#LOWER}(inclusive) to {@code upperBoundLength}(inclusive).
     *
     * @param lengthArray the {@code lengthArray} value to check.
     * @param upperBoundLength the upper bound value of the length to check.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws LengthOutOfRangeException if the {@code lengthArray} value out of
     * range from {@link Capacity#LOWER} to {@code upperBoundLength}.
     */
    public static void check(final int lengthArray, final int upperBoundLength) {
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (lengthArray < Capacity.LOWER.get()
                || lengthArray > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Length value " + lengthArray + " out of range from "
                    + Capacity.LOWER.get() + " to " + upperBoundLength);
        }
    }

}
