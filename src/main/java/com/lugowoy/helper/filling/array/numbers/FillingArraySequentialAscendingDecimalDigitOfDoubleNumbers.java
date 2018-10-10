package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 *
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with sequential ascending decimal digit
 * of numeric data of type {@link Double}.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArraySequentialAscendingDecimalDigitOfDoubleNumbers implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with sequential ascending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and increases by "0.1".
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbers(doubles);
            array.setArray(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and increases by "0.1".
     *
     * @param doubles The array to be filled with sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) throws IllegalArgumentException {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbers(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * Filling starts at "0.0" and increases by "0.1".
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled with sequential ascending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbers(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbers(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data from "0.0" (increases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number, then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param array The object of the {@link Array} class to be filled with
     *              sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the bound for filling an object of the {@link Array} class with
     *              sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles,
                                                                                                                  DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data from "0.0" (increases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param doubles The array to be filled with sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the end bound for filling an array with
     *              sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles,
                                                                                                                  DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from "0" (increases by "0.1") to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with
     *                    sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param bound The value of the border for filling the array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential ascending integer part of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles,
                                                                                                                  DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(doubles,
                                                                                                              DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data (increases by "0.1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param array The object of the {@link Array} class that must be filled with
     *              sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class with
     *                   sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class with
     *                 sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException{
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))){
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                   startBound,
                                                                                                                   endBound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                   DEFAULT_START_BOUND,
                                                                                                                   DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The array is filled with numeric data (increases by "0.1") from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param doubles The array to be filled with
     *                sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an array with
     *                   sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an array with
     *                 sequential ascending decimal digit of numeric data of type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                   startBound,
                                                                                                                   endBound);
            } else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                   DEFAULT_START_BOUND,
                                                                                                                   DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with sequential ascending decimal digit of numeric data of type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data (increases by "0.1") from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#DEFAULT_START_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with
     *                    sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param startBound The value of the start bound for filling an array with
     *                   sequential ascending decimal digit of numeric data of type {@link Double}.
     * @param endBound The value of the end bound for filling an array with
     *                 sequential ascending decimal digit of numeric data of type {@link Double}.
     * @return Created and filled an array with sequential ascending integer part of numeric data of type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            }  else {
                this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                                   DEFAULT_START_BOUND,
                                                                                                                   DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                                               DEFAULT_START_BOUND,
                                                                                                               DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    private void fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbers(Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value += fractionalDigit;
        }
    }

    private void fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromZeroToPositiveBound(Double[] doubles,
                                                                                                        double bound) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= bound) {
                doubles[i] = value;
                value += fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

    private void fillArrayElementsSequentialAscendingDecimalDigitOfDoubleNumbersFromStartBoundToEndBound(Double[] doubles,
                                                                                                         double startBound,
                                                                                                         double endBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= endBound) {
                doubles[i] = value;
                value += fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}
