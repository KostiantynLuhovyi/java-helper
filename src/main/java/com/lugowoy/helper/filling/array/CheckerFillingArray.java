package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.Array;

/**
 * The interface provides static functionality (behavior) for various checks when filling arrays with data.
 * <p>Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 */
public interface CheckerFillingArray {

    /**
     * Checks object of the {@link Array} class passed by argument a non-equality to null.
     *
     * @param array The object of the {@link Array} class for checking.
     * @return Result of checking.
     */
    static <T> boolean isNonNullArray(Array<T> array) {
        return (array != null);
    }

    /**
     * Checks array {@code tArray} passed by argument a non-equality to null.
     *
     * @param tArray The array for checking.
     * @return Result of checking.
     */
    static <T> boolean isNonNullArray(T[] tArray) {
        return (tArray != null);
    }

    /**
     * Checks the {@code lengthArray} of the array is in the valid range from 0 to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray The length of the array value for checking.
     * @return Result of checking.
     */
    static boolean checkLengthArray(int lengthArray) {
        return (lengthArray >= 0 && lengthArray <= Integer.MAX_VALUE);
    }

    /**
     * Сhecks the value is a positive number.
     *
     * @param value The value for checking.
     * @return Result of checking.
     */
    static boolean isPositiveBound(Number value) {
        return value.doubleValue() > 0;
    }

    /**
     * Checks the value is a negative number.
     *
     * @param value The value for checking.
     * @return Result of checking.
     */
    static boolean isNegativeBound(Number value) {
        return value.doubleValue() < 0;
    }

    /**
     * Checks the value is equal zero.
     *
     * @param value the value for checking.
     * @return Result of checking.
     */
    static boolean isZero(Number value) {
        return value.doubleValue() == 0.0;
    }

    /**
     * Checks the {@code bound} argument value is in the range of values from {@code lowerBound} to {@code upperBound} argument.
     *
     * @param bound      The bound value to check.
     * @param lowerBound The lower bound for checking.
     * @param upperBound The upper bound for checking.
     * @return Result of checking.
     */
    static boolean isCorrectBounds(Number bound, Number lowerBound, Number upperBound) {
        return bound.doubleValue() >= lowerBound.doubleValue() && bound.doubleValue() <= upperBound.doubleValue();
    }

    /**
     * Checks than the {@code lowerBoundValue} argument is not greater than {@code upperBoundValue} argument.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundLessThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() < upperBoundValue.doubleValue();
    }

    /**
     * Checks than the {@code lowerBoundValue} argument is greater than {@code upperBoundValue} argument.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundGreaterThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() > upperBoundValue.doubleValue();
    }

    /**
     * Checks than the {@code lowerBoundValue} argument is equal than {@code upperBoundValue} argument.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() == upperBoundValue.doubleValue();
    }

    /**
     * Checks than the {@code lowerBoundValue} argument is less or equal than {@code upperBoundValue} argument.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundLessOrEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return (isLowerBoundLessThanUpperBound(lowerBoundValue, upperBoundValue)
                    ||
                isLowerBoundEqualThanUpperBound(lowerBoundValue, upperBoundValue));
    }

    /**
     * Checks than the {@code lowerBoundValue} argument is greater or equal than {@code upperBoundValue} argument.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundGreaterOrEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return (isLowerBoundGreaterThanUpperBound(lowerBoundValue, upperBoundValue)
                    ||
                isLowerBoundEqualThanUpperBound(lowerBoundValue, upperBoundValue));
    }

}
