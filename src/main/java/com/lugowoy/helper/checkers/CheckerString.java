package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.LengthOutOfRangeException;

/**
 * The class provides functionality for checking strings and their attributes.
 * <p>
 * Created by Konstantin Lugowoy on 01.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 3.0
 */
public class CheckerString {

    /**
     * Checks the {@code lengthString} value in range from {@code
     * lowerBoundLength} (inclusive) to {@code upperBoundLength} (exclusive).
     *
     * @param lengthString the length value of the string to check.
     * @param lowerBoundLength the lower bound length of the string to check.
     * @param upperBoundLength the upper bound length of the string to check.
     *
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@code lowerBoundLength} to {@code upperBoundLength}.
     * @throws BoundsComparisonException if the {@code lowerBoundLength} value
     * greater or equal than the {@code upperBoundLength} value.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from {@code lowerBoundLength} to {@code upperBoundLength}.
     */
    public static void checkLength(final int lengthString,
                                   final int lowerBoundLength,
                                   final int upperBoundLength) {
        CheckerBoundNumber.checkInRange(lowerBoundLength, 0, Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundLength, 0, Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundLength,
                                                      upperBoundLength);
        if (lengthString < lowerBoundLength
            || lengthString > upperBoundLength) {
            throw new LengthOutOfRangeException(
                    "Value length of the string out of range ("
                    + lowerBoundLength + " - " + upperBoundLength + ")");
        }
    }

}
