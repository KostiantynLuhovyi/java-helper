package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with pseudo-random numeric data of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.1
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//TODO edit doc's
public class FillingArrayRandomIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Integer}.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        CheckerArray.checkLengthInArray(array);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayRandomIntegers(integers);
        array.setArray(integers);
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers The array to fill with pseudo-random numeric data of the type {@link Integer}.
     *
     * @throws NullPointerException If the {@code integers} array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        CheckerArray.checkLengthInArray(integers);
        this.fillArrayRandomIntegers(integers);
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     *
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Integer}.
     *
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayRandomIntegers(integers);
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-numeric data of the type {@link Integer}.
     * @param bound The upper bound for generating pseudo-random numbers to fill.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
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
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param bound The upper bound for generating pseudo-random numbers to fill.
     *
     * @throws NullPointerException If the {@code integers} array argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of the {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param bound The upper bound for generating pseudo-random numbers to fill.
     *
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Integer}.
     *
     * @throws LengthArrayOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
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
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        array.setArray(integers);
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     *
     * @throws NullPointerException If the {@code integers} array argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     *
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillArrayRandomIntegers(Integer[] integers) {
        Arrays.setAll(integers, i -> GeneratorRandomNumber.generateInt());
    }

    private void fillArrayRandomIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        Arrays.setAll(integers, i -> GeneratorRandomNumber.generateInt(bound));
    }

    private void fillArrayRandomIntegersFromLowerBoundToUpperBound(Integer[] integers, int startBound, int endBound) {
        Arrays.setAll(integers, i -> GeneratorRandomNumber.generateInt(startBound, endBound));
    }

}
