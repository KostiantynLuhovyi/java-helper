package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

/**
 * Interface with static functionality for reading and providing data about the length of the array.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.0
 */
public interface LengthReader {

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @return The result of the length of an array.
     * @throws NullPointerException If reader is null.
     * @throws LengthValueOutOfRangeException If result length array value is incorrect.
     */
    static int readLength(Reading reader) {
        int resultLengthArray;
        isReaderNull(reader);
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        return resultLengthArray;
    }

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @param boundLengthValue An argument whose value indicates the maximum allowable length of the array.
     * @return The result of the length of an array.
     * @throws NullPointerException If reader is null.
     * @throws BoundOutOfRangeException If bound value is incorrect.
     * @throws LengthValueOutOfRangeException If result length array value is incorrect.
     */
    static int readLength(Reading reader, int boundLengthValue) {
        int resultLengthArray;
        isReaderNull(reader);
        isBoundValueGreaterZero(boundLengthValue);
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        isLengthValueLessBoundValue(resultLengthArray, boundLengthValue);
        return resultLengthArray;
    }

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @param lowerBoundLengthValue An argument whose value indicates the lower allowable length of the array.
     * @param upperBoundLengthValue An argument whose value indicates the upper allowable length of the array.
     * @return The result of the length of an array.
     * @throws NullPointerException If reader is null.
     * @throws BoundOutOfRangeException If bound value is incorrect.
     * @throws LengthValueOutOfRangeException If result length array value is incorrect.
     */
    static int readLength(Reading reader, int lowerBoundLengthValue, int upperBoundLengthValue) {
        int resultLengthArray;
        isReaderNull(reader);
        isMaxBoundValueGreaterMinBoundValue(lowerBoundLengthValue, upperBoundLengthValue);
        isBoundValueGreaterZero(lowerBoundLengthValue);
        //todo Consider the possibility of adding a method for checking the max bound value less than the max int.
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        isLengthValueGreaterOrEqualMinBoundValue(resultLengthArray, lowerBoundLengthValue);
        isLengthValueLessOrEqualMaxBoundValue(resultLengthArray, upperBoundLengthValue);
        return resultLengthArray;
    }

    private static void isReaderNull(Reading reader) {
        if (reader == null) {
            throw new NullPointerException("Input is not possible. Reader is : " + null);
        }
    }

    private static void isLengthValueGreaterZero(int lengthValue) {
        if (lengthValue < 0) {
            throw new LengthValueOutOfRangeException("Incorrect length array : " + lengthValue + ". Value less than 0.");
        }
    }

    private static void isBoundValueGreaterZero(int boundValue) {
        if (boundValue < 0) {
            throw new BoundOutOfRangeException("Incorrect bound value : " + boundValue + ". Bound value less than 0.");
        }
    }

    private static void isLengthValueLessBoundValue(int lengthValue, int boundValue) {
        if (lengthValue > boundValue) {
            throw new LengthValueOutOfRangeException("Incorrect value of length array. Length array value greater than bound value.");
        }
    }

    private static void isMaxBoundValueGreaterMinBoundValue(int minBoundValue, int maxBoundValue) {
        if (minBoundValue >= maxBoundValue) {
            throw new BoundOutOfRangeException("Incorrect bound values. Min bound value greater or equal than max bound value.");
        }
    }

    private static void isLengthValueLessOrEqualMaxBoundValue(int lengthValue, int maxBoundValue) {
        if (lengthValue > maxBoundValue) {
            throw new LengthValueOutOfRangeException("Incorrect length array. Length array value greater than max bound value.");
        }
    }

    private static void isLengthValueGreaterOrEqualMinBoundValue(int lengthValue, int minBoundValue) {
        if (lengthValue < minBoundValue) {
            throw new LengthValueOutOfRangeException("Incorrect length array. Length array value less than min bound value.");
        }
    }

}
