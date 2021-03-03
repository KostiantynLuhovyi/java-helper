package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 02.02.2021.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.8
 */
//TODO write documentation
public final class ReaderMatrixLength {

    public static final String MSG_ENTER_MATRIX_ROWS =
            "Enter rows of the matrix : ";
    public static final String MSG_ENTER_MATRIX_COLUMNS =
            "Enter columns of the matrix : ";

    private static final String MSG_READER_IS_NULL = "reader is null";
    private static final String MSG_WRITER_IS_NULL = "writer is null";
    private static final String MSG_INPUT_STREAM_IS_NULL =
            "inputStream is null";
    private static final String MSG_OUTPUT_STREAM_IS_NULL =
            "outputStream is null";
    private static final String MSG_MESSAGE_IS_NULL = "message is null";

    //TODO Streams are not closed in methods after use.
    // Decide how to describe it or how to close them.

    public int readRows(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        int resultRowsMatrix = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultRowsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultRowsMatrix, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultRowsMatrix;
    }

    public int readRows(@NotNull final InputStream inputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.readRows(new InputStreamReader(inputStream));
    }

    public int readRows(@NotNull final Reader reader,
                        final int upperBoundRows) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        int resultRowsMatrix = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultRowsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultRowsMatrix, Capacity.LOWER.get(),
                                upperBoundRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultRowsMatrix;
    }

    public int readRows(@NotNull final InputStream inputStream,
                        final int upperBoundLength) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.readRows(new InputStreamReader(inputStream),
                             upperBoundLength);
    }

    public int readRows(@NotNull final Reader reader,
                        @NotNull final Writer writer,
                        @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultRowsMatrix = 0;
        try {
            writer.write(msgWriter);
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultRowsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultRowsMatrix, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultRowsMatrix;
    }

    public int readRows(@NotNull final InputStream inputStream,
                        @NotNull final OutputStream outputStream,
                        @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.readRows(new InputStreamReader(inputStream),
                             new OutputStreamWriter(outputStream),
                             msgOutputStream);
    }

    public int readRows(@NotNull final Reader reader, final int upperBoundRows,
                        @NotNull final Writer writer,
                        @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultRowsMatrix = 0;
        try {
            writer.write(msgWriter);
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultRowsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultRowsMatrix, Capacity.LOWER.get(),
                                upperBoundRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultRowsMatrix;
    }

    public int readRows(@NotNull final InputStream inputStream,
                        final int upperBoundRows,
                        @NotNull final OutputStream outputStream,
                        @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.readRows(new InputStreamReader(inputStream), upperBoundRows,
                             new OutputStreamWriter(outputStream),
                             msgOutputStream);
    }

    public int readColumns(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        int resultColumnsMatrix = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultColumnsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultColumnsMatrix, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultColumnsMatrix;
    }

    public int readColumns(@NotNull final InputStream inputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.readColumns(new InputStreamReader(inputStream));
    }

    public int readColumns(@NotNull final Reader reader,
                           final int upperBoundColumns) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundColumns, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        int resultColumnsMatrix = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultColumnsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultColumnsMatrix, Capacity.LOWER.get(),
                                upperBoundColumns);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultColumnsMatrix;
    }

    public int readColumns(@NotNull final InputStream inputStream,
                           final int upperBoundLength) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        return this.readRows(new InputStreamReader(inputStream),
                             upperBoundLength);
    }

    public int readColumns(@NotNull final Reader reader,
                           @NotNull final Writer writer,
                           @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultColumnsMatrix = 0;
        try {
            writer.write(msgWriter);
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultColumnsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultColumnsMatrix, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultColumnsMatrix;
    }

    public int readColumns(@NotNull final InputStream inputStream,
                           @NotNull final OutputStream outputStream,
                           @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.readColumns(new InputStreamReader(inputStream),
                                new OutputStreamWriter(outputStream),
                                msgOutputStream);
    }

    public int readColumns(@NotNull final Reader reader,
                           final int upperBoundColumns,
                           @NotNull final Writer writer,
                           @NotNull final String msgWriter) {
        Objects.requireNonNull(reader, MSG_READER_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundColumns, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        Objects.requireNonNull(writer, MSG_WRITER_IS_NULL);
        Objects.requireNonNull(msgWriter, MSG_MESSAGE_IS_NULL);
        int resultColumnsMatrix = 0;
        try {
            writer.write(msgWriter);
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(reader);
            resultColumnsMatrix = Integer.parseInt(bufferedReader.readLine());
            CheckerNumber.check(resultColumnsMatrix, Capacity.LOWER.get(),
                                upperBoundColumns);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultColumnsMatrix;
    }

    public int readColumns(@NotNull final InputStream inputStream,
                           final int upperBoundColumns,
                           @NotNull final OutputStream outputStream,
                           @NotNull final String msgOutputStream) {
        Objects.requireNonNull(inputStream, MSG_INPUT_STREAM_IS_NULL);
        Objects.requireNonNull(outputStream, MSG_OUTPUT_STREAM_IS_NULL);
        return this.readColumns(new InputStreamReader(inputStream),
                                upperBoundColumns,
                                new OutputStreamWriter(outputStream),
                                msgOutputStream);
    }

}