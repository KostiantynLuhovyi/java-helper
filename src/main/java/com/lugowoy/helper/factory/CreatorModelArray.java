package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * Abstract class declaring a contract for the implementation of the functional that creates objects of type Array<T> .
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 * @see com.lugowoy.helper.factory.CreatorModel
 *
 * @param <T> The type of objects that stores the object of the class Array<T>.
 */

public abstract class CreatorModelArray<T> extends CreatorModel {

    /**
     * <p>
     * The method creates an object of the Array<T> type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type Array<T> .
     */
    @Override
    public abstract Array<T> create();

    /**
     * <p>
     * The method creates an object of type Array<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class Array<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type Array<T> .
     */
    public abstract Array<T> create(T[] tArray);

    /**
     * <p>
     * The method creates an object of type Array<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class Array<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type Array<T> .
     */
    public abstract Array<T> create(int lengthArray);

}
