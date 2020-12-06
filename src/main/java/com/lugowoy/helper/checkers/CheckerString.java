package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;

/**
 * The class provides functionality for checking strings and their attributes.
 * <p>
 * Created by Konstantin Lugowoy on 01.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 3.0
 */
//TODO review documentation
public class CheckerString {

    /**
     * Checks the {@code lengthString} value in range from {@code
     * lowerLengthString}(inclusive) to {@code boundLengthString}(inclusive).
     * <p>
     * Boundary values must be in the range from 0(inclusive) to {@link
     * Integer#MAX_VALUE}(inclusive). Lower bound value must be less than or
     * equal to upper bound value.
     *
     * @param lengthString the length value of the string to check.
     * @param boundLengthString the upper bound length of the string to check.
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from 0 to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if the {@code lowerLengthString} value
     * greater than the {@code boundLengthString} value.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from {@code lowerLengthString} to {@code boundLengthString}.
     */
    public static void check(final int lengthString,
                             final int boundLengthString) {
        CheckerBoundNumber.checkInRange(boundLengthString, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (lengthString > boundLengthString) {
            throw new LengthOutOfRangeException(
                    "Value length of the string out of range from "
                    + Capacity.LOWER.get() + " to " + boundLengthString);
        }
    }

    public static void check(final String string, final int boundLengthString) {
        CheckerBoundNumber.checkInRange(boundLengthString, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        if (string.length() > boundLengthString) {
            throw new LengthOutOfRangeException(
                    "Length of the string out of range from "
                    + Capacity.LOWER.get() + " to " + boundLengthString);
        }
    }

}
