package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.FillableArrayNumbers;

/** Created by Konstantin Lugowoy on 27.07.2017. */

public class FillerArrayNumbers<T> extends FillerArray<T> implements FillableArrayNumbers<T> {

    public FillerArrayNumbers(Filling<T[]> filling) {
        super(filling);
    }

    @Override
    public T[] fill(T[] array) {
        return super.getFilling().fill(array);
    }

    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray);
    }

    @Override
    public T[] fill(T[] array, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, bound);
    }

    @Override
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, bound);
    }

    @Override
    public T[] fill(T[] array, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, minBound, maxBound);
    }

    @Override
    public T[] fill(int lengthArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, minBound, maxBound);
    }

}
