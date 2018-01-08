package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatorArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create {@link Array} class objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 */

public class FactoryArray extends Factory {

    /**
     * <p>
     * The method that creates the object by delegating the execution of the object creation
     *  to the object of the class {@link CreatorArray} passed by the parameter,
     *  which encapsulates the implementation to create the object class {@link Array}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     *
     * @param <T> The type of objects stored in the array.
     *
     * @param creatorArray An encapsulating implementation object for creating a {@link Array} type of objects.
     * @param tArray An array to be encapsulated in the created {@link Array} class object.
     *
     * @return Created {@link Array} class object.
     * */
    public <T> Array<T> create(CreatorArray<T> creatorArray, T[] tArray) {
        return creatorArray.create(tArray);
    }

    /**
     * <p>
     * The method that creates the object by delegating the execution of the object creation
     *  to the object of the class {@link CreatorArray} passed by the parameter,
     *  which encapsulates the implementation to create the object class {@link Array}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     *
     * @param <T> The type of objects stored in the array.
     *
     * @param creatorArray An encapsulating implementation object for creating a {@link Array} type of objects.
     * @param lengthArray The length of the array that will be encapsulated in the created {@link Array} class object.
     *
     * @return Created {@link Array} class object.
     * */
    public <T> Array<T> create(CreatorArray<T> creatorArray, int lengthArray) {
        return creatorArray.create(lengthArray);
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the {@link FactoryArray}.
     * </p>
     * @since 1.0
     *
     * @return Object type {@link FactoryArray}
     */
    public static FactoryArray getFactoryArray() {
        return new FactoryArray();
    }

}
