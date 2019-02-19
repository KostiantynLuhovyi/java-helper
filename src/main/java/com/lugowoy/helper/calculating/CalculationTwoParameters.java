package com.lugowoy.helper.calculating;

/**
 * Functional interface declared a contract to perform calculations based on a two parameter.
 * <p>Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> - Type of calculation result.
 * @param <K> - Type of parameter to calculate.
 * @param <V> - Type of parameter to calculate.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationTwoParameters<T, K, V> {

    /**
     * Function to performs calculations using a two parameter.
     *
     * @param kVar - Parameter to calculate.
     * @param vVar - Parameter to calculate.
     * @return Result of calculation.
     * @since 1.0
     */
    T calculate(K kVar, V vVar);

}
