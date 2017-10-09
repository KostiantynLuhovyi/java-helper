package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 *
 * <p>
 * An interface that declares methods for a contract that must be implemented for a factory of objects of type Array.
 * </p>
 *
 * @param <T> The type of objects that will be stored in the created array.
 */
public interface FactorableOfArrayModels<T> extends FactorableOfModels<Array<T>> {

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array.
     * </p>
     *
     * @param array An array of objects of types <T> that will be encapsulated in an object of type Array.
     */
    Array<T> create(T[] array);

    /**
     * <p>
     * Method for implementation of the creation of the object type Array.
     * </p>
     *
     * @param length The integer passed by the argument is the size of the array storing elements of type <T>.
     */
    Array<T> create(int length);

}
