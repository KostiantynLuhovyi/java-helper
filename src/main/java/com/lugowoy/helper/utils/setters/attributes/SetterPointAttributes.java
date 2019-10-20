package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 03.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7.4
 */
//todo write doc's
public abstract class SetterPointAttributes<T extends Point> implements SetterAttributes<T> {

    public static final String MSG_ENTER_CONSOLE_COOR_X = "Enter the value of the coordinate X : ";
    public static final String MSG_ENTER_CONSOLE_COOR_Y = "Enter the value of the coordinate Y : ";
    public static final String MSG_ENTER_CONSOLE_COOR_Z = "Enter the value of the coordinate Z : ";

}
