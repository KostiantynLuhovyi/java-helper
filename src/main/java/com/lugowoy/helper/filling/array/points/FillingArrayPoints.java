package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * <p></p>
 *
 * @param <T>
 * */

public interface FillingArrayPoints<T extends Number> {

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     * */
    Point<T>[] fill(T[] array);

}
