package com.lugowoy.helper.filling.array;

import static java.util.Objects.nonNull;

/**
 * Created by Konstantin Lugowoy on 12-Dec-17.
 * //TODO Put it in a separate package when the class hierarchy is developed. Then the documentation will be written.
 */
//todo Написать внятную реализацию и документацию функционала.
public class Checker {

    public static boolean checkNonNullArray(Number[] array) throws IllegalArgumentException {
        if (nonNull(array)) {
            return true;
        } else {
            throw new IllegalArgumentException("The reference to the array passed to the method is \"null\".");
        }
    }

    public static boolean checkValueOfLengthArray(int lengthArray) {
        if (lengthArray > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The value of the length (size) of the array passed to the method is equal to or less than 0.");
        }
    }

    public static boolean checkBound(Number bound) {
        if (bound.doubleValue() > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The boundary value passed to the method is equal to or less than 0.");
        }
    }

    public static boolean checkMinBoundAndMaxBound(Number minBound, Number maxBound) {
        if (minBound.doubleValue() < maxBound.doubleValue()) {
            return true;
        } else {
            throw new IllegalArgumentException("The minimum boundary value passed to the method is equal to or greater than the value of the maximum boundary.");
        }
     }

}