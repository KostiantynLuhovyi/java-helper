package com.lugowoy.helper.filling.fillable;

/** Created by Konstantin Lugowoy on 27.07.2017. */

public interface FillableArrayNumbers<T> extends FillableArray<T> {

    T[] fill(T[] array, T bound);

    T[] fill(int lengthArray, T bound);

    T[] fill(T[] array, T minBound, T maxBound);

    T[] fill(int lengthArray, T minBound, T maxBound);

}
