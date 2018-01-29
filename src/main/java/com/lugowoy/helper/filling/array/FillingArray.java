package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * The interface that declares a contract to filling an array with data.
 * <p> Also this interface is the inheritor of the {@link Filling} interface
 *  and thereby redefines its contract for filling with data of an object of the {@link Array} class.
 *
 * @see com.lugowoy.helper.filling.Filling
 *
 * @param <T> The type of data objects stored and filled into an array.
 * */

public interface FillingArray<T> extends Filling<Array<T>> {

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to be filled with data.
     * @return The object of the {@link Array} class filled with data.
     * */
    @Override
    Array<T> fill(Array<T> array);

    /**
     * Fills an array with data.
     *
     * @param tArray The array to be filled with data.
     * @return The array filled with data.
     * */
    T[] fill(T[] tArray);

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
     * */
    T[] fill(int lengthArray);

}
