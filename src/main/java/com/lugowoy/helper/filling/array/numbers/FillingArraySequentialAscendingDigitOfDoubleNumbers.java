package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArraySequentialAscendingDigitOfDoubleNumbers implements FillingArrayNumbers<Double> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
            array.setArray(this.initializeArrayElementsSequentialAscendingDigitOfDoubleValues(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param doubles
     *
     * @return
     * */
    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValues(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     * */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValues(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValues(new Double[DEFAULT_LENGTH_ARRAY]);
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param endBound
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(endBound)) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param doubles
     * @param endBound
     *
     * @return
     * */
    @Override
    public Double[] fill(Double[] doubles, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsPositive(endBound)) {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(doubles, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param endBound
     *
     * @return
     * */
    @Override
    public Double[] fill(int lengthArray, Double endBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(endBound)) {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(new Double[lengthArray], endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(new Double[lengthArray], DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException{
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkStartBoundValueLessThanEndBoundValue(startBound,endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))){
                    array.setArray(this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else{
                    array.setArray(this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return array;
    }

    /**
     * <p></p>
     *
     * @param doubles
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Double[] fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], startBound, endBound);
            }  else {
                doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDigitOfDoubleValues(final Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value += fractionalDigit;
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromZeroToPositiveBound(final Double[] doubles, final double endPositiveBound) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= endPositiveBound) {
                doubles[i] = value;
                value += fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDigitOfDoubleValuesFromStartBoundToEndBound(final Double[] doubles, final double startBound, final double endBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= endBound) {
                doubles[i] = value;
                value += fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

}
