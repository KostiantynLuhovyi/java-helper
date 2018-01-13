package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 12-Jan-18.
 */

public class FillingArraySequentialAscendingDoubleNumbers implements FillingArray<Double>, FillingArrayNumbers<Double> {

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValues(array.getArray());
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValues(doubles);
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
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValues(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValues(doubles);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkBoundValue(bound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(array.getArray(), bound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(array.getArray(), DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            if (checkBoundValue(bound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(doubles, bound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValue(bound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(doubles, bound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(doubles, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(doubles, DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(array.getArray(), minBound, maxBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingValues(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = (double) i;
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingValuesToBoundary(Double[] doubles, Double bound) {
        for (int i = 0; i < doubles.length; i++) {
            if (i <= bound) {
                doubles[i] = (double) i;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

    private void initializeArrayDoubleElementsWithSuccessiveAscendingValuesFromMinBoundToMaxBound(Double[] doubles, Double minBound, Double maxBound) {
        for (int i = 0; i < doubles.length; i++, minBound++) {
            if (minBound <= maxBound) {
                doubles[i] = minBound;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}
