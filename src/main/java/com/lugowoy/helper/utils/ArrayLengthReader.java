package com.lugowoy.helper.utils;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Interface with static functionality for reading and providing data about the length of the array.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.0
 */
//todo edit doc's
public final class ArrayLengthReader {

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @return The result of the length of an array.
     * @throws NullPointerException           If reader is null.
     * @throws LengthArrayOutOfRangeException If result length array value is incorrect.
     */
    public static int readLength(final Reading reader) {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray);
        return resultLengthArray;
    }

    /**
     * Read and returns the length of an array.
     *
     * @param reader           The object to read the length value.
     * @param upperBoundLength An argument whose value indicates the maximum allowable length of the array.
     * @return The result of the length of an array.
     * @throws NullPointerException           If reader is null.
     * @throws BoundOutOfRangeException       If bound value is incorrect.
     * @throws LengthArrayOutOfRangeException If result length array value is incorrect.
     */
    public static int readLength(final Reading reader, final int upperBoundLength) {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

    public static int readLength(final Reading reader, final OutputStream outputStream, final String msgOutputStream) throws IOException {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        Objects.requireNonNull(outputStream, "OutputStream must not be null.");
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray);
        return resultLengthArray;
    }

    public static int readLength(final Reading reader, final int upperBoundLength,
                                 final OutputStream outputStream, final String msgOutputStream) throws IOException {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        Objects.requireNonNull(outputStream, "OutputStream must not be null.");
        CheckerBound.isCorrectBound(upperBoundLength, Integer.MAX_VALUE);
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

}
