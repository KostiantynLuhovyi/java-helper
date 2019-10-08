package com.lugowoy.helper.io.reading;

/**
 * The interface declared a contract for implementing the reading of various data from a specific source.
 * <p>Created by Konstantin Lugowoy on 25.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 */
public interface Reading {

    /**
     * Reads a {@code byte} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    byte readByte();

    /**
     * Reads a {@code short} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    short readShort();

    /**
     * Reads a {@code int} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    int readInt();

    /**
     * Reads a {@code long} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    long readLong();

    /**
     * Reads a {@code char} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    char readChar();

    /**
     * Reads a {@code float} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    float readFloat();

    /**
     * Reads a {@code double} type value
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    double readDouble();

    /**
     * Reads a {@link String} type value.
     *
     * @return Returns the result of reading.
     * @since 1.0
     */
    String readString();

}
