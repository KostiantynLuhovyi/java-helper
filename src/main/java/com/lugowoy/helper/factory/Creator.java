package com.lugowoy.helper.factory;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * An abstract class that is the root of a class hierarchy
 *  and declaring a contract for the implementation of the functional creates different objects.
 * </p>
 *
 * @param <T> The type of objects to be created.
 */

public abstract class Creator<T> {

    /**
     * <p>
     * The method creates an object of the type passed by the generic parameter, invoking the default constructor.
     * </p>
     * @since 1.0
     *
     * @return Created object.
     */
    public abstract T create();

}
