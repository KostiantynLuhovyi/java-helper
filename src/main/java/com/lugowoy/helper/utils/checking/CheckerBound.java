package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.utils.BoundCompareException;
import com.lugowoy.helper.utils.BoundIncorrectException;
import com.lugowoy.helper.utils.BoundOutOfRangeException;

import java.util.Objects;

/**
 * The class contains static functionality for checking various boundary numerical values.
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.6.6
 */
public final class CheckerBound {

    /**
     * Description of the exception that bound value is null.
     */
    public static final String MSG_EXCEPTION_BOUND_IS_NULL = "Bound is null.";
    /**
     * Description of the exception that lower bound value is null.
     */
    public static final String MSG_EXCEPTION_LOWER_BOUND_IS_NULL = "Lower bound is null.";
    /**
     * Description of the exception that upper bound value is null.
     */
    public static final String MSG_EXCEPTION_UPPER_BOUND_IS_NULL = "Upper bound is null.";
    /**
     * Description of the exception that bound value is negative.
     */
    public static final String MSG_EXCEPTION_NEGATIVE_BOUND = "Bound is negative";
    /**
     * Description of the exception that bound value is positive.
     */
    public static final String MSG_EXCEPTION_POSITIVE_BOUND = "Bound is positive";
    /**
     * Description of the exception that bound value is nonzero.
     */
    public static final String MSG_EXCEPTION_NONZERO_BOUND = "Bound is nonzero.";
    /**
     * Description of the exception that bound value is zero.
     */
    public static final String MSG_EXCEPTION_ZERO_BOUND = "Bound is zero.";
    /**
     * Description of the exception that the lower bound is not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_NOT_EQUAL_UPPER = "Lower bound is not equal to upper bound.";
    /**
     * Description of the exception that the lower bound is equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_EQUAL_UPPER = "Lower bound is equal to upper bound.";
    /**
     * Description of the exception that the lower bound is greater or equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_GREATER_OR_EQUAL_THAN_UPPER =
            "Lower bound is greater or equal than upper bound.";
    /**
     * Description of the exception that the lower bound is less or equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_LESS_OR_EQUAL_THAN_UPPER =
            "Lower bound is less or equal than upper bound.";
    /**
     * Description of the exception that the lower bound is greater or not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_GREATER_OR_NOT_EQUAL_THAN_UPPER =
            "Lower bound is greater or not equal than upper bound.";
    /**
     * Description of the exception that the lower bound is less or not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_LESS_OR_NOT_EQUAL_THAN_UPPER =
            "Lower bound is less or not equal than upper bound.";

    private CheckerBound() {
    }

    /**
     * Check the numeric value of the {@code bound} argument is positive.
     *
     * @param bound Numeric value to check.
     * @throws NullPointerException    If the numeric value is null.
     * @throws BoundIncorrectException If the numeric value is negative or zero.
     */
    public static void isPositiveBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() < 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NEGATIVE_BOUND);
        }
    }

    /**
     * Check the numeric value of the {@code bound} argument is negative.
     *
     * @param bound Numeric value to check.
     * @throws NullPointerException    If the numeric value is null.
     * @throws BoundIncorrectException If the numeric value is positive or zero.
     */
    public static void isNegativeBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() > 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_POSITIVE_BOUND);
        }
    }

    /**
     * Check the numeric value of the {@code bound} argument is zero.
     *
     * @param bound Numeric value to check.
     * @throws NullPointerException    If the numeric value is null.
     * @throws BoundIncorrectException If the numeric value is nonzero.
     */
    public static void isZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() != 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NONZERO_BOUND);
        }
    }

    /**
     * Check the numeric value of the {@code bound} argument is nonzero.
     *
     * @param bound Numeric value to check.
     * @throws NullPointerException    If the numeric value is null.
     * @throws BoundIncorrectException If the numeric value is zero.
     */
    public static void isNonZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() == 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_ZERO_BOUND);
        }
    }

    /**
     * Check that the numeric value of the {@code bound} argument is in range from {@literal 0.0}
     * to {@code upperBound} argument value.
     *
     * @param bound      Numeric value to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException     If any of the arguments is null.
     * @throws BoundOutOfRangeException If a numerical value is out of range from {@literal 0.0} to {@code upperBound}.
     */
    public static void isCorrectBound(Number bound, Number upperBound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        double boundValue = bound.doubleValue();
        if (boundValue < 0 || boundValue > upperBound.doubleValue()) {
            throw new BoundOutOfRangeException("Bound is out of range (0.0 - " + upperBound.doubleValue() + ").");
        }
    }

    /**
     * Check that the numeric value of the {@code bound} argument is in range from {@code lowerBound}
     * to {@code upperBound} argument value.
     *
     * @param bound      Numeric value to check.
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException     If any of the arguments is null.
     * @throws BoundOutOfRangeException If a numerical value is out of range from {@code lowerBound} to {@code upperBound},
     */
    public static void isCorrectBound(Number bound, Number lowerBound, Number upperBound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        double boundValue = bound.doubleValue();
        if (boundValue < lowerBound.doubleValue() || boundValue > upperBound.doubleValue()) {
            throw new BoundOutOfRangeException("Bound value is out of range (" + lowerBound.doubleValue()
                    + " - " + upperBound.doubleValue() + ").");
        }
    }

    /**
     * Check that the numeric values of {@code lowerBound} and {@code upperBound} arguments are equal.
     *
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException  If any of the arguments is null.
     * @throws BoundCompareException If the numeric values of the method arguments are not equal.
     */
    public static void isLowerBoundEqualThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() != upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_NOT_EQUAL_UPPER);
        }
    }

    public static void isLowerBoundNotEqualThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() == upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_EQUAL_UPPER);
        }
    }

    /**
     * Check that the numeric values of {@code lowerBound} less than {@code upperBound}.
     *
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException  If any of the arguments is null.
     * @throws BoundCompareException If the numeric values of {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public static void isLowerBoundLessThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() >= upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_GREATER_OR_EQUAL_THAN_UPPER);
        }
    }

    /**
     * Check that the numeric values of {@code lowerBound} greater than {@code upperBound}.
     *
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException  If any of the arguments is null.
     * @throws BoundCompareException If the numeric values of {@code lowerBound} less or equal than {@code upperBound}.
     */
    public static void isLowerBoundGreaterThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() <= upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_LESS_OR_EQUAL_THAN_UPPER);
        }
    }

    /**
     * Check that the numeric values of {@code lowerBound} less or equal than {@code upperBound}.
     *
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException  If any of the arguments is null.
     * @throws BoundCompareException If the numeric values of {@code lowerBound} greater than {@code upperBound}.
     */
    public static void isLowerBoundLessOrEqualThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() > upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_GREATER_OR_NOT_EQUAL_THAN_UPPER);
        }
    }

    /**
     * Check that the numeric values of {@code lowerBound} greater or equal than {@code upperBound}.
     *
     * @param lowerBound Numeric value of the lower bound to check.
     * @param upperBound Numeric value of the upper bound to check.
     * @throws NullPointerException  If any of the arguments is null.
     * @throws BoundCompareException If the numeric values of {@code lowerBound} less than {@code upperBound}.
     */
    public static void isLowerBoundGreaterOrEqualThanUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() < upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_LESS_OR_NOT_EQUAL_THAN_UPPER);
        }
    }

}
