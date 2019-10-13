package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.BoundOutOfRangeException;
import com.lugowoy.helper.other.IncorrectBoundCompareException;
import com.lugowoy.helper.other.LengthValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
 * An increase in the number of type {@link Integer} for filling occurs by the integer part of the number (ex.: 1, 2, 3, 4, ...).
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konsatantin Lugowoy
 * @version 1.7
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayAscendingIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an increase in the number of type {@link Integer} occurs by 1 (ex.: 1, 2, 3, ...).
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayAscendingIntegers(integers);
            array.setArray(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an increase in the number of type {@link Integer} occurs by 1 (ex.: 1, 2, 3, ...).
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @throws NullPointerException If the {@code integers} array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        if (isNonNullArray(integers)) {
            this.fillArrayAscendingIntegers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an increase in the number of type {@link Integer} occurs by 1 (ex.: 1, 2, 3, ...).
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in ascending order.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayAscendingIntegers(integers);
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive) and an increase in the number of type {@link Integer}
     * occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MAX_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param bound The upper value for sequential ascending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive) and an increase in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code bound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MAX_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param bound The upper value for sequential ascending values ​​to fill.
     * @throws NullPointerException If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive) and an increase in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code bound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@link DefaultNumericValues#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#INT_ZERO} to {@link Integer#MAX_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param bound The upper value for sequential ascending values ​​to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in ascending order.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
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
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@code lowerBound} argument (inclusive) and an increase in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code upperBound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param lowerBound The lower value for sequential ascending values ​​to fill.
     * @param upperBound the upper value for sequential ascending values to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@code lowerBound} argument (inclusive) and an increase in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code upperBound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param lowerBound The lower value for sequential ascending values ​​to fill.
     * @param upperBound the upper value for sequential ascending values to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in ascending order.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>Filling begins with a value of {@code lowerBound} argument (inclusive) and an increase in the number of type {@link Integer}
     * occurs on the integer part of the number by 1 to the value {@code upperBound} argument (inclusive) (ex.: 1, 2, 3, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param lowerBound The lower value for sequential ascending values ​​to fill.
     * @param upperBound the upper value for sequential ascending values to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in ascending order.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
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

    private void fillArrayAscendingIntegers(Integer[] integers) {
        int value = INT_ZERO, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            integers[i] = value;
            value += integerDigit;
        }
    }

    private void fillArrayAscendingIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        int value = INT_ZERO, integerDigit = 1;
        for (int i = 0; i < integers.length; i++) {
            if (value <= bound) {
                integers[i] = value;
                value += integerDigit;
            } else {
                break;
            }
        }
    }

    private void fillArrayAscendingIntegersFromLowerBoundToUpperBound(Integer[] integers, int lowerBound, int upperBound) {
        int value = lowerBound;
        for (int i = 0; i < integers.length; i++) {
            if (value <= upperBound) {
                integers[i] = value++;
            } else {
                break;
            }
        }
    }

}
