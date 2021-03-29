package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.IndicesComparisonException;

/**
 * This class contains static functionality for checking the index value for
 * correctness.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 1.6.6
 */
//TODO review documentation
public final class CheckerIndex {

    private static final long LOWER_INDEX = 0;

    private CheckerIndex() {
    }

    /**
     * Check the {@code index} in range from {@link CheckerIndex#LOWER_INDEX}
     * (inclusive) to {@code upperBoundIndex} (exclusive).
     *
     * @param index the index value to check.
     * @param upperBoundIndex the upper bound value to check index.
     * @return result of checking.
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
     * Check the {@code index} in range from {@code lowerBoundIndex} (inclusive)
     * argument to {@code upperBoundIndex} (exclusive).
     *
     * @param index the index value to check.
     * @param lowerBoundIndex the lower bound value to check index.
     * @param upperBoundIndex the upper bound value to check index.
     * @return result of checking.
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
     * Check the {@code index} in range from {@link CheckerIndex#LOWER_INDEX}
     * (inclusive) to {@code upperBoundIndex} (exclusive).
     *
     * @param index the index value to check.
     * @param upperBoundIndex the upper bound value to check index.
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
                    "Index value " + index + " out of range from "
                    + CheckerIndex.LOWER_INDEX + "(inclusive) to "
                    + upperBoundIndex + "(exclusive)");
        }
    }

    /**
     * Check the {@code index} in range from {@code lowerBoundIndex} (inclusive)
     * argument to {@code upperBoundIndex} (exclusive).
     *
     * @param index the index value to check.
     * @param lowerBoundIndex the lower bound value to check index.
     * @param upperBoundIndex the upper bound value to check index.
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
                    "Index value " + index + " out of range from "
                    + lowerBoundIndex + "(inclusive) to " + upperBoundIndex
                    + "(exclusive)");
        }
    }

    public static boolean isLowerEqualUpper(final int lowerIndex,
                                            final int upperIndex) {
        return CheckerBoundNumber.isLowerEqualUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerEqualUpper(final int lowerIndex,
                                            final int upperIndex) {
        if (!CheckerBoundNumber.isLowerEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index is not equal to upper index");
        }
    }

    public static boolean isLowerNotEqualUpper(final int lowerIndex,
                                               final int upperIndex) {
        return CheckerBoundNumber.isLowerNotEqualUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerNotEqualUpper(final int lowerIndex,
                                               final int upperIndex) {
        if (!CheckerBoundNumber.isLowerNotEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index is equal to upper index");
        }
    }

    public static boolean isLowerLessUpper(final int lowerIndex,
                                           final int upperIndex) {
        return CheckerBoundNumber.isLowerLessUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerLessUpper(final int lowerIndex,
                                           final int upperIndex) {
        if (!CheckerBoundNumber.isLowerLessUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index less than upper index");
        }
    }

    public static boolean isLowerGreaterUpper(final int lowerIndex,
                                              final int upperIndex) {
        return CheckerBoundNumber.isLowerGreaterUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerGreaterUpper(final int lowerIndex,
                                              final int upperIndex) {
        if (!CheckerBoundNumber.isLowerGreaterUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index greater than upper index");
        }
    }

    public static boolean isLowerLessOrEqualUpper(final int lowerIndex,
                                                  final int upperIndex) {
        return CheckerBoundNumber.isLowerLessOrEqualUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerLessOrEqualUpper(final int lowerIndex,
                                                  final int upperIndex) {
        if (!CheckerBoundNumber.isLowerLessOrEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index greater or not equal upper bound");
        }
    }

    public static boolean isLowerGreaterOrEqualUpper(final int lowerIndex,
                                                     final int upperIndex) {
        return CheckerBoundNumber.isLowerGreaterOrEqualUpper(lowerIndex,
                                                             upperIndex);
    }

    public static void checkLowerGreaterOrEqualUpper(final int lowerIndex,
                                                     final int upperIndex) {
        if (!CheckerBoundNumber.isLowerGreaterOrEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index less or not equal upper bound");
        }
    }

    public static boolean isLowerLessOrNotEqualUpper(final int lowerIndex,
                                                     final int upperIndex) {
        return CheckerBoundNumber.isLowerLessOrNotEqualUpper(lowerIndex, upperIndex);
    }

    public static void checkLowerLessOrNotEqualUpper(final int lowerIndex,
                                                     final int upperIndex) {
        if (!CheckerBoundNumber.isLowerLessOrNotEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index greater or equal upper index");
        }
    }

    public static boolean isLowerGreaterOrNotEqualUpper(final int lowerIndex,
                                                        final int upperIndex) {
        return CheckerBoundNumber.isLowerGreaterOrNotEqualUpper(lowerIndex,
                                                                upperIndex);
    }

    public static void checkLowerGreaterOrNotEqualUpper(final int lowerIndex,
                                                        final int upperIndex) {
        if (!CheckerBoundNumber.isLowerGreaterOrNotEqualUpper(lowerIndex, upperIndex)) {
            throw new IndicesComparisonException(
                    "The lower index less or equal upper index");
        }
    }

}
