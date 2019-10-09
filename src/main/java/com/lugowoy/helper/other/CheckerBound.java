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

public interface CheckerBound {

    static boolean checkBound(int bound) {
        if (bound > 0 && bound < Integer.MAX_VALUE) {
            return true;
        } else {
            throw new BoundOutOfRangeException("The argument bound out of range.");
        }
    }

    static boolean checkBound(int bound, int upperBound) {
        if (bound > 0 && bound < upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("The argument bound out of range.");
        }
    }

    static boolean checkLength(int bound, int lowerBound, int upperBound) {
        if (bound > lowerBound && bound < upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("The argument bound out of range.");
        }
    }

}
