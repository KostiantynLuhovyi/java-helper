package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerNumber;

import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class reads data entered into the console.
 * <p>Created by Konstantin Lugowoy on 07.11.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 3.0
 */
//TODO review documentation
public class ReaderConsole {

    private final Scanner scanner = new Scanner(System.in,
                                                Charset.defaultCharset());

    /**
     * Reads a {@code byte} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public byte readByte() {
        return this.readByte(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    public byte readByte(final byte lowerBound, final byte upperBound) {
        byte resultByteRead = this.scanner.nextByte();
        CheckerNumber.check(resultByteRead, lowerBound, upperBound);
        return resultByteRead;
    }

    /**
     * Reads a {@code short} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public short readShort() {
        return this.readShort(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    public short readShort(final short lowerBound, final short upperBound) {
        short resultIntRead = this.scanner.nextShort();
        CheckerNumber.check(resultIntRead, lowerBound, upperBound);
        return resultIntRead;
    }

    /**
     * Reads a {@code int} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public int readInt() {
        return this.readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int readInt(final int lowerBound, final int upperBound) {
        int resultIntRead = this.scanner.nextInt();
        CheckerNumber.check(resultIntRead, lowerBound, upperBound);
        return resultIntRead;
    }

    /**
     * Reads a {@code long} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public long readLong() {
        return this.readLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public long readLong(final long lowerBound, final long upperBound) {
        long resultLongRead = this.scanner.nextLong();
        CheckerNumber.check(resultLongRead, lowerBound, upperBound);
        return resultLongRead;
    }

    /**
     * Reads a {@code char} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public char readChar() {
        char resultCharRead;
        try {
            resultCharRead = (char) this.scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "The value is not a valid byte type number from "
                    + Character.MIN_VALUE + " to " + Character.MAX_VALUE, ex);
        }
        return resultCharRead;
    }

    /**
     * Reads a {@code float} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public float readFloat() {
        return this.readFloat(Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public float readFloat(final float lowerBound, final float upperBound) {
        float resultFloatRead = this.scanner.nextFloat();
        CheckerNumber.check(resultFloatRead, lowerBound, upperBound);
        return resultFloatRead;
    }

    /**
     * Reads a {@code double} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If input is exhausted.
     * @throws IllegalStateException If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is
     * out of range.
     */
    public double readDouble() {
        return this.readDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public double readDouble(final double lowerBound, final double upperBound) {
        double resultDoubleRead = this.scanner.nextDouble();
        CheckerNumber.check(resultDoubleRead, lowerBound, upperBound);
        return resultDoubleRead;
    }


    /**
     * Reads a {@link String} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If no line was found.
     * @throws IllegalStateException If this scanner is closed.
     */
    public String readString() {
        String resultStringRead = "";
        if (this.scanner.hasNextLine()) {
            resultStringRead = this.scanner.nextLine();
        }
        return resultStringRead;
    }


}
