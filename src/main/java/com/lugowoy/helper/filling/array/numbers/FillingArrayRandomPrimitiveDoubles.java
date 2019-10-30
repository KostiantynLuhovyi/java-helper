package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
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
public class FillingArrayRandomPrimitiveDoubles implements Filling<ArrayDoubles> {

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link Double}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link Double}.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    @Override
    public void fill(ArrayDoubles array) {
        if (checkLengthInArray(array)) {
            double[] doubles = new double[array.size()];
            this.fillArrayRandomPrimitiveDoubles(doubles);
            array.setArray(doubles);
        }
    }

    public void fill(double[] doubles) {
        if (checkLengthInArray(doubles)) {
            this.fillArrayRandomPrimitiveDoubles(doubles);
        }
    }

    public double[] fill(int lengthArray) {
        double[] doubles = new double[0];
        if (checkLengthArray(lengthArray)) {
            doubles = new double[lengthArray];
            this.fillArrayRandomPrimitiveDoubles(doubles);
        }
        return doubles;
    }

    public void fill(ArrayDoubles array, double bound) {
        if (checkLengthInArray(array)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                double[] doubles = new double[array.size()];
                this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
                array.setArray(doubles);
            }
        }
    }

    public void fill(double[] doubles, double bound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
            }
        }
    }

    public double[] fill(int lengthArray, double bound) {
        double[] doubles = new double[0];
        if (checkLengthArray(lengthArray)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                doubles = new double[lengthArray];
                this.fillArrayRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
            }
        }
        return doubles;
    }

    public void fill(ArrayDoubles array, double lowerBound, double upperBound) {
        if (checkLengthInArray(array)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    double[] doubles = new double[array.size()];
                    this.fillArrayRandomPrimitiveDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    array.setArray(doubles);
                }
            }
        }
    }

    public void fill(double[] doubles, double lowerBound, double upperBound) {
        if (checkLengthInArray(doubles)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayRandomPrimitiveDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
    }

    public double[] fill(int lengthArray, double lowerBound, double upperBound) {
        double[] doubles = new double[0];
        if (checkLengthArray(lengthArray)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    doubles = new double[lengthArray];
                    this.fillArrayRandomPrimitiveDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillArrayRandomPrimitiveDoubles(double[] doubles) {
        Arrays.parallelSetAll(doubles, index -> GeneratorRandomNumber.generateDouble());
    }

    private void fillArrayRandomPrimitiveDoublesFromZeroToBound(double[] doubles, double bound) {
        Arrays.parallelSetAll(doubles, index -> GeneratorRandomNumber.generateDouble(bound));
    }

    private void fillArrayRandomPrimitiveDoublesFromLowerBoundToUpperBound(double[] doubles, double lowerBound, double upperBound) {
        Arrays.parallelSetAll(doubles, index -> GeneratorRandomNumber.generateDouble(lowerBound, upperBound));
    }

}
