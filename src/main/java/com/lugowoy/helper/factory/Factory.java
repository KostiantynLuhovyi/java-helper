package com.lugowoy.helper.factory;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 *
 * <p>
 * An abstract class that is the root of the class hierarchy,
 *  that implements the contract declared for the factory to create objects of different types.
 * </p>
 *
 * @param <T> Object type to create.
 */
public abstract class Factory<T> {

    /**
     * <p>
     * Method for creating an object of a concrete type.
     * </p>
     */
    public abstract T create();

}
