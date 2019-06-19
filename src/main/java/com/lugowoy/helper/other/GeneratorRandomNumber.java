package com.lugowoy.helper.other;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Interface with static functionality for generate random number.
 * <p>Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 */
public class GeneratorRandomNumber {

    private static final Random RANDOM = new Random();
    private static final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();
    private static final RandomDataGenerator GENERATOR = new RandomDataGenerator();

    private static final int VALUE_ZERO = 0;

    private static final int REAL_LOWER_BOUND = -1000000;
    private static final int REAL_UPPER_BOUND = 1000000;

    private static final int SCALE = 3;

    /**
     * Generate a random byte number in the range
     * from {@link Byte#MIN_VALUE} (inclusive) to {@link Byte#MAX_VALUE} (inclusive).
     *
     * @return The generated byte type number.
     */
    public static byte generateByte() {
        return (byte) GENERATOR.nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * Generate a random positive byte number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument upper bound (inclusive).
     *
     * @param bound The upper bound to generate number.
     * @return The generated byte type number.
     * @throws BoundOutOfRangeException If the boundary values is out of range.
     */
    public static byte generateByte(byte bound) {
        byte result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Byte.MAX_VALUE)) {
            result = (byte) GENERATOR.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random byte number in the range
     * from argument lower bound (inclusive) to upper bound (inclusive).
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated byte type number.
     * @throws BoundOutOfRangeException If the boundary values is out of range.
     */
    public static byte generateByte(byte lowerBound, byte upperBound) {
        byte result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Byte.MIN_VALUE, Byte.MAX_VALUE) && (lowerBound < upperBound)) {
            result = (byte) GENERATOR.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random short number in the range
     * from {@link Short#MIN_VALUE} (inclusive) to {@link Short#MAX_VALUE} (inclusive).
     *
     * @return The generated short number.
     */
    public static short generateShort() {
        return (short) GENERATOR.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    /**
     * Generate a random positive short number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument upper bound (inclusive).
     *
     * @param bound The upper bound to generate.
     * @return The generated short type number.
     * @throws BoundOutOfRangeException If the boundary values is out of range.
     */
    public static short generateShort(short bound) {
        short result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Short.MAX_VALUE)) {
            result = (short) GENERATOR.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random short number in the range
     * from argument lower bound (inclusive) to upper bound (inclusive).
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated short type number.
     * @throws BoundOutOfRangeException If the boundary values is out of range.
     */
    public static short generateShort(short lowerBound, short upperBound) {
        short result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Short.MIN_VALUE, Short.MAX_VALUE) && (lowerBound < upperBound)) {
            result = (short) GENERATOR.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random integer number in the range
     * from {@link Integer#MIN_VALUE} (inclusive) to {@link Integer#MAX_VALUE} (inclusive).
     *
     * @return The generated integer number.
     */
    public static int generateInt() {
        return GENERATOR.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a random positive integer number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument bound (inclusive).
     *
     * @param bound The upper bound to generate.
     * @return The generated integer type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static int generateInt(int bound) {
        int result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Integer.MAX_VALUE)) {
            result = GENERATOR.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random integer number in the range
     * from argument lower bound (inclusive) to upper bound (inclusive).
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated integer type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static int generateInt(int lowerBound, int upperBound) {
        int result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE) && (lowerBound <= upperBound)) {
            result = GENERATOR.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random long number in the range
     * from {@link Long#MIN_VALUE} (inclusive) to {@link Long#MAX_VALUE} (inclusive).
     *
     * @return The generated long type number.
     */
    public static long generateLong() {
        return GENERATOR.nextLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a random positive long number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument bound (inclusive).
     *
     * @param bound The upper bound to generate.
     * @return The generated long type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static long generateLong(long bound) {
        long result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Long.MAX_VALUE)) {
            result = GENERATOR.nextLong(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random long number in the range
     * from argument lower bound (inclusive) to upper bound (inclusive).
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated long type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static long generateLong(long lowerBound, long upperBound) {
        long result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Long.MIN_VALUE, Long.MAX_VALUE) && (lowerBound < upperBound)) {
            result = GENERATOR.nextLong(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random double number in the range from {@link GeneratorRandomNumber#REAL_LOWER_BOUND} (inclusive)
     * to {@link GeneratorRandomNumber#REAL_UPPER_BOUND} (inclusive).
     *
     * @return The generated double type number.
     */
    public static double generateDouble() {
        RandomGenerator randomGenerator = GENERATOR.getRandomGenerator();
        double resultDouble = randomGenerator.nextDouble() * (REAL_UPPER_BOUND + 1 - REAL_LOWER_BOUND) + REAL_UPPER_BOUND;
        return new BigDecimal(new DecimalFormat("0.000").format(resultDouble)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    //todo add doc's (inclusive to exclusive)
    public static double generateExpDouble() {
        return THREAD_LOCAL_RANDOM.nextDouble(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a random positive double number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument bound (inclusive).
     *
     * @param bound The upper bound to generate.
     * @return The generated double type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static double generateDouble(double bound) {
        double result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, REAL_UPPER_BOUND)) {
            result = Math.random() * (bound + 1 - VALUE_ZERO) + VALUE_ZERO;
        }
        return new BigDecimal(new DecimalFormat("0.000").format(result)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    //todo add doc's (inclusive to exclusive)
    public static double generateExpDouble(double bound) {
        return THREAD_LOCAL_RANDOM.nextDouble(VALUE_ZERO, bound);
    }

    /**
     * Generate a random double number in the range
     * from argument lower bound (inclusive) to upper bound (inclusive).
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated double type number.
     * @throws BoundOutOfRangeException If the boundary values is out in range.
     */
    public static double generateDouble(double lowerBound, double upperBound) {
        double result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, REAL_LOWER_BOUND, REAL_UPPER_BOUND) && (lowerBound < upperBound)) {
            result = Math.random() * (upperBound + 1 - lowerBound) + lowerBound;
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    //todo add doc's (inclusive to exclusive)
    public static double generateExpDouble(double lowerBound, double upperBound) {
        return THREAD_LOCAL_RANDOM.nextDouble(lowerBound, upperBound);
    }


    /**
     * Generate a random float number in the range from {@link GeneratorRandomNumber#REAL_LOWER_BOUND} (inclusive)
     * to {@link GeneratorRandomNumber#REAL_UPPER_BOUND} (inclusive).
     *
     * @return The generated float type number.
     */
    public static float generateFloat() {
        RandomGenerator randomGenerator = GENERATOR.getRandomGenerator();
        return randomGenerator.nextFloat() * (REAL_UPPER_BOUND + 1 - REAL_LOWER_BOUND) + REAL_UPPER_BOUND;
        /*new BigDecimal(new DecimalFormat("0.000").format(resultDouble)).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();*/
    }

    /**
     * Generate a random positive float number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO}  to argument bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated float type number.
     * @throws BoundOutOfRangeException If the bound value is out in range.
     */
    public static float generateFloat(float bound) {
        float result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Long.MAX_VALUE)) {
            result = RandomUtils.nextFloat(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();
    }

    /**
     * Generate a random float number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The start bound to generate.
     * @param upperBound The end bound to generate.
     * @return The generated float type number.
     * @throws BoundOutOfRangeException If the bound value is out in range.
     */
    public static float generateFloat(float lowerBound, float upperBound) {
        float result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Long.MIN_VALUE, Long.MAX_VALUE) && (lowerBound < upperBound)) {
            result = RandomUtils.nextFloat(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();
    }

    private static boolean isBoundValueInRange(long lowerBound, long upperBound,
                                               long minLowerBound, long maxLowerBound) {
        if (lowerBound >= minLowerBound && upperBound <= maxLowerBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound value is out of range.");
        }
    }

    private static boolean isBoundValueInRange(double lowerBound, double upperBound,
                                               double minLowerBound, double maxLowerBound) {
        if (lowerBound >= minLowerBound && upperBound <= maxLowerBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound value is out of range.");
        }
    }

}
