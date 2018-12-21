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
    static int getlengthArray(final Reading reader) {
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
     * @param boundlengthArray Value to determine the maximum length bound of the array.
     */
    static int getlengthArray(final Reading reader, final int boundlengthArray) {
        int lengthArray;
        if ((reader != null) && (boundlengthArray >= 0)) {
            lengthArray = reader.readInt();
            if ((lengthArray <= 0) || (lengthArray > boundlengthArray)) {
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
     * @param minBoundlengthArray Value to determine the minimum length bound of the array.
     * @param maxBoundlengthArray Value to determine the maximum length bound of the array.
     */
    static int getlengthArray(final Reading reader, final int minBoundlengthArray, final int maxBoundlengthArray) {
        int lengthArray;
        if ((reader != null) && ((minBoundlengthArray >= 0) && (maxBoundlengthArray >= 0))) {
            if (minBoundlengthArray < maxBoundlengthArray) {
                lengthArray = reader.readInt();
                if ((lengthArray <= minBoundlengthArray) || (lengthArray >= maxBoundlengthArray)) {
                    lengthArray = DEFAULT_LENGTH_OF_ARRAY;
                }
            } else {
                lengthArray = DEFAULT_LENGTH_OF_ARRAY;
            }
        } else {
            lengthArray = DEFAULT_LENGTH_OF_ARRAY;
        }
        return lengthArray;
    }

}
