package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.utils.BoundCompareException;
import com.lugowoy.helper.utils.BoundOutOfRangeException;

import java.util.Objects;

import static com.lugowoy.helper.utils.BoundOutOfRangeException.*;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.6.6
 */
//todo write doc's
public final class CheckerBound {

    private static final String MSG_BOUND_IS_NULL = "Bound must not be null.";
    private static final String MSG_LOWER_BOUND_IS_NULL = "Lower bound must not be null.";
    private static final String MSG_UPPER_BOUND_IS_NULL = "Upper bound must not be null.";

    private CheckerBound() {
    }

    public static boolean isPositiveBound(final Number bound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        if (bound.doubleValue() > 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NEGATIVE_BOUND);
        }
    }

    public static boolean isNegativeBound(final Number bound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        if (bound.doubleValue() < 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_POSITIVE_BOUND);
        }
    }

    public static boolean isZeroBound(final Number bound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        if (bound.doubleValue() == 0.0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NON_ZERO_BOUND);
        }
    }

    public static boolean isNonZeroBound(final Number bound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        if (bound.doubleValue() != 0.0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_ZERO_BOUND);
        }
    }

    public static boolean isCorrectBound(final Number bound, final Number upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        double boundValue = bound.doubleValue();
        if (boundValue >= 0 && boundValue <= upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound is out of range (0.0 - " + upperBound.doubleValue() + ").");
        }
    }

    public static boolean isCorrectBound(final Number bound, final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(bound, MSG_BOUND_IS_NULL);
        Objects.requireNonNull(bound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(bound, MSG_UPPER_BOUND_IS_NULL);
        double boundValue = bound.doubleValue();
        if (boundValue >= lowerBound.doubleValue() && boundValue <= upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound value is out of range (" + lowerBound.doubleValue()
                                                                       + " - " + upperBound.doubleValue() + ").");
        }
    }

    public static boolean isLowerBoundEqualThanUpperBound(final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() == upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is not equal to upper bound.");
        }
    }

    public static boolean isLowerBoundLessThanUpperBound(final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() < upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater than upper bound.");
        }
    }

    public static boolean isLowerBoundGreaterThanUpperBound(final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() > upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less than upper bound.");
        }
    }

    public static boolean isLowerBoundLessOrEqualThanUpperBound(final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() <= upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater or not equal than upper bound.");
        }
    }

    public static boolean isLowerBoundGreaterOrEqualThanUpperBound(final Number lowerBound, final Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() >= upperBound.doubleValue()) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less or not equal than upper bound.");
        }
    }

}
