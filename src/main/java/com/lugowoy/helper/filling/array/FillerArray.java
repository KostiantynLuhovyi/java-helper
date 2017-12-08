package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillableArray;

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
