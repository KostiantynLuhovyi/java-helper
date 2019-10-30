package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthArray;
import static com.lugowoy.helper.utils.checking.CheckerLengthArray.checkLengthInArray;

/**
 * Created by Konstantin Lugowoy on 30.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.0
 */
public class FillingArrayRandomPrimitiveIntegers implements Filling<ArrayInts> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link int}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link int}.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(ArrayInts array) {
        if (checkLengthInArray(array)) {
            int[] ints = new int[array.size()];
            this.fillArrayRandomPrimitiveInts(ints);
            array.setArray(ints);
        }
    }

    public void fill(int[] ints) {
        if (checkLengthInArray(ints)) {
            this.fillArrayRandomPrimitiveInts(ints);
        }
    }

    public int[] fill(int lengthArray) {
        int[] ints = new int[0];
        if (checkLengthArray(lengthArray)) {
            ints = new int[lengthArray];
            this.fillArrayRandomPrimitiveInts(ints);
        }
        return ints;
    }

    public void fill(ArrayInts array, int bound) {
        if (checkLengthInArray(array)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                int[] ints = new int[array.size()];
                this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
                array.setArray(ints);
            }
        }
    }

    public void fill(int[] ints, int bound) {
        if (checkLengthInArray(ints)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
            }
        }
    }

    public int[] fill(int lengthArray, int bound) {
        int[] ints = new int[0];
        if (checkLengthArray(lengthArray)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                ints = new int[lengthArray];
                this.fillArrayRandomPrimitiveIntsFromZeroToBound(ints, bound);
            }
        }
        return ints;
    }

    public void fill(ArrayInts array, int lowerBound, int upperBound) {
        if (checkLengthInArray(array)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    int[] ints = new int[array.size()];
                    this.fillArrayRandomPrimitiveIntsFromLowerBoundToUpperBound(ints, lowerBound, upperBound);
                    array.setArray(ints);
                }
            }
        }
    }

    public void fill(int[] ints, int lowerBound, int upperBound) {
        if (checkLengthInArray(ints)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomPrimitiveIntsFromLowerBoundToUpperBound(ints, lowerBound, upperBound);
                }
            }
        }
    }

    public int[] fill(int lengthArray, int lowerBound, int upperBound) {
        int[] ints = new int[0];
        if (checkLengthArray(lengthArray)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    ints = new int[lengthArray];
                    this.fillArrayRandomPrimitiveIntsFromLowerBoundToUpperBound(ints, lowerBound, upperBound);
                }
            }
        }
        return ints;
    }

    private void fillArrayRandomPrimitiveInts(int[] ints) {
        Arrays.parallelSetAll(ints, index -> GeneratorRandomNumber.generateInt());
    }

    private void fillArrayRandomPrimitiveIntsFromZeroToBound(int[] ints, int bound) {
        Arrays.parallelSetAll(ints, index -> GeneratorRandomNumber.generateInt(bound));
    }

    private void fillArrayRandomPrimitiveIntsFromLowerBoundToUpperBound(int[] ints, int lowerBound, int upperBound) {
        Arrays.parallelSetAll(ints, index -> GeneratorRandomNumber.generateInt(lowerBound, upperBound));
    }

}
