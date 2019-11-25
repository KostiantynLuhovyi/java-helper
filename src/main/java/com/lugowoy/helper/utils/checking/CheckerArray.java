package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;

import java.util.Objects;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.6.6
 */
//todo write doc's
public final class CheckerArray {

    private static final String MSG_ARRAY_IS_NULL = "Array must not be null.";

    public static final int LOWER_BOUND_LENGTH_ARRAY = 0;

    private static final int ARRAY_HEADER = 8;

    public static final int UPPER_BOUND_LENGTH_ARRAY = Integer.MAX_VALUE - ARRAY_HEADER;

    private CheckerArray() {
    }

    public static boolean checkLengthInArray(final AbstractArray array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    public static boolean checkLengthInArray(final AbstractArray array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        boolean resultCheckLengthInArray = false;
        if (checkUpperBoundLengthInArray(upperBoundLength)) {
            if (array.size() <= upperBoundLength) {
                resultCheckLengthInArray = true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        }
        return resultCheckLengthInArray;
    }

    public static <T> boolean checkLengthInArray(final T[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    public static <T> boolean checkLengthInArray(final T[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        boolean resultCheckLengthInArray = false;
        if (checkUpperBoundLengthInArray(upperBoundLength)) {
            if (array.length <= upperBoundLength) {
                resultCheckLengthInArray = true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        }
        return resultCheckLengthInArray;
    }

    public static boolean checkLengthInArray(final int[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    public static boolean checkLengthInArray(final int[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        boolean resultCheckLengthInArray = false;
        if (checkUpperBoundLengthInArray(upperBoundLength)) {
            if (array.length <= upperBoundLength) {
                resultCheckLengthInArray = true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        }
        return resultCheckLengthInArray;
    }

    public static boolean checkLengthInArray(final double[] array) {
        return checkLengthInArray(array, Integer.MAX_VALUE);
    }

    public static boolean checkLengthInArray(final double[] array, final int upperBoundLength) {
        Objects.requireNonNull(array, MSG_ARRAY_IS_NULL);
        boolean resultCheckLengthInArray = false;
        if (checkUpperBoundLengthInArray(upperBoundLength)) {
            if (array.length <= upperBoundLength) {
                resultCheckLengthInArray = true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        }
        return resultCheckLengthInArray;
    }

    public static boolean checkLengthArray(final int lengthArray) {
        return checkLengthArray(lengthArray, Integer.MAX_VALUE);
    }

    public static boolean checkLengthArray(final int lengthArray, final int upperBoundLength) {
        boolean resultCheckLengthArray = false;
        if (checkUpperBoundLengthInArray(upperBoundLength)) {
            if (lengthArray >= LOWER_BOUND_LENGTH_ARRAY && lengthArray <= upperBoundLength) {
                resultCheckLengthArray = true;
            } else {
                throw new LengthArrayOutOfRangeException();
            }
        }
        return resultCheckLengthArray;
    }

    private static boolean checkUpperBoundLengthInArray(final int upperBoundLengthInArray) {
        boolean resultCheckUpperBound = false;
        if (CheckerBound.isCorrectBound(upperBoundLengthInArray, LOWER_BOUND_LENGTH_ARRAY, UPPER_BOUND_LENGTH_ARRAY)) {
            resultCheckUpperBound = true;
        }
        return resultCheckUpperBound;
    }

}
