package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.DefaultNumericValues.DOUBLE_ZERO;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with sequential numeric data of type {@link Double} in descending order.
 * Decrease in the number of type {@link Double} for filling occurs by the integer part of the number (ex.: 4.3, 3.3, 2.3, ...).
 * <p>Created by Konstantin Lugowoy on 13-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//todo edit doc's
public class FillingArrayDescendingDoubles implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive)
     * and an decrease in the number of type {@link Double} occurs on the integer part of the number by 1.0 (ex.: 0.0, -1.0, -2.0, ...).
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Double} in descending order.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Double> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            this.fillArrayDescendingDoubles(doubles);
            array.setArray(doubles);
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive)
     * and an decrease in the number of type {@link Double} occurs on the integer part of the number by 1.0 (ex.: 0.0, -1.0, -2.0, ...).
     *
     * @param doubles The array to fill with sequential numeric data of type {@link Double} in descending order.
     * @throws NullPointerException If the {@code doubles} array argument is null.
     */
    @Override
    public void fill(Double[] doubles) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            this.fillArrayDescendingDoubles(doubles);
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive)
     * and an decrease in the number of type {@link Double} occurs on the integer part of the number by 1.0 (ex.: 0.0, -1.0, -2.0, ...).
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Double} in descending order.
     * @return Created and filled an array with sequential numeric data of type {@link Double} in descending order.
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayDescendingDoubles(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code bound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@link DefaultNumericValues#DOUBLE_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#DOUBLE_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with sequential numeric data of type {@link Double} in descending order.
     * @param bound The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (CheckerBound.isCorrectBound(bound, Long.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingDoublesFromZeroToNegativeBound(doubles, bound);
                array.setArray(doubles);
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code bound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@link DefaultNumericValues#DOUBLE_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#DOUBLE_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles The array to fill with sequential numeric data of type {@link Double} in descending order.
     * @param bound   The lower value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the {@code doubles} argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            if (CheckerBound.isCorrectBound(bound, Long.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingDoublesFromZeroToNegativeBound(doubles, bound);
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@link DefaultNumericValues#DOUBLE_ZERO} (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code bound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@link DefaultNumericValues#DOUBLE_ZERO} to {@code bound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the argument {@code bound} must be in the range from {@link DefaultNumericValues#DOUBLE_ZERO} to {@link Integer#MIN_VALUE},
     * otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Double} in descending order.
     * @param bound       The lower value for sequential descending values ​​to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Double} in descending order.
     * @throws BoundOutOfRangeException       If the {@code bound} argument value is out of valid range.
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (CheckerBound.isCorrectBound(bound, Long.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingDoublesFromZeroToNegativeBound(doubles, bound);
            }
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code lowerBound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@code upperBound} to {@code lowerBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array      The object of the {@link Array} class to fill with sequential numeric data of type {@link Double} in descending order.
     * @param lowerBound the lower value for sequential descending values to fill.
     * @param upperBound The upper value for sequential descending values ​​to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingDoublesFromLowerBoundToUpperBound(doubles, lowerBound, lowerBound);
                }
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code lowerBound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@code upperBound} to {@code lowerBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles    The array to fill with sequential numeric data of type {@link Double} in descending order.
     * @param lowerBound The lower value for sequential descending values ​​to fill.
     * @param upperBound the upper value for sequential descending values to fill.
     * @throws NullPointerException     If the {@code doubles} argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with sequential numeric data of type {@link Double} in descending order.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>Filling begins with a value of {@code upperBound} argument (inclusive) and an decrease in the number of type {@link Double}
     * occurs on the integer part of the number by 1.0 to the value {@code lowerBound} argument (inclusive) (ex.: 0.0, -1.0, -2.0, ...).
     * If the range of values from {@code lowerBound} to {@code upperBound} is not enough to fill the entire array,
     * then elements of which are enough to fill, and the rest remain the same.
     * The value of the {@code upperBound} and {@code lowerBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise an {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with sequential numeric data of type {@link Double} in descending order.
     * @param lowerBound  The lower value for sequential descending values ​​to fill.
     * @param upperBound  the upper value for sequential descending values to fill.
     * @return Created and filled an array with sequential numeric data of type {@link Double} in descending order.
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} or {@code upperBound} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} value is less or not equal than to the {@code upperBound} value.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillArrayDescendingDoubles(Double[] doubles) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= integerDigit;
        }
    }

    private void fillArrayDescendingDoublesFromZeroToNegativeBound(Double[] doubles, double bound) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= bound) {
                doubles[i] = value;
                value -= integerDigit;
            } else {
                break;
            }
        }
    }

    private void fillArrayDescendingDoublesFromLowerBoundToUpperBound(Double[] doubles, double lowerBound, double upperBound) {
        double value = lowerBound, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= upperBound) {
                doubles[i] = value;
                value -= integerDigit;
            } else {
                break;
            }
        }
    }

}
