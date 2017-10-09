package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.FillableArrayNumbers;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public abstract class FillingArrayNumbers<T> extends FillingArray<T> implements FillableArrayNumbers<T>{

    @Override
    public abstract T[] fill(T[] array);

    @Override
    public abstract T[] fill(int lengthArray);

    @Override
    public abstract T[] fill(T[] array, T bound);

    @Override
    public abstract T[] fill(int lengthArray, T bound);

    @Override
    public abstract T[] fill(T[] array, T minBound, T maxBound);

    @Override
    public abstract T[] fill(int lengthArray, T minBound, T maxBound);

}
