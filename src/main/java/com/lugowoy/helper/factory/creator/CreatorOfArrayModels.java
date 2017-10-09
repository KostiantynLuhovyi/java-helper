package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.factory.FactorableOfArrayModels;
import com.lugowoy.helper.factory.models.FactoryOfModels;
import com.lugowoy.helper.factory.models.array.FactoryOfArrayModels;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorOfModels
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfArrayModels
 *
 * <p>
 * A class that uses the factory implements the creation of objects of type Array<T>.
 * </p>
 *
 * @param <T> The type of objects that are stored in the array.
 */
public class CreatorOfArrayModels<T> extends CreatorOfModels<Array<T>> implements FactorableOfArrayModels<T> {

    /**
     * <p>
     * An attribute of an object that encapsulates a concrete factory.
     * </p>
     */
    public CreatorOfArrayModels(FactoryOfModels<Array<T>> factory) {
        super(factory);
    }

    /**
     * <p>
     * Method that implements the creation of an object of type Array<T>
     * </p>
     */
    @Override
    public Array<T> create() {
        return super.getFactory().create();
    }

    /**
     * <p>
     * Method that implements the creation of an object of type Array<T>
     * </p>
     *
     * @param array Array of objects that will be encapsulated in an object of type Array<T>.
     */
    @Override
    public Array<T> create(T[] array) {
        return ((FactoryOfArrayModels<T>)super.getFactory()).create(array);
    }

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<T>.
     * </p>
     *
     * @param length The integer passed by the argument is the size of the array storing elements of type <T>.
     */
    @Override
    public Array<T> create(int length) {
        return ((FactoryOfArrayModels<T>)super.getFactory()).create(length);
    }

}
