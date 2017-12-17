package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.generator.GeneratorDataRandomInteger;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.numbers.DefaultValuesForArrays.*;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array the random integer numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayWithNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayWithNumbers
 */

public class FillingArrayWithIntegerRandomNumbers extends FillingArrayWithNumbers<Integer> {

    /**
     * <p>
     * The method fills the array the random integer numeric data (values).
     * </p>
     * @param array The array to fill the random integer numeric data (values).
     * @return An array filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(Integer[] array) {
        return array != null ? Arrays.stream(array)
                                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt())
                                     .boxed()
                                     .toArray(Integer[]::new)
                             : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS);
    }

    /**
     * <p>
     * The method fills the array the random integer numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random integer numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return An array created and filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(int lengthArray) {
        return lengthArray > 0 ? Arrays.stream(new Integer[lengthArray])
                                       .mapToInt(value -> GeneratorDataRandomInteger.generateInt())
                                       .boxed()
                                       .toArray(Integer[]::new)
                               : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS);
    }

    /**
     * <p>
     * The method fills the array the random integer numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the random integer numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(Integer[] array, Integer bound) {
        return ((array != null) && (bound > 0)) ? Arrays.stream(array)
                                                        .mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound))
                                                        .boxed()
                                                        .toArray(Integer[]::new)
                                                : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_BOUND);
    }

    /**
     * <p>
     * The method fills array the random integer numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random integer numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        return ((lengthArray > 0) && (bound > 0)) ? Arrays.stream(new Integer[lengthArray])
                                                          .mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound))
                                                          .boxed()
                                                          .toArray(Integer[]::new)
                                                  : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_BOUND);
    }

    /**
     * <p>
     * The method fills an array the random integer numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the random integer numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(Integer[] array, Integer minBound, Integer maxBound) {
        return ((array != null) && (minBound < maxBound)) ? Arrays.stream(array)
                                                                  .mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound))
                                                                  .boxed()
                                                                  .toArray(Integer[]::new)
                                                          : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
    }

    /**
     * <p>
     * The method fills array the random integer numeric data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random integer numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the random integer numeric data (values).
     */
    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        return ((lengthArray > 0) && (minBound < maxBound)) ? Arrays.stream(new Integer[lengthArray])
                                                                    .mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound))
                                                                    .boxed()
                                                                    .toArray(Integer[]::new)
                                                            : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
    }

}
