package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

/**
 * Interface that performs static functionality to implement the selection of the length of the array to create.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 */
public interface ArrayLength {

    /**
     * Default length of an array.
     */
    int DEFAULT_LENGTH_ARRAY = 10;

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     */
    static int getLengthArray(final Reading reader) {
        int lengthArray;
        if (reader != null) {
            lengthArray = reader.readInt();
            if (lengthArray <= 0) {
                lengthArray = DEFAULT_LENGTH_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_ARRAY;
        }
        return lengthArray;
    }

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     * @param boundLengthArray Value to determine the maximum length bound of the array.
     */
    static int getLengthArray(final Reading reader, final int boundLengthArray) {
        int lengthArray;
        if ((reader != null) && (boundLengthArray >= 0)) {
            lengthArray = reader.readInt();
            if ((lengthArray <= 0) || (lengthArray > boundLengthArray)) {
                lengthArray = DEFAULT_LENGTH_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_ARRAY;
        }
        return lengthArray;
    }

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     * @param minBoundLengthArray Value to determine the minimum length bound of the array.
     * @param maxBoundLengthArray Value to determine the maximum length bound of the array.
     */
    static int getLengthArray(final Reading reader, final int minBoundLengthArray, final int maxBoundLengthArray) {
        int lengthArray;
        if ((reader != null) && ((minBoundLengthArray >= 0) && (maxBoundLengthArray >= 0))) {
            if (minBoundLengthArray < maxBoundLengthArray) {
                lengthArray = reader.readInt();
                if ((lengthArray <= minBoundLengthArray) || (lengthArray >= maxBoundLengthArray)) {
                    lengthArray = DEFAULT_LENGTH_ARRAY;
                }
            } else {
                lengthArray = DEFAULT_LENGTH_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_ARRAY;
        }
        return lengthArray;
    }

}
