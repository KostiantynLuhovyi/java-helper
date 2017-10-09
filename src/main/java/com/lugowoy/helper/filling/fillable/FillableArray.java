package com.lugowoy.helper.filling.fillable;

/** Created by Konstantin Lugowoy on 27.07.2017. */

public interface FillableArray<T> extends Fillable<T[]> {

    @Override
    T[] fill(T[] array);

    T[] fill(int length);

}
