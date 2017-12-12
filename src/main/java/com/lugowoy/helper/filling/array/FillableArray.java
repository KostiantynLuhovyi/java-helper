package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Fillable;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the array with data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @param <T> The type of the array and, accordingly, the type of data (values) by which the array will be filled.
 */
//todo Проверить документацию и корректность интерфейса.
public interface FillableArray<T> extends Fillable<T[]> {

    /**
     * TODO Add documentation.
     * */
    Number[] DEFAULT_ARRAY = {0, 0, 0, 0, 0};

    /**
     * <p>
     * The method fills the array with data. The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return A reference to the array created and filled with data.
     */
    T[] fill(int lengthArray);

}