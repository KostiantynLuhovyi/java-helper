package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

import java.io.IOException;
import java.io.OutputStream;

import static com.lugowoy.helper.other.setters.attributes.SetterAttributes.*;

/**
 * Created by LugowoyKonstantin on 31.08.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */

//todo refactoring code
//todo edit doc's

public class SetterArrayAttributes<T> implements SetterAttributes<Array<T>> {

    public static final String MSG_ENTER_CONSOLE_LENGTH = "Enter the length of the array : ";

    @Override
    public void setAttributes(Array<T> array) {
        if (isNonNullObject(array)) {
            array.setArray(Array.DEFAULT_LENGTH);
        }
    }

    @Override
    public void setAttributes(Array<T> array, Reading reader) {
        if (isNonNullObject(array)) {
            if (isNonNullReader(reader)) {
                array.setArray(reader.readInt());
            }
        }
    }

    public void setAttributes(Array<T> array, int lengthArray) {
        if (isNonNullObject(array)) {
            array.setArray(lengthArray);
        }
    }

    public void setAttributes(Array<T> array, Reading reader, OutputStream outputStreamToMsg, String msgLengthArray) {
        if (isNonNullObject(array)) {
            if (isNonNullReader(reader)) {
                if (isNonNullOutputStream(outputStreamToMsg)) {
                    try {
                        outputStreamToMsg.write(msgLengthArray.getBytes());
                        array.setArray(reader.readInt());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
