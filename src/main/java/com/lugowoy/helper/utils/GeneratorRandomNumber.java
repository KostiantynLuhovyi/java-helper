package com.lugowoy.helper.utils;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

/**
 * The class with static functionality to generate pseudo-random number.
 * <p>Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 */
public class GeneratorRandomNumber {

    private static final Random RANDOM = new Random();
    private static final RandomDataGenerator RANDOM_GENERATOR = new RandomDataGenerator();

    private static final int VALUE_ZERO = 0;
    private static final int SCALE = 3;

    /**
     * Generate a pseudo-random {@code byte} number in the range
     * from {@link Byte#MIN_VALUE} (inclusive) to {@link Byte#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code byte} type pseudo-random number
     * in the range from {@link Byte#MIN_VALUE} to {@link Byte#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateByte(byte, byte)
     */
    public static byte generateByte() {
        return generateByte(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code byte} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound} (inclusive).
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Byte#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code byte} type.
     * @return The generated {@code double} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateByte(byte, byte)
     */
    public static byte generateByte(byte bound) {
        return generateByte((byte) VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code byte} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range of values from {@link Byte#MIN_VALUE}
     * to {@link Byte#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code byte} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code byte} type.
     * @return The generated {@code byte} type pseudo-random number in the range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static byte generateByte(byte lowerBound, byte upperBound) {
        byte resultValue = 0;
        if (isBoundValueInRange(lowerBound, Byte.MIN_VALUE, Byte.MAX_VALUE)
                && isBoundValueInRange(upperBound, Byte.MIN_VALUE, Byte.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                resultValue = (byte) generateInt(lowerBound, upperBound);
            }
        }
        return resultValue;
    }

    /**
     * Generate a pseudo-random {@code short} number in the range
     * from {@link Short#MIN_VALUE} (inclusive) to {@link Short#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code short} type pseudo-random number
     * in the range from {@link Short#MIN_VALUE} to {@link Short#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateShort(short, short)
     */
    public static short generateShort() {
        return generateShort(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code short} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound} (inclusive).
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Short#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code short} type.
     * @return The generated {@code short} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateShort(short, short)
     */
    public static short generateShort(short bound) {
        return generateShort((short) VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code short} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range
     * of values from {@link Short#MIN_VALUE} to {@link Short#MAX_VALUE} respectively,
     * otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code short} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code short} type.
     * @return The generated {@code short} type pseudo-random number
     * in the argument range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static short generateShort(short lowerBound, short upperBound) {
        short resultValue = 0;
        if (isBoundValueInRange(lowerBound, Short.MIN_VALUE, Short.MAX_VALUE)
                && isBoundValueInRange(upperBound, Short.MIN_VALUE, Short.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                resultValue = (short) RANDOM_GENERATOR.nextInt(lowerBound, upperBound);
            }
        }
        return resultValue;
    }

    /**
     * Generate a pseudo-random {@code int} number in the range
     * from {@link Integer#MIN_VALUE} (inclusive) to {@link Integer#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code int} type pseudo-random number
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateInt(int, int)
     */
    public static int generateInt() {
        return generateInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code int} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound} (inclusive).
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Integer#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code int} type.
     * @return The generated {@code int} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateInt(int, int)
     */
    public static int generateInt(int bound) {
        return generateInt(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code int} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range of values from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} respectively, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code int} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code int} type.
     * @return The generated {@code int} type pseudo-random number
     * in the argument range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static int generateInt(int lowerBound, int upperBound) {
        int resultValue = 0;
        if (isBoundValueInRange(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                && isBoundValueInRange(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                return RANDOM_GENERATOR.nextInt(lowerBound, upperBound);
            }
        }
        return resultValue;
    }

    /**
     * Generate a pseudo-random {@code long} number in the range
     * from {@link Long#MIN_VALUE} (inclusive) to {@link Long#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code long} type pseudo-random number
     * in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateLong(long, long)
     */
    public static long generateLong() {
        return generateLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code long} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound} (inclusive).
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Long#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code long} type.
     * @return The generated {@code long} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateLong(long, long)
     */
    public static long generateLong(long bound) {
        return generateLong(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code long} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range of values from {@link Long#MIN_VALUE}
     * to {@link Long#MAX_VALUE} respectively, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code long} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code long} type.
     * @return The generated {@code long} type pseudo-random number
     * in the argument range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static long generateLong(long lowerBound, long upperBound) {
        long resultValue = 0L;
        if (isBoundValueInRange(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                && isBoundValueInRange(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                resultValue = RANDOM_GENERATOR.nextLong(lowerBound, upperBound);
            }
        }
        return resultValue;
    }

    /**
     * Generate a pseudo-random {@code float} number in the range
     * from {@link Integer#MIN_VALUE} (inclusive) to {@link Integer#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code float} pseudo-random number
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateFloat(float, float)
     */
    public static float generateFloat() {
        return generateFloat(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code float} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound}.
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Integer#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code float} type.
     * @return The generated {@code float} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateFloat(float, float)
     */
    public static float generateFloat(float bound) {
        return generateFloat(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code float} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range of values from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} respectively, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code float} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code float} type.
     * @return The generated {@code float} type pseudo-random number
     * in the argument range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static float generateFloat(float lowerBound, float upperBound) {
        float resultValue = 0F;
        if (isBoundValueInRange(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                && isBoundValueInRange(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                resultValue = RANDOM.nextFloat() * (upperBound - lowerBound) + lowerBound;
            }
        }
        return resultValue;
    }

    /**
     * Generate a pseudo-random {@code double} number in the range
     * from {@link Integer#MIN_VALUE} (inclusive) to {@link Integer#MAX_VALUE} (inclusive).
     *
     * @return The generated {@code double} type pseudo-random number
     * in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @see GeneratorRandomNumber#generateDouble(double, double)
     */
    public static double generateDouble() {
        return generateDouble(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random positive {@code double} number in the range
     * from {@link GeneratorRandomNumber#VALUE_ZERO} (inclusive) to argument {@code bound} (inclusive).
     * <p>Argument {@code bound} must be within the range of values from {@link GeneratorRandomNumber#VALUE_ZERO}
     * to {@link Integer#MAX_VALUE}, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param bound The bound value for generating pseudo-random numbers of {@code double} type.
     * @return The generated {@code double} type pseudo-random number
     * in the range from {@link GeneratorRandomNumber#VALUE_ZERO} to argument {@code bound}.
     * @throws BoundOutOfRangeException If the {@code bound} value is out of range values.
     * @see GeneratorRandomNumber#generateDouble(double, double)
     */
    public static double generateDouble(double bound) {
        return generateDouble(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random {@code double} number in the range
     * from {@code lowerBound} (inclusive) to {@code upperBound} (inclusive).
     * <p>Arguments {@code lowerBound} and {@code upperBound} must be within the range of values from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE} respectively, otherwise {@link BoundOutOfRangeException} exception will be thrown.
     * Also, the value of the {@code lowerBound} argument must be less than or equal to the value of {@code upperBound}.
     * If these conditions are not met, a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lowerBound The lower bound value for generating pseudo-random numbers of {@code double} type.
     * @param upperBound The upper bound value for generating pseudo-random numbers of {@code double} type.
     * @return The generated {@code double} type pseudo-random number
     * in the argument range from {@code lowerBound} to {@code upperBound}.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} value is out of range values.
     * @throws BoundOutOfRangeException If {@code lowerBound} value is greater or not equal than the {@code upperBound} value.
     */
    public static double generateDouble(double lowerBound, double upperBound) {
        double resultValue = 0D;
        if (isBoundValueInRange(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                && isBoundValueInRange(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            if (isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound)) {
                resultValue = RANDOM.nextDouble() * (upperBound - lowerBound) + lowerBound;
            }
        }
        return resultValue;
    }

    private static boolean isBoundValueInRange(long bound, long minBound, long maxBound) {
        if (bound >= minBound && bound <= maxBound) {
            return true;
        } else {
            String msgEx = "Bound (" + bound + ") value is out of range (" + minBound + " - " + maxBound + ").";
            throw new BoundOutOfRangeException(msgEx);
        }
    }

    private static boolean isBoundValueInRange(double bound, double minBound, double maxBound) {
        if (bound >= minBound && bound <= maxBound) {
            return true;
        } else {
            String msgEx = "Bound (" + bound + ") value is out of range (" + minBound + " - " + maxBound + ").";
            throw new BoundOutOfRangeException(msgEx);
        }
    }

    private static boolean isLowerBoundLessOrEqualUpperBound(long lowerBound, long upperBound) {
        if (lowerBound <= upperBound) {
            return true;
        } else {
            String msgEx = "Lower bound (" + lowerBound + ") value is greater than the upper bound (" + upperBound + ") value.";
            throw new BoundOutOfRangeException(msgEx);
        }
    }

    private static boolean isLowerBoundLessOrEqualUpperBound(double lowerBound, double upperBound) {
        if (lowerBound <= upperBound) {
            return true;
        } else {
            String msgEx = "Lower bound (" + lowerBound + ") value is greater than the upper bound (" + upperBound + ") value.";
            throw new BoundOutOfRangeException(msgEx);
        }
    }

}
