package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;
import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
 * Increase in the number of type {@link Integer} for filling occurs by the integer part of the number (ex.: 1, 2, 3, 4, ...).
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//todo edit doc's
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
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            this.fillArrayAscendingIntegers(integers);
            array.setArray(integers);
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
        if (checkLengthInArray(integers)) {
            this.fillArrayAscendingIntegers(integers);
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
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayAscendingIntegers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in ascending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#INT_ZERO} (inclusive)
     * and an increase in the number of type {@link Integer} occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 1, 2, 3, ...).
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
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            }
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
     * @param bound    The upper value for sequential ascending values ​​to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (checkLengthInArray(integers)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
            }
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
     * @param bound       The upper value for sequential ascending values ​​to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in ascending order.
     * @throws BoundOutOfRangeException       If the {@code bound} argument value is out of valid range.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayAscendingIntegersFromZeroToPositiveBound(integers, bound);
            }
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
     * @param array      The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param lowerBound The lower value for sequential ascending values ​​to fill.
     * @param upperBound the upper value for sequential ascending values to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                }
            }
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
     * @param integers   The array to fill with sequential numeric data of type {@link Integer} in ascending order.
     * @param lowerBound The lower value for sequential ascending values ​​to fill.
     * @param upperBound the upper value for sequential ascending values to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (checkLengthInArray(integers)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
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
     * @param lowerBound  The lower value for sequential ascending values ​​to fill.
     * @param upperBound  the upper value for sequential ascending values to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in ascending order.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayAscendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
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
