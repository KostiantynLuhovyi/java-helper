package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;

import java.io.IOException;
import java.io.OutputStream;

import static com.lugowoy.helper.utils.CheckerLengthArray.checkLengthArray;

/**
 * Created by Konstantin Lugowoy on 31.08.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7.4
 */
//todo write doc's
public class SetterArrayAttributes<T> implements SetterAttributes<Array<T>> {

    public static final String MSG_ENTER_CONSOLE_LENGTH = "Enter the length of the array : ";

    @Override
    public void setAttributes(Array<T> array) {
        if (array != null) {
            array.setArray(Array.DEFAULT_LENGTH);
        } else {
            throw new NullPointerException("Array is null");
        }
    }

    @Override
    public void setAttributes(Array<T> array, Reading reader) {
        if (array != null) {
            if (reader != null) {
                array.setArray(reader.readInt());
            } else {
                throw new NullPointerException("Reader is null");
            }
        } else {
            throw new NullPointerException("Array is null.");
        }
    }

    public void setAttributes(Array<T> array, int lengthArray) {
        if (array != null) {
            if (checkLengthArray(lengthArray)) {
                array.setArray(lengthArray);
            }
        } else {
            throw new NullPointerException("Array is null.");
        }
    }

    public void setAttributes(Array<T> array, Reading reader, OutputStream outputStreamToMsg, String msgLengthArray) {
        if (array != null) {
            if (reader != null) {
                if (outputStreamToMsg != null) {
                    try (outputStreamToMsg) {
                        outputStreamToMsg.write(msgLengthArray.getBytes());
                        array.setArray(reader.readInt());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("Output stream is null.");
                }
            } else {
                throw new NullPointerException("Reader is null");
            }
        } else {
            throw new NullPointerException("Array is null.");
        }
    }

}
