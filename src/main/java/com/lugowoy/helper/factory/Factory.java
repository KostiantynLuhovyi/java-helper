package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.Creator;

/**
 * Created by Konstantin Lugowoy on 05-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 */

public class Factory {

    private Factory() {
    }

    /**
     * <p>
     * The method that creates the object by delegating the execution of the object creation
     * to the object of the class {@link Creator} passed by the parameter, which encapsulates the implementation to create the object.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     *
     * @param <T> Type of objects to create.
     *
     * @param creating An encapsulating implementation object for creating a specific type of objects.
     *
     * @return Created object.
     * */
    public <T> T create(final Creator<T> creating) {
        return creating.create();
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the factory.
     * </p>
     * @since 1.0
     *
     * @return Object type {@link Factory}
     */
    public static Factory getFactory() {
        return new Factory();
    }

}
