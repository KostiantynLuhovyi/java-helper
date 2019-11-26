package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_ZERO;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
 * Decrease in the number of type {@link Integer} for filling occurs by the integer part of the number (ex.: 4, 3, 2, ...).
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//todo edit doc's
public class FillingArrayDescendingIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            this.fillArrayDescendingIntegers(integers);
            array.setArray(integers);
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @throws NullPointerException If the {@code integers} array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        if (CheckerArray.checkLengthInArray(integers)) {
            this.fillArrayDescendingIntegers(integers);
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 (ex.: 0, -1, -2, ...).
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers = new Integer[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayDescendingIntegers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link ValuesToFilling#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (CheckerBound.isCorrectBound(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
                array.setArray(integers);
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs on the integer part of the number by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link ValuesToFilling#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound    The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (CheckerArray.checkLengthInArray(integers)) {
            if (CheckerBound.isCorrectBound(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>Filling begins with a value of {@link ValuesToFilling#INT_ZERO} (inclusive)
     * and an decrease in the number of type {@link Integer} occurs by 1 to the value {@code bound} argument (inclusive) (ex.: 0, -1, -2, ...).
     * If the range of values from {@link ValuesToFilling#INT_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param bound       The lower value for sequential descending values ​​to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws BoundOutOfRangeException       If the {@code bound} argument value is out of valid range.
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers = new Integer[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (CheckerBound.isCorrectBound(bound, Integer.MIN_VALUE, INT_ZERO)) {
                this.fillArrayDescendingIntegersFromZeroToNegativeBound(integers, bound);
            }
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
     * @param array      The object of the {@link Array} class to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound the lower value for sequential descending values to fill.
     * @param upperBound The upper value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                }
            }
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
     * @param integers   The array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound The lower value for sequential descending values ​​to fill.
     * @param upperBound the upper value for sequential descending values to fill.
     * @throws NullPointerException     If the {@code integers} argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (CheckerArray.checkLengthInArray(integers)) {
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Integer} in descending order.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Integer}
     * occurs on the integer part of the number by 1.0 to the value {@code lowerBound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Integer} in descending order.
     * @param lowerBound  The lower value for sequential descending values ​​to fill.
     * @param upperBound  the upper value for sequential descending values to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Integer} in descending order.
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers = new Integer[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
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
