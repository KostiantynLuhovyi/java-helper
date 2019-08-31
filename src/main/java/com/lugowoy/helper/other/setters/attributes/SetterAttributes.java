package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Model;

/**
 * Created by LugowoyKonstantin on 29.08.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (interface, methods)
public interface SetterAttributes<T extends Model> {

    void setAttributes(T t);

    void setAttributes(T t, Reading reading);

}
