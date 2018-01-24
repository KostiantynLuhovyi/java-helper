package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 12-Jan-18.
 *
 * @author Konsatantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 * */

public class FillingArraySequentialAscendingDoubleNumbers implements FillingArrayNumbers<Double> {

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
                this.initializeArrayElementsSequentialAscendingDoubleNumbers(array.getArray());
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
            this.initializeArrayElementsSequentialAscendingDoubleNumbers(doubles);
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
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbers(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbers(new Double[DEFAULT_LENGTH_ARRAY]);
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param bound
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_BOUND));
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
     * @param bound
     *
     * @return
     * */
    @Override
    public Double[] fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsPositive(bound)) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_BOUND);
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
     * @param bound
     *
     * @return
     * */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], bound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param array
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                        && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(array.getArray(), minBound, maxBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
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
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
     * @param minBound
     * @param maxBound
     *
     * @return
     * */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDoubleNumbers(final Double[] doubles) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value += integerDigit;
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(final Double[] doubles, final double bound) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= bound) {
                doubles[i] = value;
                value += integerDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDoubleNumbersFromMinBoundToMaxBound(final Double[] doubles, final double minBound, final double maxBound) {
        double value = minBound;
        for (int i = 0; i < doubles.length; i++, value++) {
            if (value <= maxBound) {
                doubles[i] = value;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

}
