package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.util.Arrays;

/**
 * The class implements the functionality to fill the class objects {@link ArrayInts} and
 * arrays of the int type with pseudo-random data of the int type.
 * <p> To see the functionality of pseudorandom number generation you can in the class {@link RandomNumber}.
 * <p> Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
public class FillingArrayRandomPrimitiveIntegers {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(ArrayInts array) {
        CheckerArray.checkLengthInArray(array);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveInts(ints);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param ints the array to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(int[] ints) {
        CheckerArray.checkLengthInArray(ints);
        this.fillArrayRandomPrimitiveInts(ints);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public int[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArrayRandomPrimitiveInts(ints);
        return ints;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(ArrayInts array, int bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param ints the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(int[] ints, int bound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public int[] fill(int lengthArray, int bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
        return ints;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public void fill(ArrayInts array, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the ints type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param ints the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public void fill(int[] ints, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with pseudo-random numerical data of the int type.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
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
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public int[] fill(int lengthArray, int lowerBound, int upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        int[] ints = new int[lengthArray];
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillArrayRandomPrimitiveInts(int[] ints) {
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayRandomPrimitiveIntsFromZeroToBound(int[] ints, int bound) {
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, ValuesToFilling.INT_ZERO, bound);
    }

    private void fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(int[] ints, int lowerBound, int upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(ints, index -> randomNumber.generateInt(lowerBound, upperBound));
    }

}
