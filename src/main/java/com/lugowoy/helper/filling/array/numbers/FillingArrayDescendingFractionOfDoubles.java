package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.storages.arrays.Array;

import static com.lugowoy.helper.filling.DefaultNumericValues.DEFAULT_DOUBLE_VALUE;
import static com.lugowoy.helper.filling.DefaultNumericValues.DOUBLE_ZERO;
import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundGreaterOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with sequential descending decimal digit
 * of numeric data of type {@link Double}.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//todo edit doc's
public class FillingArrayDescendingFractionOfDoubles implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            this.fillArrayDescendingFractionOfDouble(doubles);
            array.setArray(doubles);
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     *
     * @param doubles The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) {
        if (checkLengthInArray(doubles)) {
            this.fillArrayDescendingFractionOfDouble(doubles);
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayDescendingFractionOfDouble(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number, then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}.
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the bound for filling an object of the {@link Array} class with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (isCorrectBounds(bound, Integer.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingFractionOfDoubleFromZeroToNegativeBound(doubles, bound);
                array.setArray(doubles);
            }
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}.
     *
     * @param doubles The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound   The value of the end bound for filling an array with
     *                sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(bound, Integer.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingFractionOfDoubleFromZeroToNegativeBound(doubles, bound);
            }
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0.0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound       The value of the border for filling the array with sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isCorrectBounds(bound, Integer.MIN_VALUE, DOUBLE_ZERO)) {
                this.fillArrayDescendingFractionOfDoubleFromZeroToNegativeBound(doubles, bound);
            }
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data (decreases by "0.1") from the value "lowerBound" to the value of the "upperBound" parameters.
     * If the value of the argument "lowerBound" is less than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#START_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class that must be filled with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param lowerBound The value of the start bound for filling an object of the {@link Array} class with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param upperBound The value of the end bound for filling an object of the {@link Array} class with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingFractionOfDoubleFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    array.setArray(doubles);
                }
            }
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data (decreases by "0.1") from "lowerBound" to the value of the "upperBound" parameter.
     * If the value of the argument "lowerBound" is less than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#START_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND} respectively.
     *
     * @param doubles    The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @param lowerBound The value of the start bound for filling an array with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param upperBound The value of the end bound for filling an array with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingFractionOfDoubleFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data (decreases by "0.1") from the value "lowerBound" to the value of the "upperBound" parameters.
     * If the value of the argument "lowerBound" is less than the value of "upperBound"
     * or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#START_BOUND}
     * and {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @param lowerBound  The value of the start bound for filling an array with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @param upperBound  The value of the end bound for filling an array with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundGreaterOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayDescendingFractionOfDoubleFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillArrayDescendingFractionOfDouble(Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= fractionalDigit;
        }
    }

    private void fillArrayDescendingFractionOfDoubleFromZeroToNegativeBound(Double[] doubles, double bound) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= bound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

    private void fillArrayDescendingFractionOfDoubleFromLowerBoundToUpperBound(Double[] doubles, double lowerBound, double upperBound) {
        double value = lowerBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= upperBound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}
