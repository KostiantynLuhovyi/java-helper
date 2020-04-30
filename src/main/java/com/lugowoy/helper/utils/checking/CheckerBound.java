package com.lugowoy.helper.utils.checking;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class contains static functionality for checking various boundary numerical values.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @since 1.6.6
 */
public final class CheckerBound {

    /**
     * An exception message indicating that the boundary value is null.
     */
    public static final String MSG_EXC_BOUND_IS_NULL = "Bound is null";
    /**
     * An exception message indicating that the lower boundary value is null.
     */
    public static final String MSG_EXC_LOWER_IS_NULL = "Lower bound is null";
    /**
     * An exception message indicating that the upper boundary value is null.
     */
    public static final String MSG_EXC_UPPER_IS_NULL = "Upper bound is null";
    /**
     * An exception message indicating that the lower bound value is equal to
     * the upper bound value.
     */
    public static final String MSG_EXC_LOWER_EQUAL_UPPER =
            "Lower bound equal to upper bound";
    /**
     * An exception message indicating that the lower bound value is not equal
     * to the upper bound value.
     */
    public static final String MSG_EXC_LOWER_NOT_EQUAL_UPPER =
            "Lower bound not equal to upper bound";
    /**
     * An exception message indicating that the lower bound value is less than
     * or equal to the upper bound value.
     */
    public static final String MSG_EXC_LOWER_LESS_OR_EQUAL_UPPER =
            "Lower bound less or equal upper bound";
    /**
     * An exception message indicating that the lower bound value is greater
     * than or equal to the upper bound value.
     */
    public static final String MSG_EXC_LOWER_GREATER_OR_EQUAL_UPPER =
            "Lower bound greater or equal upper bound";
    /**
     * An exception message indicating that the lower bound value is less than
     * or not equal to the upper bound value.
     */
    public static final String MSG_EXC_LOWER_LESS_OR_NOT_EQUAL_UPPER =
            "Lower bound less or not equal upper bound";
    /**
     * An exception message indicating that the lower bound value is greater
     * than or not equal to the upper bound value.
     */
    public static final String MSG_EXC_LOWER_GREATER_OR_NOT_EQUAL_UPPER =
            "Lower bound greater or not equal upper bound";

    private static final Number ZERO = 0.0;


    private CheckerBound() {
    }

    /**
     * Check the {@code bound} is positive.
     *
     * @param bound the bound value to check.
     *
     * @throws NullPointerException if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} negative or zero.
     */
    public static void isPositiveBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() < 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NEGATIVE_BOUND);
        }
    }

    /**
     * Check the {@code bound} is negative.
     *
     * @param bound the bound value to check.
     *
     * @throws NullPointerException if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} positive or zero.
     */
    public static void isNegativeBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() > 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_POSITIVE_BOUND);
        }
    }

    /**
     * Check the {@code bound} is zero.
     *
     * @param bound the bound value to check.
     *
     * @throws NullPointerException if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} nonzero.
     */
    public static void isZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() != 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NONZERO_BOUND);
        }
    }

    /**
     * Check the {@code bound} is nonzero.
     *
     * @param bound the bound value to check.
     *
     * @throws NullPointerException if the {@code bound} null.
     * @throws BoundIncorrectException If the {@code bound} zero.
     */
    public static void isNonZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() == 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_ZERO_BOUND);
        }
    }

    /**
     * Check the {@code bound} in range from {@literal 0.0} to {@code upperBound}.
     *
     * @param bound the bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@literal 0.0} to {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isCorrectBound(
            @NotNull final T bound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(bound, MSG_EXC_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(bound, (T) ZERO) > 0 && compare(bound, upperBound) < 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check the {@code bound} in range from {@code lowerBound} to {@code upperBound}.
     *
     * @param bound the bound value to check.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@code lowerBound} to {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isCorrectBound(
            @NotNull final T bound, @NotNull final T lowerBound,
            @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(bound, MSG_EXC_BOUND_IS_NULL);
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(bound, lowerBound) > 0 && compare(bound, upperBound) < 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} and {@code upperBound} equal.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} not equal {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundEqualUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) == 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} and {@code upperBound} not equal.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} equal {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundNotEqualUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) != 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} less than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundLessUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) < 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} greater than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} less or equal than {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundGreaterUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) > 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} less or equal than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} greater than {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundLessOrEqualUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) <= 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check {@code lowerBound} greater or equal than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @throws NullPointerException if any of the arguments null.
     * @throws BoundsCompareException if {@code lowerBound} less than {@code upperBound}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerBoundGreaterOrEqualUpperBound(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(lowerBound, MSG_EXC_LOWER_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXC_UPPER_IS_NULL);
        if (compare(lowerBound, upperBound) >= 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    private static <T extends Number & Comparable<T>> int compare(
            final T valueFirst, final T valueSecond) {
        return valueFirst.compareTo(valueSecond);
    }

}
