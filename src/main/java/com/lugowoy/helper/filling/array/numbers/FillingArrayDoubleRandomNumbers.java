package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.generator.GeneratorDataRandomDouble;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 29.07.2017
 * <p>
 * The class encapsulates the implementation of array filling with random double values.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see FillingArray
 * @see FillingArrayNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @see FillableArrayNumbers
 */

public class FillingArrayDoubleRandomNumbers extends FillingArrayNumbers<Double> {

    /**
     * <p>
     * The method fills an array the random double values.
     * </p>
     * @param array The array to fill it with random double values.
     * @return A reference to the array filled with random double values.
     */
    @Override
    public Double[] fill(Double[] array) {
        return Arrays.stream(array)
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * A method that fills the random double values of an array, which is created based on the variable of the length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill random double values.
     *                          The value of the length of the array to fill in the random double values must be a positive number.
     * @return A reference to the array created and filled with random double values.
     */
    @Override
    public Double[] fill(int lengthArray) {
        return Arrays.stream(new Double[lengthArray])
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * A method fills an array the random double values in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill with random double values.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with random double values.
     */
    @Override
    public Double[] fill(Double[] array, Double bound) {
        return Arrays.stream(array)
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values in the range from 0 to the "border",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill random double values.
     *                          The value of the length of the array to fill in the random double values must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an the array created and filled with random double values.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return Arrays.stream(new Double[lengthArray])
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * A method fills an array the random double values in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill with random double values.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array filled with random double values.
     */
    @Override
    public Double[] fill(Double[] array, Double minBound, Double maxBound) {
        return Arrays.stream(array)
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * A method fills an array the random double values in the range from "minBound" to the "maxBound",
     *                                                       which is created based on the variable length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill values.
     *                          The value of the length of the array to fill in the random double values must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an the array created and filled with random double values.
     */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return Arrays.stream(new Double[lengthArray])
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                     .boxed()
                     .toArray(Double[]::new);
    }

}
