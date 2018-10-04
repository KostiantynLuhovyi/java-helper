package com.lugowoy.helper.factory.creator.arrays;

import com.lugowoy.helper.factory.creator.Creator;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * Abstract class declaring a contract for the implementation of the functional that creates objects of type {@link Array}.
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see CreatingArray
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 */
// todo edit methods doc's
public class CreatorArray<T> extends Creator<Array<T>> implements CreatingArray<T>{

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
