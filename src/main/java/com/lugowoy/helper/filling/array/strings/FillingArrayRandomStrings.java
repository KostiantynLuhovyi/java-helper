package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.models.arrays.Array;

/**
 * This class implements the {@link FillingArrayStrings} interface
 * by filling with object of the {@link String} type of an object of the {@link Array} wrapper class
 * and an classical arrays.
 * <p>Created by Konstantin Lugowoy on 07.08.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.3
 */
public abstract class FillingArrayRandomStrings implements FillingArrayStrings {

    /**
     * A constant that stores the default value of the start string length.
     * @since 1.3
     * */
    static final int DEFAULT_START_STRING_LENGTH = 0;

    /**
     * A constant that stores the default value of the minimum string length.
     * @since 1.3
     * */
    static final int DEFAULT_MIN_STRING_LENGTH = 1;

    /**
     * A constant that stores the default length of a string.
     * @since 1.3
     * */
    static final int DEFAULT_STRING_LENGTH = 10;

    private CharacterReader characterReader;
    private String fileName;

    /**
     * Constructs a new object of the {@link FillingArrayRandomStrings} subclass.
     * @param fileName The name of the file from which the random characters are read.
     */
    FillingArrayRandomStrings(String fileName) {
        this.characterReader = CharacterReader::readCharacters;
        this.fileName = fileName;
    }

    /**
     * Fills an object of the {@link Array} class with object of the {@link String} type.
     * @param array The object of the {@link Array} class to be filled with object of the {@link String} type.
     */
    @Override
    public abstract void fill(Array<String> array);

    /**
     * Fills an array with object of the {@link String} type.
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public abstract void fill(String[] strings);

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public abstract String[] fill(int lengthArray);

    /**
     * Returns implementation readout data to create random strings.
     * @since 1.3
     */
    CharacterReader getCharacterReader() {
        return characterReader;
    }

    /**
     * Returns the file name ({@link FillingArrayRandomStrings#fileName}) from which to take the data to create the strings.
     * @since 1.3
     */
    public String getFileName() {
        return fileName;
    }

    /**
    * Sets the name of the file ({@link FillingArrayRandomStrings#fileName}) from which data is taken to create the strings.
    * @since 1.3
    */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
