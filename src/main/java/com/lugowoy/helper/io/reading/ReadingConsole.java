package com.lugowoy.helper.io.reading;

import com.lugowoy.helper.utils.ValueOutOfRangeException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class reads data entered into the console.
 * This is an implementation of the contract declared in the {@link Reading} interface.
 * <p>Created by Konstantin Lugowoy on 25.07.2017
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.io.reading.Reading
 * @since 1.0
 */
public class ReadingConsole implements Reading {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Reads a {@code byte} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @see Scanner#nextByte()
     * @since 1.0
     */
    @Override
    public byte readByte() {
        byte resultByteRead;
        try {
            resultByteRead = SCANNER.nextByte();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a byte number or is out of range (from " + Byte.MIN_VALUE
                                                                                             + " to " + Byte.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultByteRead;
    }

    /**
     * Reads a {@code short} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @see Scanner#nextShort()
     * @since 1.0
     */
    @Override
    public short readShort() {
        short resultShortRead;
        try {
            resultShortRead = SCANNER.nextShort();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a short number or is out of range (from " + Short.MIN_VALUE
                                                                                              + " to " + Short.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultShortRead;
    }

    /**
     * Reads a {@code int} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @see Scanner#nextInt()
     * @since 1.0
     */
    @Override
    public int readInt() {
        int resultIntRead;
        try {
            resultIntRead = SCANNER.nextInt();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a int number or is out of range (from " + Integer.MIN_VALUE
                                                                                            + " to " + Integer.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultIntRead;
    }

    /**
     * Reads a {@code long} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @see Scanner#nextLong()
     * @since 1.0
     */
    @Override
    public long readLong() {
        long resultLongRead;
        try {
            resultLongRead = SCANNER.nextLong();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a long number or is out of range (from " + Long.MIN_VALUE
                                                                                             + " to " + Long.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultLongRead;
    }

    /**
     * Reads a {@code char} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @see Scanner#nextInt()
     * @since 1.0
     */
    @Override
    public char readChar() {
        char resultCharRead;
        try {
            resultCharRead = (char) SCANNER.nextInt();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a char or is out of range (from " + Character.MIN_VALUE
                                                                                      + " to " + Character.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultCharRead;
    }

    /**
     * Reads a {@code float} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @since 1.0
     */
    @Override
    public float readFloat() {
        float resultFloatRead;
        try {
            resultFloatRead = SCANNER.nextFloat();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a float number or is out of range (from " + Float.MIN_VALUE
                                                                                              + " to " + Float.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultFloatRead;
    }

    /**
     * Reads a {@code double} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException   If input is exhausted.
     * @throws IllegalStateException    If this scanner is closed.
     * @throws ValueOutOfRangeException If the reading value is not number or is out of range.
     * @since 1.0
     */
    @Override
    public double readDouble() {
        double resultDoubleRead;
        try {
            resultDoubleRead = SCANNER.nextDouble();
        } catch (InputMismatchException ex) {
            throw new ValueOutOfRangeException("Value is not a double or is out of range (from " + Double.MIN_VALUE
                                                                                        + " to " + Double.MAX_VALUE + ").");
        } finally {
            SCANNER.close();
        }
        return resultDoubleRead;
    }

    /**
     * Reads a {@link String} type value from the console.
     *
     * @return Returns the result of reading.
     * @throws NoSuchElementException If no line was found.
     * @throws IllegalStateException  If this scanner is closed.
     * @since 1.0
     */
    @Override
    public String readString() {
        String resultStringRead;
        try {
            resultStringRead = SCANNER.nextLine();
        } finally {
            SCANNER.close();
        }
        return resultStringRead;
    }

}
