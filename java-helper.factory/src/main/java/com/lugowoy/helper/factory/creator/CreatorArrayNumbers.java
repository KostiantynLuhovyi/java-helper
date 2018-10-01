package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.ArrayOfNumbers;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The class implements a contract that creates objects of the {@link ArrayOfNumbers} type encapsulating an array of numeric data.
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorArray
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 *
 * @param <T> The type an array of numeric data encapsulated in an {@link ArrayOfNumbers} object.
 */

public class CreatorArrayNumbers<T extends Number> extends CreatorArray<T> {

    /**
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the default constructor.
     *
     * @return The created object of type {@link ArrayOfNumbers}.
     */
    @Override
    public ArrayOfNumbers<T> create() {
        return new ArrayOfNumbers<>();
    }

    /**
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the constructor with parameter {@link ArrayOfNumbers#ArrayOfNumbers(T[])}.
     *
     * @param tArray An array of numeric data that will be encapsulate in the created class object {@link ArrayOfNumbers}.
     * @return The created object of type {@link ArrayOfNumbers}.
     */
    @Override
    public ArrayOfNumbers<T> create(final T[] tArray) {
        return new ArrayOfNumbers<>(tArray);
    }

    /**
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the constructor with parameter {@link ArrayOfNumbers#ArrayOfNumbers(int)}.
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link ArrayOfNumbers}.
     * @return The created object {@link ArrayOfNumbers} encapsulates an array of the length of the passed parameter.
     */
    @Override
    public ArrayOfNumbers<T> create(final int lengthArray) {
        return new ArrayOfNumbers<>(lengthArray);
    }

}
