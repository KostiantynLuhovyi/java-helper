package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Model;

/**
 * Created by Konstantin Lugowoy on 29.08.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.7.4
 */
//todo write doc's
public interface SetterAttributes<T extends Model> {

    void setAttributes(T t);

    void setAttributes(T t, Reading reading);

}
