package com.lugowoy.helper.io.reading;

import java.util.Scanner;

/**
 * The class implements the contract declared in the interface by reading different data from the console.
 * <p>Created by Konstantin Lugowoy on 25.07.2017
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.io.reading.Reading
 * @since 1.0
 */
public class ReadingConsole implements Reading {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Reading data by byte type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public byte readByte() {
        return this.getCorrectByteNumberValue(ReadingChecker::isByteNumber);
    }

    /**
     * Reading data by short type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public short readShort() {
        return this.getCorrectShortNumberValue(ReadingChecker::isShortNumber);
    }

    /**
     * Reading data by int type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public int readInt() {
        return this.getCorrectIntNumberValue(ReadingChecker::isIntegerNumber);
    }

    /**
     * Reading data by long type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public long readLong() {
        return this.getCorrectLongNumberValue(ReadingChecker::isLongNumber);
    }

    /**
     * Reading data by char type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public char readChar() {
        return this.getCorrectCharacterValue(ReadingChecker::isOnlyCharacter);
    }

    /**
     * Reading data by float type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public float readFloat() {
        return this.getCorrectFloatNumberValue(ReadingChecker::isFloatNumber);
    }

    /**
     * Reading data by double type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public double readDouble() {
        return this.getCorrectDoubleNumberValue(ReadingChecker::isDoubleNumber);
    }

    /**
     * Reading data by String type from the console.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public String readString() {
        String value = "";
        if (SCANNER.hasNextLine()) {
            value = SCANNER.nextLine();
        }
        return value.trim();
    }

    private byte getCorrectByteNumberValue(final ReadingChecker readingChecker) {
        byte resultByteInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultByteInputValue = Byte.parseByte(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultByteInputValue = this.getCorrectByteNumberValue(readingChecker);
        }
        return resultByteInputValue;
    }

    private short getCorrectShortNumberValue(final ReadingChecker readingChecker) {
        short resultShortInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultShortInputValue = Short.parseShort(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultShortInputValue = this.getCorrectByteNumberValue(readingChecker);
        }
        return resultShortInputValue;
    }

    private int getCorrectIntNumberValue(final ReadingChecker readingChecker) {
        int resultIntInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultIntInputValue = Integer.parseInt(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultIntInputValue = this.getCorrectIntNumberValue(readingChecker);
        }
        return resultIntInputValue;
    }

    private long getCorrectLongNumberValue(final ReadingChecker readingChecker) {
        long resultLongInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultLongInputValue = Long.parseLong(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultLongInputValue = this.getCorrectLongNumberValue(readingChecker);
        }
        return resultLongInputValue;
    }

    private char getCorrectCharacterValue(final ReadingChecker readingChecker) {
        char resultCharacterValue;

        String value = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(value)) {
            resultCharacterValue = value.charAt(0);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultCharacterValue = this.getCorrectCharacterValue(readingChecker);
        }
        return resultCharacterValue;
    }

    private float getCorrectFloatNumberValue(final ReadingChecker readingChecker) {
        float resultFloatInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultFloatInputValue = Float.parseFloat(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultFloatInputValue = this.getCorrectFloatNumberValue(readingChecker);
        }
        return resultFloatInputValue;
    }

    private double getCorrectDoubleNumberValue(final ReadingChecker readingChecker) {
        double resultDoubleInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (readingChecker.isCorrect(inputValue)) {
            resultDoubleInputValue = Double.parseDouble(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultDoubleInputValue = this.getCorrectDoubleNumberValue(readingChecker);
        }
        return resultDoubleInputValue;
    }

}
