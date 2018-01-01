package com.lugowoy.helper.other;

import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 01.01.2017
 * <p>
 *     The interface provides a functional for generating random integers and double numbers.
 *      Functionality is provided in a static context.
 * </p>
 */

public interface GeneratorRandomNumber {

    /**
     * <p>
     *     The method generate a random integer number.
     * </p>
     * @return The generated integer number.
     */
    static int generateInt() {
        return new Random().nextInt();
    }

    /**
     * <p>
     *      The method generate a random integer number from 0 to parameter "bound".
     * </p>
     * @return The generated integer number.
     */
    static int generateInt(int bound) {
        return new Random().nextInt(bound);
    }

    /**
     * <p>
     *     The method generate a random integer number from parameter "minBound" to parameter "maxBound".
     * </p>
     * @return The generated integer number.
     */
    static int generateInt(int minBound, int maxBound) {
        return (minBound + (new Random().nextInt((maxBound - minBound) + 1)));
    }

    /**
     * <p>
     *     The method generate a random double number.
     * </p>
     * @return The generated double number.
     */
    static double generateDouble() {
        return new Random().nextDouble();
    }

    /**
     * <p>
     *     The method generate a random double number from 0 to parameter "bound".
     * </p>
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return (0 + (new Random().nextDouble() * (bound - 0)));
    }

    /**
     * <p>
     *     The method generate a random integer number from parameter "minBound" to parameter "maxBound".
     * </p>
     * @return The generated double number.
     */
    static double generateDouble(double minBound, double maxBound) {
        return (minBound + (new Random().nextDouble() * (maxBound - minBound)));
    }

}
