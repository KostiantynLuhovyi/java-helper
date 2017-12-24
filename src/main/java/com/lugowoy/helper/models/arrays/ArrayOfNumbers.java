package com.lugowoy.helper.models.arrays;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 18.12.2017
 * <p>
 *      A class representing an implementation for using a non-expandable array model whose elements are numbers.
 * </p>
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.arrays.Array
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 */

public class ArrayOfNumbers<T extends Number> extends Array<T> implements ArrayOfPrimitiveNumbers {

    /**
     * <p>
     *     The default constructor that initializes the created object with an array of the numbers of default size.
     *     Array elements are null.
     * </p>
     */
    public ArrayOfNumbers() {
    }

    /**
     * <p>
     *     The constructor that initializes the created object with an array of the numbers of passed by an argument.
     *
     *     If the array passed by the argument is null, the created object will initialize the array with the default size.
     *     In this case, the elements of the array are null.
     * </p>
     */
    public ArrayOfNumbers(T[] array) {
        super(array);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayOfNumbers<T> clone() throws CloneNotSupportedException {
        ArrayOfNumbers<T> arrayOfNumbers = (ArrayOfNumbers<T>) super.clone();
        arrayOfNumbers.setArray(super.getArray());
        return arrayOfNumbers;
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
    @SuppressWarnings("unchecked")
    @Override
    public void setArray(int sizeOfArray) {
        if (sizeOfArray > 0) {
            super.setArray((T[]) new Object[sizeOfArray]);
        } else {
            super.setArray((T[]) new Object[DEFAULT_SIZE_OF_ARRAY]);
        }
    }

    /**
     * <p>
     *     Returns an array of integers.
     * </p>
     */
    @Override
    public int[] getArrayOfIntegerPrimitiveNumbers() {
        int[] ints = new int[super.getArray().length];
        for (int i = 0; i < super.getArray().length; i++) {
            ints[i] = super.getArray()[i].intValue();
        }
        return ints;
    }

    /**
     * <p>
     *     Initializes an array, by an array passed argument.
     *
     *     If the value of the array passed by the argument is null, an array of the default size will be created.
     *     In this case, the elements of the array are null.
     * </p>
     * @param array Array for initialization.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setArrayOfIntegerPrimitiveNumbers(final int[] array) {
        if (array != null) {
            final Integer[] integers = new Integer[array.length];
            for (int i = 0; i < array.length; i++) {
                integers[i] = array[i];
            }
            super.setArray((T[]) integers);
        } else {
            super.setArray((T[]) new Integer[DEFAULT_SIZE_OF_ARRAY]);
        }
    }

    /**
     * <p>
     *     Returns an array of doubles.
     * </p>
     */
    @Override
    public double[] getArrayOfDoublePrimitiveNumbers() {
        final double[] doubles = new double[super.getArray().length];
        for (int i = 0; i < super.getArray().length; i++) {
            doubles[i] = super.getArray()[i].doubleValue();
        }
        return doubles;
    }

    /**
     * <p>
     *     Initializes an array, by an array passed argument.
     *
     *     If the value of the array passed by the argument is null, an array of the default size will be created.
     *     In this case, the elements of the array are null.
     * </p>
     * @param array Array for initialization.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setArrayOfDoublePrimitiveNumbers(final double[] array) {
        if (array != null) {
            final Double[] doubles = new Double[array.length];
            for (int i = 0; i < array.length; i++) {
                doubles[i] = array[i];
            }
            super.setArray((T[]) doubles);
        } else {
            super.setArray((T[]) new Double[DEFAULT_SIZE_OF_ARRAY]);
        }
    }

}
