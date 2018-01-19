package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *
 * @param <T>
 */

public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * <p></p>
     *
     * @param array
     * @param bound
     *
     * @return
     *
     * @since 1.0
     */
    Array<T> fill(Array<T> array, T bound);

    /**
     * <p></p>
     *
     * @param tArray
     * @param bound
     *
     * @return
     *
     * @since 1.0
     */
    T[] fill(T[] tArray, T bound);

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param bound
     *
     * @return
     *
     * @since 1.0
     */
    T[] fill(int lengthArray, T bound);

    /**
     * <p></p>
     *
     * @param array
     * @param minBound
     * @param maxBound
     *
     * @return
     *
     * @since 1.0
     */
    Array<T> fill(Array<T> array, T minBound, T maxBound);

    /**
     * <p></p>
     *
     * @param tArray
     * @param minBound
     * @param maxBound
     *
     * @return
     *
     * @since 1.0
     */
    T[] fill(T[] tArray, T minBound, T maxBound);

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param minBound
     * @param maxBound
     *
     * @return
     *
     * @since 1.0
     */
    T[] fill(int lengthArray, T minBound, T maxBound);

}
