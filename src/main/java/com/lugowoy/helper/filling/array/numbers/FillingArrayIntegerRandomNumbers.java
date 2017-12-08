package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.generator.GeneratorDataRandomInteger;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 29.07.2017
 * <p>
 * The class encapsulates the implementation of array filling with random integer values.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see FillingArray
 * @see FillingArrayNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @see FillableArrayNumbers
 */

public class FillingArrayIntegerRandomNumbers extends FillingArrayNumbers<Integer> {

    /**
     * <p>
     * The method fills an array the random integer values.
     * </p>
     * @param array The array to fill it with random integer values.
     * @return A reference to the array filled with random integer values.
     */
    @Override
    public Integer[] fill(Integer[] array) {
        return Arrays.stream(array)
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt())
                     .boxed()
                     .toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values, which is created based on the variable of the length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill random integer values.
     *                          The value of the length of the array to fill in the random integer values must be a positive number.
     * @return A reference to the array created and filled with random integer values.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        return Arrays.stream(new Integer[lengthArray])
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt())
                     .boxed()
                     .toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill with random integer values.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with random integer values.
     */
    @Override
    public Integer[] fill(Integer[] array, Integer bound) {
        return Arrays.stream(array)
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound))
                     .boxed()
                     .toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values in the range from 0 to the "border",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill random integer values.
     *                          The value of the length of the array to fill in the random integer values must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an the array created and filled with random integer values.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        return Arrays.stream(new Integer[lengthArray])
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound))
                     .boxed()
                     .toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill with random integer values.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array filled with random integer values.
     */
    @Override
    public Integer[] fill(Integer[] array, Integer minBound, Integer maxBound) {
        return Arrays.stream(array)
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound))
                     .boxed()
                     .toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values in the range from "minBound" to the "maxBound",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill values.
     *                          The value of the length of the array to fill in the random integer values must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array created and filled with random integer values.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        return Arrays.stream(new Integer[lengthArray])
                     .mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound))
                     .boxed()
                     .toArray(Integer[]::new);
    }

}
