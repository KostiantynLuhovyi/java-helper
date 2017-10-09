package com.lugowoy.helper.factory.models;

import com.lugowoy.helper.factory.Factory;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factory
 *
 * <p>
 * An abstract class that is the root of the factory class hierarchy
 * that implements the contract declared to create the objects of the Model class heirs.
 * </p>
 *
 * @param <T> Object type to create.
 */
public abstract class FactoryOfModels<T> extends Factory<T> {
}
