package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.FillableArray;

/** Created by Konstantin Lugowoy on 27.07.2017. */

public abstract class FillerArray<T> extends Filler<T[]> implements FillableArray<T> {

    public FillerArray(Filling<T[]> filling) {
        super(filling);
    }

    @Override
    public abstract T[] fill(T[] array);

    @Override
    public abstract T[] fill(int lengthArray);

    @Override
    public Filling<T[]> getFilling() {
        return super.getFilling();
    }

}
