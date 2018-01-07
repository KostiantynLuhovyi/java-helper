package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.ArrayOfNumbers;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class implements a contract that creates objects of the {@link ArrayOfNumbers} type encapsulating an array of numeric data.
 * </p>
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
     * <p>
     * A constructor called to create a class object {@link ArrayOfNumbers} using its constructor without parameters {@link ArrayOfNumbers#ArrayOfNumbers()}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     */
    public CreatorArrayNumbers() {
        this.create();
    }

    /**
     * <p>
     * A constructor with a parameter, the use of which creates a class object {@link ArrayOfNumbers} invoking its constructor {@link ArrayOfNumbers#ArrayOfNumbers(Number[])}
     *  into which an array of numeric data is transferred which will be encapsulated in the created object.
     * </p>
     * @since 1.0
     *
     * @param tArray An array of numeric data that will be encapsulate in the created class object {@link ArrayOfNumbers}.
     */
    public CreatorArrayNumbers(final T[] tArray) {
        super(tArray);
    }

    /**
     * <p>
     * A constructor with a parameter, the use of which creates a class object {@link ArrayOfNumbers} invoking its constructor {@link ArrayOfNumbers#ArrayOfNumbers(int)}
     *  into which the length of an array of objects is transferred which will be encapsulated in the created object.
     * </p>
     * @since 1.0
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link ArrayOfNumbers} .
     */
    public CreatorArrayNumbers(final int lengthArray) {
        super(lengthArray);
    }

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.Creating
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @return The created object of type {@link ArrayOfNumbers}.
     */
    @Override
    public ArrayOfNumbers<T> create() {
        return new ArrayOfNumbers<>();
    }

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the constructor with parameter {@link ArrayOfNumbers#ArrayOfNumbers(T[])}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @param tArray An array of numeric data that will be encapsulate in the created class object {@link ArrayOfNumbers}.
     *
     * @return The created object of type {@link ArrayOfNumbers}.
     */
    @Override
    public ArrayOfNumbers<T> create(final T[] tArray) {
        return new ArrayOfNumbers<>(tArray);
    }

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfNumbers} type that calls the constructor with parameter {@link ArrayOfNumbers#ArrayOfNumbers(int)}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link ArrayOfNumbers}.
     *
     * @return The created object {@link ArrayOfNumbers} encapsulates an array of the length of the passed parameter.
     */
    @Override
    public ArrayOfNumbers<T> create(final int lengthArray) {
        return new ArrayOfNumbers<>(lengthArray);
    }

}
