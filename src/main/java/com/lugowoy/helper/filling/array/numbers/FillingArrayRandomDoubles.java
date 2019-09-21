package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;
import static com.lugowoy.helper.other.GeneratorRandomNumber.*;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface
 * to fills an object of the {@link Array} class and a classic array with random numeric data of type {@link Double}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomDoubles implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND}
     * to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND}.
     *
     * @param array The object of the {@link Array} class to fill with numeric data of the type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array) {
        if (isNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.fillArrayRandomDoubles(doubles);
            array.setArray(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND}
     * to ({@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND).
     *
     * @param doubles The array to fill with random numeric data of the type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) {
        if (isNonNullArray(doubles)) {
            this.fillArrayRandomDoubles(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND}
     * to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND}.
     * <p>The array is created based on the length an array parameter.
     * If the value of length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayRandomDoubles(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayRandomDoubles(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND},
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND}
     *
     * @param array      The object of the {@link Array} class to fill with random numeric data of the type {@link Double}.
     * @param upperBound The value of the upper bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double upperBound) {
        if (isNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isPositiveBound(upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, upperBound);
                array.setArray(doubles);
            } else {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, DOUBLE_UPPER_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND},
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND}.
     *
     * @param doubles    The array to fill with random numeric data of the type {@link Double}.
     * @param upperBound The value of the upper bound to fill an array with random numeric data of the type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double upperBound) {
        if (isNonNullArray(doubles)) {
            if (isPositiveBound(upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, upperBound);
            } else {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, DOUBLE_UPPER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is created based on the length an array parameter.
     * If the value of the length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND},
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND}.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Double}.
     * @param upperBound  The value of the upper bound to fill the array with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double upperBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isPositiveBound(upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, upperBound);
            } else {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, DOUBLE_UPPER_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, DOUBLE_UPPER_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Double}.
     * <p>Numerical values to fill are in the range from the value of the lower bound to upper bound parameters.
     * If the value of the argument lower bound is greater than the value of the upper bound or if one of the arguments
     * is not in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND},
     * then the values {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} and {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to fill with random numeric data of the type {@link Double}.
     * @param lowerBound The value of the lower bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Double}.
     * @param upperBound The value of the upper bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Double}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        if (isNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                array.setArray(doubles);
            } else {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>Numerical values to fill are in the range from the value of the lower bound to upper bound parameters.
     * If the value of the argument lower bound is greater than the value of the upper bound or if one of the arguments is not
     * in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND},
     * then the values {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} and {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND} respectively.
     *
     * @param doubles    The array to fill with random numeric data of the type {@link Double}.
     * @param lowerBound The value of the lower bound to fill an array with random numeric data of the type {@link Double}.
     * @param upperBound The value of the upper bound to fill an array with random numeric data of the type {@link Double}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        if (isNonNullArray(doubles)) {
            if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
            } else {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is created based on the length an array parameter.
     * If the value of the length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from the value of the lower bound to the upper bound parameters.
     * If the value of the argument lower bound is greater than the value of upper bound or if one of the arguments is not
     * in the range from {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} to {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND,
     * then the values {@link GeneratorRandomNumber#DOUBLE_LOWER_BOUND} and {@link GeneratorRandomNumber#DOUBLE_UPPER_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Double}.
     * @param lowerBound  The value of the lower bound to fill an array with random numeric data of the type {@link Double}.
     * @param upperBound  The value of the end bound to fill an array with random numeric data of the type {@link Double}.
     * @return Created and filled an array with random numeric data of the type {@link Double}.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound) &&
                    (upperBound >= DOUBLE_LOWER_BOUND && upperBound <= DOUBLE_UPPER_BOUND)) {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
            } else {
                this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND);
        }
        return doubles;
    }

    private void fillArrayRandomDoubles(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = generateDouble();
        }
    }

    private void fillArrayRandomDoublesFromZeroToPositiveBound(Double[] doubles, double bound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = generateDouble(bound);
        }
    }

    private void fillArrayRandomDoublesFromLowerBoundToUpperBound(Double[] doubles, double lowerBound, double upperBound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = generateDouble(lowerBound, upperBound);
        }
    }

}
