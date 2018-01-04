package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.Model;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * Abstract class declaring a contract for the implementation of the functional that creates objects
 *  that implement the interface Model.
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 */

public abstract class CreatorModel extends Creator<Model> {

    /**
     * <p>
     * The method creates an object of the Model type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     *
     * @return The created object of type Model.
     */
    @Override
    public abstract Model create();

}
