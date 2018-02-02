package com.lugowoy.helper.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The interface provides a functional for generating random integers and double numbers.
 *  Functionality is provided in a static context.
 */

public interface GeneratorRandomNumber {

    Random RANDOM = new Random();

    int SCALE = 2;

    int MIN_INT_BOUND = -128;
    int MAX_INT_BOUND = 127;

    double MIN_DOUBLE_BOUND = -128;
    double MAX_DOUBLE_BOUND = 127;

    /**
     * The method generate a random integer number in the range from {@link GeneratorRandomNumber#MIN_INT_BOUND}
     * to {@link GeneratorRandomNumber#MAX_INT_BOUND}.
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return getRandomInRangeIntValue(MIN_INT_BOUND, MAX_INT_BOUND);
    }

    /**
     * The method generate a random integer number in the range from "0" to parameter "bound".
     *
     * @return The generated integer number.
     */
    static int generateInt(final int bound) {
        return RANDOM.nextInt(bound);
    }

    /**
     * The method generate a random integer number in the range from parameter "minBound" to parameter "maxBound" .
     *
     * @return The generated integer number.
     */
    static int generateInt(final int minBound, final int maxBound) {
        return getRandomInRangeIntValue(minBound, maxBound);
    }

    /**
     * The method generate a random double number in the range from {@link GeneratorRandomNumber#MIN_DOUBLE_BOUND}
     *  to {@link GeneratorRandomNumber#MAX_DOUBLE_BOUND}.
     *
     * @return The generated double number.
     */
    static double generateDouble() {
        return new BigDecimal(getRandomInRangeDoubleValue(MIN_DOUBLE_BOUND, MAX_DOUBLE_BOUND)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random double number in the range from "0" to parameter "bound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return new BigDecimal(getRandomInRangeDoubleValue(0, bound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random integer number from parameter "minBound" to parameter "maxBound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double minBound, double maxBound) {
        return new BigDecimal(getRandomInRangeDoubleValue(minBound, maxBound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    private static int getRandomInRangeIntValue(int minBound, int maxBound) {
        return minBound + (RANDOM.nextInt((maxBound - minBound) + 1));
    }

    private static double getRandomInRangeDoubleValue(double minBound, double maxBound) {
        return minBound + (RANDOM.nextDouble() * (maxBound - minBound));
    }

}
