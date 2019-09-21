package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;
import static com.lugowoy.helper.other.GeneratorRandomNumber.*;

/**
 * The class implements the contract declared by the {@link FillingArrayNumbers} interface
 * to fills an object of the {@link Array} class and a classic array with random numeric data of type {@link Integer}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayRandomIntegers implements FillingArrayNumbers<Integer> {

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND}
     * to {@link GeneratorRandomNumber#INT_UPPER_BOUND}.
     *
     * @param array The object of the {@link Array} class to fill with numeric data of the type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayRandomIntegers(integers);
            array.setArray(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND}
     * to ({@link GeneratorRandomNumber#INT_UPPER_BOUND).
     *
     * @param integers The array to fill with random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers) {
        if (isNonNullArray(integers)) {
            this.fillArrayRandomIntegers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * Numerical values are in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND}
     * to {@link GeneratorRandomNumber#INT_UPPER_BOUND}.
     * <p>The array is created based on the length an array parameter.
     * If the value of length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayRandomIntegers(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomIntegers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#INT_UPPER_BOUND}
     *
     * @param array      The object of the {@link Array} class to fill with random numeric data of the type {@link Integer}.
     * @param upperBound The value of the upper bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer upperBound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isPositiveBound(upperBound) && isCorrectRangeBounds(0, INT_UPPER_BOUND)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, upperBound);
                array.setArray(integers);
            } else {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, INT_UPPER_BOUND);
                array.setArray(integers);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#INT_UPPER_BOUND}.
     *
     * @param integers   The array to fill with random numeric data of the type {@link Integer}.
     * @param upperBound The value of the upper bound to fill an array with random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer upperBound) {
        if (isNonNullArray(integers)) {
            if (isPositiveBound(upperBound) && isCorrectRangeBounds(0, upperBound)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, upperBound);
            } else {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, INT_UPPER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the length an array parameter.
     * If the value of the length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>Numerical values to fill are in the range from "0" to the value of the upper bound parameter.
     * If the value of the upper bound argument is a negative number or greater than {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the range value for filling the array from "0" to {@link GeneratorRandomNumber#INT_UPPER_BOUND}.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Integer}.
     * @param upperBound  The value of the upper bound to fill the array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer upperBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isPositiveBound(upperBound) && isCorrectRangeBounds(0, upperBound)) {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, upperBound);
            } else {
                this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, INT_UPPER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomIntegersFromZeroToPositiveBound(integers, INT_UPPER_BOUND);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with random numeric data of the type {@link Integer}.
     * <p>Numerical values to fill are in the range from the value of the lower bound to upper bound parameters.
     * If the value of the argument lower bound is greater than the value of the upper bound or if one of the arguments
     * is not in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND} to {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the values {@link GeneratorRandomNumber#INT_LOWER_BOUND} and {@link GeneratorRandomNumber#INT_UPPER_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to fill with random numeric data of the type {@link Integer}.
     * @param lowerBound The value of the lower bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @param upperBound The value of the upper bound to fill an object of the {@link Array} class
     *                   with random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectRangeBounds(lowerBound, upperBound) && isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                array.setArray(integers);
            } else {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, INT_LOWER_BOUND, INT_UPPER_BOUND);
                array.setArray(integers);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>Numerical values to fill are in the range from the value of the lower bound to upper bound parameters.
     * If the value of the argument lower bound is greater than the value of the upper bound or if one of the arguments is not
     * in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND} to {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the values {@link GeneratorRandomNumber#INT_LOWER_BOUND} and {@link GeneratorRandomNumber#INT_UPPER_BOUND} respectively.
     *
     * @param integers   The array to fill with random numeric data of the type {@link Integer}.
     * @param lowerBound The value of the lower bound to fill an array with random numeric data of the type {@link Integer}.
     * @param upperBound The value of the upper bound to fill an array with random numeric data of the type {@link Integer}.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(integers)) {
            if (isCorrectRangeBounds(lowerBound, upperBound) && isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
            } else {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, INT_LOWER_BOUND, INT_UPPER_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with random numeric data of the type {@link Integer}.
     * <p>The array is created based on the length an array parameter.
     * If the value of the length an array is less than "0" or is greatest than {@link Integer#MAX_VALUE}(exclusion),
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from the value of the lower bound to the upper bound parameters.
     * If the value of the argument lower bound is greater than the value of upper bound or if one of the arguments is not
     * in the range from {@link GeneratorRandomNumber#INT_LOWER_BOUND} to {@link GeneratorRandomNumber#INT_UPPER_BOUND}(exclusion),
     * then the values {@link GeneratorRandomNumber#INT_LOWER_BOUND} and {@link GeneratorRandomNumber#INT_UPPER_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to fill with random numeric data of the type {@link Integer}.
     * @param lowerBound  The value of the lower bound to fill an array with random numeric data of the type {@link Integer}.
     * @param upperBound  The value of the end bound to fill an array with random numeric data of the type {@link Integer}.
     * @return Created and filled an array with random numeric data of the type {@link Integer}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectRangeBounds(lowerBound, upperBound) && isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
            } else {
                this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, INT_LOWER_BOUND, INT_UPPER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayRandomIntegersFromLowerBoundToUpperBound(integers, INT_LOWER_BOUND, INT_UPPER_BOUND);
        }
        return integers;
    }

    private void fillArrayRandomIntegers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = generateInt();
        }
    }

    private void fillArrayRandomIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = generateInt(bound);
        }
    }

    private void fillArrayRandomIntegersFromLowerBoundToUpperBound(Integer[] integers, int startBound, int endBound) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = generateInt(startBound, endBound);
        }
    }

}
