package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * <p></p>
 *
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 *
 * @param <T>
 */

public class FillerArrayNumbers<T extends Number> extends FillerArray<T> implements FillingArrayNumbers<T> {

    /**
     * <p></p>
     *
     * @param fillingArrayNumbers
     */
    protected FillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        super(fillingArrayNumbers);
    }

    /**
     * <p></p>
     *
     * @param array
     *
     * @return
     */
    @Override
    public Array<T> fill(Array<T> array) {
        return super.fill(array);
    }

    /**
     * <p></p>
     *
     * @param array
     * @param bound
     *
     * @return
     */
    @Override
    public Array<T> fill(Array<T> array, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, bound);
    }

    /**
     * <p></p>
     *
     * @param tArray
     * @param bound
     *
     * @return
     */
    @Override
    public T[] fill(T[] tArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, bound);
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param bound
     *
     * @return
     */
    @Override
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * <p></p>
     *
     * @param array
     * @param minBound
     * @param maxBound
     *
     * @return
     */
    @Override
    public Array<T> fill(Array<T> array, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, minBound, maxBound);
    }

    /**
     * <p></p>
     *
     * @param tArray
     * @param minBound
     * @param maxBound
     *
     * @return
     */
    @Override
    public T[] fill(T[] tArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, minBound, maxBound);
    }

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param minBound
     * @param maxBound
     *
     * @return
     */
    @Override
    public T[] fill(int lengthArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, minBound, maxBound);
    }

    /**
     * <p></p>
     *
     * @param fillingArrayNumbers
     *
     * @return
     */
    public static <T extends Number> FillerArrayNumbers<T> getFillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<T>(fillingArrayNumbers);
    }

}
