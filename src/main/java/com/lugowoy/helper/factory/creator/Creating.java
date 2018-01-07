package com.lugowoy.helper.factory.creator;

/**
 * Created by Konstantin Lugowoy on 07-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The interface declares a contract to create an object using a constructor without parameters.
 * </p>
 *
 * @param <T> Type of object to create.
 */

public interface Creating<T> {

    /**
     * <p>
     * The method executes the creation of an object by calling the constructor of parameters.
     * </p>
     * @since 1.0
     *
     * @return Created object.
     */
    T create();

}
