package com.lugowoy.helper.other;

/**
 * Checks the length of the array.
 * <p>Created by LugowoyKonstantin on 07.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.6.6
 */
public interface CheckerLengthArray {

    /**
     * Checking the value (argument) of the array length for compliance with the condition.
     * The condition is that the value passed by the argument
     *  is greater than 0 and less than the value of argument maxLengthValue.
     *
     * @param lengthValue Length array value.
     * @param maxLengthValue Maximum allowed length value of array.
     * @return Result of check.
     * @throws IncorrectLengthArgumentException If the length of the array is not in the range.
     */
    static boolean checkLengthValueInRange(int lengthValue, long maxLengthValue) {
        if (lengthValue > 0 && lengthValue <= maxLengthValue) {
            return true;
        } else {
            throw new IncorrectLengthArgumentException("Array length is out of range");
        }
    }

    /**
     * Checking the value (argument) of the array length for compliance with the condition.
     * The condition is that the value passed by the argument
     *  is greater than zero and less than the value of {@link Integer#MAX_VALUE}.
     *
     * @param lengthValue Length array value.
     * @return Result of check.
     * @throws IncorrectLengthArgumentException If the length of the array is not in the range.
     */
    static boolean checkLengthValueInRange(int lengthValue) {
        return checkLengthValueInRange(lengthValue, Integer.MAX_VALUE);
    }

}
