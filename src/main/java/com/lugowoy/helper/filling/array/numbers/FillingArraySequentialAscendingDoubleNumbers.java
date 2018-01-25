package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 12-Jan-18.
 *
 * @author Konsatantin Lugowoy
 * @version 1.2
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
     * @param endBound
     *
     * @return
     * */
    @Override
    public Array<Double> fill(final Array<Double> array, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(endBound)) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND));
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
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(doubles, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
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
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_POSITIVE_BOUND);
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
                if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
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
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
            if (checkMinBoundValueLessThanMaxBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(new Double[lengthArray], startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(new Double[lengthArray], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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

    private Double[] initializeArrayElementsSequentialAscendingDoubleNumbersFromZeroToPositiveBound(final Double[] doubles, final double positiveBound) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= positiveBound) {
                doubles[i] = value;
                value += integerDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialAscendingDoubleNumbersFromStartBoundToEndBound(final Double[] doubles, final double startBound, final double endBound) {
        double value = startBound;
        for (int i = 0; i < doubles.length; i++, value++) {
            if (value <= endBound) {
                doubles[i] = value;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

}
