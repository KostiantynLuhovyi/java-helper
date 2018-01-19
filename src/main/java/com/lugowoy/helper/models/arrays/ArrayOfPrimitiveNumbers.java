package com.lugowoy.helper.models.arrays;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 * An interface that declares a contract to implement getters that convert an array of reference numeric elements into
 *  an array of primitive types.
 * </p>
 */

public interface ArrayOfPrimitiveNumbers {

    /**
     * <p>
     * Returns an array of primitive integers using array elements encapsulated in the object of the class that implements this functional.
     * </p>
     *
     * @return Returns an array of primitive integer numbers.
     *
     * @since 1.0
     */
    int[] getArrayOfIntegerPrimitiveNumbers();

    /**
     * <p>
     * Returns an array of primitive real using array elements encapsulated in the object of the class that implements this functional.
     * </p>
     *
     * @return Returns an array of primitive real numbers.
     *
     * @since 1.0
     */
    double[] getArrayOfDoublePrimitiveNumbers();

}
