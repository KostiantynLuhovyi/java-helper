package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

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
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayEnteredValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArrayEnteredDoubleNumbers extends FillingArrayEnteredValues<Double> implements FillingArrayNumbers<Double> {

    /**
     * <p></p>
     *
     * @param reader
     *
     * @since 1.0
     */
    public FillingArrayEnteredDoubleNumbers(Reader reader) {
        super(reader);
    }

    /**
     * <p></p>
     *
     * @param reading
     */
    public FillingArrayEnteredDoubleNumbers(Reading reading) {
        super(reading);
    }

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
                array.setArray(this.initializeArrayElementsEnteredDoubleNumbers(array.getArray()));
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the argument is null."));
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
            doubles = this.initializeArrayElementsEnteredDoubleNumbers(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
        }
        return doubles;
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = this.initializeArrayElementsEnteredDoubleNumbers(new Double[lengthArray]);
        } else {
            doubles = this.initializeArrayElementsEnteredDoubleNumbers(new Double[DEFAULT_LENGTH_ARRAY]);
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
     */
    @Override
    public Array<Double> fill(final Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkBoundValueIsPositive(bound)) {
                    array.setArray(this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(array.getArray(), bound));
                } else {
                    array.setArray(this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(array.getArray(), DEFAULT_DOUBLE_BOUND));
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
            if (checkBoundValueIsPositive(bound)) {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_BOUND);
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
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], bound);
            } else {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(new Double[lengthArray], DEFAULT_DOUBLE_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_BOUND);
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
     */
    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkNonNullArrayNumbers(array.getArray())) {
                if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                        && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                    array.setArray(this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(array.getArray(), minBound, maxBound));
                } else {
                    array.setArray(this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND));
                }
            } else {
                throw new IllegalArgumentException(new NullPointerException("The array passed by the argument is null."));
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the parameter is null."));
        }
        return null;
    }

    /**
     * <p></p>
     *
     * @param doubles
     * @param minBound
     * @param maxBound
     *
     * @return
     */
    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(doubles, minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
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
     */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundValueLessThanMaxBoundValue(minBound, maxBound)
                    && (checkBoundValueIsInCorrectRange(minBound) && checkBoundValueIsInCorrectRange(maxBound))) {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], minBound, maxBound);
            } else {
                doubles = this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(new Double[lengthArray], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
            }
        } else {
            doubles = this.initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(new Double[DEFAULT_LENGTH_ARRAY], DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
        }
        return doubles;
    }

    private Double[] initializeArrayElementsEnteredDoubleNumbers(final Double[] doubles) {
        return Arrays.stream(doubles).mapToDouble(value -> super.getReader().readDouble()).boxed().toArray(Double[]::new);
    }

    private Double[] initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(final Double[] doubles, final double bound) {
        return Arrays.stream(doubles).mapToDouble(value -> {
            value = super.getReader().readDouble();
            if ((value >= DEFAULT_START_BOUND) && (value <= bound)) {
                return value;
            } else {
                return DEFAULT_DOUBLE_VALUE;
            }
        }).boxed().toArray(Double[]::new);
    }

    private Double[] initializeArrayElementsEnteredDoubleNumbersFromMinBoundToMaxBound(final Double[] doubles,
                                                                                              final double minBound, final double maxBound) {
        return Arrays.stream(doubles).mapToDouble(value -> {
            value = super.getReader().readDouble();
            if ((value >= minBound) && (value <= maxBound)) {
                return value;
            } else {
                return DEFAULT_DOUBLE_VALUE;
            }
        }).boxed().toArray(Double[]::new);
    }

}
