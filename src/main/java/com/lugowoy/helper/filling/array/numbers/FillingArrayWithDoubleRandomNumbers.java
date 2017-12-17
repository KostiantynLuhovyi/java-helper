package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.generator.GeneratorDataRandomDouble;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.numbers.DefaultValuesForArrays.*;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array the random double numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayWithNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayWithNumbers
 */

public class FillingArrayWithDoubleRandomNumbers extends FillingArrayWithNumbers<Double> {

    /**
     * <p>
     * The method fills the array the random double numeric data (values).
     * </p>
     * @param array The array to fill the random double numeric data (values).
     * @return An array filled the random double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array) {
        return array != null ? Arrays.stream(array)
                                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                                     .boxed()
                                     .toArray(Double[]::new)
                             : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS);

    }

    /**
     * <p>
     * The method fills the array the random double numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return An array created and filled with random double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray) {
        return lengthArray > 0 ? Arrays.stream(new Double[lengthArray])
                                       .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                                       .boxed()
                                       .toArray(Double[]::new)
                                : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS);
    }

    /**
     * <p>
     * The method fills the array the random double numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the random double numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the random double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double bound) {
        return ((array != null) && (bound > 0)) ? Arrays.stream(array)
                                                        .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                                                        .boxed()
                                                        .toArray(Double[]::new)
                                                : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS, DEFAULT_DOUBLE_BOUND);
    }

    /**
     * <p>
     * The method fills array the random double numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the random double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return ((lengthArray > 0) && (bound > 0)) ? Arrays.stream(new Double[lengthArray])
                                                          .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                                                          .boxed()
                                                          .toArray(Double[]::new)
                                                  : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS, DEFAULT_DOUBLE_BOUND);
    }

    /**
     * <p>
     * The method fills an array the random double numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the random double numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the random double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double minBound, Double maxBound) {
        return ((array != null) && (minBound < maxBound)) ? Arrays.stream(array)
                                                                  .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                                                                  .boxed()
                                                                  .toArray(Double[]::new)
                                                          : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
    }

    /**
     * <p>
     * The method fills array the random double numeric data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the random double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return ((lengthArray > 0) && (minBound < maxBound)) ? Arrays.stream(new Double[lengthArray])
                                                                    .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                                                                    .boxed()
                                                                    .toArray(Double[]::new)
                                                            : this.fill(DEFAULT_ARRAY_OF_DOUBLE_NUMBERS, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND);
    }

}
