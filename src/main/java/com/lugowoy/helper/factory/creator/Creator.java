package com.lugowoy.helper.factory.creator;

/**
 * Abstract class that is the root of a class hierarchy and declaring a contract
 *  for the implementation of the functional creates different objects.
 * <p>Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @param <T> Type of objects to create.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.factory.creator.Creating
 * @since 1.0
 */
public abstract class Creator<T> implements Creating<T> {

    /**
     * The method executes the creation of an object by calling the constructor of parameters.
     *
     * @return Created object.
     */
    public abstract T create();

}
