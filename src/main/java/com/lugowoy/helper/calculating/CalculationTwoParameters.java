package com.lugowoy.helper.calculating;

/**
 * This is a functional interface providing functions for
 * calculations based on two operands.
 * <p>
 * Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> the type of calculation result.
 * @param <K> the type of object to calculate.
 * @param <V> the type of object to calculate.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationTwoParameters<T, K, V> {

    /**
     * Calculations based on the {@code kVar}, {@code vVar} objects.
     *
     * @param kVar the object to perform calculations.
     * @param vVar the object to perform calculations.
     *
     * @return the result of calculation.
     *
     * @since 1.0
     */
    T calculate(K kVar, V vVar);

}
