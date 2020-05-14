package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundsComparisonException;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The class provides functionality for checking various values.
 * <p>
 * Created by Konstantin Lugowoy on 15.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 3.0
 */
public final class CheckerNumber {

    private static final String MSG_EXC_VALUE_IS_NULL = "Value is null.";
    private static final String MSG_EXC_LOWER_VALUE_IS_NULL =
            "Lower value is null";
    private static final String MSG_EXC_UPPER_VALUE_IS_NULL =
            "Upper value is null";

    private CheckerNumber() {
    }

    /**
     * Checks that the {@code value} is positive.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isPositive(
            @NotNull final T value) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(value, MSG_EXC_VALUE_IS_NULL);
        if (value.compareTo((T) BigDecimal.ZERO) > 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Check that the {@code value} is negative.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isNegative(
            @NotNull final T value) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(value, MSG_EXC_VALUE_IS_NULL);
        if (value.compareTo((T) BigDecimal.ZERO) < 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Checks that the {@code value} is zero.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isZero(
            @NotNull final T value) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(value, MSG_EXC_VALUE_IS_NULL);
        if (value.compareTo((T) BigDecimal.ZERO) == 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    /**
     * Checks that the {@code value} is nonzero.
     *
     * @param <T> the type of the value to check.
     * @param value the value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if the {@code value} is {@code null}.
     */
    public static <T extends Number & Comparable<T>> boolean isNonZero(
            @NotNull final T value) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(value, MSG_EXC_VALUE_IS_NULL);
        if (value.compareTo((T) BigDecimal.ZERO) != 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }


    /**
     * Checks the {@code value} in range from {@code lowerValue}(inclusive) to
     * {@code upperValue}(inclusive).
     *
     * @param <T> the type of the value and boundary values to check.
     * @param value the value to check.
     * @param lowerValue the lower bound value to check.
     * @param upperValue the upper bound value to check.
     *
     * @return result of checking.
     *
     * @throws NullPointerException if the {@code value} is {@code null}.
     * @throws NullPointerException if any of boundary values is {@code null}.
     * @throws BoundsComparisonException if the {@code lowerValue} greater or
     * equal than {@code upperValue} value.
     * @since 3.0
     */
    public static <T extends Number & Comparable<T>> boolean check(
            @NotNull final T value, @NotNull final T lowerValue,
            @NotNull final T upperValue) {
        boolean resultOfCheck = false;
        Objects.requireNonNull(value, MSG_EXC_VALUE_IS_NULL);
        Objects.requireNonNull(lowerValue, MSG_EXC_LOWER_VALUE_IS_NULL);
        Objects.requireNonNull(upperValue, MSG_EXC_UPPER_VALUE_IS_NULL);
        CheckerBoundNumber.checkLowerLessUpper(lowerValue, upperValue);
        if (value.compareTo(lowerValue) > 0 && value.compareTo(upperValue)
                < 0) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

}
