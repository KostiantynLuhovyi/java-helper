package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.DEFAULT_DOUBLE_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.DEFAULT_DOUBLE_POSITIVE_BOUND;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 *
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>The class fills an object of the {@link Array} class and a classic array with random numeric data of type {@link Double}.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArrayRandomDoubleNumbers implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.fillArrayElementsRandomDoubleNumbers(doubles);
            array.setArray(doubles);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     *
     * @param doubles The array to be filled with random numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            this.fillArrayElementsRandomDoubleNumbers(doubles);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayElementsRandomDoubleNumbers(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomDoubleNumbers(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * <p>The object of the {@link Array} class is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled with random numeric data of the type {@link Double}.
     * @param bound The value of the bound for filling an object of the {@link Array} class
     *              with random numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param doubles The array to be filled with random numeric data of the type {@link Double}.
     * @param bound The value of the end bound for filling an array with random numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isPositiveBoundValueAndNonNull(bound )) {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray' determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from 0 to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Double}.
     * @param bound The value of the border for filling the array with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * <p>The object of the {@link Array} class is filled
     * with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param array The object of the {@link Array} class to be filled with random numeric data of the type {@link Double}.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with random numeric data of the type {@link Double}.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class
     *                 with random numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                        DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                        DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is filled with numeric data from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param doubles The array to be filled with random numeric data of the type {@link Double}.
     * @param startBound The value of the start bound for filling an array with random numeric data of the type {@link Double}.
     * @param endBound The value of the end bound for filling an array with random numeric data of the type {@link Double}.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(doubles)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                        DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                        DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesForFilling#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesForFilling#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with random numeric data of the type {@link Double}.
     * @param startBound The value of the start bound for filling an array with random numeric data of the type {@link Double}.
     * @param endBound The value of the end bound for filling an array with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkArrayLength(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                        DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                        DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                             DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    private void fillArrayElementsRandomDoubleNumbers(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble();
        }
    }

    private void fillArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(Double[] doubles, double bound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble(bound);
        }
    }

    private void fillArrayElementsRandomDoubleNumbersFromStartBoundToEndBound(Double[] doubles,
                                                                              double startBound,
                                                                              double endBound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble(startBound, endBound);
        }
    }

}
