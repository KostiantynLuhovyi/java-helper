package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.factory.Factory;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 *
 * <p>
 * An abstract class that is the root of a class hierarchy
 *  that are containers for encapsulating a particular factory to create objects.
 * </p>
 *
 * @param <T> Object type to create.
 */
public abstract class Creator<T> {

    /**
     * <p>
     * An attribute of an object that encapsulates a concrete factory.
     * </p>
     */
    private Factory<T> factory;

    /**
     * <p>
     * Constructor initializing attribute {@link #factory}.
     * </p>
     */
    public Creator(Factory<T> factory) {
        this.factory = factory;
    }

    /**
     * <p>
     * A method that returns an object created by a factory that is encapsulated in an attribute {@link #factory}.
     * </p>
     */
    public abstract T create();

    /**
     * <p>
     * The method that returns the encapsulated factory in the attribute {@link #factory}.
     * </p>
     */
    public Factory<T> getFactory() {
        return factory;
    }

}
