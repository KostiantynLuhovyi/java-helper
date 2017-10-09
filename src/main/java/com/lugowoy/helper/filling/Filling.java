package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.Fillable;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public abstract class Filling<T> implements Fillable<T> {

    @Override
    public abstract T fill(T t);

}
