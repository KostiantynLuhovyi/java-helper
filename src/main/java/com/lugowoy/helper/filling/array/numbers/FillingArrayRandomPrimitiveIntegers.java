package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
//TODO edit doc's
public class FillingArrayRandomPrimitiveIntegers implements Filling<ArrayInts> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link int}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link int}.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(ArrayInts array) {
        CheckerArray.checkLengthInArray(array);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveInts(ints);
        array.setArray(ints);
    }

    public void fill(int[] ints) {
        CheckerArray.checkLengthInArray(ints);
        this.fillArrayRandomPrimitiveInts(ints);
    }

    public int[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArrayRandomPrimitiveInts(ints);
        return ints;
    }

    public void fill(ArrayInts array, int bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
        array.setArray(ints);
    }

    public void fill(int[] ints, int bound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
    }

    public int[] fill(int lengthArray, int bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
        return ints;
    }

    public void fill(ArrayInts array, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        int[] ints = new int[array.size()];
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        array.setArray(ints);
    }

    public void fill(int[] ints, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
    }

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
