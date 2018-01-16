package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 09-Jan-18.
 */

public interface FillingArrayChecker {

    static <T> boolean checkNonNullArrayObject(Array<T> array) {
        return array != null;
    }

    static boolean checkNonNullArrayNumbers(Number[] numbers) {
        return numbers != null;
    }

    static <T extends Number> boolean checkNonNullArrayPoints(Point<T>[] points) {
        return points != null;
    }

    static boolean checkLengthArray(int lengthArray) {
        return lengthArray > 0;
    }

    static boolean checkBoundValueIsPositive(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() > 0);
    }

    static boolean checkBoundValueIsNegative(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() < 0);
    }

    static boolean checkBoundValueIsInCorrectRange(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() >= Short.MIN_VALUE && boundValue.doubleValue() <= Short.MAX_VALUE);
    }

    static boolean checkStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.doubleValue() < endBound.doubleValue();
    }

}
