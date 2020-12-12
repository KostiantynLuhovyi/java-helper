package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.ComparatorNumber;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The class provides functionality for checking various values.
 * <p>
 * Created by Konstantin Lugowoy on 15.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 3.0
 */
//TODO review documentation
public final class CheckerNumber {

    private static final ComparatorNumber COMPARATOR =
            ComparatorNumber::compareNumber;

    private static final String MSG_VALUE_IS_NULL = "Value is null";
    private static final String MSG_LOWER_VALUE_IS_NULL = "Lower value is null";
    private static final String MSG_UPPER_VALUE_IS_NULL = "Upper value is null";
    private static final String MSG_VALUE_IS_NEGATIVE_OR_ZERO =
            "Value is negative or zero";
    private static final String MSG_VALUE_IS_POSITIVE_OR_ZERO =
            "Value is positive or zero";
    private static final String MSG_VALUE_IS_ZERO = "Value is zero";
    private static final String MSG_VALUE_IS_NOT_ZERO = "Value is not zero";

    private CheckerNumber() {
    }

    /**
     * Checks that the {@code value} is positive.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     * @return result of checking.
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isPositive(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        return COMPARATOR.compare(value, BigDecimal.ZERO) > 0;
    }

    public static <T extends Number & Comparable<T>> void checkPositive(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        if (COMPARATOR.compare(value, BigDecimal.ZERO) <= 0) {
            throw new ValueOutOfRangeException(MSG_VALUE_IS_NEGATIVE_OR_ZERO);
        }
    }

    /**
     * Check that the {@code value} is negative.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     * @return result of checking.
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isNegative(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        return COMPARATOR.compare(value, BigDecimal.ZERO) < 0;
    }

    public static <T extends Number & Comparable<T>> void checkNegative(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        if (COMPARATOR.compare(value, BigDecimal.ZERO) >= 0) {
            throw new ValueOutOfRangeException(MSG_VALUE_IS_POSITIVE_OR_ZERO);
        }
    }

    /**
     * Checks that the {@code value} is zero.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     * @return result of checking.
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isZero(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        return COMPARATOR.compare(value, BigDecimal.ZERO) == 0;
    }

    public static <T extends Number & Comparable<T>> void checkZero(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        if (COMPARATOR.compare(value, BigDecimal.ZERO) != 0) {
            throw new ValueOutOfRangeException(MSG_VALUE_IS_NOT_ZERO);
        }
    }

    /**
     * Checks that the {@code value} is nonzero.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     * @return result of checking.
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isNonZero(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        return COMPARATOR.compare(value, BigDecimal.ZERO) != 0;
    }

    public static <T extends Number & Comparable<T>> void checkNonZero(
            @NotNull final T value) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        if (COMPARATOR.compare(value, BigDecimal.ZERO) == 0) {
            throw new ValueOutOfRangeException(MSG_VALUE_IS_ZERO);
        }
    }

    /**
     * Checks the {@code value} in range from {@code lowerValue}(inclusive) to
     * {@code upperValue}(inclusive).
     *
     * @param <T> the type of the value and boundary values to check.
     * @param value the value to check.
     * @param lowerValue the lower bound value to check.
     * @param upperValue the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if the {@code value} is {@code null}.
     * @throws NullPointerException if any of boundary values is {@code null}.
     * @throws BoundsComparisonException if the {@code lowerValue} greater or
     * equal than {@code upperValue} value.
     * @since 3.0
     */
    public static <T extends Number & Comparable<T>> boolean isCorrect(
            @NotNull final T value, @NotNull final T lowerValue,
            @NotNull final T upperValue) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        Objects.requireNonNull(lowerValue, MSG_LOWER_VALUE_IS_NULL);
        Objects.requireNonNull(upperValue, MSG_UPPER_VALUE_IS_NULL);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerValue, upperValue);
        return COMPARATOR.compare(value, lowerValue) >= 0 && COMPARATOR.compare(
                value, upperValue) <= 0;
    }

    public static <T extends Number & Comparable<T>> void check(
            @NotNull final T value, @NotNull final T lowerValue,
            @NotNull final T upperValue) {
        Objects.requireNonNull(value, MSG_VALUE_IS_NULL);
        Objects.requireNonNull(lowerValue, MSG_LOWER_VALUE_IS_NULL);
        Objects.requireNonNull(upperValue, MSG_UPPER_VALUE_IS_NULL);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerValue, upperValue);
        if (COMPARATOR.compare(value, lowerValue) > 0
                && COMPARATOR.compare(value, upperValue) > 0) {
            throw new ValueOutOfRangeException(
                    "Value out of the range from " + lowerValue + " to "
                    + upperValue);
        }
    }

}
