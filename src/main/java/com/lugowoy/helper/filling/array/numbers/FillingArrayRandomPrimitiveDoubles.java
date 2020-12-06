package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.models.arrays.ArrayDoubles;
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
 * ArrayDoubles} and arrays of the double type with pseudo-random data of the
 * primitive double type. <p>To see the functionality of pseudorandom number
 * generation you can in the class {@link RandomNumber}.
 * <p>Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 2.0
 */
//TODO review documentation
public class FillingArrayRandomPrimitiveDoubles {

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * primitive double type. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public void fill(@NotNull final ArrayDoubles array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        double[] doubles = new double[array.size()];
        this.fillArray(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the
     * primitive double type. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param doubles the array to fill.
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public void fill(@NotNull final double[] doubles) {
        CheckerArray.check(doubles, Capacity.UPPER.get());
        this.fillArray(doubles);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the primitive
     * double type and fills it with pseudo-random numerical data of the
     * primitive double type. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public double[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        double[] doubles = new double[lengthArray];
        this.fillArray(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * primitive double type. <p>Pseudorandom numeric data to fill generates
     * functional of the class {@link RandomNumber}. Numeric values ​​generate
     * in the range from {@link BigDecimal#ZERO} to {@code bound}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    public void fill(@NotNull final ArrayDoubles array, final double bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[] doubles = new double[array.size()];
        this.fillArrayFromZeroToBound(doubles, bound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the
     * double type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@link
     * BigDecimal#ZERO} to {@code bound}.
     *
     * @param doubles the array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    public void fill(@NotNull final double[] doubles, final double bound) {
        CheckerArray.check(doubles, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillArrayFromZeroToBound(doubles, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double
     * type and fills it with pseudo-random numerical data of the double type.
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
     * from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    public double[] fill(final int lengthArray, final double bound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[] doubles = new double[lengthArray];
        this.fillArrayFromZeroToBound(doubles, bound);
        return doubles;
    }

    /**
     * Fills the {@code array} object with pseudo-random numerical data of the
     * double type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@code
     * lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public void fill(@NotNull final ArrayDoubles array, final double lowerBound,
                     final double upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[] doubles = new double[array.size()];
        this.fillArrayFromLowerToUpper(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with pseudo-random numerical data of the
     * double type.
     * <p>Pseudorandom numeric data to fill generates functional of the class
     * {@link RandomNumber}. Numeric values ​​generate in the range from {@code
     * lowerBound} to {@code upperBound}.
     *
     * @param doubles the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public void fill(@NotNull final double[] doubles, final double lowerBound,
                     final double upperBound) {
        CheckerArray.check(doubles, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MIN_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillArrayFromLowerToUpper(doubles, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double
     * type and fills it with pseudo-random numerical data of the double type.
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
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    public double[] fill(final int lengthArray, final double lowerBound,
                         final double upperBound) {
        CheckerArray.check(lengthArray, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[] doubles = new double[lengthArray];
        this.fillArrayFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArray(final double[] doubles) {
        this.fillArrayFromLowerToUpper(doubles, Double.MIN_VALUE,
                                       Double.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(final double[] doubles,
                                          final double bound) {
        this.fillArrayFromLowerToUpper(doubles, BigDecimal.ZERO.doubleValue(),
                                       bound);
    }

    private void fillArrayFromLowerToUpper(final double[] doubles,
                                           final double lowerBound,
                                           final double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(doubles,
                      i -> randomNumber.generateDouble(lowerBound, upperBound));
    }

}
