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
 * arrays of the type {@link Integer} with pseudo-random data of the type {@link Integer}.
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
public class FillingArrayRandomIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Integer> array) {
        CheckerArray.checkLengthInArray(array);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayRandomIntegers(integers);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers the array to fill.
     *
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Integer[] integers) {
        CheckerArray.checkLengthInArray(integers);
        this.fillArrayRandomIntegers(integers);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
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
    @Override
    public Integer[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayRandomIntegers(integers);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param integers the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@link ValuesToFilling#INT_ZERO} to {@code bound}.
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
     * from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Integer}.
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
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayRandomIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range of {@code lowerBound} to {@code upperBound}.
     *
     * @param integers the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
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
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayRandomIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillArrayRandomIntegers(Integer[] integers) {
        this.fillArrayRandomIntegersFromLowerToUpperBounds(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayRandomIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        this.fillArrayRandomIntegersFromLowerToUpperBounds(integers, ValuesToFilling.INT_ZERO, bound);
    }

    private void fillArrayRandomIntegersFromLowerToUpperBounds(Integer[] integers, int startBound, int endBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(integers, i -> randomNumber.generateInt(startBound, endBound));
    }

}
