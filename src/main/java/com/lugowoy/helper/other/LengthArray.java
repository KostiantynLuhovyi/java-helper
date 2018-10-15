package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

/**
 * Interface that performs static functionality to implement the selection of the length of the array to create.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
public interface LengthArray {

    /**
     * Default length of an array.
     */
    int DEFAULT_LENGTH_OF_ARRAY = 10;

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     */
    static int getLengthOfArray(final Reading reader) {
        int lengthArray;
        if (reader != null) {
            lengthArray = reader.readInt();
            if (lengthArray <= 0) {
                lengthArray = DEFAULT_LENGTH_OF_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_OF_ARRAY;
        }
        return lengthArray;
    }

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     * @param boundLengthOfArray Value to determine the maximum length bound of the array.
     */
    static int getLengthOfArray(final Reading reader, final int boundLengthOfArray) {
        int lengthArray;
        if ((reader != null) && (boundLengthOfArray >= 0)) {
            lengthArray = reader.readInt();
            if ((lengthArray <= 0) || (lengthArray > boundLengthOfArray)) {
                lengthArray = DEFAULT_LENGTH_OF_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_OF_ARRAY;
        }
        return lengthArray;
    }

    /**
     * Returns the length of an array.
     *
     * @param reader The object to read the length value of the array.
     * @param minBoundLengthOfArray Value to determine the minimum length bound of the array.
     * @param maxBoundLengthOfArray Value to determine the maximum length bound of the array.
     */
    static int getLengthOfArray(final Reading reader, final int minBoundLengthOfArray, final int maxBoundLengthOfArray) {
        int lengthOfArray;
        if ((reader != null) && ((minBoundLengthOfArray >= 0) && (maxBoundLengthOfArray >= 0))) {
            if (minBoundLengthOfArray < maxBoundLengthOfArray) {
                lengthOfArray = reader.readInt();
                if ((lengthOfArray <= minBoundLengthOfArray) || (lengthOfArray >= maxBoundLengthOfArray)) {
                    lengthOfArray = DEFAULT_LENGTH_OF_ARRAY;
                }
            } else {
                lengthOfArray = DEFAULT_LENGTH_OF_ARRAY;
            }
        } else {
            lengthOfArray = DEFAULT_LENGTH_OF_ARRAY;
        }
        return lengthOfArray;
    }

}
