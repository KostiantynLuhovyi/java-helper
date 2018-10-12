package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;

/**
 * The interface provides a static functional for various checks
 * that are used to implement the filling of data objects or data structures (arrays).
 * <p>Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 */
public interface CheckerFillingArray {

    int DEFAULT_START_LENGTH_ARRAY = 0;

    /**
     * The method that check that an object of the {@link Array} class is not equal to null.
     * @param array The object of class Array for checking.
     * @return Result of checking.
     */
    static <T> boolean checkNonNullArray(Array<T> array) {
        return array != null;
    }

    /**
     * The method that check that an array of objects of the {@link Number} class is not equal to null.
     * @param numbers The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(Number[] numbers) {
        return numbers != null;
    }

    /**
     * The method that check that an array of objects of the {@link Point} class is not equal to null.
     * @param points The array for checking.
     * @return Result of checking.
     */
    static <T extends Number> boolean checkNonNullArray(Point<T>[] points) {
        return points != null;
    }

    /**
     * The method that check an array of objects of the {@link String} class is not equal to null.
     * @param strings The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArray(String[] strings) {
        return strings != null;
    }

    /**
     * The method that checks that the value of "lengthArray" is greater than "0" and less than {@link Integer#MAX_VALUE}.
     * @param lengthArray The value for checking.
     * @return Result of checking.
     */
    static boolean checkLengthArray(int lengthArray) {
        return ((lengthArray >= DEFAULT_START_LENGTH_ARRAY) && (lengthArray < Integer.MAX_VALUE));
    }

    /**
     * The method checks that the value "boundValue" is a positive number and less than {@link Integer#MAX_VALUE}.
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isPositiveBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && ((boundValue.intValue() >= 0) && (boundValue.intValue() < Integer.MAX_VALUE));
    }

    /**
     * The method checks that the value "boundValue" is a negative number and greatest than {@link Integer#MIN_VALUE}.
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isNegativeBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && (boundValue.intValue() < 0 && boundValue.intValue() > Integer.MIN_VALUE);
    }

    /**
     * The method checks that the value "boundValue" is in the range of values from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean isCorrectRangeBoundValue(Number boundValue) {
        return boundValue.intValue() > Integer.MIN_VALUE && boundValue.intValue() < Integer.MAX_VALUE;
    }

    /**
     * The method checks the value "startBound" is not greater than "endBound".
     * @param startBound The value for checking.
     * @param endBound The value for checking.
     * @return Result of checking.
     */
    static boolean isStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() < endBound.intValue();
    }

    /**
     * The method checks the value "startBound" is greater than "endBound".
     * @param startBound The value for checking.
     * @param endBound The value for checking.
     * @return Result of checking.
     */
    static boolean isStartBoundValueGreatestThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() > endBound.intValue();
    }

}
