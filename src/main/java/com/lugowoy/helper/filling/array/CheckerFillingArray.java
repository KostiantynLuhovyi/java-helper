package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * The interface provides static functionality (behavior) for various checks when filling arrays with data.
 * <p>Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 */
public interface CheckerFillingArray {

    /**
     * Default lower bound of the length of array.
     */
    int LOWER_BOUND_LENGTH_ARRAY = 0;

    /**
     * Checks object of the {@link Array} class passed by argument a non-equality to null.
     *
     * @param array The object of the {@link Array} class for checking.
     * @return Result of checking.
     */
    static <T> boolean checkNonNullArray(Array<T> array) {
        return (array != null);
    }

    /**
     * Checks array of type {@link Number} passed by argument a non-equality to null.
     *
     * @param numbers The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(Number[] numbers) {
        return (numbers != null);
    }

    /**
     * Checks array of type {@link Point} passed by argument a non-equality to null.
     *
     * @param points The array for checking.
     * @return Result of checking.
     */
    static <T extends Number> boolean checkNonNullArray(Point<T>[] points) {
        return (points != null);
    }

    /**
     * Checks array of type {@link String} passed by argument a non-equality to null.
     *
     * @param strings The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(String[] strings) {
        return (strings != null);
    }

    /**
     * Checks that the length of the array is in the valid range from 0 to ({@link Integer#MAX_VALUE} - 1).
     *
     * @param lengthArray The length of the array value for checking.
     * @return Result of checking.
     */
    static boolean checkLengthArray(int lengthArray) {
        return (lengthArray >= LOWER_BOUND_LENGTH_ARRAY && lengthArray < Integer.MAX_VALUE);
    }

    /**
     * Сhecks than the value is a positive number and less than ({@link Integer#MAX_VALUE} - 1).
     *
     * @param value The value for checking.
     * @return Result of checking.
     */
    static boolean isPositiveBound(Number value) {
        return (value.doubleValue() > 0 && value.doubleValue() < Integer.MAX_VALUE);
    }

    /**
     * Checks than the value is a negative number and greatest than {@link Integer#MIN_VALUE}.
     *
     * @param value The value for checking.
     * @return Result of checking.
     */
    static boolean isNegativeBound(Number value) {
        return (value.intValue() < 0 && value.intValue() > Integer.MIN_VALUE);
    }

    //todo add doc's
    static boolean isZero(Number value) {
        return (value.doubleValue() == 0.0);
    }

    /**
     * Checks than the bound value is in the range of values from ({@link Integer#MIN_VALUE} + 1) to ({@link Integer#MAX_VALUE} - 1).
     *
     * @param boundValue The bound value for checking.
     * @return Result of checking.
     */
    static boolean isCorrectRangeBound(Number boundValue) {
        return boundValue.doubleValue() > Integer.MIN_VALUE && boundValue.doubleValue() < Integer.MAX_VALUE;
    }

    //todo add doc's
    static boolean isCorrectRangeBounds(Number lowerBoundValue, Number upperBoundValue) {
        return (isCorrectRangeBound(lowerBoundValue) && isCorrectRangeBound(upperBoundValue));
    }

    /**
     * Checks than the lower bound value is not greater than upper bound value.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundLessThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() < upperBoundValue.doubleValue();
    }

    /**
     * Checks than the lower bound value is greater than upper bound value.
     *
     * @param lowerBoundValue The lower bound value for checking.
     * @param upperBoundValue The upper bound value for checking.
     * @return Result of checking.
     */
    static boolean isLowerBoundGreaterThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() > upperBoundValue.doubleValue();
    }

    //todo add doc's
    static boolean isLowerBoundLessOrEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return (isLowerBoundLessThanUpperBound(lowerBoundValue, upperBoundValue)
                        ||
                isLowerBoundEqualThanUpperBound(lowerBoundValue, upperBoundValue));
    }

    //todo add doc's
    static boolean isLowerBoundGreaterOrEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return (isLowerBoundGreaterThanUpperBound(lowerBoundValue, upperBoundValue)
                        ||
                isLowerBoundEqualThanUpperBound(lowerBoundValue, upperBoundValue));
    }

    //todo add doc's
    static boolean isLowerBoundEqualThanUpperBound(Number lowerBoundValue, Number upperBoundValue) {
        return lowerBoundValue.doubleValue() == upperBoundValue.doubleValue();
    }

}
