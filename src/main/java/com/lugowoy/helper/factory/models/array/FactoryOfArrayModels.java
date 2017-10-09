package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.factory.FactorableOfArrayModels;
import com.lugowoy.helper.factory.models.FactoryOfModels;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfArrayModels
 * @see com.lugowoy.helper.factory.Factory
 * @see com.lugowoy.helper.factory.models.FactoryOfModels
 *
 * <p>
 * An abstract class that overrides the methods declared in interfaces to implement the creation of type Array object.
 * </p>
 *
 * @param <T> The type of objects that are stored in the array.
 */
public abstract class FactoryOfArrayModels<T> extends FactoryOfModels<Array<T>> implements FactorableOfArrayModels<T> {


    /**
     * <p>
     * Method for creating an object of a type Array<T>.
     * </p>
     */
    @Override
    public abstract Array<T> create();

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array.
     * </p>
     *
     * @param array An array of objects of types <T> that will be encapsulated in an object of type Array.
     */
    @Override
    public abstract Array<T> create(T[] array);

    /**
     * <p>
     * Method for implementation of the creation of the object type Array.
     * </p>
     *
     * @param length The integer passed by the argument is the size of the array storing elements of type <T>.
     */
    @Override
    public abstract Array<T> create(int length);

}
