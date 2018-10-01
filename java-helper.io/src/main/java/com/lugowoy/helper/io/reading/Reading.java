package com.lugowoy.helper.io.reading;

/**
 * Created by Konstantin Lugowoy on 25.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The interface declares a contract to implement the reading of different data.
 */

public interface Reading {

    /**
     * Reading data by byte type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    byte readByte();

    /**
     * Reading data by short type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    short readShort();

    /**
     * Reading data by int type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    int readInt();

    /**
     * Reading data by long type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    long readLong();

    /**
     * Reading data by char type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    char readChar();

    /**
     * Reading data by float type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    float readFloat();

    /**
     * Reading data by double type.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    double readDouble();

    /**
     * Reading strings.
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    String readString();

}
