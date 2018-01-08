package com.lugowoy.helper.other;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The interface provides a functional for generating random integers and double numbers.
 *  Functionality is provided in a static context.
 * </p>
 */

public interface GeneratorRandomNumber {

    int SCALE = 2;

    double MIN_DOUBLE_BOUND = Short.MIN_VALUE;
    double MAX_DOUBLE_BOUND = Short.MAX_VALUE;

    /**
     * <p>
     * The method generate a random integer number.
     * </p>
     * @since 1.0
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return new Random().nextInt();
    }

    /**
     * <p>
     * The method generate a random integer number from 0 to parameter "bound".
     * </p>
     * @since 1.0
     *
     * @return The generated integer number.
     */
    static int generateInt(final int bound) {
        return new Random().nextInt(bound);
    }

    /**
     * <p>
     * The method generate a random integer number from parameter "minBound" to parameter "maxBound" .
     * </p>
     * @since 1.0
     *
     * @return The generated integer number.
     */
    static int generateInt(final int minBound, final int maxBound) {
        return getRandomInRangeIntValue(minBound, maxBound);
    }

    /**
     * <p>
     * The method generate a random double number.
     * <p>
     * Real numbers are generated in the range from -32768 to 32767.
     * </p>
     * @since 1.0
     *
     * @return The generated double number.
     */
    static double generateDouble() {
        return new BigDecimal(getRandomInRangeDoubleValue(MIN_DOUBLE_BOUND, MAX_DOUBLE_BOUND)).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * <p>
     * The method generate a random double number from 0 to parameter "bound".
     * </p>
     * @since 1.0
     *
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return new BigDecimal(getRandomInRangeDoubleValue(0, bound)).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * <p>
     * The method generate a random integer number from parameter "minBound" to parameter "maxBound".
     * </p>
     * @since 1.0
     *
     * @return The generated double number.
     */
    static double generateDouble(double minBound, double maxBound) {
        return new BigDecimal(getRandomInRangeDoubleValue(minBound, maxBound)).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    static int getRandomInRangeIntValue(int minBound, int maxBound) {
        return minBound + (new Random().nextInt((maxBound - minBound) + 1));
    }

    static double getRandomInRangeDoubleValue(double minBound, double maxBound) {
        return minBound + (new Random().nextDouble() * (maxBound - minBound));
    }

}
