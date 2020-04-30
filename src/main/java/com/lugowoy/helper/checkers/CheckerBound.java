package com.lugowoy.helper.checkers;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class provides functionality for checking various boundary numerical
 * values.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.9
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
     * Checks that the {@code bound} value in range from {@literal 0} to {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Checks that the {@code bound} value in range from {@code lowerBound}
     * value to {@code upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Checks that the {@code lowerBound} value and the {@code upperBound} value
     * is equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Check that the {@code lowerBound} value and the {@code upperBound} value
     * is not equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Check that the {@code lowerBound} value less than the {@code upperBound}
     * value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Check that the {@code lowerBound} value greater than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Check that the {@code lowerBound} value less or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
     * Check that the {@code lowerBound} value greater or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
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
