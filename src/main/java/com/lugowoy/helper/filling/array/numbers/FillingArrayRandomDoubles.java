package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with pseudo-random numeric data of type {@link Double}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomDoubles implements FillingArrayNumbers<Double> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Double}.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Double> array) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            this.fillArrayRandomDoubles(doubles);
            array.setArray(doubles);
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param doubles The array to fill with pseudo-random numeric data of the type {@link Double}.
     * @throws NullPointerException If the {@code doubles} array argument is null.
     */
    @Override
    public void fill(Double[] doubles) {
        if (checkLengthInArray(doubles)) {
            this.fillArrayRandomDoubles(doubles);
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Double}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Double}.
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Double}.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayRandomDoubles(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-numeric data of the type {@link Double}.
     * @param bound The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles The array to fill with pseudo-random numeric data of the type {@link Double}.
     * @param bound   The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the {@code doubles} array argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Double}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of the {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Double}.
     * @param bound       The upper bound for generating pseudo-random numbers to fill.
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Double}.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code bound} argument value is out of valid range.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
            }
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array      The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Double}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        if (checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    array.setArray(doubles);
                }
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or than not equal to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles    The array to fill with pseudo-random numeric data of the type {@link Double}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the {@code doubles} array argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Double}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Double}.
     * @param lowerBound  The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound  The upper bound for generating pseudo-random numbers to fill.
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        Double[] doubles = new Double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillArrayRandomDoubles(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble();
        }
    }

    private void fillArrayRandomDoublesFromZeroToPositiveBound(Double[] doubles, double bound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble(bound);
        }
    }

    private void fillArrayRandomDoublesFromLowerBoundToUpperBound(Double[] doubles, double lowerBound, double upperBound) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = GeneratorRandomNumber.generateDouble(lowerBound, upperBound);
        }
    }

}
