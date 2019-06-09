package com.lugowoy.helper.other;

/**
 * <p> Created by LugowoyKonstantin on 08.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.6.6
 */
//todo add doc's
public interface CheckerLength {

    //todo add doc's (from 0 to Integer.Max)
    static boolean checkLength(int length) {
        if (length > 0 && length < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

    //todo add doc's (from 0 to upperLength)
    static boolean checkLength(int length, int upperLength) {
        if (length > 0 && length < upperLength) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

    //todo add doc's (from lowerLength to upperLength)
    static boolean checkLength(int length, int lowerLength, int upperLength) {
        if (length > lowerLength && length < upperLength) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

}
