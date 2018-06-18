package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * The class implements a contract that creates objects of the {@link Array} type encapsulating an array of object of the <T> type.
 *
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorArray
 *
 * @param <T> The type an array of object of the <T> type encapsulated in an {@link Array} object.
 * */

public class CreatorArrayUnknown<T> extends CreatorArray<T> {

    /**
     * The method creates an object of the {@link Array} type that calls the default constructor {@link Array#Array()}.
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.Creating
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type {@link Array}.
     * */
    @Override
    public Array<T> create() {
        return new Array<>();
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(T[])}.
     *
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object of type {@link Array}.
     * */
    @Override
    public Array<T> create(T[] tArray) {
        return new Array<>(tArray);
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(int)}.
     *
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     * */
    @Override
    public Array<T> create(int lengthArray) {
        return new Array<>(lengthArray);
    }

}
