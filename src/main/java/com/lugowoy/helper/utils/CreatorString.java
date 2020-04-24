package com.lugowoy.helper.utils;

import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerString;

import java.util.Objects;

/**
 * The class provides functionality for generating pseudorandom objects of the {@link String} class.
 * <p> Created by Konstantin Lugowoy on 21.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 3.0
 */
public final class CreatorString {

    /**
     * Constructs an object of this class.
     */
    public CreatorString() {
    }

    /**
     * Creates a string of length as a {@code lengthString} argument
     * from the pseudo-random characters contained in the {@code characters} array.
     *
     * @param characters the array of characters from which the string creates.
     * @param lengthString the length of created string.
     *
     * @return the created string.
     *
     * @throws NullPointerException if the {@code characters} array is null.
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value
     * out of range from 0 to {@link Integer#MAX_VALUE}.
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value out of correct range.
     * @see Objects#requireNonNull(Object)
     * @see CheckerString#checkLengthString(int)
     * @see CheckerString#checkLengthString(int)
     */
    public String create(final char[] characters, final int lengthString) {
        CheckerString.checkLengthString(lengthString);
        Objects.requireNonNull(characters);
        StringBuilder stringBuilder = new StringBuilder();
        RandomNumber random = new RandomNumber();
        for (int i = 0; i < lengthString; i++) {
            stringBuilder.append(characters[random.generateInt(characters.length - 1)]);
        }
        return stringBuilder.toString();
    }

    /**
     * Creates a string with a length as a pseudo-random number ranging
     * from {@code lowerBoundLength} to {@code upperBoundLength}
     * and containing pseudo-random characters contained in the {@code characters} array.
     *
     * @param characters the array of characters from which the string creates.
     * @param lowerBoundLength the lower boundary length value of string.
     * @param upperBoundLength the upper boundary length value of string.
     *
     * @return the created string
     *
     * @throws BoundOutOfRangeException if the any of boundary arguments
     * out of range from 0 to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if the {@code lowerBoundLength} greater
     * or equal than {@code upperBoundLength}.
     * @throws NullPointerException if the {@code characters} array is null.
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value
     * out of range from 0 to {@link Integer#MAX_VALUE}.
     * @throws LengthStringOutOfRangeException if the {@code lengthString} value out of correct range.
     * @see CheckerBound#isCorrectBound(Number, Number)
     * @see CheckerBound#isLowerBoundLessUpperBound(Number, Number)
     * @see CreatorString#create(char[], int)
     * @see CreatorString#create(char[], int)
     * @see CheckerString#checkLengthString(int)
     */
    public String create(final char[] characters, final int lowerBoundLength, final int upperBoundLength) {
        CheckerBound.isCorrectBound(lowerBoundLength, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundLength, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundLength, upperBoundLength);
        int randomLengthString = new RandomNumber().generateInt(lowerBoundLength, upperBoundLength);
        return this.create(characters, randomLengthString);
    }

}
