package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 31.08.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (class, constants, methods)
public class SetterArrayAttributes<T> implements SetterAttributes<Array<T>> {

    @Override
    public void setAttributes(Array<T> array) {
        array.setArray(Array.DEFAULT_LENGTH);
    }

    @Override
    public void setAttributes(Array<T> array, Reading reader) {
        if (isNonNullArray(array)) {
            if (isNonNullReader(reader)) {
                //todo most likely, need to add a check for the attribute to be in the range of valid values.
                array.setArray(reader.readInt());
            }
        }
    }

    public void setAttributes(Array<T> array, int lengthArray) {

    }

    private static <T> boolean isNonNullArray(Array<T> array) {
        if (Objects.isNull(array)) {
            throw new NullPointerException("The array is equal null.");
        } else {
            return true;
        }
    }

    private static boolean isNonNullReader(Reading reader) {
        if (Objects.isNull(reader)) {
            throw new NullPointerException("The reader is equal null.");
        } else {
            return true;
        }
    }

}
