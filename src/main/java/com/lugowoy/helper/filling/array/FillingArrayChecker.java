package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.arrays.Array;

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
        return boundValue.doubleValue() > 0;
    }

    static boolean checkMinBoundLessThanMaxBound(Number minBound, Number maxBound) {
        return minBound.doubleValue() < maxBound.doubleValue();
    }

}
