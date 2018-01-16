package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public interface FillingArrayPoints<T extends Number> {

    Point<T>[] fill(T[] array);

}
