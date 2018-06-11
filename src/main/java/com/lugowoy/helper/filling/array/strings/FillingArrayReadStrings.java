package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkLengthArray;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 * */

//todo Add doc's;
public class FillingArrayReadStrings extends FillingArrayStrings {

    private Reader reader;

    public FillingArrayReadStrings(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayReadStrings(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to be filled with data.
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
     * Fills an array with data.
     *
     * @param strings The array to be filled with data.
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
