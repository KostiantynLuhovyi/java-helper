package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.FillableArray;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public abstract class FillingArray<T> extends Filling<T[]> implements FillableArray<T> {

    @Override
    public abstract T[] fill(T[] array);

    @Override
    public abstract T[] fill(int lengthArray);



}
