package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.util.Arrays;

/**
 * The class provides the functionality to fill the class objects {@link ArrayDoubles} and
 * arrays of the double type with pseudo-random data of the double type.
 * <p> To see the functionality of pseudorandom number generation you can in the class {@link RandomNumber}.
 * <p> Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
public class FillingArrayRandomPrimitiveDoubles {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(ArrayDoubles array) {
        CheckerArray.checkLengthInArray(array);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoubles(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param doubles the array to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArrayRandomPrimitiveDoubles(doubles);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoubles(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public void fill(ArrayDoubles array, double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param doubles the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public void fill(double[] doubles, double bound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public double[] fill(int lengthArray, double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public void fill(ArrayDoubles array, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param doubles the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public void fill(double[] doubles, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MIN_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with pseudo-random numerical data of the double type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public double[] fill(int lengthArray, double lowerBound, double upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArrayRandomPrimitiveDoubles(double[] doubles) {
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayRandomPrimitiveDoublesFromZeroToBound(double[] doubles, double bound) {
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(double[] doubles, double lowerBound, double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(doubles, index -> randomNumber.generateDouble(lowerBound, upperBound));
    }

}
