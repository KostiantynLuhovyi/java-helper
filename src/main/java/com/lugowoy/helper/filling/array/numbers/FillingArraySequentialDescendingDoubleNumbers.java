package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
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

public class FillingArraySequentialDescendingDoubleNumbers implements FillingArrayNumbers<Double> {

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
                array.setArray(this.initializeArrayElementsSequentialDescendingDoubleValues(array.getArray()));
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
            doubles = this.initializeArrayElementsSequentialDescendingDoubleValues(doubles);
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
            doubles = this.initializeArrayElementsSequentialDescendingDoubleValues(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDoubleValues(new Double[DEFAULT_LENGTH_ARRAY]);
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
                    array.setArray(this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(array.getArray(), endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(array.getArray(), DEFAULT_DOUBLE_NEGATIVE_BOUND));
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
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(doubles, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(doubles, DEFAULT_DOUBLE_NEGATIVE_BOUND);
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
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(new Double[lengthArray], endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(new Double[lengthArray], DEFAULT_DOUBLE_NEGATIVE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_NEGATIVE_BOUND);
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
                    array.setArray(this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound));
                } else {
                    array.setArray(this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND));
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
            if (checkStartBoundValueMoreThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
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
                doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], startBound, endBound);
            } else {
                doubles =this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(new Double[lengthArray], DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MAX_BOUND, DEFAULT_DOUBLE_MIN_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDoubleValues(final Double[] doubles) {
        double value = doubles.length - 1, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= integerDigit;
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDoubleValuesFromZeroToNegativeBound(final Double[] doubles, final double endBound) {
        double value = 0.0, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= endBound) {
                doubles[i] = value;
                value -= integerDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

    private Double[] initializeArrayElementsSequentialDescendingDoubleValuesFromStartBoundToEndBound(final Double[] doubles, final double startBound, final double endBound) {
        double value = startBound, integerDigit = 1.0;
        for (int i = 0; i < doubles.length; i++) {
            if (value >= endBound) {
                doubles[i] = value;
                value -= integerDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
        return doubles;
    }

}
