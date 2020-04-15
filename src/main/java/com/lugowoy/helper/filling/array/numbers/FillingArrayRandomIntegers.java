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
 * The class provides the functionality to fill the class objects {@link Array} and
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
     * Numeric values ​​generate in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Integer> array) {
        CheckerArray.checkLengthInArray(array);
        Integer[] integers = new Integer[array.size()];
        this.fillArray(integers);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
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
        this.fillArray(integers);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
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
        this.fillArray(integers);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Array<Integer> array, Integer boundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromZeroToBound(integers, boundValue);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param integers the array to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Integer[] integers, Integer boundValue) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(integers, boundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer boundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromZeroToBound(integers, boundValue);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param integers the array to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with pseudo-random numerical data of the type {@link Integer}.
     * <p> Pseudorandom numeric data to fill generates functional of the class {@link RandomNumber}.
     * Numeric values ​​generate in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
        return integers;
    }

    private void fillArray(Integer[] integers) {
        this.fillArrayFromLowerToUpper(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(Integer[] integers, int boundValue) {
        this.fillArrayFromLowerToUpper(integers, ValuesToFilling.INT_ZERO, boundValue);
    }

    private void fillArrayFromLowerToUpper(Integer[] integers, int lowerBoundValue, int upperBoundValue) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(integers, i -> randomNumber.generateInt(lowerBoundValue, upperBoundValue));
    }

}
