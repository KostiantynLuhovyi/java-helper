package com.lugowoy.helper.io.reading;

/**
 * The class is a container that encapsulates a specific implementation of a functional to read different data.
 * The execution of functionality is delegated to the class object implementing the contract of the {@link Reading} interface,
 * which is initialized when an object of this class is created.
 * <p>Created by Konstantin Lugowoy on 26.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.io.reading.Reading
 * @since 1.0
 */
public class Reader implements Reading {

    private final Reading reading;

    public Reader(Reading reading) {
        this.reading = reading;
    }

    /**
     * Reads a {@code byte} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public byte readByte() {
        return this.reading.readByte();
    }

    /**
     * Reads a {@code short} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public short readShort() {
        return this.reading.readShort();
    }

    /**
     * Reads a {@code int} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public int readInt() {
        return this.reading.readInt();
    }

    /**
     * Reads a {@code long} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public long readLong() {
        return this.reading.readLong();
    }

    /**
     * Reads a {@code char} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public char readChar() {
        return this.reading.readChar();
    }

    /**
     * Reads a {@code float} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public float readFloat() {
        return this.reading.readFloat();
    }

    /**
     * Reads a {@code double} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public double readDouble() {
        return this.reading.readDouble();
    }

    /**
     * Reads a {@link String} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    @Override
    public String readString() {
        return this.reading.readString();
    }

}
