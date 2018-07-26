package com.lugowoy.helper.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 *
 * The interface provides a functional for generating random integers and double numbers.
 *  Functionality is provided in a static context.
 */

public interface GeneratorRandomNumber {

    Random RANDOM = new Random();

    int SCALE = 2;

    /**
     * The method generate a random integer number in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return getRandomIntegerValueInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * The method generate a random integer number in the range from "0" to parameter "bound".
     *
     * @return The generated integer number.
     */
    static int generateInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    /**
     * The method generate a random integer number in the range from parameter "startBound" to parameter "endBound" .
     *
     * @return The generated integer number.
     */
    static int generateInt(int startBound, int endBound) {
        return getRandomIntegerValueInRange(startBound, endBound);
    }

    /**
     * The method generate a random double number in the range from {@link Integer#MIN_VALUE}
     *  to {@link Integer#MAX_VALUE}.
     *
     * @return The generated double number.
     */
    static double generateDouble() {
        return new BigDecimal(getRandomDoubleValueInRange(Integer.MIN_VALUE, Integer.MAX_VALUE)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random double number in the range from "0" to parameter "bound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return new BigDecimal(getRandomDoubleValueInRange(0, bound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random integer number from parameter "startBound" to parameter "endBound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double startBound, double endBound) {
        return new BigDecimal(getRandomDoubleValueInRange(startBound, endBound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    private static int getRandomIntegerValueInRange(int startBound, int endBound) {
        return startBound + (RANDOM.nextInt((endBound - startBound) + 1));
    }

    private static double getRandomDoubleValueInRange(double startBound, double endBound) {
        return startBound + (RANDOM.nextDouble() * (endBound - startBound));
    }

}
