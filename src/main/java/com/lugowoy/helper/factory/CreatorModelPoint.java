package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

public class CreatorModelPoint<T extends Number> extends CreatorModel {

    @Override
    public Model create() {
        return new Point<>();
    }

}
