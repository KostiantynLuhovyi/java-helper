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
 * @version 1.7
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
     * Description of the exception that the lower bound not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_NOT_EQUAL_UPPER = "Lower bound not equal to upper bound.";
    /**
     * Description of the exception that the lower bound equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_EQUAL_UPPER = "Lower bound equal to upper bound.";
    /**
     * Description of the exception that the lower bound greater or equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_GREATER_OR_EQUAL_UPPER = "Lower bound greater or equal upper bound.";
    /**
     * Description of the exception that the lower bound less or equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_LESS_OR_EQUAL_UPPER = "Lower bound less or equal upper bound.";
    /**
     * Description of the exception that the lower bound greater or not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_GREATER_OR_NOT_EQUAL_UPPER = "Lower bound greater or not equal upper bound.";
    /**
     * Description of the exception that the lower bound less or not equal to the upper bound.
     */
    public static final String MSG_EXCEPTION_LOWER_LESS_OR_NOT_EQUAL_UPPER = "Lower bound less or not equal upper bound.";

    private CheckerBound() {
    }

    /**
     * Check the {@code bound} is positive.
     *
     * @param bound the bound value to check.
     * @throws NullPointerException    if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} negative or zero.
     */
    public static void isPositiveBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() < 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NEGATIVE_BOUND);
        }
    }

    /**
     * Check the {@code bound} is negative.
     *
     * @param bound the bound value to check.
     * @throws NullPointerException    if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} positive or zero.
     */
    public static void isNegativeBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() > 0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_POSITIVE_BOUND);
        }
    }

    /**
     * Check the {@code bound} is zero.
     *
     * @param bound the bound value to check.
     * @throws NullPointerException    if the {@code bound} null.
     * @throws BoundIncorrectException if the {@code bound} nonzero.
     */
    public static void isZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() != 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_NONZERO_BOUND);
        }
    }

    /**
     * Check the {@code bound} is nonzero.
     *
     * @param bound the bound value to check.
     * @throws NullPointerException    if the {@code bound} null.
     * @throws BoundIncorrectException If the {@code bound} zero.
     */
    public static void isNonZeroBound(Number bound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        if (bound.doubleValue() == 0.0) {
            throw new BoundIncorrectException(MSG_EXCEPTION_ZERO_BOUND);
        }
    }

    /**
     * Check the {@code bound} in range from {@literal 0.0} to {@code upperBound}.
     *
     * @param bound      the bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException     if any of the arguments null.
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@literal 0.0} to {@code upperBound}.
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
     * Check the {@code bound} in range from {@code lowerBound} to {@code upperBound}.
     *
     * @param bound      the bound value to check.
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException     if any of the arguments null.
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@code lowerBound} to {@code upperBound}.
     */
    public static void isCorrectBound(Number bound, Number lowerBound, Number upperBound) {
        Objects.requireNonNull(bound, MSG_EXCEPTION_BOUND_IS_NULL);
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        double boundValue = bound.doubleValue();
        if (boundValue < lowerBound.doubleValue() || boundValue > upperBound.doubleValue()) {
            throw new BoundOutOfRangeException("Bound value out of range (" + lowerBound.doubleValue()
                                                                    + " - " + upperBound.doubleValue() + ").");
        }
    }

    /**
     * Check {@code lowerBound} and {@code upperBound} equal.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException  if any of the arguments null.
     * @throws BoundCompareException if {@code lowerBound} not equal {@code upperBound}.
     */
    public static void isLowerBoundEqualUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() != upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_NOT_EQUAL_UPPER);
        }
    }

    /**
    * Check {@code lowerBound} and {@code upperBound} not equal.
    *
    * @param lowerBound the lower bound value to check.
    * @param upperBound the upper bound value to check.
    * @throws NullPointerException if any of the arguments null.
    * @throws BoundCompareException if {@code lowerBound} equal {@code upperBound}.
    */
    public static void isLowerBoundNotEqualUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() == upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_EQUAL_UPPER);
        }
    }

    /**
     * Check {@code lowerBound} less than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException  if any of the arguments null.
     * @throws BoundCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public static void isLowerBoundLessUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() >= upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_GREATER_OR_EQUAL_UPPER);
        }
    }

    /**
     * Check {@code lowerBound} greater than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException  if any of the arguments null.
     * @throws BoundCompareException if {@code lowerBound} less or equal than {@code upperBound}.
     */
    public static void isLowerBoundGreaterUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() <= upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_LESS_OR_EQUAL_UPPER);
        }
    }

    /**
     * Check {@code lowerBound} less or equal than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException  if any of the arguments null.
     * @throws BoundCompareException if {@code lowerBound} greater than {@code upperBound}.
     */
    public static void isLowerBoundLessOrEqualUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() > upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_GREATER_OR_NOT_EQUAL_UPPER);
        }
    }

    /**
     * Check {@code lowerBound} greater or equal than {@code upperBound}.
     *
     * @param lowerBound the lower bound value to check.
     * @param upperBound the upper bound value to check.
     * @throws NullPointerException  if any of the arguments null.
     * @throws BoundCompareException if {@code lowerBound} less than {@code upperBound}.
     */
    public static void isLowerBoundGreaterOrEqualUpperBound(Number lowerBound, Number upperBound) {
        Objects.requireNonNull(lowerBound, MSG_EXCEPTION_LOWER_BOUND_IS_NULL);
        Objects.requireNonNull(upperBound, MSG_EXCEPTION_UPPER_BOUND_IS_NULL);
        if (lowerBound.doubleValue() < upperBound.doubleValue()) {
            throw new BoundCompareException(MSG_EXCEPTION_LOWER_LESS_OR_NOT_EQUAL_UPPER);
        }
    }

}
