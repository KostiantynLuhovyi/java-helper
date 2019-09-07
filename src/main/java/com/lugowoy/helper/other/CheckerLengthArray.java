package com.lugowoy.helper.other;

import com.lugowoy.helper.models.Array;

/**
 * <p> Created by LugowoyKonstantin on 08.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.6.6
 */
//todo add doc's
public class CheckerLengthArray {

    //todo add doc's
    public static <T> boolean checkLengthArray(Array<T> array) {
        if (array.getLength() < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new LengthArrayOutOfRangeException("The array argument has a length value greatest than upper bound value.");
        }
    }

    //todo add doc's
    public static <T> boolean checkLengthArray(T[] tArray) {
        if (tArray.length < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new LengthArrayOutOfRangeException("The array argument has a length value greatest than upper bound value.");
        }
    }

}
