package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;

/**
 * The class provides functionality for checking various values.
 * <p> Created by Konstantin Lugowoy on 15.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
public final class CheckerValue {

    private CheckerValue() {
    }

    /**
     * Checks the {@code value} argument in of the range from {@code lowerBoundValue} value to {@code upperBoundValue} value.
     *
     * @param value the numeric value to check.
     * @param lowerBoundValue the lower bound numeric value to check.
     * @param upperBoundValue the upper bound numeric value to check.
     *
     * @throws NullPointerException if the {@code value} argument is null.
     * @throws BoundsCompareException if the {lowerBoundValue} value greater of equal than {@code upperBoundValue} value.
     * @throws ValueOutOfRangeException if the {@code value} argument out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @since 3.0
     */
    public static void checkValue(Number value, Number lowerBoundValue, Number upperBoundValue) {
        if (value == null) { throw new NullPointerException("Value is null."); }
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        boolean valueLessLower = value.doubleValue() < lowerBoundValue.doubleValue();
        boolean valueGreaterUpper = value.doubleValue() > upperBoundValue.doubleValue();
        if (valueLessLower || valueGreaterUpper) {
            throw new ValueOutOfRangeException(getMsgExceptionValueOutOfRange(lowerBoundValue, upperBoundValue));
        }
    }

    private static String getMsgExceptionValueOutOfRange(Number lowerBoundValue, Number upperBoundValue) {
        return "Value out of range (" + lowerBoundValue + " - " + upperBoundValue + ")";
    }

}
