package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.arrays.Array;

import static java.lang.Short.*;

/**
 * Created by Konstantin Lugowoy on 09-Jan-18.
 */

public interface FillingArrayChecker {

    static <T> boolean checkNonNullArrayObj(Array<T> array) {
        return array != null;
    }

    static boolean checkNonNullArray(Number[] numbers) {
        return numbers != null;
    }

    static boolean checkLengthArray(int lengthArray) {
        return lengthArray > 0;
    }

    static boolean checkBoundValue(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() > 0);
    }

    static boolean checkStartBoundIsInCorrectRange(Number startBound) {
        return (startBound != null) && (startBound.doubleValue() >= Short.MIN_VALUE && startBound.doubleValue() <= Short.MAX_VALUE);
    }

    static boolean checkMinBoundLessThanMaxBound(Number minBound, Number maxBound) {
        return minBound.doubleValue() < maxBound.doubleValue();
    }

}
