package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public interface FillingArray<T> extends Filling<Array<T>> {

    T[] fill(T[] tArray);

    T[] fill(int lengthArray);

}
