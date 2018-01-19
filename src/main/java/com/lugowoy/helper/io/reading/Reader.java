package com.lugowoy.helper.io.reading;

/**
 * Created by Konstantin Lugowoy on 26.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 * A class is a container that encapsulates a specific implementation of a functional to read different data.
 * </p>
 *
 * @see com.lugowoy.helper.io.reading.Reading
 */

public class Reader implements Reading {

    private final Reading reading;

    private Reader(final Reading reading) {
        this.reading = reading;
    }

    /**
     * <p>
     * Read data by byte type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public byte readByte() {
        return this.reading.readByte();
    }

    /**
     * <p>
     * Read data by short type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public short readShort() {
        return this.reading.readShort();
    }

    /**
     * <p>
     * Read data by int type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public int readInt() {
        return this.reading.readInt();
    }

    /**
     * <p>
     * Read data by long type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public long readLong() {
        return this.reading.readLong();
    }

    /**
     * <p>
     * Read data by char type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public char readChar() {
        return this.reading.readChar();
    }

    /**
     * <p>
     * Read data by float type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public float readFloat() {
        return this.reading.readFloat();
    }

    /**
     * <p>
     * Read data by double type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public double readDouble() {
        return this.reading.readDouble();
    }

    /**
     * <p>
     * Read data by String type by delegating execution to an encapsulated object.
     * </p>
     *
     * @return Returns the result of reading.
     *
     * @since 1.0
     */
    @Override
    public String readString() {
        return this.reading.readString();
    }

    /**
     * <p>
     * A method that initializes the created object with a specific implementation of the functional to read different data
     *  and return new object of class Reader.
     * </p>
     *
     * @param reading Specific implementation of the functional to read different data.
     *                 The parameter must implement the interface Reading.
     *
     * @see com.lugowoy.helper.io.reading.Reading
     *
     * @return A new object of this class encapsulating a specific implementation of the functional to read different data.
     *
     * @since 1.1
     */
    public static Reader getReader(final Reading reading) {
        return new Reader(reading);
    }

}
