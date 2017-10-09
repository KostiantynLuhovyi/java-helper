package com.lugowoy.helper.calculating;

/**
 * Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 03.02.2017
 * <p>
 * Functional interface declares a contract for calculations using the two variables.
 * </p>
 * @param <T> - Calculation result type.
 * @param <K> - Type of variable used for calculations.
 * @param <V> - Type of variable used for calculations.
 */
@FunctionalInterface
public interface CalculableOnTheTwoVariables<T, K, V> {

    /**
     * <p>
     * The method(function) of performing calculations on the value of the two variables.
     * </p>
     * @param kFirst - The first variable for calculate.
     * @param vSecond - The second variable for calculate.
     * @return The result of the calculation the type T.
     * @since 03.02.2017
     */
    T calculate(K kFirst, V vSecond);

}
