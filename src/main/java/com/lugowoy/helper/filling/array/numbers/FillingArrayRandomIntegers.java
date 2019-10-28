package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface to fills a classic array and
 * an object of the {@link Array} class with pseudo-random numeric data of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            this.fillArrayRandomIntegers(integers);
            array.setArray(integers);
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers The array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the {@code integers} array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        if (checkLengthInArray(integers)) {
            this.fillArrayRandomIntegers(integers);
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Integer}.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayRandomIntegers(integers);
        }
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
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param bound    The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the {@code integers} array argument is null.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (checkLengthInArray(integers)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of the {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from 0 to {@code bound} argument.
     * If the {@code bound} value of the argument is not in the range from 0 to {@link Integer#MAX_VALUE},
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param bound       The upper bound for generating pseudo-random numbers to fill.
     * @return Created and filled an array with pseudo-random numeric data of the type {@link Integer}.
     * @throws LengthValueOutOfRangeException If the {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code bound} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, bound);
            }
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception exception will be thrown.
     *
     * @param array      The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (checkLengthInArray(array)) {
            Integer[] integers = new Integer[array.size()];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                }
            }
        }
    }

    /**
     * Fills an array with pseudo-random numeric data of the type {@link Integer}.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers   The array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound The upper bound for generating pseudo-random numbers to fill.
     * @throws NullPointerException     If the {@code integers} array argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (checkLengthInArray(integers)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>The numerical pseudo-random values for filling are generated in the range from {@code lowerBound} to {@code upperBound} argument.
     * If the {@code lowerBound} or {@code upperBound} value of the argument is not in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} or if the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value,
     * then a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with pseudo-random numeric data of the type {@link Integer}.
     * @param lowerBound  The lower bound for generating pseudo-random numbers to fill.
     * @param upperBound  The upper bound for generating pseudo-random numbers to fill.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException       If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers = new Integer[0];
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
        }
        return integers;
    }

    private void fillArrayRandomIntegers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt();
        }
    }

    private void fillArrayRandomIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(bound);
        }
    }

    private void fillArrayRandomIntegersFromLowerBoundToUpperBound(Integer[] integers, int startBound, int endBound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = GeneratorRandomNumber.generateInt(startBound, endBound);
        }
    }

}
