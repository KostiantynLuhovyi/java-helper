package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Fillable;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the arrays the data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @param <T> Type of arrays that is filling with data (values).
 */

public interface FillableArray<T> extends Fillable<T[]> {

    /**
     * <p>
     * The method fills the arrays with data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling with data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return An array filled with data (values).
     */
    T[] fill(int lengthArray);

}