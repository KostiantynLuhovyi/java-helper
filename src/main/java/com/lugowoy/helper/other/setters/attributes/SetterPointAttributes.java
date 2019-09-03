package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by LugowoyKonstantin on 03.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (class, constants, methods)
public abstract class SetterPointAttributes<T extends Point> implements SetterAttributes<T> {

    public static final String MSG_ENTER_CONSOLE_COOR_X = "";
    public static final String MSG_ENTER_CONSOLE_COOR_Y = "";
    public static final String MSG_ENTER_CONSOLE_COOR_Z = "";

    @Override
    public abstract void setAttributes(T point);

    @Override
    public abstract void setAttributes(T point, Reading reader);

}
