package com.lugowoy.helper.utils.checking;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.6.6
 */
//todo write doc's
public final class CheckerIndex {

    public static final String MSG_INDEX_IS_OUT_OF_RANGE = "Index is out of range.";
    private static final int LOWER_INDEX = 0;

    private CheckerIndex() {
    }

    public static boolean checkIndex(final int index, final int upperBoundIndex) {
        boolean resultCheckIndex = false;
        if (CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE)) {
            if (index >= LOWER_INDEX && index < upperBoundIndex) {
                resultCheckIndex = true;
            } else {
                throw new IndexOutOfBoundsException(MSG_INDEX_IS_OUT_OF_RANGE);
            }
        }
        return resultCheckIndex;
    }

    public static void checkIndexTest(final int index, final int upperBoundIndex) {
        if (CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE)) {
            if (index < LOWER_INDEX || index > upperBoundIndex) {
                throw new IndexOutOfBoundsException(MSG_INDEX_IS_OUT_OF_RANGE);
            }
        }
    }

    public static boolean checkIndex(final int index, final int lowerBoundIndex, final int upperBoundIndex) {
        boolean resultCheckIndex = false;
        if (CheckerBound.isCorrectBound(lowerBoundIndex, LOWER_INDEX, Integer.MAX_VALUE)
                && CheckerBound.isCorrectBound(upperBoundIndex, LOWER_INDEX, Integer.MAX_VALUE)) {
            if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundIndex, upperBoundIndex)) {
                if (index >= lowerBoundIndex && index <= upperBoundIndex) {
                    resultCheckIndex = true;
                } else {
                    throw new IndexOutOfBoundsException(MSG_INDEX_IS_OUT_OF_RANGE);
                }
            }
        }
        return resultCheckIndex;
    }

}
