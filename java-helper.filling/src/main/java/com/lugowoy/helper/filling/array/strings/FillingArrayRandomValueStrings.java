package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.2
 *
 * The class fills an object of the {@link Array} class and a classic array with random an object of the {@link String} type.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayRandomStrings
 */

public class FillingArrayRandomValueStrings extends FillingArrayRandomStrings {

    /**
     * Constructs a new object of the {@link FillingArrayRandomValueStrings} class.
     * @param fileName The name of the file from which the random characters are read.
     */
    public FillingArrayRandomValueStrings(String fileName) {
        super(fileName);
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     *    The strings size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     */
    @Override
    public void fill(Array<String> array) throws IllegalArgumentException {
        this.fill(array, DEFAULT_STRING_LENGTH);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     *    The strings random size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(String[] strings) throws IllegalArgumentException {
        if (checkNonNullArrayStrings(strings)) {
            this.initializeArrayElementsRandomStrings(strings, DEFAULT_STRING_LENGTH);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     *    The strings random size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public String[] fill(int lengthArray) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            strings = new String[lengthArray];
            this.initializeArrayElementsRandomStrings(strings, DEFAULT_STRING_LENGTH);
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is "lengthString" parameter.
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     * @param lengthString The length of strings.
     */
    public void fill(Array<String> array, int lengthString) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkCorrectLengthString(lengthString)) {
                String[] strings = new String[array.getLength()];
                this.initializeArrayElementsRandomStrings(strings, lengthString);
                array.setArray(strings);
            } else {
                throw new IllegalArgumentException("The value of the length of the string is not correct.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is "lengthString" parameter.
     * @param strings The array to be filled with object of the {@link String} type.
     * @param lengthString The length of strings.
     */
    public void fill(String[] strings, int lengthString) throws IllegalArgumentException {
        if (checkNonNullArrayStrings(strings)) {
            if (checkCorrectLengthString(lengthString)) {
                this.initializeArrayElementsRandomStrings(strings, lengthString);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is "lengthString" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @param lengthString The length of strings.
     * @return Created and filled array with object of the {@link String} type.
     */
    public String[] fill(int lengthArray, int lengthString) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            if (checkCorrectLengthString(lengthString)) {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, lengthString);
            } else {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, DEFAULT_STRING_LENGTH);
            }
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    private void initializeArrayElementsRandomStrings(String[] strings, int lengthString) {
        char[] chars = super.getCharacterReader().read(super.getFileName());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = DEFAULT_START_STRING_LENGTH; j < lengthString; j++) {
                stringBuilder.append(chars[GeneratorRandomNumber.generateInt(chars.length - 1)]);
            }
            strings[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private static boolean checkCorrectLengthString(int lengthString) {
        return (lengthString > DEFAULT_MIN_STRING_LENGTH) && (lengthString < Integer.MAX_VALUE);
    }

}
