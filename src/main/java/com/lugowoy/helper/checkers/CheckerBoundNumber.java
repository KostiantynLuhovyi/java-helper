package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.ComparatorNumber;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class provides functionality for checking various boundary numerical
 * values.
 * <p>
 * Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 2.7
 * @since 1.6.6
 */
//TODO review documentation
public final class CheckerBoundNumber {

    /**
     * An exception message indicating that the boundary value is null.
     */
    private static final String MSG_BOUND_IS_NULL = "Bound is null";
    /**
     * An exception message indicating that the lower boundary value is null.
     */
    private static final String MSG_LOWER_BOUND_IS_NULL = "Lower bound is null";
    /**
     * An exception message indicating that the upper boundary value is null.
     */
    private static final String MSG_UPPER_BOUND_IS_NULL = "Upper bound is null";
    /**
     * An exception message indicating that the lower bound value is equal to
     * the upper bound value.
     */
    private static final String MSG_LOWER_BOUND_EQUAL_TO_UPPER_BOUND =
            "Lower bound equal to upper bound";
    /**
     * An exception message indicating that the lower bound value is not equal
     * to the upper bound value.
     */
    private static final String MSG_LOWER_BOUND_NOT_EQUAL_TO_UPPER_BOUND =
            "Lower bound not equal to upper bound";
    /**
     * An exception message indicating that the lower bound value is less than
     * or equal to the upper bound value.
     */
    private static final String MSG_LOWER_BOUND_LESS_OR_EQUAL_UPPER_BOUND =
            "Lower bound less or equal upper bound";
    /**
     * An exception message indicating that the lower bound value is greater
     * than or equal to the upper bound value.
     */
    private static final String MSG_LOWER_BOUND_GREATER_OR_EQUAL_UPPER_BOUND =
            "Lower bound greater or equal upper bound";
    /**
     * An exception message indicating that the lower bound value is less than
     * or not equal to the upper bound value.
     */
    private static final String MSG_LOWER_BOUND_LESS_OR_NOT_EQUAL_UPPER_BOUND =
            "Lower bound less or not equal upper bound";
    /**
     * An exception message indicating that the lower bound value is greater
     * than or not equal to the upper bound value.
     */
    private static final String
            MSG_LOWER_BOUND_GREATER_OR_NOT_EQUAL_UPPER_BOUND =
            "Lower bound greater or not equal upper bound";

    private static final Number ZERO = 0.0;

    private CheckerBoundNumber() {
    }

    /**
     * Checks that the {@code bound} value in range from 0 (inclusive) to {@code
     * upperBound}(inclusive) value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting
    public static <T extends Number & Comparable<T>> boolean isInRange(
            @NotNull final T bound, @NotNull final T upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(bound, (T) ZERO) >= 0 && compare(bound, upperBound) <= 0;
    }

    /**
     * Checks that the {@code bound} value in range from 0 (inclusive) to {@code
     * upperBound}(inclusive) value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@literal 0} to {@code upperBound} value.
     */
    @SuppressWarnings("unchecked") //Type safety when casting
    public static <T extends Number & Comparable<T>> void checkInRange(
            @NotNull final T bound, @NotNull final T upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(bound, (T) ZERO) < 0 || compare(bound, upperBound) > 0) {
            throw new BoundOutOfRangeException(
                    getExceptionMessage((T) ZERO, upperBound));
        }
    }

    /**
     * Checks that the {@code bound} value in range from {@code lowerBound}
     * (inclusive) value to {@code upperBound}(inclusive) value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isInRange(
            @NotNull final T bound, @NotNull final T lowerBound,
            @NotNull final T upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(bound, lowerBound) >= 0 && compare(bound, upperBound) <= 0;
    }

    /**
     * Checks that the {@code bound} value in range from {@code lowerBound}
     * (inclusive) value to {@code upperBound}(inclusive) value.
     *
     * @param <T> the type of the boundary values.
     * @param bound the bound value to check.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@code lowerBound} to {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkInRange(
            @NotNull final T bound, @NotNull final T lowerBound,
            @NotNull final T upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(bound, lowerBound) < 0 || compare(bound, upperBound) > 0) {
            throw new BoundOutOfRangeException(
                    getExceptionMessage(lowerBound, upperBound));
        }
    }

    /**
     * Checks that the {@code lowerBound} value and the {@code upperBound} value
     * is equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) == 0;
    }

    /**
     * Checks that the {@code lowerBound} value and the {@code upperBound} value
     * is equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value is not
     * equal the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) != 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_NOT_EQUAL_TO_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value and the {@code upperBound} value
     * is not equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) != 0;
    }

    /**
     * Check that the {@code lowerBound} value and the {@code upperBound} value
     * is not equal.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value is
     * equal the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) == 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_EQUAL_TO_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value less than the {@code upperBound}
     * value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerLessUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) < 0;
    }

    /**
     * Check that the {@code lowerBound} value less than the {@code upperBound}
     * value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value greater
     * or equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerLessUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) >= 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_GREATER_OR_EQUAL_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value greater than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerGreaterUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) > 0;
    }

    /**
     * Check that the {@code lowerBound} value greater than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value less or
     * equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerGreaterUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) <= 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_LESS_OR_EQUAL_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value less or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerLessOrEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) <= 0;
    }

    /**
     * Check that the {@code lowerBound} value less or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value greater
     * or not equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerLessOrEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) > 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_GREATER_OR_NOT_EQUAL_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value greater or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerGreaterOrEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) >= 0;
    }

    /**
     * Check that the {@code lowerBound} value greater or equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value less or
     * not equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerGreaterOrEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) < 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_LESS_OR_NOT_EQUAL_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value less or not equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerLessOrNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) < 0;
    }

    /**
     * Check that the {@code lowerBound} value less or not equal than the {@code
     * upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value greater
     * or equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerLessOrNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) >= 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_GREATER_OR_EQUAL_UPPER_BOUND);
        }
    }

    /**
     * Check that the {@code lowerBound} value greater or not equal than the
     * {@code upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @return result of checking.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     */
    public static <T extends Number & Comparable<T>> boolean isLowerGreaterOrNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        return compare(lowerBound, upperBound) > 0;
    }

    /**
     * Check that the {@code lowerBound} value greater or not equal than the
     * {@code upperBound} value.
     *
     * @param <T> the type of the boundary values.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException if any of the boundary values is {@code
     * null}.
     * @throws BoundsComparisonException if the {@code lowerBound} value less or
     * equal than the {@code upperBound} value.
     */
    public static <T extends Number & Comparable<T>> void checkLowerGreaterOrNotEqualUpper(
            @NotNull final T lowerBound, @NotNull final T upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (compare(lowerBound, upperBound) <= 0) {
            throw new BoundsComparisonException(
                    MSG_LOWER_BOUND_LESS_OR_EQUAL_UPPER_BOUND);
        }
    }

    private static <T extends Number & Comparable<T>> int compare(
            final T valueFirst, final T valueSecond) {
        ComparatorNumber comparator = ComparatorNumber::compareNumber;
        return comparator.compare(valueFirst, valueSecond);
    }

    private static <T extends Number & Comparable<T>> String getExceptionMessage(
            final T lowerBound, final T upperBound) {
        return "Bound value out of range (" + lowerBound + "-" + upperBound + ")";
    }

}
