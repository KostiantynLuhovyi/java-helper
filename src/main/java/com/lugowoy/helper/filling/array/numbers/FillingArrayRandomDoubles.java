package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.util.Arrays;

/**
 * The class implements the functionality to fill the class objects {@link Array} and
 * arrays of the type {@link Double} with pseudo-random data of type {@link Double}.
 * Thereby the class implements the interface contract {@link FillingArrayNumbers}.
 * <p> To see the functionality of pseudorandom number generation you can in the class {@link RandomNumber}.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.2
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomDoubles implements FillingArrayNumbers<Double> {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Double> array) {
        CheckerArray.checkLengthInArray(array);
        Double[] doubles = new Double[array.size()];
        this.fillArrayRandomDoubles(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param doubles the array to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArrayRandomDoubles(doubles);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayRandomDoubles(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[] doubles = new Double[array.size()];
        this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param doubles the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayRandomDoublesFromZeroToPositiveBound(doubles, bound);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[] doubles = new Double[array.size()];
        this.fillArrayRandomDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param doubles the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with pseudo-random numerical data of the type {@link Double}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayRandomDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArrayRandomDoubles(Double[] doubles) {
        this.fillArrayRandomDoublesFromLowerToUpperBounds(doubles, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayRandomDoublesFromZeroToPositiveBound(Double[] doubles, double bound) {
        this.fillArrayRandomDoublesFromLowerToUpperBounds(doubles, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillArrayRandomDoublesFromLowerToUpperBounds(Double[] doubles, double lowerBound, double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(doubles, i -> randomNumber.generateDouble(lowerBound, upperBound));
    }

}
