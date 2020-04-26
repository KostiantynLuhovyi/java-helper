package com.lugowoy.helper.calculating;

/**
 * This is a functional interface providing functions for
 * calculations based on one operand.
 * <p>
 * Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @param <T> the type of the calculation result.
 * @param <K> the type of the object to calculate.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
@FunctionalInterface
public interface CalculationOneParameter<T, K> {

    /**
     * Calculations based on the object {@code kVar}.
     *
     * @param kVar the object to perform calculations.
     *
     * @return the result of calculation.
     *
     * @since 1.0
     */
    T calculate(K kVar);

}
