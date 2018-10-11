package com.lugowoy.helper.factory.creator.arrays;

import com.lugowoy.helper.factory.creator.Creator;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Abstract class declaring a contract for the implementation of the functional that creates objects of type {@link Array}.
 * <p>Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.arrays.CreatingArray
 * @since 1.0
 */
public class CreatorArray<T> extends Creator<Array<T>> implements CreatingArray<T>{

    // todo edit methods doc's

    /**
     * The method creates an object of the {@link Array} type that calls the default constructor {@link Array#Array()}.
     *
     * @return The created object of type {@link Array}.
     */
    @Override
    public Array<T> create() {
        return new Array<>();
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(T[])}.
     *
     * @param array An array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object of type {@link Array}.
     */
    public Array<T> create(T[] array) {
        return new Array<>(array);
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(int)}.
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    public Array<T> create(int lengthArray) {
        return new Array<>(lengthArray);
    }

}
