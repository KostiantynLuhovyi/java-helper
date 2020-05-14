package com.lugowoy.helper.utils;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerString;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class provides functionality for generating pseudorandom objects of the
 * {@link String} class from character from the store.
 * <p>
 * Created by Konstantin Lugowoy on 21.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
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
     * Creates an object of the {@link String} class of length as the value
     * {@code lengthString} from the pseudo-random characters contained in the
     * {@code characters} array. The maximum length of the created string is
     * {@link Integer#MAX_VALUE}.
     *
     * @param characters the array of characters from which the string creates.
     * @param lengthString the length of created string.
     *
     * @return the created string.
     *
     * @throws NullPointerException if the {@code characters} array is {@code
     * null}.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from 0 to {@link Integer#MAX_VALUE}.
     */
    public String create(final int lengthString,
                         @NotNull final char... characters) {
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
     * Creates an object of the {@link String} calss with a length as a
     * pseudo-random number ranging from {@code lowerLengthString}(inclusive) to
     * {@code upperLengthString}(inclusive) and containing pseudo-random
     * characters contained in the {@code characters} array. The maximum length
     * of the created string is {@link Integer#MAX_VALUE}.
     *
     * @param characters the array of characters from which the string creates.
     * @param lowerLengthString the lower boundary length value of string.
     * @param upperLengthString the upper boundary length value of string.
     *
     * @return the created string.
     *
     * @throws NullPointerException if the {@code characters} array is {@code
     * null}.
     * @throws BoundOutOfRangeException if the any of boundary arguments out of
     * range from 0 to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if the {@code lowerLengthString}
     * greater or equal than {@code upperLengthString}.
     * @throws LengthOutOfRangeException if the {@code lengthString} value out
     * of range from 0 to {@link Integer#MAX_VALUE}.
     */
    public String create(final int lowerLengthString,
                         final int upperLengthString,
                         @NotNull final char... characters) {
        CheckerBoundNumber.checkInRange(lowerLengthString, Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperLengthString, Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        int randLength = new RandomNumber().generateInt(lowerLengthString,
                                                        upperLengthString);
        return this.create(randLength, characters);
    }

}
