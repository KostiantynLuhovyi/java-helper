package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.6.6
 */
//todo write doc's
public interface CheckerIndex {

    static boolean checkIndex(int index) {
        if (index >= 0 && index < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static <T> boolean checkIndex(int index, Array<T> array) {
        if (index >= 0 && index < array.size()) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static <T> boolean checkIndex(int index, T[] array) {
        if (index >= 0 && index < array.length) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static boolean checkIndex(int index, int[] array) {
        if (index >= 0 && index < array.length) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static boolean checkIndex(int index, double[] array) {
        if (index >= 0 && index < array.length) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static boolean checkIndex(int index, int upperBoundIndex) {
        if (index >= 0 && index < upperBoundIndex) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    static boolean checkIndex(int index, int lowerBoundIndex, int upperBoundIndex) {
        if (index >= lowerBoundIndex && index <= upperBoundIndex) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

}
