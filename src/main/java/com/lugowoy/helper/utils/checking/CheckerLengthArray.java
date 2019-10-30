package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.6.6
 */
//todo write doc's
public interface CheckerLengthArray {

    static boolean checkLengthInArray(AbstractArray array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    static boolean checkLengthInArray(AbstractArray array, int upperBoundLength) {
        if (array != null) {
            if (array.size() <= upperBoundLength) {
                return true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        } else {
            throw new NullPointerException("Array is null");
        }
    }

    static <T> boolean checkLengthInArray(T[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    static <T> boolean checkLengthInArray(T[] array, int upperBoundLength) {
        if (array != null) {
            if (array.length <= upperBoundLength) {
                return true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        } else {
            throw new NullPointerException("Array is null");
        }
    }

    static boolean checkLengthInArray(int[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    static boolean checkLengthInArray(int[] array, int upperBoundLength) {
        if (array != null) {
            if (array.length <= upperBoundLength) {
                return true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        } else {
            throw new NullPointerException("Array is null");
        }
    }

    static boolean checkLengthInArray(double[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    static boolean checkLengthInArray(double[] array, int upperBoundLength) {
        if (array != null) {
            if (array.length <= upperBoundLength) {
                return true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        } else {
            throw new NullPointerException("Array is null.");
        }
    }

    static boolean checkLengthArray(int lengthArray) {
        return checkLengthArray(lengthArray, Integer.MAX_VALUE);
    }

    static boolean checkLengthArray(int lengthArray, int upperBoundLength) {
        if (upperBoundLength > 0 && upperBoundLength <= Integer.MAX_VALUE) {
            if (lengthArray > 0 && lengthArray <= upperBoundLength) {
                return true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        } else {
            throw new BoundOutOfRangeException("Upper bound length of the array is out of correct range values.");
        }
    }

}
