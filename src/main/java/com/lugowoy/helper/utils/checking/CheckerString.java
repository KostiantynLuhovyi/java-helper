package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthStringOutOfRangeException;

/**
 * The class provides functionality for checking strings and their attributes.
 * <p> Created by Konstantin Lugowoy on 01.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
public class CheckerString {

    private static final int DEFAULT_LOWER_STRING = 0;

    /**
     * Checks the {@code lengthString} value in the valid range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param lengthString the string length value to check.
     *
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     */
    public static void checkLengthString(int lengthString) {
        checkLengthString(lengthString, DEFAULT_LOWER_STRING, Integer.MAX_VALUE);
    }

    /**
     * Checks the {@code lengthString} value in the valid range from {@code lowerBoundLength} to {@code upperBoundLength}.
     *
     * @param lengthString the string length value to check.
     * @param lowerBoundLength the string length lower bound to check.
     * @param upperBoundLength the string length upper bound to check.
     *
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value out of range
     * from {@code lowerBoundLength} to {@code upperBoundLength}.
     */
    public static void checkLengthString(int lengthString, int lowerBoundLength, int upperBoundLength) {
        CheckerBound.isCorrectBound(lowerBoundLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundLength, upperBoundLength);
        if (lengthString < lowerBoundLength || lengthString > upperBoundLength) {
            String msgEx = "Value length of the string out of range (" + lowerBoundLength + " - " + upperBoundLength + ")";
            throw new LengthStringOutOfRangeException(msgEx);
        }
    }

}
