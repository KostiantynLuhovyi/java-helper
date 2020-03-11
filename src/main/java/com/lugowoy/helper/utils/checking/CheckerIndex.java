package com.lugowoy.helper.utils.checking;

/**
 * This class contains static functionality for checking the index value for correctness.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.6.6
 */
public final class CheckerIndex {

    private static final String MSG_EXCEPTION_INDEX_OUT_OF_RANGE = "Index out of range.";

    private static final int LOWER_INDEX = 0;

    private CheckerIndex() {
    }

    /**
     * Check the {@code index} in range from {@link CheckerIndex#LOWER_INDEX} to {@code upperBoundIndex}.
     *
     * @param index the index value to check.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @throws IndexOutOfBoundsException if the {@code index} value out of range
     * from {@link CheckerIndex#LOWER_INDEX} to {@code upperBoundIndex}.
     */
    public static void checkIndex(int index, int upperBoundIndex) {
        CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        if (index < LOWER_INDEX || index > upperBoundIndex) {
            throw new IndexOutOfBoundsException(MSG_EXCEPTION_INDEX_OUT_OF_RANGE);
        }
    }

    /**
     * Check the {@code index} in range from {@code lowerBoundIndex} argument to {@code upperBoundIndex}
     *
     * @param index the index value to check.
     * @param lowerBoundIndex the lower bound value to check index.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @throws IndexOutOfBoundsException if the {@code index} value out of range
     * from {@code lowerBoundIndex} to {@code upperBoundIndex}.
     */
    public static void checkIndex(int index, int lowerBoundIndex, int upperBoundIndex) {
        CheckerBound.isCorrectBound(lowerBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundIndex, upperBoundIndex);
        if (index < lowerBoundIndex && index > upperBoundIndex) {
            throw new IndexOutOfBoundsException(MSG_EXCEPTION_INDEX_OUT_OF_RANGE);
        }
    }

}
