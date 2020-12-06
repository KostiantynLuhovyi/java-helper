package com.lugowoy.helper.utils;

import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class reads data entered into the console.
 * <p>Created by Konstantin Lugowoy on 07.11.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
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
        byte resultByteRead = 0;
        try {
            resultByteRead = this.scanner.nextByte();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "The value is not a valid byte type number from "
                    + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE, ex);
        }
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
        short resultShortRead;
        try {
            resultShortRead = this.scanner.nextShort();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "The value is not a valid byte type number from "
                    + Short.MIN_VALUE + " to " + Short.MAX_VALUE, ex);
        }
        return resultShortRead;
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
        int resultIntRead;
        try {
            resultIntRead = this.scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "The value is not a valid byte type number from "
                    + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE, ex);
        }
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
        long resultLongRead;
        try {
            resultLongRead = this.scanner.nextLong();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "The value is not a valid byte type number from "
                    + Long.MIN_VALUE + " to " + Long.MAX_VALUE, ex);
        }
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
        float resultFloatRead;
        try {
            resultFloatRead = this.scanner.nextFloat();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "Value is not a float number or is out of range (from "
                    + Float.MIN_VALUE + " to " + Float.MAX_VALUE + ").");
        }
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
        double resultDoubleRead;
        try {
            resultDoubleRead = this.scanner.nextDouble();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException(
                    "Value is not a double or is out of range (from "
                    + Double.MIN_VALUE + " to " + Double.MAX_VALUE + ").");
        }
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
