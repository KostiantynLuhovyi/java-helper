package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.Model;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 *
 * A class that is the root of the inheritance hierarchy is a different class
 *  for the implementation and use of the model of an elementary non-expandable array.
 *
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 *
 * @param <T> The type of elements stored in the array.
 */

public abstract class Array<T> implements Model {

    /**
     * Default length of array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH_ARRAY = 10;

    private Object[] array;

    /**
     * The default constructor that initializes the created object with an array of default length.
     * Array elements are null.
     *
     * @since 1.0
     */
    public Array() {
         this.array = new Object[DEFAULT_LENGTH_ARRAY];
    }

    /**
     * The constructor that initializes the created object with an array of passed by an parameter.
     * <p> If the array passed by the parameter is null, the created object will initialize the array with the default length.
     * In this case, the elements of the array are null.
     *
     * @param array Array to initialize the object to be created.
     *
     * @since 1.0
     */
    public Array(final T[] array) {
        this.setCorrectArray(array);
    }

    /**
     * The constructor that initializes the created object with an array whose length is equal to the value passed to the parameter
     * <p> If the length of array value passed by the parameter is equal to or less the 0,
     *  the created object will initialize the array with the default length.
     * <p> Array elements are null.
     *
     * @param lengthArray The length of the array to initialize the object to be created.
     *
     * @since 1.0
     */
    public Array(final int lengthArray) {
        this.setCorrectArray(lengthArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array<?> array1 = (Array<?>) o;
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
     * Returns an array that is encapsulated in this object.
     *
     * @return The object of the array encapsulated in this object.
     *
     * @since 1.0
     */
    @SuppressWarnings("unchecked") // Type safety. Unchecked cast Object[] to T[].
    public T[] getArray() {
        return (T[]) this.array;
    }

    /**
     * Sets the object of the array encapsulated in this object.
     * <p> If the object of the array passed by the parameter is null, an array of the default length will be created.
     * In this case, the elements of the array are null.
     *
     * @param array An array object to initialize an array encapsulated in this object.
     *
     * @since 1.0
     */
    public void setArray(final T[] array) {
        this.setCorrectArray(array);
    }

    /**
     * Sets the value for the object of the array encapsulated in this object,
     *  creating a new array with the length of passed by the parameter.
     * <p> If the length value passed by the parameter is equal to or less than 0,
     *  then the array is initialized by an array of the default length..
     * <p> Array elements are null.
     *
     * @param lengthArray The length of array to create and initialize the array that encapsulates of the object.
     *
     * @since 1.1
     */
    public void setArray(final int lengthArray) {
        this.setCorrectArray(lengthArray);
    }

    /**
     * Returns value of length of array that is encapsulated in object of this class.
     *
     * @return The value of length of an array.
     *
     * @since 1.2
     */
    public int getLength() {
        return this.array.length;
    }

    private void setCorrectArray(final T[] array) {
        if (checkNonNull(array)) {
            this.array = array;
        } else {
            this.array = new Object[DEFAULT_LENGTH_ARRAY];
        }
    }

    private void setCorrectArray(final int lengthArray) {
        if (checkLengthLargerZero(lengthArray)) {
            this.array = new Object[lengthArray];
        } else {
            this.array = new Object[DEFAULT_LENGTH_ARRAY];
        }
    }

    private boolean checkLengthLargerZero(final int lengthArray) {
        return lengthArray > 0;
    }

    private boolean checkNonNull(final T[] array) {
        return array != null;
    }

}
