package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The class provides functionality to reads data for fills an object of the {@link Array} class
 *  and classical arrays with object of the {@link String} type.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 */

public class FillingArrayReadValueStrings implements FillingArrayStrings {

    private Reader reader;

    /**
     * Constructs a new object of the {@link FillingArrayReadValueStrings} class.
     * @param reading An object that implements the {@link Reading} interface, which provides a specific implementation for reading data.
     */
    public FillingArrayReadValueStrings(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * Fills an object of the {@link Array} class with object of the {@link String} type.
     * @param array The object of the {@link Array} class to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(Array<String> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            String[] strings = new String[array.getLength()];
            this.initializeArrayElementsEnteredStrings(strings);
            array.setArray(strings);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(String[] strings) throws IllegalArgumentException {
        if (strings != null) {
            this.initializeArrayElementsEnteredStrings(strings);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with object of the {@link String} type.
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
            this.initializeArrayElementsEnteredStrings(strings);
        } else {
            strings = new String[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsEnteredStrings(strings);
        }
        return strings;
    }

    private void initializeArrayElementsEnteredStrings(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = this.reader.readString();
        }
    }

}
