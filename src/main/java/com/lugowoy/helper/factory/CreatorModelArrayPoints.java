package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfPoints;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

public class CreatorModelArrayPoints<T extends Number> extends CreatorModelArray<Point<T>> {

    @Override
    public Array<Point<T>> create() {
        return new ArrayOfPoints<>();
    }

}
