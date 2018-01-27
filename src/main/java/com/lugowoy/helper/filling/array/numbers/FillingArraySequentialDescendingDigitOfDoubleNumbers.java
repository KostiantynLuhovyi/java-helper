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
 * */

public class FillingArraySequentialDescendingDigitOfDoubleNumbers implements FillingArrayNumbers<Double> {

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
                array.setArray(this.initializeArrayElementsSequentialDescendingDigitOfDoubleValues(array.getArray()));
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
            doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValues(doubles);
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
            doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValues(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValues(new Double[DEFAULT_LENGTH_ARRAY]);
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
                if (checkBoundValueIsNegative(endBound)) {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(array.getArray(), DEFAULT_DOUBLE_NEGATIVE_BOUND));
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
            if (checkBoundValueIsNegative(endBound)) {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(doubles, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(doubles, DEFAULT_DOUBLE_NEGATIVE_BOUND);
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
            if (checkBoundValueIsNegative(endBound)) {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(new Double[lengthArray], endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(new Double[lengthArray], DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_NEGATIVE_BOUND);
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
    public Array<Double> fill(final Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND));
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
    public Double[] fill(Double[] doubles, Double startBound, Double endBound) {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
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
            if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDigitOfDoubleValues(final Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= fractionalDigit;
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromZeroToNegativeBound(final Double[] doubles, final double endNegativeBound) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= endNegativeBound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDigitOfDoubleValuesFromStartBoundToEndBound(final Double[] doubles, final double startBound, final double endBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= endBound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }


}
