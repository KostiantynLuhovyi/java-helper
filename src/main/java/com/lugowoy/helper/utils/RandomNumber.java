package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.math.BigDecimal;
import java.util.Random;

/**
 * The class provides functionality to generate pseudo-random numeric values of
 * all primitive numeric data types.
 * <p>
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 3.0
 */
public class RandomNumber {

    /**
     * The default zero value to generating pseudo-random number.
     */
    public static final int ZERO = BigDecimal.ZERO.intValue();

    private final Random random;
    private final RandomDataGenerator randomGenerator;

    /**
     * Constructs an object of this class to generate pseudo-random numeric
     * values of all primitive data types.
     *
     * @since 3.0
     */
    public RandomNumber() {
        this.random = new Random();
        this.randomGenerator = new RandomDataGenerator();
    }

    /**
     * Generates a pseudo-random number of byte type in the range from {@link
     * Byte#MIN_VALUE} (inclusive) to {@link Byte#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type byte.
     *
     * @see RandomNumber#generateInt(int, int)
     */
    public byte generateByte() {
        return this.generateByte(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of byte type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} value (inclusive).
     *
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type byte.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} value out of
     * range from {@link RandomNumber#ZERO} to {@code upperBound} value.
     * @see RandomNumber#generateInt(int, int)
     */
    public byte generateByte(final byte upperBound) {
        return this.generateByte((byte) ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of byte type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type byte.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Byte#MIN_VALUE} to {@link Byte#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     * @see RandomNumber#generateInt(int, int)
     */
    public byte generateByte(final byte lowerBound, final byte upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Byte.MIN_VALUE,
                                        Byte.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Byte.MIN_VALUE,
                                        Byte.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return (byte) this.generateInt(lowerBound, upperBound);
    }

    /**
     * Generates a pseudo-random number of short type in the range from {@link
     * Short#MIN_VALUE} (inclusive) to {@link Short#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type short.
     *
     * @see RandomNumber#generateInt(int, int)
     */
    public short generateShort() {
        return this.generateShort(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of short type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type short.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} value out of
     * range from {@link RandomNumber#ZERO} to {@code upperBound} value.
     * @see RandomNumber#generateInt(int, int)
     */
    public short generateShort(final short upperBound) {
        return this.generateShort((short) ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of short type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type short.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Short#MIN_VALUE} to {@link Short#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     * @see RandomNumber#generateInt(int, int)
     */
    public short generateShort(final short lowerBound, final short upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Short.MIN_VALUE,
                                        Short.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Short.MIN_VALUE,
                                        Short.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return (short) this.generateInt(lowerBound, upperBound);
    }

    /**
     * Generates a pseudo-random number of int type in the range from {@link
     * Integer#MIN_VALUE} (inclusive) to {@link Integer#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type int.
     */
    public int generateInt() {
        return this.generateInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of int type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type int.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} value out of
     * range from {@link RandomNumber#ZERO} to {@code upperBound}.
     */
    public int generateInt(final int upperBound) {
        return this.generateInt(ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of int type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type int.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     */
    public int generateInt(final int lowerBound, final int upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return this.randomGenerator.nextInt(lowerBound, upperBound);
    }

    /**
     * Generates a pseudo-random number of long type in the range from {@link
     * Long#MIN_VALUE} (inclusive) to {@link Long#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type long.
     */
    public long generateLong() {
        return this.generateLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of long type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type long.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} out of range
     * from {@link RandomNumber#ZERO} to {@code upperBound}.
     */
    public long generateLong(final long upperBound) {
        return this.generateLong(ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of long type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type long.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     */
    public long generateLong(final long lowerBound, final long upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Long.MIN_VALUE,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Long.MIN_VALUE,
                                        Long.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return this.randomGenerator.nextLong(lowerBound, upperBound);
    }

    /**
     * Generates a pseudo-random number of float type in the range from {@link
     * Float#MIN_VALUE} (inclusive) to {@link Float#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type float.
     */
    public float generateFloat() {
        return this.generateFloat(Float.MIN_VALUE, Float.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of float type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param upperBound the upper upperBound value to generate number.
     *
     * @return the generated pseudo-random number of type float.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} out of range
     * from {@link RandomNumber#ZERO} to {@code upperBound}.
     */
    public float generateFloat(final float upperBound) {
        return this.generateFloat(ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of float type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type float.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Float#MIN_VALUE} to {@link Float#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     */
    public float generateFloat(final float lowerBound, final float upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Float.MIN_VALUE,
                                        Float.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Float.MIN_VALUE,
                                        Float.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return this.random.nextFloat() * (upperBound - lowerBound) + lowerBound;
    }

    /**
     * Generates a pseudo-random number of double type in the range from {@link
     * Double#MIN_VALUE} (inclusive) to {@link Double#MAX_VALUE} (inclusive).
     *
     * @return the generated pseudo-random number of type double.
     */
    public double generateDouble() {
        return this.generateDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    /**
     * Generates a pseudo-random number of double type in the range from {@link
     * BigDecimal#ZERO} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type double.
     *
     * @throws BoundOutOfRangeException if the {@code upperBound} out of range
     * from {@link RandomNumber#ZERO} to {@code upperBound}.
     */
    public double generateDouble(final double upperBound) {
        return this.generateDouble(ZERO, upperBound);
    }

    /**
     * Generates a pseudo-random number of double type in the range from {@code
     * lowerBound} (inclusive) to {@code upperBound} (inclusive).
     *
     * @param lowerBound the lower bound value to generate number.
     * @param upperBound the upper bound value to generate number.
     *
     * @return the generated pseudo-random number of type double.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} greater or equal
     * than {@code upperBound}.
     */
    public double generateDouble(final double lowerBound,
                                 final double upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerBound, upperBound);
        return this.random.nextDouble() * (upperBound - lowerBound)
                + lowerBound;
    }

}
