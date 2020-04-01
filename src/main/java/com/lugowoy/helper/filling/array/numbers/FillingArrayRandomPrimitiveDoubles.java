package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
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
public class FillingArrayRandomPrimitiveDoubles implements Filling<ArrayDoubles> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Double}.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(ArrayDoubles array) {
        CheckerArray.checkLengthInArray(array);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoubles(doubles);
        array.setArray(doubles);
    }

    public void fill(double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArrayRandomPrimitiveDoubles(doubles);
    }

    public double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoubles(doubles);
        return doubles;
    }

    public void fill(ArrayDoubles array, double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
        array.setArray(doubles);
    }

    public void fill(double[] doubles, double bound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
    }

    public double[] fill(int lengthArray, double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
        return doubles;
    }

    public void fill(ArrayDoubles array, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        double[] doubles = new double[array.size()];
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    public void fill(double[] doubles, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MIN_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
    }

    public double[] fill(int lengthArray, double lowerBound, double upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        double[] doubles = new double[lengthArray];
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArrayRandomPrimitiveDoubles(double[] doubles) {
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayRandomPrimitiveDoublesFromZeroToBound(double[] doubles, double bound) {
        this.fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(doubles, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillArrayRandomPrimitiveDoublesFromLowerToUpperBounds(double[] doubles, double lowerBound, double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        Arrays.setAll(doubles, index -> randomNumber.generateDouble(lowerBound, upperBound));
    }

}
