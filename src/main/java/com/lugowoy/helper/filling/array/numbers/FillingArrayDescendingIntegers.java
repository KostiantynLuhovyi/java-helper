package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.BoundOutOfRangeException;
import com.lugowoy.helper.other.IncorrectBoundCompareException;
import com.lugowoy.helper.other.LengthValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
 * Decrease in the number of type {@link Integer} for filling occurs by the integer part of the number (ex.: 4, 3, 2, ...).
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayDescendingIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayDescendingIntegers(integers);
            array.setArray(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @throws NullPointerException If the {@code integers} array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        if (isNonNullArray(integers)) {
            this.fillArrayDescendingIntegers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayDescendingIntegers(integers);
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
                array.setArray(integers);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs on the integer part of the number by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound The lower value for sequential descending values ​​to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code lowerBound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@code upperBound} to {@code lowerBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound the lower value for sequential descending values to fill.
     * @param upperBound The upper value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is less or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1 to the value {@code lowerBound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@code upperBound} to {@code lowerBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound The lower value for sequential descending values ​​to fill.
     * @param upperBound the upper value for sequential descending values to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is less or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Integer}
     * occurs on the integer part of the number by 1.0 to the value {@code lowerBound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound The lower value for sequential descending values ​​to fill.
     * @param upperBound the upper value for sequential descending values to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is less or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    private void fillArrayDescendingIntegers(Integer[] integers) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value -= integerDigit;
        }
    }

    private void fillArrayDescendingIntegersFromZeroToNegativeBound(Integer[] integers, int bound) {
        int value = 0, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= bound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                break;
            }
        }
    }

    private void fillArrayDescendingIntegersFromLowerBoundToUpperBound(Integer[] integers, int lowerBound, int upperBound) {
        int value = lowerBound, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value >= upperBound) {
                integers[i] = value;
                value -= integerDigit;
            } else {
                break;
            }
        }
    }

}
