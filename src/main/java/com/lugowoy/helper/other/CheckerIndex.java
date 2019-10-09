package com.lugowoy.helper.other;

import com.lugowoy.helper.models.Array;

/**
 * <p> Created by LugowoyKonstantin on 08.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.6.6
 */

//todo refactoring code
//todo edit doc's

public interface CheckerIndex {

    static boolean checkIndex(int index) {
        if (index >= 0 && index < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    static <T> boolean checkIndex(int index, Array<T> array) {
        if (index >= 0 && index < array.getLength()) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    static <T> boolean checkIndex(int index, T[] tArray) {
        if (index >= 0 && index < tArray.length) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    static boolean checkIndex(int bound, int upperBound) {
        if (bound >= 0 && bound < upperBound) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument bound out of range.");
        }
    }

    static boolean checkIndex(int bound, int lowerBound, int upperBound) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument bound out of range.");
        }
    }

}
