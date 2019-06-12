package com.lugowoy.helper.other;

import com.lugowoy.helper.models.Array;

/**
 * <p> Created by LugowoyKonstantin on 08.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.6.6
 */
//todo add doc's
public interface CheckerIndex {

    //todo add doc's (from 0 to Integer.Max)
    static boolean checkIndex(int index) {
        if (index >= 0 && index < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    //todo add doc's (from 0 to array.getLength())
    static <T> boolean checkIndex(int index, Array<T> array) {
        if (index >= 0 && index < array.getLength()) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    //todo add doc's (from 0 to tArray.length)
    static <T> boolean checkIndex(int index, T[] tArray) {
        if (index >= 0 && index < tArray.length) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument index out of range.");
        }
    }

    //todo add doc's (from 0 to upperBound)
    static boolean checkIndex(int bound, int upperBound) {
        if (bound >= 0 && bound < upperBound) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument bound out of range.");
        }
    }

    //todo add doc's (from lowerBound to upperBound)
    static boolean checkIndex(int bound, int lowerBound, int upperBound) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("The argument bound out of range.");
        }
    }

}
