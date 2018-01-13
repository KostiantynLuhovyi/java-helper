package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 13-Jan-18.
 */

public class FillingArraySequentialDescendingDoubleNumbers implements FillingArray<Double>, FillingArrayNumbers<Double> {

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValues(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValues(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValues(doubles);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double startBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkStartBoundIsInCorrectRange(startBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(array.getArray(), startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(array.getArray(), DEFAULT_DOUBLE_BOUND);
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
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(doubles, startBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
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
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(doubles, startBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(doubles, DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(array.getArray(), minBound, maxBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private void initializeArrayDoubleElementsWithSuccessiveDescendingValues(Double[] doubles) {
        double value = doubles.length - 1;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = value;
            value--;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromBoundary(Double[] doubles, Double startBound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = startBound;
            startBound--;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveDescendingValuesFromMinBoundToMaxBound(Double[] doubles, Double minBound, Double maxBound) {
        for (int i = 0; i < doubles.length; i++) {
            if (maxBound >= minBound) {
                doubles[i] = maxBound;
                maxBound--;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}
