package com.lugowoy.helper.utils;

import com.lugowoy.helper.utils.checking.CheckerBound;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

/**
 * The class provides functionality to generate values of all primitive numeric data types.
 * <p> Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
public class RandomNumber {

    private final Random random = new Random();
    private final RandomDataGenerator randomGenerator = new RandomDataGenerator();

    private static final int VALUE_ZERO = 0;

    /**
     * Generate a pseudo-random number of byte type in the range
     * from {@link Byte#MIN_VALUE}(inclusive) to {@link Byte#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type byte.
     */
    public byte generateByte() {
        return this.generateByte(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of byte type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type byte.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public byte generateByte(byte bound) {
        return this.generateByte((byte) VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of byte type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type byte.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Byte#MIN_VALUE} to {@link Byte#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public byte generateByte(byte lowerBound, byte upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Byte.MIN_VALUE, Byte.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Byte.MIN_VALUE, Byte.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return (byte) this.generateInt(lowerBound, upperBound);
    }

    /**
     * Generate a pseudo-random number of short type in the range
     * from {@link Short#MIN_VALUE}(inclusive) to {@link Short#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type short.
     */
    public short generateShort() {
        return this.generateShort(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of short type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type short.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public short generateShort(short bound) {
        return this.generateShort((short) VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of short type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type short.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Short#MIN_VALUE} to {@link Short#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public short generateShort(short lowerBound, short upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Short.MIN_VALUE, Short.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Short.MIN_VALUE, Short.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return (short) this.generateInt(lowerBound, upperBound);
    }

    /**
     * Generate a pseudo-random number of int type in the range
     * from {@link Integer#MIN_VALUE}(inclusive) to {@link Integer#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type int.
     */
    public int generateInt() {
        return this.generateInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of int type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type int.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public int generateInt(int bound) {
        return this.generateInt(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of int type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type int.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public int generateInt(int lowerBound, int upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return this.randomGenerator.nextInt(lowerBound, upperBound);
    }

    /**
     * Generate a pseudo-random number of long type in the range
     * from {@link Long#MIN_VALUE}(inclusive) to {@link Long#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type long.
     */
    public long generateLong() {
        return this.generateLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of long type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type long.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public long generateLong(long bound) {
        return this.generateLong(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of long type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type long.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public long generateLong(long lowerBound, long upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return this.randomGenerator.nextLong(lowerBound, upperBound);
    }

    /**
     * Generate a pseudo-random number of float type in the range
     * from {@link Integer#MIN_VALUE}(inclusive) to {@link Integer#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type float.
     */
    public float generateFloat() {
        return this.generateFloat(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of float type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type float.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public float generateFloat(float bound) {
        return this.generateFloat(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of float type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type float.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public float generateFloat(float lowerBound, float upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return this.random.nextFloat() * (upperBound - lowerBound) + lowerBound;
    }

    /**
     * Generate a pseudo-random number of double type in the range
     * from {@link Long#MIN_VALUE}(inclusive) to {@link Long#MAX_VALUE}(inclusive).
     *
     * @return the generated pseudo-random number of type double.
     */
    public double generateDouble() {
        return this.generateDouble(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a pseudo-random number of double type in the range
     * from {@link RandomNumber#VALUE_ZERO}(inclusive) to {@code bound}(inclusive).
     *
     * @return the generated pseudo-random number of type double.
     *
     * @throws BoundOutOfRangeException if the {@code bound} out of range from {@link RandomNumber#VALUE_ZERO} to {@code bound}.
     */
    public double generateDouble(double bound) {
        return this.generateDouble(VALUE_ZERO, bound);
    }

    /**
     * Generate a pseudo-random number of double type in the range
     * from {@code lowerBound}(inclusive) to {@code upperBound}(inclusive).
     *
     * @return the generated pseudo-random number of type double.
     *
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public double generateDouble(double lowerBound, double upperBound) {
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        return this.random.nextDouble() * (upperBound - lowerBound) + lowerBound;
    }

}
