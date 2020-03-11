package com.lugowoy.helper.utils;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * This interafce contains functionality for reading data about the length of the array.
 * <p> Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @since 1.0
 */
public final class ArrayLengthReader {

    /**
     * Reads the length(size) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     *
     * @return the read length(size) for an array.
     *
     * @throws NullPointerException if {@code reader} is null.
     * @throws LengthArrayOutOfRangeException if the read length(size) for an array out of valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static int readLength(final Reading reader) {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the read value.
     *
     * @return the read length(size) for an array.
     *
     * @throws NullPointerException if {@code reader} is null.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} out of range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws LengthArrayOutOfRangeException if the read length(size) for an array out of valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@code upperBoundLength}.
     */
    public static int readLength(final Reading reader, final int upperBoundLength) {
        int resultLengthArray;
        Objects.requireNonNull(reader, "Input is not possible. Reader must not be null.");
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param outputStream the stream for outputting a message prior to read the length(size) value.
     * @param msgOutputStream the text message to output by {@code outputStream} stream.
     *
     * @return the read length(size) for an array.
     *
     * @throws NullPointerException if at least one of the arguments is null.
     * @throws IOException if an I/O error occurs.
     * @throws LengthArrayOutOfRangeException if the read length(size) for an array out of valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static int readLength(Reading reader, OutputStream outputStream, String msgOutputStream) throws IOException {
        Objects.requireNonNull(reader, MSG_EXCEPTION_READER_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_EXCEPTION_OUTPUT_STREAM_IS_NULL);
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the read value.
     * @param outputStream the stream for outputting a message prior to read the length(size) value.
     * @param msgOutputStream the text message to output by {@code outputStream} stream.
     *
     * @return the read length(size) for an array.
     *
     * @throws NullPointerException if at least one of the arguments is null.
     * @throws IOException if an I/O error occurs.
     * @throws LengthArrayOutOfRangeException if the read length(size) for an array out of valid range
     * from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public static int readLength(Reading reader, int upperBoundLength,
                                 OutputStream outputStream, String msgOutputStream) throws IOException {
        Objects.requireNonNull(reader, MSG_EXCEPTION_READER_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_EXCEPTION_OUTPUT_STREAM_IS_NULL);
        CheckerBound.isCorrectBound(upperBoundLength, CheckerArray.UPPER_BOUND_LENGTH_ARRAY);
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

}
