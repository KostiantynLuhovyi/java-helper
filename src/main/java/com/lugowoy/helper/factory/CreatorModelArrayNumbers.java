package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfNumbers;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

public class CreatorModelArrayNumbers<T extends Number> extends CreatorModelArray<T> {

    @Override
    public Array<T> create() {
        return new ArrayOfNumbers<>();
    }

}
