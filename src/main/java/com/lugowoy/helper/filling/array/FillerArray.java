package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 *
 * </p>
 *
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *
 * @param <T>
 */

public class FillerArray<T> extends Filler<Array<T>> implements FillingArray<T> {

    /**
     * <p></p>
     * @since 1.0
     */
    protected FillerArray() {
    }

    /**
     * <p></p>
     *
     * @param filling
     *
     * @since 1.0
     */
    protected FillerArray(FillingArray<T> filling) {
        super(filling);
    }

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     *
     * @since 1.0
     */
    @Override
    public Array<T> fill(Array<T> array) {
        return super.fill(array);
    }

    /**
     * <p></p>
     *
     * @param tArray
     *
     * @return
     *
     * @since 1.0
     */
    @Override
    public T[] fill(T[] tArray) {
        return ((FillingArray<T>)super.getFilling()).fill(tArray);
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     *
     * @return
     *
     * @since 1.0
     */
    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>)super.getFilling()).fill(lengthArray);
    }

    /**
     * <p></p>
     *
     * @param fillingArray
     *
     * @return
     *
     * @since 1.0
     */
    public static <T> FillerArray<T> getFillerArray(FillingArray<T> fillingArray) {
        return new FillerArray<>(fillingArray);
    }

}
