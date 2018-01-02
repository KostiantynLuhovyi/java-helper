package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

public abstract class CreatorModelArray<T> extends CreatorModel {

    @Override
    public abstract Array<T> create();

}
