package com.lugowoy.helper.factory.creator.arrays;

import com.lugowoy.helper.factory.creator.Creating;
import com.lugowoy.helper.models.arrays.Array;

/**
 * The interface declares a contract to create class objects {@link Array} using constructors with different parameters.
 * <p>Created by Konstantin Lugowoy on 07-Jan-18.
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.factory.creator.Creating
 * @since 1.0
 */
public interface CreatingArray<T> extends Creating<Array<T>> {

    /**
     * The method executes the creation of a class object Array<T> by calling the constructor with a parameter.
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created class object {@link Array} the encapsulating array passed by the parameter.
     */
    Array<T> create(T[] tArray);

    /**
     * The method executes the creation of a class object {@link Array} by calling the constructor with a parameter.
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    Array<T> create(int lengthArray);

}
