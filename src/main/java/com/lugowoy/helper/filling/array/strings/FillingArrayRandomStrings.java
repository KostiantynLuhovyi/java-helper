package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerString;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.CreatorString;
import com.lugowoy.helper.utils.ReaderCharacters;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.Objects;

/**
 * The class fills an object of the {@link Array} class and a classic array with
 * random an object of the {@link String} type of the random length.
 * <p>Created by Konstantin Lugowoy on 18.07.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 * @since 1.3
 */
//TODO review documentation
public class FillingArrayRandomStrings implements FillingArrayStrings<Integer> {

    private static final int DEFAULT_STRING_LENGTH = 10;

    private final ReaderCharacters readerCharacters;
    private final InputStream inputStream;
    private final CreatorString creatorString;

    /**
     * Constructs a new object of the {@link FillingArrayRandomStrings} class.
     */
    public FillingArrayRandomStrings(@NotNull final InputStream inputStream) {
        Objects.requireNonNull(inputStream, "Input stream is null");
        this.inputStream = inputStream;
        this.readerCharacters = new ReaderCharacters();
        this.creatorString = new CreatorString();
    }

    /**
     * Fills an object of the {@link Array} class with object of the {@link
     * String} type.
     *
     * @param array The object of the {@link Array} class to be filled with
     * object of the {@link String} type.
     */
    @Override
    public void fill(@NotNull final Array<String> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        String[] strings = new String[array.size()];
        this.fillArrayRandomStringsDefaultLength(strings);
        array.setArray(strings);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken
     * from the file in the resources. The strings random size from {@link } to
     * {@link } characters.
     *
     * @param array The array to be filled with object of the {@link String}
     * type.
     */
    @Override
    public void fill(@NotNull final String[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArrayRandomStringsDefaultLength(array);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken
     * from the file in the resources. The strings random size from {@link } to
     * {@link } characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object
     * of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public String[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        String[] strings = new String[lengthArray];
        this.fillArrayRandomStringsDefaultLength(strings);
        return strings;
    }

    /**
     * Fills an object of the {@link Array} class with object of the {@link
     * String} type.
     * <p>The strings consist of random alphabetic characters that were taken
     * from the file in the resources. The strings random size from {@link } to
     * {@link } characters.
     *
     * @param array The object of the {@link Array} class to be filled with
     * object of the {@link String} type.
     * @param lengthString The length of strings.
     */
    @Override
    public void fill(@NotNull final Array<String> array,
                     @NotNull final Integer lengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Objects.requireNonNull(lengthString, "Length of the string is null");
        CheckerString.check(lengthString, Capacity.UPPER.get());
        String[] strings = new String[array.size()];
        this.fillArrayRandomStringsFromLowerToUpperLength(strings, lengthString,
                                                          lengthString);
        array.setArray(strings);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken
     * from the file in the resources. The strings random size from {@link } to
     * {@link } characters.
     *
     * @param strings The array to be filled with object of the {@link String}
     * type.
     * @param lengthString The length of strings.
     */
    public void fill(@NotNull final String[] strings,
                     @NotNull final Integer lengthString) {
        CheckerArray.check(strings, Capacity.UPPER.get());
        Objects.requireNonNull(lengthString, "Length of the string is null");
        CheckerString.check(lengthString, Capacity.UPPER.get());
        this.fillArrayRandomStringsFromLowerToUpperLength(strings, lengthString,
                                                          lengthString);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken
     * from the file in the resources. The strings random size from {@link } to
     * {@link } characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object
     * of the {@link String} type.
     * @param lengthString The length of strings.
     * @return Created and filled array with object of the {@link String} type.
     */
    public String[] fill(final int lengthArray,
                         @NotNull final Integer lengthString) {
        CheckerArray.check(lengthArray);
        Objects.requireNonNull(lengthString, "Length of the string is null");
        CheckerString.check(lengthString, Capacity.UPPER.get());
        String[] strings = new String[lengthArray];
        this.fillArrayRandomStringsFromLowerToUpperLength(strings, lengthString,
                                                          lengthString);
        return strings;
    }

    public void fill(@NotNull final Array<String> array,
                     @NotNull final Integer lowerLengthString,
                     @NotNull final Integer upperLengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Objects.requireNonNull(lowerLengthString,
                               "Lower length of the string is null");
        Objects.requireNonNull(upperLengthString,
                               "Upper length of the string is null");
        CheckerString.check(lowerLengthString, Capacity.UPPER.get());
        CheckerString.check(upperLengthString, Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        String[] strings = new String[array.size()];
        this.fillArrayRandomStringsFromLowerToUpperLength(strings,
                                                          lowerLengthString,
                                                          upperLengthString);
        array.setArray(strings);
    }

    public void fill(@NotNull final String[] strings,
                     @NotNull final Integer lowerLengthString,
                     @NotNull final Integer upperLengthString) {
        CheckerArray.check(strings, Capacity.UPPER.get());
        Objects.requireNonNull(lowerLengthString,
                               "Lower length of the string is null");
        Objects.requireNonNull(upperLengthString,
                               "Upper length of the string is null");
        CheckerString.check(lowerLengthString, Capacity.UPPER.get());
        CheckerString.check(upperLengthString, Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        this.fillArrayRandomStringsFromLowerToUpperLength(strings,
                                                          lowerLengthString,
                                                          upperLengthString);
    }

    public String[] fill(final int lengthArray,
                         @NotNull final Integer lowerLengthString,
                         @NotNull final Integer upperLengthString) {
        CheckerArray.check(lengthArray);
        Objects.requireNonNull(lowerLengthString,
                               "Lower length of the string is null");
        Objects.requireNonNull(upperLengthString,
                               "Upper length of the string is null");
        CheckerString.check(lowerLengthString, Capacity.UPPER.get());
        CheckerString.check(upperLengthString, Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        String[] strings = new String[lengthArray];
        this.fillArrayRandomStringsFromLowerToUpperLength(strings,
                                                          lowerLengthString,
                                                          upperLengthString);
        return strings;

    }


    private void fillArrayRandomStringsDefaultLength(final String[] strings) {
        this.fillArrayRandomStringsFromLowerToUpperLength(strings,
                                                          DEFAULT_STRING_LENGTH,
                                                          DEFAULT_STRING_LENGTH);
    }

    private void fillArrayRandomStringsFromLowerToUpperLength(
            final String[] strings, final int lowerLengthString,
            final int upperLengthString) {
        char[] chars = this.readerCharacters.readCharacters(this.inputStream);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = this.creatorString.create(lowerLengthString,
                                                   upperLengthString, chars);
        }
    }


}
