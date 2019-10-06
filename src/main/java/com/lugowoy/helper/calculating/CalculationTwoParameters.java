package com.lugowoy.helper.calculating;

/**
 * This is a functional interface declares a contract to perform calculations based on the two parameters.
 * <p>Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> - Type of calculation result.
 * @param <K> - Type of first parameter to perform calculations.
 * @param <V> - Type of second parameter to perform calculations.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationTwoParameters<T, K, V> {

    /**
     * Function to performs calculations using two parameters.
     * The {@code kVar} and {@code vVar} arguments encapsulates the data on the basis
     * of which the calculations will be performed.
     *
     * @param kVar - An object that encapsulates data to perform calculations.
     * @param vVar - An object that encapsulates data to perform calculations.
     * @return Result of calculation.
     * @since 1.0
     */
    T calculate(K kVar, V vVar);

}
