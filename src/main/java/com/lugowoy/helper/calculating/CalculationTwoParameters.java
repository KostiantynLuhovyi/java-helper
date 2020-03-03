package com.lugowoy.helper.calculating;

/**
 * This ia a functional interface to perform calculations based on the two parameters.
 * <p>Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> - the type of calculation result.
 * @param <K> - the type of argument to calculate.
 * @param <V> - the type of argument to calculate.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationTwoParameters<T, K, V> {

    /**
     * Function to perform calculations using the two parameters.
     * The {@code kVar} and {@code vVar} arguments encapsulates the data on the basis
     * of which the calculations will be performed.
     *
     * @param kVar - an object that encapsulates data to perform calculations.
     * @param vVar - an object that encapsulates data to perform calculations.
     * @return result of calculation.
     * @since 1.0
     */
    T calculate(K kVar, V vVar);

}
