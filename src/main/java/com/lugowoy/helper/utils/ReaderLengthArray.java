package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Objects;

/**
 * This class provides functions for reading data for the length of the array.
 * <p>
 * Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @since 1.0
 */
//TODO revision of documentation
public final class ReaderLengthArray {

    private static final String MSG_READER_IS_NULL = "Reader is null.";
    private static final String MSG_WRITER_IS_NULL = "Writer is null.";

    /**
     * Reads the length(size) value ({@code int}) for an array.
     *
     * @param reader the {@code reader} to read the length(size) value.
     * @return the read length(size) value ({@code int}) for an array.
     * @throws NullPointerException if the {@code reader} is {@code null}.
     * @throws ValueOutOfRangeException if the read length(size) value for an
     * array out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    public static int read(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        int resultLengthArray = 0;
        try {
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(reader);
        }
        return resultLengthArray;
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
    public static int read(@NotNull final Reader reader,
                           final int upperBoundLength) {
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
        } finally {
            close(reader);
        }
        return resultLengthArray;
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
     * array out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    public static int read(@NotNull final Reader reader,
                           @NotNull final Writer writer,
                           @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, "Message is null.");
        int resultLengthArray = 0;
        try {
            writer.write(msgWriter);
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(writer);
            close(reader);
        }
        return resultLengthArray;
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
    public static int read(@NotNull final Reader reader,
                           final int upperBoundLength,
                           @NotNull final Writer writer,
                           @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundLength, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, "Message is null");

        int resultLengthArray = 0;
        try {
            writer.write(msgWriter);
            resultLengthArray = reader.read();
            CheckerNumber.check(resultLengthArray, Capacity.LOWER.get(),
                                upperBoundLength);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(writer);
            close(reader);
        }
        return resultLengthArray;
    }

    private static void close(@NotNull final Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void close(@NotNull final Writer writer) {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
