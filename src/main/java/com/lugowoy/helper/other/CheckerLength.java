package com.lugowoy.helper.other;

/**
 * <p> Created by LugowoyKonstantin on 08.06.2019
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.6.6
 */

//todo refactoring code
//todo edit doc's

public interface CheckerLength {

    static boolean checkLength(int length) {
        if (length > 0 && length < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

    static boolean checkLength(int length, int upperLength) {
        if (length > 0 && length < upperLength) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

    static boolean checkLength(int length, int lowerLength, int upperLength) {
        if (length > lowerLength && length < upperLength) {
            return true;
        } else {
            throw new LengthValueOutOfRangeException("The argument length out of range.");
        }
    }

}
