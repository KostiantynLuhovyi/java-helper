package com.lugowoy.helper.models.arrays;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 20.12.2017
 * <p>
 *      An interface that declares a contract to implement the methods of
 *      getters and setters for arrays containing numeric elementary data types.
 * </p>
 */

public interface ArrayOfPrimitiveNumbers {

    /**
     * <p>
     *     Returns an array of integers.
     * </p>
     */
    int[] getArrayOfIntegerPrimitiveNumbers();

    /**
     * <p>
     *     Initializes an array, by an array passed argument.
     * </p>
     * @param array Array for initialization.
     */
    void setArrayOfIntegerPrimitiveNumbers(int[] array);

    /**
     * <p>
     *     Returns an array of doubles.
     * </p>
     */
    double[] getArrayOfDoublePrimitiveNumbers();

    /**
     * <p>
     *     Initializes an array, by an array passed argument.
     * </p>
     * @param array Array for initialization.
     */
    void setArrayOfDoublePrimitiveNumbers(double[] array);

}
