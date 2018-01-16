package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 */

public class FillerArray<T> extends Filler<Array<T>> implements FillingArray<T> {

    protected FillerArray() {
    }

    protected FillerArray(Filling<Array<T>> filling) {
        super(filling);
    }

    @Override
    public T[] fill(T[] tArray) {
        return ((FillingArray<T>)super.getFilling()).fill(tArray);
    }

    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>)super.getFilling()).fill(lengthArray);
    }

    public static <T> FillerArray<T> getFillerArray(FillingArray<T> fillingArray) {
        return new FillerArray<>(fillingArray);
    }

}
