package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.Creating;

/**
 * Created by Konstantin Lugowoy on 05-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 *
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> The type of objects created by the factory.
 */

public class Factory<T> implements Creating<T> {

    private Creating<T> creating;

    /**
     * <p>
     * A constructor with a parameter that takes an object of the class that implements the contract interface {@link Creating}
     * to create objects of different types for initialization to attribute of factory.
     * </p>
     *
     * @see com.lugowoy.helper.factory.creator.Creating
     *
     * @param creating An object of the class that implements the contract interface {@link Creating} to create objects of different types.
     *
     * @since 1.1
     */
    Factory(Creating<T> creating) {
        this.creating = creating;
    }

    /**
     * <p>
     * The method executes the creation of an object by calling the constructor of parameters.
     * </p>
     *
     * @return Created object.
     *
     * @since 1.1
     */
    @Override
    public T create() {
        return this.creating.create();
    }

    /**
     * <p>
     * Returns the object that is encapsulated in the factory.
     * This object implements the interface contract {@link Creating} and performs the functionality to create objects.
     * </p>
     *
     * @see com.lugowoy.helper.factory.creator.Creating
     *
     * @return Returns the object encapsulated in the factory, needed to create objects of different types.
     *
     * @since 1.1
     */
    protected Creating<T> getCreating() {
        return this.creating;
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the {@link Factory}.
     * </p>
     *
     * @return Object type {@link FactoryArray}
     *
     * @since 1.1
     */
    public static <T> Factory<T> getFactory(final Creating<T> creating) {
        return new Factory<>(creating);
    }

}
