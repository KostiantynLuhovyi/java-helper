package com.lugowoy.helper.other;

import com.lugowoy.helper.reading.Reading;

/**
 * Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 18.12.2017
 * <p>
 *     A class that performs static functionality to implement the selection of the size of the array to create.
 * </p>
 */
public class SizeOfArray {

    /**
     * <p>Default size of an array.</p>
     */
    public static final int DEFAULT_SIZE_OF_ARRAY = 5;

    /**
     * <p>
     *     Returns the size of an array.
     * </p>
     * @param reader The object to read the size value of the array.
     */
    public static int getSizeOfArray(Reading reader) {
        int sizeArray;
        if (reader != null) {
            sizeArray = reader.readInt();
            if (sizeArray <= 0) {
                sizeArray = DEFAULT_SIZE_OF_ARRAY;
            }
        } else {
            sizeArray = DEFAULT_SIZE_OF_ARRAY;
        }
        return sizeArray;
    }

    /**
     * <p>
     *     Returns the size of an array.
     * </p>
     * @param reader The object to read the size value of the array.
     * @param boundSizeOfArray Value to determine the maximum size bound of the array.
     */
    public static int getSizeOfArray(Reading reader, int boundSizeOfArray) throws IllegalArgumentException {
        int sizeArray;
        if ((reader != null) && (boundSizeOfArray >= 0)) {
            sizeArray = reader.readInt();
            if ((sizeArray <= 0) || (sizeArray > boundSizeOfArray)) {
                sizeArray = DEFAULT_SIZE_OF_ARRAY;
            }
        } else {
            sizeArray = DEFAULT_SIZE_OF_ARRAY;
        }
        return sizeArray;
    }

    /**
     * <p>
     *     Returns the size of an array.
     * </p>
     * @param reader The object to read the size value of the array.
     * @param minBoundSizeOfArray Value to determine the minimum size bound of the array.
     * @param maxBoundSizeOfArray Value to determine the maximum size bound of the array.
     */
    public static int getSizeOfArray(Reading reader, int minBoundSizeOfArray, int maxBoundSizeOfArray) throws IllegalArgumentException {
        int sizeArray;
        if ((reader != null) && ((minBoundSizeOfArray >= 0) && (maxBoundSizeOfArray >= 0))) {
            if (minBoundSizeOfArray < maxBoundSizeOfArray) {
                sizeArray = reader.readInt();
                if ((sizeArray <= minBoundSizeOfArray) || (sizeArray >= maxBoundSizeOfArray)) {
                    sizeArray = DEFAULT_SIZE_OF_ARRAY;
                }
            } else {
                sizeArray = DEFAULT_SIZE_OF_ARRAY;
            }
        } else {
            sizeArray = DEFAULT_SIZE_OF_ARRAY;
        }
        return sizeArray;
    }

}
