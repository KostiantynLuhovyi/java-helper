package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Random;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 */
//todo Add doc's;
public class FillingArrayRandomStrings extends FillingArrayStrings {

    private static final int DEFAULT_STRING_LENGTH = 10;

    private CharacterReader characterReader;
    private String fileName;

    public FillingArrayRandomStrings(String fileName) {
        this.characterReader = CharacterReader::readCharacters;
        this.fileName = fileName;
    }

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to be filled with data.
     */
    @Override
    public void fill(Array<String> array) throws IllegalArgumentException {
        this.fill(array, DEFAULT_STRING_LENGTH);
    }

    /**
     * Fills an array with data.
     *
     * @param strings The array to be filled with data.
     */
    @Override
    public void fill(String[] strings) throws IllegalArgumentException {
        if (strings != null) {
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
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

    public void fill(Array<String> array, int lengthString) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkMinLengthStringToLessMaxLengthString(0, lengthString)) {
                String[] strings = new String[array.getLength()];
                this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
                array.setArray(strings);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    public void fill(String[] strings, int lengthString) throws IllegalArgumentException {
        if (strings != null) {
            if (checkMinLengthStringToLessMaxLengthString(0, lengthString)) {
                this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    public String[] fill(int lengthArray, int lengthString) {
        String[] strings;
        if (checkLengthArray(lengthArray)) {
            try {
                if (checkMinLengthStringToLessMaxLengthString(0, lengthString)) {
                    strings = new String[lengthArray];
                    this.initializeArrayElementsRandomStrings(strings, 0, lengthString);
                }
            } final {
                strings = new String[lengthArray];
                this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
            }
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsRandomStrings(strings, 0, DEFAULT_STRING_LENGTH);
        }
        return strings;
    }

    public void fill(Array<String> array, int minLengthString, int maxLengthString) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            String[] strings = new String[array.getLength()];
            this.initializeArrayElementsRandomStrings(strings, minLengthString, maxLengthString);
            array.setArray(strings);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    public void fill(String[] strings, int minLengthString, int maxLengthString) throws IllegalArgumentException {

    }

    public void fill(int lengthArray, int minLengthString, int maxLengthString) {

    }

/*    private void initializeArrayElementsRandomStrings(String[] strings) {
        char[] chars = this.characterReader.read(this.fileName);
        Random randomChar = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < DEFAULT_STRING_LENGTH; j++) {
                stringBuilder.append(chars[randomChar.nextInt(chars.length)]);
            }
            strings[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private void initializeArrayElementsRandomStrings(String[] strings, int lengthString) {
        char[] chars = this.characterReader.read(this.fileName);
        Random randomChar = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < lengthString; j++) {
                stringBuilder.append(chars[randomChar.nextInt(chars.length)]);
            }
            strings[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }*/

    public void initializeArrayElementsRandomStrings(String[] strings, int minLengthString, int maxLengthString) {
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

    private static boolean checkMinLengthStringToLessMaxLengthString(int minLengthString, int maxLengthString) throws IllegalArgumentException {
        boolean result;
        if (minLengthString < maxLengthString) {
            result = true;
        } else {
            throw new IllegalArgumentException("The values of the length of the lines are not correct.");
        }
        return result;
    }

}
