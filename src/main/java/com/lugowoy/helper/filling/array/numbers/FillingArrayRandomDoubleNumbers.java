package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class FillingArrayRandomDoubleNumbers implements FillingArrayNumbers<Double> {

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
                array.setArray(Arrays.stream(array.getArray())
                                     .mapToDouble(value -> GeneratorRandomNumber.generateDouble())
                                     .boxed()
                                     .toArray(Double[]::new));
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            doubles = Arrays.stream(doubles)
                            .mapToDouble(value -> GeneratorRandomNumber.generateDouble())
                            .boxed()
                            .toArray(Double[]::new);
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
            doubles = Arrays.stream(new Double[lengthArray])
                            .mapToDouble(value -> GeneratorRandomNumber.generateDouble())
                            .boxed()
                            .toArray(Double[]::new);
        } else {
            doubles = this.fill(DEFAULT_LENGTH_ARRAY);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, final Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(bound)) {
                array.setArray(Arrays.stream(array.getArray())
                                     .mapToDouble(value -> GeneratorRandomNumber.generateDouble(bound))
                                     .boxed()
                                     .toArray(Double[]::new));
            } else {
                array.setArray(this.fill(array, DEFAULT_DOUBLE_BOUND).getArray());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsPositive(bound )) {
                doubles = Arrays.stream(doubles)
                                .mapToDouble(value -> GeneratorRandomNumber.generateDouble(bound))
                                .boxed()
                                .toArray(Double[]::new);
            } else {
                doubles = this.fill(doubles, DEFAULT_DOUBLE_BOUND);
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
            if (checkBoundValueIsPositive(bound)) {
                doubles = Arrays.stream(new Double[lengthArray])
                                .mapToDouble(value -> GeneratorRandomNumber.generateDouble(bound))
                                .boxed()
                                .toArray(Double[]::new);
            } else {
                doubles = this.fill(lengthArray, DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = this.fill(DEFAULT_LENGTH_ARRAY, DEFAULT_DOUBLE_BOUND);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                array.setArray(Arrays.stream(array.getArray())
                                     .mapToDouble(value -> GeneratorRandomNumber.generateDouble(minBound, maxBound))
                                     .boxed()
                                     .toArray(Double[]::new));
            } else {
                array.setArray(this.fill(array, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND).getArray());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                doubles = Arrays.stream(doubles)
                                .mapToDouble(value -> GeneratorRandomNumber.generateDouble(minBound, maxBound))
                                .boxed()
                                .toArray(Double[]::new);
            } else {
                doubles = this.fill(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)) {
                doubles = Arrays.stream(new Double[lengthArray])
                                .mapToDouble(value -> GeneratorRandomNumber.generateDouble(minBound, maxBound))
                                .boxed()
                                .toArray(Double[]::new);
            } else {
                doubles = this.fill(lengthArray, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.fill(DEFAULT_LENGTH_ARRAY, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

}
