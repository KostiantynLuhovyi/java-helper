package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.Array;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH_ARRAY;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with sequential descending decimal digit
 * of numeric data of type {@link Double}.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArraySequentialDescendingDecimalDigitOfDoubleNumbers implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbers(doubles);
            array.setArray(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     *
     * @param doubles The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) throws IllegalArgumentException {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbers(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential descending of numeric data of type {@link Double}.
     * Filling starts at "0.0" and decreases by "0.1".
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthOfArray The length(size) of the array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthOfArray) {
        Double[] doubles;
        if (checkLengthArray(lengthOfArray)) {
            doubles = new Double[lengthOfArray];
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbers(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbers(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number, then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}.
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the bound for filling an object of the {@link Array} class with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isNegativeBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles, bound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles, DEFAULT_DOUBLE_NEGATIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}.
     *
     * @param doubles The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the end bound for filling an array with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isNegativeBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles, bound);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles,
                                                                                                                   DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0.0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from "0.0" (decreases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a positive number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}.
     *
     * @param lengthOfArray The length(size) of the array to be filled with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the border for filling the array with sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthOfArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthOfArray)) {
            doubles = new Double[lengthOfArray];
            if (isNegativeBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles, bound);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles,
                                                                                                                   DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(doubles,
                                                                                                               DEFAULT_DOUBLE_NEGATIVE_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data (decreases by "0.1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is less than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND} respectively.
     *
     * @param array The object of the {@link Array} class that must be filled with
     *              sequential descending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class with
     *                 sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    startBound,
                                                                                                                    endBound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    DEFAULT_START_BOUND,
                                                                                                                    DEFAULT_DOUBLE_NEGATIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data (decreases by "0.1") from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is less than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND} respectively.
     *
     * @param doubles The array to be filled with sequential descending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an array with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an array with
     *                 sequential descending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double startBound, Double endBound) {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    startBound,
                                                                                                                    endBound);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    DEFAULT_START_BOUND,
                                                                                                                    DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential descending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data (decreases by "0.1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is less than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND} respectively.
     *
     * @param lengthOfArray The length(size) of the array to be filled with
     *                    sequential descending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an array with
     *                   sequential descending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an array with
     *                 sequential descending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential descending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthOfArray, Double startBound, Double endBound) {
        Double[] doubles;
        if (checkLengthArray(lengthOfArray)) {
            doubles = new Double[lengthOfArray];
            if (isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    startBound,
                                                                                                                    endBound);
            } else {
                this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                    DEFAULT_START_BOUND,
                                                                                                                    DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                DEFAULT_START_BOUND,
                                                                                                                DEFAULT_DOUBLE_NEGATIVE_BOUND);
        }
        return doubles;
    }

    private void fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbers(Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= fractionalDigit;
        }
    }

    private void fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromZeroToNegativeBound(Double[] doubles,
                                                                                                         double bound) {
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

    private void fillArrayElementsSequentialDescendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(Double[] doubles,
                                                                                                          double startBound,
                                                                                                          double endBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= endBound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}