package com.lugowoy.helper.utils;

import com.lugowoy.helper.io.reading.Reading;

import static com.lugowoy.helper.utils.CheckerLengthArray.checkLengthArray;

/**
 * Interface with static functionality for reading and providing data about the length of the array.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
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
        checkLengthArray(resultLengthArray);
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
        checkLengthArray(resultLengthArray, upperBoundLength);
        return resultLengthArray;
    }

    private static void isReaderNull(Reading reader) {
        if (reader == null) {
            throw new NullPointerException("Input is not possible. Reader is null.");
        }
    }

}
