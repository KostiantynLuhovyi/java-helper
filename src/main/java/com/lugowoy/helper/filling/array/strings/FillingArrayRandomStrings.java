package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Random;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.2
 *
 * The class fills an object of the {@link Array} class and a classic array with random an object of the {@link String} type.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 */

public class FillingArrayRandomStrings extends FillingArrayStrings {

    private static final int DEFAULT_STRING_LENGTH = 10;

    private CharacterReader characterReader;

    private String fileName;

    /**
     * Constructs a new object of the {@link FillingArrayRandomStrings} class.
     *
     * @param fileName The name of the file from which the random characters are read.
     */
    public FillingArrayRandomStrings(String fileName) {
        this.characterReader = CharacterReader::readCharacters;
        this.fileName = fileName;
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is 10 characters.
     *
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     */
    @Override
    public void fill(Array<String> array) throws IllegalArgumentException {
        this.fill(array, DEFAULT_STRING_LENGTH);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is 10 characters.
     *
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(String[] strings) throws IllegalArgumentException {
        if (checkNonNullArrayStrings(strings)) {
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is 10 characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public String[] fill(int lengthArray) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            strings = new String[lengthArray];
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is parameter "lengthString".
     *
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     * @param lengthString Length of strings to fills.
     */
    public void fill(Array<String> array, int lengthString) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkMinLengthStringToLessMaxLengthString(0, lengthString) && checkCorrectEndBoundOfLengthString(lengthString)) {
                String[] strings = new String[array.getLength()];
                this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
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
     *    The strings size is parameter "lengthString".
     *
     * @param strings The array to be filled with object of the {@link String} type.
     * @param lengthString Length of strings to fills.
     */
    public void fill(String[] strings, int lengthString) throws IllegalArgumentException {
        if (checkNonNullArrayStrings(strings)) {
            if (checkMinLengthStringToLessMaxLengthString(0, lengthString) && checkCorrectEndBoundOfLengthString(lengthString)) {
                this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size is parameter "lengthString" characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @param lengthString Length of strings to fills.
     * @return Created and filled array with object of the {@link String} type.
     */
    public String[] fill(int lengthArray, int lengthString) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            if (checkMinLengthStringToLessMaxLengthString(0, lengthString) && checkCorrectEndBoundOfLengthString(lengthString)) {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
            } else {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
            }
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size from parameter "minLengthString" to "maxLengthString".
     *
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     * @param minLengthString The starting (minimum) value of the string length.
     * @param maxLengthString The ending (maximum) value of the string length.
     */
    public void fill(Array<String> array, int minLengthString, int maxLengthString) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            String[] strings = new String[array.getLength()];
            this.initializeArrayElementsRandomStrings(strings, minLengthString, maxLengthString);
            array.setArray(strings);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size from parameter "minLengthString" to "maxLengthString".
     *
     * @param strings The array to be filled with object of the {@link String} type.
     * @param minLengthString The starting (minimum) value of the string length.
     * @param maxLengthString The ending (maximum) value of the string length.
     */
    public void fill(String[] strings, int minLengthString, int maxLengthString) throws IllegalArgumentException {
        if (checkNonNullArrayStrings(strings)) {
            if (checkMinLengthStringToLessMaxLengthString(minLengthString, maxLengthString)
                    && checkCorrectEndBoundOfLengthString(maxLengthString)) {
                this.initializeArrayElementsRandomStrings(strings, minLengthString, maxLengthString);
            } else {
                this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     *    The strings size from parameter "minLengthString" to "maxLengthString" characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @param minLengthString The starting (minimum) value of the string length.
     * @param maxLengthString The ending (maximum) value of the string length.
     * @return Created and filled array with object of the {@link String} type.
     */
    public String[] fill(int lengthArray, int minLengthString, int maxLengthString) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            if (checkMinLengthStringToLessMaxLengthString(minLengthString, maxLengthString)
                    && checkCorrectEndBoundOfLengthString(maxLengthString)) {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, minLengthString, maxLengthString);
            } else {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
            }
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    private void initializeArrayElementsRandomStrings(String[] strings, int minLengthString, int maxLengthString) {
        char[] chars = this.characterReader.read(this.fileName);
        Random randomChar = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = minLengthString; j < maxLengthString; j++) {
                stringBuilder.append(chars[randomChar.nextInt(chars.length)]);
            }
            strings[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private static boolean checkMinLengthStringToLessMaxLengthString(int minLengthString, int maxLengthString) {
        boolean resultOfCheck = false;
        if (minLengthString < maxLengthString) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

    private static boolean checkCorrectEndBoundOfLengthString(int lengthString) {
        boolean resultOfCheck = false;
        if ((lengthString > 0) && (lengthString <= Byte.MAX_VALUE)) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

}
