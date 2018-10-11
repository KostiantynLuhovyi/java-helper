package com.lugowoy.helper.factory.creator;

/**
 * The interface declares a contract to create an object using a constructor without parameters.
 * <p>Created by Konstantin Lugowoy on 07-Jan-18.
 *
 * @param <T> Type of object to create.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 */
public interface Creating<T> {

    /**
     * The method executes the creation of an object by calling the constructor of parameters.
     *
     * @return Created object.
     */
    T create();

}
