package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;

/**
 * This class provides functions for reading data for the length of the array.
 * <p>
 * Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 2.1
 * @since 1.0
 */
//TODO review documentation
public final class ReaderArrayLength {

    public static final String MSG_ENTER_ARRAY_LENGTH =
            "Enter length of the array : ";

    private static final String MSG_READER_IS_NULL = "reader is null";
    private static final String MSG_WRITER_IS_NULL = "writer is null";
    private static final String MSG_INPUT_STREAM_IS_NULL =
            "inputStream is null";
    private static final String MSG_OUTPUT_STREAM_IS_NULL =
            "outputStream is null";
    private static final String MSG_MESSAGE_IS_NULL = "message is null";

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @return the read length(size) value ({@code int}) for an array.
     * @throws NullPointerException if the {@code reader} is {@code null}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public int read(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        int resultLengthArray = 0;
        try {
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultLengthArray;
    }

    public int read(@NotNull final InputStream inputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.read(new InputStreamReader(inputStream));
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the
     * read value.
     * @return the read length(size) value ({@code int}) for an array.
     * @throws NullPointerException if the {@code reader} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public int read(@NotNull final Reader reader, final int upperBoundLength) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        int resultLengthArray = 0;
        try {
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                upperBoundLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultLengthArray;
    }

    public int read(@NotNull final InputStream inputStream,
                    final int upperBoundLength) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.read(new InputStreamReader(inputStream), upperBoundLength);
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param writer the stream for outputting a message prior to read the
     * length(size) value.
     * @param msgWriter the text message to output by {@code outputStream}
     * stream.
     * @return the read length(size) value ({@code int}) for an array.
     * @throws NullPointerException if at least one of the arguments is {@code
     * null}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    public int read(@NotNull final Reader reader, @NotNull final Writer writer,
                    @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultLengthArray = 0;
        try {
            writer.write(msgWriter);
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultLengthArray;
    }

    public int read(@NotNull final InputStream inputStream,
                    @NotNull final OutputStream outputStream,
                    @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.read(new InputStreamReader(inputStream),
                         new OutputStreamWriter(outputStream), msgOutputStream);
    }

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @param upperBoundLength the upper bound length(size) value to check the
     * read value.
     * @param writer the stream for outputting a message prior to read the
     * length(size) value.
     * @param msgWriter the text message to output by {@code outputStream}
     * stream.
     * @return the read length(size) value ({@code int)} for an array.
     * @throws NullPointerException if at least one of the arguments is {@code
     * null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundLength} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link Capacity#LOWER} to {@code
     * upperBoundLength}.
     */
    public int read(@NotNull final Reader reader, final int upperBoundLength,
                    @NotNull final Writer writer,
                    @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultLengthArray = 0;
        try {
            writer.write(msgWriter);
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                upperBoundLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultLengthArray;
    }

    public int read(@NotNull final InputStream inputStream,
                    final int upperBoundLength,
                    @NotNull final OutputStream outputStream,
                    @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.read(new InputStreamReader(inputStream), upperBoundLength,
                         new OutputStreamWriter(outputStream), msgOutputStream);
    }

}
