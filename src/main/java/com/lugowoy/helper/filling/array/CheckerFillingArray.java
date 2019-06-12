package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * The interface provides static functionality (behavior) for various checks when filling arrays with data.
 * <p>Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 */
public interface CheckerFillingArray {

    /**
     * Default start of array.
     */
    int DEFAULT_START_LENGTH_ARRAY = 0;

    /**
     * Check object of the {@link Array} class passed by argument a non-equality to null.
     *
     * @param array Object of the {@link Array} class for checking.
     * @return Result of checking.
     */
    static <T> boolean checkNonNullArray(Array<T> array) {
        return array != null;
    }

    /**
     * Check array of type {@link Number} passed by argument a non-equality to null.
     *
     * @param numbers The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(Number[] numbers) {
        return numbers != null;
    }

    /**
     * Check array of type {@link Point} passed by argument a non-equality to null.
     *
     * @param points The array for checking.
     * @return Result of checking.
     */
    static <T extends Number> boolean checkNonNullArray(Point<T>[] points) {
        return points != null;
    }

    /**
     * Check array of type {@link String} passed by argument a non-equality to null.
     *
     * @param strings The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(String[] strings) {
        return strings != null;
    }

    /**
     * Check the value of "lengthArray" is greater than "0" and less than {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray The value for checking.
     * @return Result of checking.
     */
    static boolean checkLengthArray(int lengthArray) {
        return lengthArray >= DEFAULT_START_LENGTH_ARRAY && lengthArray < Integer.MAX_VALUE;
    }

    /**
     * Сheck the value "boundValue" is a positive number and less than {@link Integer#MAX_VALUE}.
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isPositiveBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && (boundValue.intValue() >= 0 && boundValue.intValue() < Integer.MAX_VALUE);
    }

    /**
     * Check the value "boundValue" is a negative number and greatest than {@link Integer#MIN_VALUE}.
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isNegativeBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && (boundValue.intValue() < 0 && boundValue.intValue() > Integer.MIN_VALUE);
    }

    /**
     * Check the value "boundValue" is in the range of values from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isCorrectRangeBoundValue(Number boundValue) {
        return boundValue.intValue() > Integer.MIN_VALUE && boundValue.intValue() < Integer.MAX_VALUE;
    }

    /**
     * Checks the value "startBound" is not greater than "endBound".
     *
     * @param startBound The start value for checking.
     * @param endBound   The end value for checking.
     * @return Result of checking.
     */
    static boolean isStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() < endBound.intValue();
    }

    /**
     * Checks the value "startBound" is greater than "endBound".
     *
     * @param startBound The start value for checking.
     * @param endBound   The end value for checking.
     * @return Result of checking.
     */
    static boolean isStartBoundValueGreatestThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() > endBound.intValue();
    }

}
