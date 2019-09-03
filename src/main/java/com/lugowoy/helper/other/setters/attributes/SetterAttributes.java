package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Model;

import java.io.OutputStream;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 29.08.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */
//todo add doc's (interface, methods)
public interface SetterAttributes<T extends Model> {

    void setAttributes(T t);

    void setAttributes(T t, Reading reading);

    static <T> boolean isNonNullObject(T t) {
        if (Objects.isNull(t)) {
            throw new NullPointerException("The object for setting attributes is null.");
        } else {
            return true;
        }
    }

    static boolean isNonNullReader(Reading reader) {
        if (Objects.isNull(reader)) {
            throw new NullPointerException("The reader is null.");
        } else {
            return true;
        }
    }

    static boolean isNonNullOutputStream(OutputStream outputStream) {
        if (Objects.isNull(outputStream)) {
            throw new NullPointerException("The output stream is null.");
        } else {
            return true;
        }
    }

}
