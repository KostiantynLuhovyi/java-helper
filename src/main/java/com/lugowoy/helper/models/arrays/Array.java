package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.Model;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 18.12.2017
 * <p>
 *     A class that is the root of the inheritance hierarchy is a different class
 *     for the implementation and use of the model of an elementary non-expandable array.
 * </p>
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @param <T> The type of elements stored in the array.
 */

public abstract class Array<T> implements Model {

    /**
     * <p>
     *     Default array size.
     * </p>
     */
    static final int DEFAULT_SIZE_OF_ARRAY = 5;

    private T[] array;

    /**
     * <p>
     *     The default constructor that initializes the created object with an array of default size.
     *     Array elements are null.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public Array() {
        this.array = (T[]) new Object[DEFAULT_SIZE_OF_ARRAY];
    }

    /**
     * <p>
     *     The constructor that initializes the created object with an array of passed by an argument.
     *
     *     If the array passed by the argument is null, the created object will initialize the array with the default size.
     *     In this case, the elements of the array are null.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public Array(final T[] array) {
        if (array != null) {
            this.array = array;
        } else {
            this.array = (T[]) new Object[DEFAULT_SIZE_OF_ARRAY];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array<?> array1 = (Array<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getArray(), array1.getArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArray());
    }

    @Override
    public String toString() {
        return "Array" + Arrays.toString(array);
    }

    /**
     * <p>
     *     Returns an array that is encapsulated in this object.
     * </p>
     */
    public T[] getArray() {
        return this.array;
    }

    /**
     * <p>
     *     Sets the value for the attribute of the array encapsulated in this object.
     *
     *     If the value of the array passed by the argument is null, an array of the default size will be created.
     *     In this case, the elements of the array are null.
     * </p>
     * @param array An array whose value will be assigned to the object attribute.
     */
    @SuppressWarnings("unchecked")
    public void setArray(final T[] array) {
        if (array != null) {
            this.array = array;
        } else {
            this.array = (T[]) new Object[DEFAULT_SIZE_OF_ARRAY];
        }
    }

    /**
     * <p>
     *      Sets the value for the attribute of the array encapsulated in this object,
     *      creating a new array with the size of the value passed by the argument.
     *
     *      If the value passed by the argument is equal to or less than 0,
     *      then the attribute is initialized by an array of the default size.
     *
     *      Array elements are null.
     * </p>
     * @param sizeOfArray The size of the array to create and initialize the attribute of the object.
     */
    public abstract void setArray(int sizeOfArray);

}
