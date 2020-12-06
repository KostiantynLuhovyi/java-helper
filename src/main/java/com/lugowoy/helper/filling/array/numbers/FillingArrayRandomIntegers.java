package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * The class provides the functionality to fill the class objects {@link Array}
 * and arrays of the type {@link Integer} with pseudo-random data of the type
 * {@link Integer}. Thereby the class implements the interface contract {@link
 * FillingArrayNumbers}. <p>To see the functionality of pseudorandom number
 * generation you can in the class {@link RandomNumber}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.3
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//TODO review documentation
public class FillingArrayRandomIntegers
        implements FillingArrayNumbers<Integer> {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Integer#MIN_VALUE} to {@link
     * Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final Array<Integer> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Integer[] integers = new Integer[array.size()];
        this.fillArray(integers);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Integer#MIN_VALUE} to {@link
     * Integer#MAX_VALUE}.
     *
     * @param array the array to fill.
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final Integer[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArray(array);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Integer} and fills it with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public Integer[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        Integer[] integers = new Integer[lengthArray];
        this.fillArray(integers);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final Array<Integer> array,
                     @NotNull final Integer bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromZeroToBound(integers, bound);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param array the array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final Integer[] array,
                     @NotNull final Integer bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(array, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Integer} and fills it with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public Integer[] fill(final int lengthArray, @NotNull final Integer bound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromZeroToBound(integers, bound);
        return integers;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final Array<Integer> array,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromLowerToUpper(integers, lowerBound, upperBound);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param array the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code integers} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final Integer[] array,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillArrayFromLowerToUpper(array, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Integer} and fills it with pseudo-random numerical data of the
     * type {@link Integer}. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public Integer[] fill(final int lengthArray,
                          @NotNull final Integer lowerBound,
                          @NotNull final Integer upperBound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromLowerToUpper(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillArray(final Integer[] integers) {
        this.fillArrayFromLowerToUpper(integers, Integer.MIN_VALUE,
                                       Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(final Integer[] integers,
                                          final int bound) {
        this.fillArrayFromLowerToUpper(integers, BigDecimal.ZERO.intValue(),
                                       bound);
    }

    private void fillArrayFromLowerToUpper(final Integer[] integers,
                                           final int lowerBound,
                                           final int upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(integers,
                      i -> randomNumber.generateInt(lowerBound, upperBound));
    }

}
