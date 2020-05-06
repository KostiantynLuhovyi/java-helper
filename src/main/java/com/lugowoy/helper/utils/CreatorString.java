package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerString;

import java.util.Objects;

/**
 * The class provides functionality for generating pseudorandom objects of the
 * {@link String} class from character storage.
 * <p>
 * Created by Konstantin Lugowoy on 21.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 3.0
 */
public final class CreatorString {

    private RandomNumber rand;
    private StringBuffer strBuffer;

    /**
     * Constructs an object of this class.
     */
    public CreatorString() {
        this.rand = new RandomNumber();
        this.strBuffer = new StringBuffer();
    }

    /**
     * Creates a string of length as the value {@code lengthString} from the
     * pseudo-random characters contained in the {@code characters} array. The
     * maximum length of the created string is {@link Integer#MAX_VALUE}.
     *
     * @param characters the array of characters from which the string creates.
     * @param lengthString the length of created string.
     *
     * @return the created string.
     *
     * @throws NullPointerException if the {@code characters} array is {@code
     * null}.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from {@literal 0} to {@link Integer#MAX_VALUE}.
     */
    public String create(final char[] characters, final int lengthString) {
        Objects.requireNonNull(characters, "Array of characters is null.");
        CheckerString.checkLength(lengthString, 0, Integer.MAX_VALUE);
        for (int i = 0; i < lengthString; i++) {
            this.strBuffer.append(this.rand.generateInt(characters.length - 1));
        }
        String res = strBuffer.toString();
        strBuffer.delete(0, strBuffer.length() - 1);
        return res;
    }

    /**
     * Creates a string with a length as a pseudo-random number ranging from
     * {@code lowerLength} to {@code upperLength} and containing pseudo-random
     * characters contained in the {@code characters} array. The maximum length
     * of the created string is {@link Integer#MAX_VALUE}.
     *
     * @param characters the array of characters from which the string creates.
     * @param lowerLength the lower boundary length value of string.
     * @param upperLength the upper boundary length value of string.
     *
     * @return the created string.
     *
     * @throws NullPointerException if the {@code characters} array is null.
     * @throws BoundOutOfRangeException if the any of boundary arguments out of
     * range from {@literal 0} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if the {@code lowerLength} greater or
     * equal than {@code upperLength}.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from {@literal 0} to {@link Integer#MAX_VALUE}.
     */
    public String create(final char[] characters, final int lowerLength,
                         final int upperLength) {
        CheckerBoundNumber.checkInRange(lowerLength, 0, Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperLength, 0, Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessUpper(lowerLength, upperLength);
        int randLength = new RandomNumber().generateInt(lowerLength,
                                                        upperLength);
        return this.create(characters, randLength);
    }

}
