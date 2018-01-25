package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
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

public class FillingArrayRandomDoubleNumbers implements FillingArrayNumbers<Double> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     */
    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                array.setArray(this.initializeArrayElementsRandomDoubleNumbers(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
     */
    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            doubles = this.initializeArrayElementsRandomDoubleNumbers(doubles);
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
            doubles = this.initializeArrayElementsRandomDoubleNumbers(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsRandomDoubleNumbers(new Double[DEFAULT_LENGTH_ARRAY]);
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
    public Array<Double> fill(final Array<Double> array, final Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_POSITIVE_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
            if (checkBoundValueIsPositive(bound )) {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
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
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], bound);
            } else {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_POSITIVE_BOUND);
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
                    array.setArray(this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(array.getArray(), minBound, maxBound));
                } else {
                    array.setArray(this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
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
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsRandomDoubleNumbers(final Double[] doubles) {
        return Arrays.stream(doubles).mapToDouble(value -> GeneratorRandomNumber.generateDouble()).boxed().toArray(Double[]::new);
    }

    private Double[] initializeArrayElementsRandomDoubleNumbersFromZeroToPositiveBound(final Double[] doubles, final double bound) {
        return Arrays.stream(doubles).mapToDouble(value -> GeneratorRandomNumber.generateDouble(bound)).boxed().toArray(Double[]::new);
    }

    private Double[] initializeArrayElementsRandomDoubleNumbersFromMinBoundToMaxBound(final Double[] doubles,
                                                                                                        final double minBound, final double maxBound) {
        return Arrays.stream(doubles).mapToDouble(value -> GeneratorRandomNumber.generateDouble(minBound, maxBound)).boxed().toArray(Double[]::new);
    }

}
