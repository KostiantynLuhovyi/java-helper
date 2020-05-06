package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.io.reading.Reading;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * This class provides functions for reading data for the length of the array.
 * <p>
 * Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 1.0
 */
public final class ReaderLengthArray {

    private static final String MSG_EXC_READER_IS_NULL =
            "Input not possible. Reader is null.";
    private static final String MSG_EXC_OUTPUT_STREAM_IS_NULL =
            "OutputStream is null.";

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     *
     * @return the read length(size) value ({@code int}) for an array.
     *
     * @throws NullPointerException if the {@code reader} is {@code null}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static int read(@NotNull final Reading reader) {
        Objects.requireNonNull(reader, MSG_EXC_READER_IS_NULL);
        int resultLengthArray = reader.readInt();
        CheckerNumber.check(resultLengthArray, CheckerArray.LOWER_BOUND_LENGTH,
                            CheckerArray.UPPER_BOUND_LENGTH);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the
     * read value.
     *
     * @return the read length(size) value ({@code int}) for an array.
     *
     * @throws NullPointerException if the {@code reader} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code
     * upperBoundLength}.
     */
    public static int read(@NotNull final Reading reader,
                           final int upperBoundLength) {
        Objects.requireNonNull(reader, MSG_EXC_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength,
                                        CheckerArray.LOWER_BOUND_LENGTH,
                                        CheckerArray.UPPER_BOUND_LENGTH);
        int resultLengthArray = reader.readInt();
        CheckerNumber.check(resultLengthArray, CheckerArray.LOWER_BOUND_LENGTH,
                            upperBoundLength);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param outputStream the stream for outputting a message prior to read the
     * length(size) value.
     * @param msgOutputStream the text message to output by {@code outputStream}
     * stream.
     *
     * @return the read length(size) value ({@code int}) for an array.
     *
     * @throws NullPointerException if at least one of the arguments is {@code
     * null}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     */
    public static int read(@NotNull final Reading reader,
                           @NotNull final OutputStream outputStream,
                           final String msgOutputStream) {
        Objects.requireNonNull(reader, MSG_EXC_READER_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_EXC_OUTPUT_STREAM_IS_NULL);
        try {
            outputStream.write(msgOutputStream.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int resultLengthArray = reader.readInt();
        CheckerNumber.check(resultLengthArray, CheckerArray.LOWER_BOUND_LENGTH,
                            CheckerArray.UPPER_BOUND_LENGTH);
        return resultLengthArray;
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the
     * read value.
     * @param outputStream the stream for outputting a message prior to read the
     * length(size) value.
     * @param msgOutputStream the text message to output by {@code outputStream}
     * stream.
     *
     * @return the read length(size) value ({@code int)} for an array.
     *
     * @throws NullPointerException if at least one of the arguments is {@code
     * null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@link
     * CheckerArray#UPPER_BOUND_LENGTH}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link CheckerArray#LOWER_BOUND_LENGTH} to {@code
     * upperBoundLength}.
     */
    public static int read(@NotNull final Reading reader,
                           final int upperBoundLength,
                           @NotNull final OutputStream outputStream,
                           final String msgOutputStream) {
        Objects.requireNonNull(reader, MSG_EXC_READER_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_EXC_OUTPUT_STREAM_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength,
                                        CheckerArray.LOWER_BOUND_LENGTH,
                                        CheckerArray.UPPER_BOUND_LENGTH);
        try {
            outputStream.write(msgOutputStream.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int resultLengthArray = reader.readInt();
        CheckerNumber.check(resultLengthArray, CheckerArray.LOWER_BOUND_LENGTH,
                            upperBoundLength);
        return resultLengthArray;
    }

}
