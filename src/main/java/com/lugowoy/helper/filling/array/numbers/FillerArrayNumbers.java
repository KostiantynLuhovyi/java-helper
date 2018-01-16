package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillerArrayNumbers<T extends Number> extends FillerArray<T> implements FillingArrayNumbers<T> {

    private FillerArrayNumbers() {
    }

    private FillerArrayNumbers(Filling<Array<T>> filling) {
        super(filling);
    }

    @Override
    public Array<T> fill(Array<T> array, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, bound);
    }

    @Override
    public T[] fill(T[] tArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, bound);
    }

    @Override
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, bound);
    }

    @Override
    public Array<T> fill(Array<T> array, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, minBound, maxBound);
    }

    @Override
    public T[] fill(T[] tArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, minBound, maxBound);
    }

    @Override
    public T[] fill(int lengthArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, minBound, maxBound);
    }

    public static <T extends Number> FillerArrayNumbers<T> getFillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<T>(fillingArrayNumbers);
    }

}
