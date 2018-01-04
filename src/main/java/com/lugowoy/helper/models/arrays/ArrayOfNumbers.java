package com.lugowoy.helper.models.arrays;

/**
 * Created by Konstantin Lugowoy on 31.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A class representing an implementation for using a non-expandable array model whose elements are numbers.
 * </p>
 *
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.arrays.Array
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 *
 * @param <T> The type of number elements stored in the array.
 */

public class ArrayOfNumbers<T extends Number> extends Array<T> implements ArrayOfPrimitiveNumbers {

    /**
     * <p>
     * The default constructor that initializes the created object with an array of default length.
     * Array elements are null.
     * </p>
     * @since 1.0
     */
    public ArrayOfNumbers() {
        super();
    }

    /**
     * <p>
     * The constructor that initializes the created object with an array of passed by an parameter.
     * <p>
     * If the array passed by the parameter is null, the created object will initialize the array with the default length.
     * In this case, the elements of the array are null.
     * </p>
     * @since 1.0
     *
     * @param array Array to initialize the object to be created.
     */
    public ArrayOfNumbers(final T[] array) {
        super(array);
    }

    /**
     * <p>
     * The constructor that initializes the created object with an array whose length is equal to the value passed to the parameter.
     * <p>
     * If the length of array value passed by the parameter is equal to or less the 0,
     *  the created object will initialize the array with the default length.
     * <p>
     * Array elements are null.
     * </p>
     * @since 1.0
     *
     * @param lengthArray The length of the array to initialize the object to be created.
     */
    public ArrayOfNumbers(final int lengthArray) {
        super(lengthArray);
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
     * Returns an array of primitive integer numbers using array elements encapsulated in the object.
     * <p>
     * If the array encapsulated in the object contains real numbers, then their value after the decimal point will be discarded.
     * If the element of the original array contains a real number greater than or less
     *  than the maximum or minimum allowable value of a primitive number of type int,
     *  then the value assigned to the element of the array of primitive numbers will be equal to -2147483648 or 2147483648,
     *  respectively.
     * </p>
     * @since 1.0
     *
     * @return Returns an array of primitive integer numbers.
     */
    @Override
    public int[] getArrayOfIntegerPrimitiveNumbers() {
        final int[] ints = new int[super.getArray().length];
        for (int i = 0; i < super.getArray().length; i++) {
            ints[i] = super.getArray()[i].intValue();
        }
        return ints;
    }

    /**
     * <p>
     * Returns an array of primitive double numbers using array elements encapsulated in the object.
     * <p>
     * If the array encapsulated in the object contains integer numbers, then the value after the decimal point is 0.
     * </p>
     * @since 1.0
     *
     * @return Returns an array of primitive double numbers.
     */
    @Override
    public double[] getArrayOfDoublePrimitiveNumbers() {
        final double[] doubles = new double[super.getArray().length];
        for (int i = 0; i < super.getArray().length; i++) {
            doubles[i] = super.getArray()[i].doubleValue();
        }
        return doubles;
    }

}
