package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.factory.models.FactoryOfModels;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.creator.Creator
 *
 * <p>
 * An abstract class that is a container for a factory that implements creation of objects, heirs of type Model.
 * </p>
 *
 * @param <T> Object type to create.
 */
public abstract class CreatorOfModels<T> extends Creator<T> {

    /**
     * <p>
     * An attribute of an object that encapsulates a concrete factory.
     * </p>
     */
    public CreatorOfModels(FactoryOfModels<T> factory) {
        super(factory);
    }

}
