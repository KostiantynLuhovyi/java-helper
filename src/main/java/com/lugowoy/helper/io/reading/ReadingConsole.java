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
     * @since 1.0
     */
    @Override
    public byte readByte() {
        return this.getCorrectByteNumberValue(CheckerReading::isByteNumber);
    }

    /**
     * Reading data by short type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public short readShort() {
        return this.getCorrectShortNumberValue(CheckerReading::isShortNumber);
    }

    /**
     * Reading data by int type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public int readInt() {
        return this.getCorrectIntNumberValue(CheckerReading::isIntegerNumber);
    }

    /**
     * Reading data by long type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public long readLong() {
        return this.getCorrectLongNumberValue(CheckerReading::isLongNumber);
    }

    /**
     * Reading data by char type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public char readChar() {
        return this.getCorrectCharacterValue(CheckerReading::isOnlyCharacter);
    }

    /**
     * Reading data by float type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public float readFloat() {
        return this.getCorrectFloatNumberValue(CheckerReading::isFloatNumber);
    }

    /**
     * Reading data by double type from the console.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public double readDouble() {
        return this.getCorrectDoubleNumberValue(CheckerReading::isDoubleNumber);
    }

    /**
     * Reading data by String type from the console.
     *
     * @return Returns the result of reading.
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

    private byte getCorrectByteNumberValue(final CheckerReading checkerReading) {
        byte resultByteInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultByteInputValue = Byte.parseByte(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultByteInputValue = this.getCorrectByteNumberValue(checkerReading);
        }
        return resultByteInputValue;
    }

    private short getCorrectShortNumberValue(final CheckerReading checkerReading) {
        short resultShortInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultShortInputValue = Short.parseShort(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultShortInputValue = this.getCorrectByteNumberValue(checkerReading);
        }
        return resultShortInputValue;
    }

    private int getCorrectIntNumberValue(final CheckerReading checkerReading) {
        int resultIntInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultIntInputValue = Integer.parseInt(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultIntInputValue = this.getCorrectIntNumberValue(checkerReading);
        }
        return resultIntInputValue;
    }

    private long getCorrectLongNumberValue(final CheckerReading checkerReading) {
        long resultLongInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultLongInputValue = Long.parseLong(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultLongInputValue = this.getCorrectLongNumberValue(checkerReading);
        }
        return resultLongInputValue;
    }

    private char getCorrectCharacterValue(final CheckerReading checkerReading) {
        char resultCharacterValue;

        String value = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(value)) {
            resultCharacterValue = value.charAt(0);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultCharacterValue = this.getCorrectCharacterValue(checkerReading);
        }
        return resultCharacterValue;
    }

    private float getCorrectFloatNumberValue(final CheckerReading checkerReading) {
        float resultFloatInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultFloatInputValue = Float.parseFloat(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultFloatInputValue = this.getCorrectFloatNumberValue(checkerReading);
        }
        return resultFloatInputValue;
    }

    private double getCorrectDoubleNumberValue(final CheckerReading checkerReading) {
        double resultDoubleInputValue;

        String inputValue = SCANNER.nextLine().trim();

        if (checkerReading.isCorrectData(inputValue)) {
            resultDoubleInputValue = Double.parseDouble(inputValue);
        } else {
            System.out.println("Incorrect data entered.");
            System.out.println("Re-enter : ");
            resultDoubleInputValue = this.getCorrectDoubleNumberValue(checkerReading);
        }
        return resultDoubleInputValue;
    }

}
