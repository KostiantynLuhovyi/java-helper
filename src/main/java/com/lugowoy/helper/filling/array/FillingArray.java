package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillableArray;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * The class is encapsulating the interface to implementation of the array filling with values.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @param <T> The type of the elements of the array, which is filling with values.
 */

public abstract class FillingArray<T> extends Filling<T[]> implements FillableArray<T> {

    /**
     * <p>
     * The method fills an array the values with created based on the length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill values.
     *                          The value of the length of the array to fill in the values must be a positive number.
     * @return A reference to the array created and filled with values.
     */
    @Override
    public abstract T[] fill(int lengthArray);

}
