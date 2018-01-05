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
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    byte readByte();

    /**
     * <p>
     * Reading data by short type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    short readShort();

    /**
     * <p>
     * Reading data by int type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    int readInt();

    /**
     * <p>
     * Reading data by long type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    long readLong();

    /**
     * <p>
     * Reading data by char type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    char readChar();

    /**
     * <p>
     * Reading data by float type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    float readFloat();

    /**
     * <p>
     * Reading data by double type.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    double readDouble();

    /**
     * <p>
     * Reading strings.
     * </p>
     * @since 1.0
     *
     * @return Returns the result of reading.
     */
    String readString();

}
