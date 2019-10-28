package com.lugowoy.helper.utils;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerLengthArray;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface with static functionality for reading and providing data about the length of the array.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.0
 */
//todo edit doc's
public interface LengthArrayReader {

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @return The result of the length of an array.
     * @throws NullPointerException           If reader is null.
     * @throws LengthArrayOutOfRangeException If result length array value is incorrect.
     */
    static int readLength(Reading reader) {
        int resultLengthArray;
        isReaderNull(reader);
        resultLengthArray = reader.readInt();
        CheckerLengthArray.checkLengthArray(resultLengthArray);
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
    static int readLength(Reading reader, int upperBoundLength) {
        int resultLengthArray;
        isReaderNull(reader);
        resultLengthArray = reader.readInt();
        CheckerLengthArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

    static int readLength(Reading reader, OutputStream outputStream, String msgOutputStream) throws IOException {
        int resultLengthArray;
        isReaderNull(reader);
        isOutputStreamNull(outputStream);
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerLengthArray.checkLengthArray(resultLengthArray);
        return resultLengthArray;
    }

    static int readLength(Reading reader, int upperBoundLength, OutputStream outputStream, String msgOutputStream) throws IOException {
        int resultLengthArray;
        isReaderNull(reader);
        isOutputStreamNull(outputStream);
        CheckerBound.isCorrectBounds(upperBoundLength);
        outputStream.write(msgOutputStream.getBytes());
        resultLengthArray = reader.readInt();
        CheckerLengthArray.checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

    private static void isReaderNull(Reading reader) {
        if (reader == null) {
            throw new NullPointerException("Input is not possible. Reader is null.");
        }
    }

    private static void isOutputStreamNull(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("Output stream is null.");
        }
    }

}
