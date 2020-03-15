package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

/**
 * The class fills an object of the {@link Array} class and a classic array with random an object of the {@link String} type.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayRandomStrings
 * @since 1.2
 */
//TODO edit doc's
public class FillingArrayRandomValueStrings extends FillingArrayRandomStrings {

    /**
     * Constructs a new object of the {@link FillingArrayRandomValueStrings} class.
     *
     * @param fileName The name of the file from which the random characters are read.
     */
    public FillingArrayRandomValueStrings(String fileName) {
        super(fileName);
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     * The strings size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     *
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     */
    @Override
    public void fill(Array<String> array) {
        this.fill(array, DEFAULT_STRING_LENGTH);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     * The strings random size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     *
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(String[] strings) {
        CheckerArray.checkLengthInArray(strings);
        this.fillArrayRandomStrings(strings, DEFAULT_STRING_LENGTH);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the resources.
     * The strings random size is {@link FillingArrayRandomStrings#DEFAULT_STRING_LENGTH} characters.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     *
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public String[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        String[] strings = new String[lengthArray];
        this.fillArrayRandomStrings(strings, DEFAULT_STRING_LENGTH);
        return strings;
    }

    /**
     * Fills an object of the {@link Array} class with objects of the {@link String} class.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     * The strings size is "lengthString" parameter.
     *
     * @param array The object of the {@link Array} class to be filled with objects of the {@link String} class.
     * @param lengthString The length of strings.
     */
    public void fill(Array<String> array, int lengthString) {
        CheckerArray.checkLengthInArray(array);
        if (checkCorrectLengthString(lengthString)) {
            String[] strings = new String[array.size()];
            this.fillArrayRandomStrings(strings, lengthString);
            array.setArray(strings);
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     * The strings size is "lengthString" parameter.
     *
     * @param strings The array to be filled with object of the {@link String} type.
     * @param lengthString The length of strings.
     */
    public void fill(String[] strings, int lengthString) {
        CheckerArray.checkLengthInArray(strings);
        if (checkCorrectLengthString(lengthString)) {
            this.fillArrayRandomStrings(strings, lengthString);
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The strings consist of random alphabetic characters that were taken from the file in the properties.
     * The strings size is "lengthString" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @param lengthString The length of strings.
     *
     * @return Created and filled array with object of the {@link String} type.
     */
    public String[] fill(int lengthArray, int lengthString) {
        CheckerArray.checkLengthArray(lengthArray);
        String[] strings = new String[lengthArray];
        if (checkCorrectLengthString(lengthString)) {
            this.fillArrayRandomStrings(strings, lengthString);
        }
        return strings;
    }

    private void fillArrayRandomStrings(String[] strings, int lengthString) {
        char[] chars = super.getReaderCharacters().read(super.getFileName());
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
