package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 */

public interface FillingArrayChecker {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     */
    static <T> boolean checkNonNullArrayObject(Array<T> array) {
        return array != null;
    }

    /**
     * <p></p>
     *
     * @param numbers
     *
     * @return
     */
    static boolean checkNonNullArrayNumbers(Number[] numbers) {
        return numbers != null;
    }

    /**
     * <p></p>
     *
     * @param points
     *
     * @return
     */
    static <T extends Number> boolean checkNonNullArrayPoints(Point<T>[] points) {
        return points != null;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     */
    static boolean checkLengthArray(int lengthArray) {
        return ((lengthArray > 0) && (lengthArray <= Short.MAX_VALUE));
    }


    /**
     * <p></p>
     *
     * @param boundValue
     *
     * @return
     */
    static boolean checkBoundValueIsPositive(Number boundValue) {
        return (boundValue != null) && ((boundValue.doubleValue() > 0) && (boundValue.doubleValue() <= Short.MAX_VALUE));
    }

    /**
     * <p></p>
     *
     * @param boundValue
     *
     * @return
     */
    static boolean checkBoundValueIsNegative(Number boundValue) {
        return (boundValue != null) && ((boundValue.doubleValue() < 0) && (boundValue.doubleValue() >= Short.MIN_VALUE));
    }

    /**
     * <p></p>
     *
     * @param boundValue
     *
     * @return
     */
    static boolean checkBoundValueIsInCorrectRange(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() >= Short.MIN_VALUE && boundValue.doubleValue() <= Short.MAX_VALUE);
    }

    /**
     * <p></p>
     *
     * @param minBound
     * @param maxBound
     *
     * @return
     */
    static boolean checkMinBoundValueLessThanMaxBoundValue(Number minBound, Number maxBound) {
        return minBound.doubleValue() < maxBound.doubleValue();
    }

    /**
     * <p></p>
     *
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    static boolean checkStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.doubleValue() < endBound.doubleValue();
    }

    /**
     * <p></p>
     *
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    static boolean checkStartBoundValueMoreThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.doubleValue() > endBound.doubleValue();
    }

}
