package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 *
 * @param <T>
 */

public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * <p></p>
     *
     * @param tArray
     *
     * @return
     */
    T[] fill(T[] tArray);

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     */
    T[] fill(int lengthArray);

}
