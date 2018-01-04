package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfNumbers;

import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A class that implements a contract for a functional that creates objects of type ArrayOfNumbers<T> .
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 * @see com.lugowoy.helper.factory.CreatorModel
 * @see com.lugowoy.helper.factory.CreatorModelArray
 *
 * @param <T> The type of objects that stores the object of the class ArrayOfNumbers<T>.
 */

public class CreatorModelArrayNumbers<T extends Number> extends CreatorModelArray<T> {

    /**
     * <p>
     * The method creates an object of the ArrayOfNumbers<T> type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @return The created object of type ArrayOfNumbers<T> .
     */
    @Override
    public ArrayOfNumbers<T> create() {
        return new ArrayOfNumbers<>();
    }

    /**
     * <p>
     * The method creates an object of type ArrayOfNumbers<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class ArrayOfNumbers<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @return The created object of type ArrayOfNumbers<T> .
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayOfNumbers<T> create(T[] tArray) {
        ArrayOfNumbers<T> array;
        if (tArray != null) {
            array = new ArrayOfNumbers<>(tArray);
        } else {
            array = new ArrayOfNumbers<>((T[])new Number[DEFAULT_LENGTH_ARRAY]);
        }
        return array;
    }

    /**
     * <p>
     * The method creates an object of type ArrayOfNumbers<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class ArrayOfNumbers<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfNumbers
     *
     * @return The created object of type ArrayOfNumbers<T> .
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayOfNumbers<T> create(int lengthArray) {
        ArrayOfNumbers<T> array;
        if (lengthArray > 0) {
            array = new ArrayOfNumbers<>(lengthArray);
        } else {
            array = new ArrayOfNumbers<>((T[])new Number[DEFAULT_LENGTH_ARRAY]);
        }
        return array;
    }

}
