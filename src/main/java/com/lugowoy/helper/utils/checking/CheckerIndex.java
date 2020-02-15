package com.lugowoy.helper.utils.checking;

/**
 * This class contains static functionality for checking the index value for correctness.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.6.6
 */
public final class CheckerIndex {

    private static final String MSG_EXCEPTION_INDEX_IS_OUT_OF_RANGE = "Index is out of range.";

    private static final int LOWER_INDEX = 0;

    private CheckerIndex() {
    }

    /**
     * Check the argument {@code index} for correct entry into a range of values
     * from {@link CheckerIndex#LOWER_INDEX} argument to {@code upperBoundIndex}
     *
     * @param index           Index value to check.
     * @param upperBoundIndex Upper bound value to check index.
     * @throws IndexOutOfBoundsException If the value {@code index} is not in the range of valid values
     *                                   from {@link CheckerIndex#LOWER_INDEX} to {@code upperBoundIndex}.
     */
    public static void checkIndex(int index, int upperBoundIndex) {
        CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        if (index < LOWER_INDEX || index > upperBoundIndex) {
            throw new IndexOutOfBoundsException(MSG_EXCEPTION_INDEX_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Check the argument {@code index} for correct entry into a range of values
     * from {@code lowerBoundIndex} argument to {@code upperBoundIndex}
     *
     * @param index           Index value to check.
     * @param lowerBoundIndex Lower bound value to check index.
     * @param upperBoundIndex Upper bound value to check index.
     * @throws IndexOutOfBoundsException If the value {@code index} is not in the range of valid values
     *                                   from {@code lowerBoundIndex} to {@code upperBoundIndex}.
     */
    public static void checkIndex(int index, int lowerBoundIndex, int upperBoundIndex) {
        CheckerBound.isCorrectBound(lowerBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundIndex, upperBoundIndex);
        if (index < lowerBoundIndex && index > upperBoundIndex) {
            throw new IndexOutOfBoundsException(MSG_EXCEPTION_INDEX_IS_OUT_OF_RANGE);
        }
    }

}
