package com.lugowoy.helper.other;

import com.lugowoy.helper.models.arrays.Array;

/**
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.2
 *
 * An interface that performs static functions to perform checks on the correctness of various values associated with arrays.
 */

public interface ArrayChecker {

    /**
     * Returns the result of the check object of the Array class passed by argument to is a null.
     *
     * @param array The object of the Array class to check.
     * @return Result of the check.
     */
    static <T> boolean checkArrayNonNull(Array<T> array) throws IllegalArgumentException {
        if (array != null) {
            return true;
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the Array class passed by the argument is null."));
        }
    }

    /**
     * Returns the result of the check array passed by argument to is a null.
     *
     * @param array The array to check.
     * @return Result to check.
     */
    static <T> boolean checkArrayNonNull(T[] array) throws IllegalArgumentException {
        if (array != null) {
            return true;
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the argument is null."));
        }
    }

    /**
     * Returns the result of the check value of the length of the array passed by argument is equal to or greater than zero.
     *
     * @param lengthOfArray The value of the length of the array.
     * @return Result to check.
     */
    static boolean checkLengthOfArrayIsEqualZeroOrGreater(int lengthOfArray) throws IllegalArgumentException {
        if (lengthOfArray >= 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The value of the length of the array passed by the argument is equal to or greater than zero.");
        }
    }

    /**
     * Returns the result of the check value of the length of the array passed by argument is greater than zero.
     *
     * @param lengthOfArray The value of the length of the array.
     * @return Result to check.
     */
    static boolean checkLengthOfArrayIsGreaterZero(int lengthOfArray) throws IllegalArgumentException {
        if (lengthOfArray > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The value of the length of the array passed by the argument is greater than zero.");
        }
    }

}
