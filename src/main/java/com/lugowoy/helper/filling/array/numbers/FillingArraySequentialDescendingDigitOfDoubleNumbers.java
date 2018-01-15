package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.filling.array.FillingArrayChecker;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillingArraySequentialDescendingDigitOfDoubleNumbers implements FillingArray<Double>, FillingArrayNumbers<Double> {
    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValues(doubles);
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
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValues(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValues(doubles);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkStartBoundIsInCorrectRange(startBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(array.getArray(), startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(array.getArray(), DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double startBound) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            if (checkStartBoundIsInCorrectRange(startBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(doubles, startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double startBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkStartBoundIsInCorrectRange(startBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(doubles, startBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkMinBoundLessThanMaxBound(startBound, endBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(array.getArray(), startBound, endBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double startBound, Double endBound) {
        if (checkNonNullArray(doubles)) {
            if (checkMinBoundLessThanMaxBound(startBound, endBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
            if (checkMinBoundLessThanMaxBound(startBound, endBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    //-------------------------------------------------------------------------------------------------------

    private void initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValues(Double[] doubles) {
        double value = 0, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= fractionalDigit;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromBoundary(Double[] doubles, Double startBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value -= fractionalDigit;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveDescendingFractionalValuesFromStartBoundToEndBound(Double[] doubles, Double startBound, Double endBound) {
        double value = startBound, fractionalDigit = 0.1;
        for (int i = 0; i < doubles.length; i++) {
            if (value <= endBound) {
                doubles[i] = value;
                value -= fractionalDigit;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }


}
