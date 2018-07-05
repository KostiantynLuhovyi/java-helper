package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * Abstract class declaring a contract for the implementation of the functional that creates objects of type {@link Array}.
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 */

public abstract class CreatorArray<T> extends Creator<Array<T>> implements CreatingArray<T>{

    /**
     * The method creates an object of the {@link Array} type that calls the default constructor {@link Array#Array()}.
     *
     * @return The created object of type {@link Array}.
     */
    @Override
    public abstract Array<T> create();

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(T[])}.
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object of type {@link Array}.
     */
    public abstract Array<T> create(final T[] tArray);

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(int)}.
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    public abstract Array<T> create(final int lengthArray);

}
