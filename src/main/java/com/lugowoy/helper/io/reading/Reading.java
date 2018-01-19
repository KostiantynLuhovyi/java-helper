package com.lugowoy.helper.io.reading;

/**
 * Created by Konstantin Lugowoy on 25.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The interface declares a contract to implement the reading of different data.
 * </p>
 */

public interface Reading {

    /**
     * <p>
     * Reading data by byte type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    byte readByte();

    /**
     * <p>
     * Reading data by short type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    short readShort();

    /**
     * <p>
     * Reading data by int type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    int readInt();

    /**
     * <p>
     * Reading data by long type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    long readLong();

    /**
     * <p>
     * Reading data by char type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    char readChar();

    /**
     * <p>
     * Reading data by float type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    float readFloat();

    /**
     * <p>
     * Reading data by double type.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    double readDouble();

    /**
     * <p>
     * Reading strings.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    String readString();

}
