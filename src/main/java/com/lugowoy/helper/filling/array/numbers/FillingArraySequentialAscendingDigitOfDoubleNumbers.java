package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillingArraySequentialAscendingDigitOfDoubleNumbers implements FillingArrayNumbers<Double> {

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValues(doubles);
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValues(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValues(doubles);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(array.getArray(), startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(array.getArray(), DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double startBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(doubles, startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double startBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsInCorrectRange(startBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(doubles, startBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException{
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            }  else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValues(Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value += fractionalDigit;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromBoundary(Double[] doubles, Double startBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value += fractionalDigit;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingFractionalValuesFromStartBoundToEndBound(Double[] doubles, Double startBound, Double endBound) {
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
