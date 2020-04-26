package com.lugowoy.helper.calculations;

/**
 * This is a functional interface providing functions for
 * calculations based on three operands.
 * <p>
 * Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> the type of calculation result.
 * @param <K> the type of object to calculate.
 * @param <V> the type of object to calculate.
 * @param <Z> the type of object to calculate.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationByThreeParameters<T, K, V, Z> {

    /**
     * Calculations based on the {@code kVar}, {@code vVar} and
     * {@code zVar} objects.
     *
     * @param kVar - the object to perform calculations.
     * @param vVar - the object to perform calculations.
     * @param zVar - the object to perform calculations.
     *
     * @return the result of calculation.
     *
     * @since 1.0
     */
    T calculate(K kVar, V vVar, Z zVar);

}
