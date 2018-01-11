package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public interface FillingArrayNumbers<T extends Number> {

    Array<T> fill(Array<T> array, T bound);

    T[] fill(T[] tArray, T bound);

    T[] fill(int lengthArray, T bound);

    Array<T> fill(Array<T> array, T minBound, T maxBound);

    T[] fill(T[] tArray, T minBound, T maxBound);

    T[] fill(int lengthArray, T minBound, T maxBound);

}
