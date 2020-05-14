package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;

/**
 * This class contains static functionality for checking the index value for
 * correctness.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.6.6
 */
public final class CheckerIndex {

    private static final long LOWER_INDEX = 0;

    private CheckerIndex() {
    }

    /**
     * Check the {@code index} in range from {@link CheckerIndex#LOWER_INDEX}
     * (inclusive) to {@code upperBoundIndex}(exclusive).
     *
     * @param index the index value to check.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @return result of checking.
     *
     * @throws BoundOutOfRangeException if the {@code upperBoundIndex} value out
     * of range from {@link CheckerIndex#LOWER_INDEX} to {@link
     * Long#MAX_VALUE}.
     */
    public static boolean isInRange(final long index,
                                    final long upperBoundIndex) {
        CheckerBoundNumber.checkInRange(upperBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        return index >= LOWER_INDEX && index < upperBoundIndex;
    }

    /**
     * Check the {@code index} in range from {@link CheckerIndex#LOWER_INDEX}
     * (inclusive) to {@code upperBoundIndex}(exclusive).
     *
     * @param index the index value to check.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @throws BoundOutOfRangeException if the {@code upperBoundIndex} value out
     * of range from {@link CheckerIndex#LOWER_INDEX} to {@link
     * Long#MAX_VALUE}.
     * @throws IndexOutOfBoundsException if the {@code index} value out of range
     * from {@link CheckerIndex#LOWER_INDEX} to {@code upperBoundIndex}.
     */
    public static void checkInRange(final long index,
                                    final long upperBoundIndex) {
        CheckerBoundNumber.checkInRange(upperBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        if (index < LOWER_INDEX || index >= upperBoundIndex) {
            throw new IndexOutOfBoundsException(
                    "Index value out of range(" + CheckerIndex.LOWER_INDEX + "-"
                    + upperBoundIndex + ")");
        }
    }

    /**
     * Check the {@code index} in range from {@code lowerBoundIndex} (inclusive)
     * argument to {@code upperBoundIndex}(exclusive).
     *
     * @param index the index value to check.
     * @param lowerBoundIndex the lower bound value to check index.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @return result of checking.
     *
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link CheckerIndex#LOWER_INDEX} to {@link Long#MAX_VALUE}.
     * @throws BoundsComparisonException if the {@code lowerBoundIndex} value
     * greater or equal than the {@code upperBoundIndex} value.
     */
    public static boolean isInRange(final long index,
                                    final long lowerBoundIndex,
                                    final long upperBoundIndex) {
        CheckerBoundNumber.checkInRange(lowerBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBoundIndex,
                                               upperBoundIndex);
        return index >= lowerBoundIndex && index < upperBoundIndex;
    }

    /**
     * Check the {@code index} in range from {@code lowerBoundIndex} (inclusive)
     * argument to {@code upperBoundIndex}(exclusive).
     *
     * @param index the index value to check.
     * @param lowerBoundIndex the lower bound value to check index.
     * @param upperBoundIndex the upper bound value to check index.
     *
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link CheckerIndex#LOWER_INDEX} to {@link Long#MAX_VALUE}.
     * @throws BoundsComparisonException if the {@code lowerBoundIndex} value
     * greater or equal than the {@code upperBoundIndex} value.
     * @throws IndexOutOfBoundsException if the {@code index} value out of range
     * from {@code lowerBoundIndex} to {@code upperBoundIndex}.
     */
    public static void checkInRange(final long index,
                                    final long lowerBoundIndex,
                                    final long upperBoundIndex) {
        CheckerBoundNumber.checkInRange(lowerBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundIndex, LOWER_INDEX,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBoundIndex,
                                               upperBoundIndex);
        if (index < lowerBoundIndex || index >= upperBoundIndex) {
            throw new IndexOutOfBoundsException(
                    "Index value out of range(" + lowerBoundIndex + "-"
                    + upperBoundIndex + ")");
        }
    }

}
