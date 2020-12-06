package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * The class provides the functionality to fill the class objects {@link
 * ArrayInts} and arrays of the int type with pseudo-random data of the int
 * type.
 * <p>To see the functionality of pseudorandom number generation you can in the
 * class {@link RandomNumber}.
 * <p>Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 2.0
 */
//TODO review documentation
public class FillingArrayRandomPrimitiveIntegers {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public void fill(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int[] ints = new int[array.size()];
        this.fillArray(ints);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the int
     * type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param ints the array to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public void fill(@NotNull final int[] ints) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        this.fillArray(ints);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with pseudo-random numerical data of the int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public int[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArray(ints);
        return ints;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * BigDecimal#ZERO} to {@code bound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(@NotNull final ArrayInts array, final int bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayFromZeroToBound(ints, bound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the int
     * type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * BigDecimal#ZERO} to {@code bound}.
     *
     * @param ints the array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(@NotNull final int[] ints, final int bound) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(ints, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with pseudo-random numerical data of the int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * BigDecimal#ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    public int[] fill(final int lengthArray, final int bound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayFromZeroToBound(ints, bound);
        return ints;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@code
     * lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public void fill(@NotNull final ArrayInts array, final int lowerBound,
                     final int upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[] ints = new int[array.size()];
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with pseudo-random numerical data of the
     * ints type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@code
     * lowerBound} to {@code upperBound}.
     *
     * @param ints the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public void fill(@NotNull final int[] ints, final int lowerBound,
                     final int upperBound) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with pseudo-random numerical data of the int type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@code
     * lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public int[] fill(final int lengthArray, final int lowerBound,
                      final int upperBound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[] ints = new int[lengthArray];
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillArray(final int[] ints) {
        this.fillArrayFromLowerToUpper(ints, Integer.MIN_VALUE,
                                       Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(final int[] ints, final int bound) {
        this.fillArrayFromLowerToUpper(ints, BigDecimal.ZERO.intValue(), bound);
    }

    private void fillArrayFromLowerToUpper(final int[] ints,
                                           final int lowerBound,
                                           final int upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(ints,
                      i -> randomNumber.generateInt(lowerBound, upperBound));
    }

}
