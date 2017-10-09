package com.lugowoy.helper.factory;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 *
 * <p>
 * An interface that extends the hierarchy of interfaces.
 * This is the root of the hierarchy of interfaces that declare a contract to implement a factory to create objects
 *  that are types of the Model (and also heirs).
 * </p>
 */
public interface FactorableOfModels<T> extends Factorable{
}
