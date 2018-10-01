package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 07-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The interface declares a contract to create class objects {@link Array} using constructors with different parameters.
 *
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 */

public interface CreatingArray<T> extends Creating<Array<T>> {

    /**
     * The method executes the creation of a class object Array<T> by calling the constructor with a parameter.
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created class object {@link Array} the encapsulating array passed by the parameter.
     */
    Array<T> create(final T[] tArray);

    /**
     * The method executes the creation of a class object {@link Array} by calling the constructor with a parameter.
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    Array<T> create(final int lengthArray);

}
