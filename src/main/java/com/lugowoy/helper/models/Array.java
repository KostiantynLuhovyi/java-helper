package com.lugowoy.helper.models;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * This class is the implementation of the dynamic array model.
 * (own implementation of java.util.ArrayList)
 * <p>Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @param <T> Type of elements (objects) stored in dynamic array (an object of this class).
 * @author Konstantin Lugowoy
 * @version 2.2
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @see java.lang.Iterable
 * @since 1.0
 */
public class Array<T> implements Model, Iterable<T> {

    /**
     * Default length of dynamic array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH = 10;

    private Object[] array;
    private int indexElement;

    /**
     * Constructs a new dynamic array object of size {@link Array#DEFAULT_LENGTH}.
     */
    public Array() {
        this.array = new Object[DEFAULT_LENGTH];
        this.indexElement = 0;
    }

    /**
     * Constructs a new dynamic array object initialized by the elements of the array passed in by the argument.
     * The length of the array is equal to the dimension of the array passed in by the argument.
     * The control index is equal to the index of the last (length of the array) element of the array.
     *
     * @param array Array of elements to initialize.
     * @throws NullPointerException Argument 'array' is null.
     */
    public Array(T[] array) {
        if (array != null) {
            this.array = array;
            this.indexElement = this.array.length;
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
    }

    /**
     * Constructs a new dynamic array object with the length passed in by the argument.
     * The control index is equal to 0.
     *
     * @param lengthArray Length of the array.
     * @throws IllegalArgumentException Argument 'lengthArray' is less than 0 or greater than {@link Integer#MAX_VALUE};
     */
    public Array(int lengthArray) {
        if (lengthArray >= 0 && lengthArray < Integer.MAX_VALUE) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        } else {
            throw new IllegalArgumentException("Argument 'lengthArray': " + lengthArray + " is not valid.");
        }
    }

    /**
     * Constructs a new dynamic array object.
     * Initialize the elements with elements from the dynamic array object passed in by the argument.
     * Copy constructor.
     * The control index is equal to control index of the object passed by argument.
     *
     * @param array Object to copy state.
     * @throws NullPointerException Argument 'array' is null.
     */
    public Array(Array<T> array) {
        if (array != null) {
            this.array = Arrays.copyOfRange(array.toArray((T[]) new Object[array.getLength()]), 0, array.getLength());
            this.indexElement = array.indexElement;
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
    }

    /**
     * Method overridden from class Object.
     * Implemented for comparison on equality of dynamic arrays objects of this class.
     *
     * @param o Object reference for comparison.
     * @return The result of the comparison of objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    /**
     * Method overridden from class Object.
     * Implemented to display hashcode for a dynamic array object of this class.
     *
     * @return Object hashcode.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    /**
     * Method overridden from class Object.
     * Implemented to output a dynamic array object of this class as a string.
     *
     * @return The state of this object as a string.
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Returns the length of a dynamic array object.
     *
     * @return Length of a dynamic array object.
     * @since 1.2
     */
    public int getLength() {
        return this.array.length;
    }

    /**
     * Returns an array (passed in argument) filled with elements of a dynamic array object.
     * <p>The size of the array passed to the argument is not important,
     * so the array with the length as in the dynamic array is returned.
     *
     * @param tArray Array to fill.
     * @return Array filled with elements of a dynamic array object.
     * @throws IncorrectLengthAvailableException Argument 'tArray' has incorrect length.
     * @throws NullPointerException              Argument 'tArray' is null.
     */
    public T[] toArray(T[] tArray) {
        if (isNonNull(tArray)) {
            if (isCorrectLength(tArray.length)) {
                tArray = (T[]) Arrays.copyOf(this.array, this.array.length, tArray.getClass());
            } else {
                throw new IncorrectLengthAvailableException("Argument 'tArray' has incorrect length : " + tArray.length + ".");
            }
        } else {
            throw new NullPointerException("Argument 'tArray' is null.");
        }
        return tArray;
    }

    /**
     * Returns an array containing the elements of the dynamic array object.
     *
     * @return Array containing the elements of the dynamic array object.
     */
    public Object[] toArray() {
        return this.array;
    }

    /**
     * Sets (initializes) a dynamic array object with the elements of the array passed in by the argument.
     * The control index is equal to dynamic array object length.
     *
     * @param array Array with elements to initialize.
     * @throws IncorrectLengthAvailableException Argument 'array' has incorrect length.
     * @throws NullPointerException              Argument 'array' is null.
     * @since 1.0
     */
    public void setArray(T[] array) {
        if (isNonNull(array)) {
            if (isCorrectLength(array.length)) {
                this.array = Arrays.copyOfRange(array, 0, array.length);
                this.indexElement = this.array.length;
            } else {
                throw new IncorrectLengthAvailableException("Array 'array' has incorrect length : " + array.length + ".");
            }
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
    }

    /**
     * Sets the new length of the dynamic array object, thereby resetting all previously data in it.
     * Array elements are null.
     * The control index is equal to 0.
     *
     * @param lengthArray New length of an dynamic array.
     * @throws IllegalArgumentException Argument 'lengthArray' has incorrect value.
     * @since 1.1
     */
    public void setArray(int lengthArray) {
        if (isCorrectLength(lengthArray)) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        } else {
            throw new IllegalArgumentException("Argument 'length' has incorrect value : " + lengthArray);
        }
    }

    /**
     * Get element by index from dynamic array.
     *
     * @param index Index to get the element.
     * @throws IncorrectIndexesAvailableException Argument 'index' has incorrect value.
     * @since 1.2
     */
    public T get(int index) {
        T obj;
        if (isCorrectIndex(index)) {
            obj = (T) this.array[index];
        } else {
            throw new IncorrectIndexesAvailableException("Argument 'index' has incorrect value : " + index + ", size : " + this.array.length);
        }
        return obj;
    }

    /**
     * Sets the element to position by index.
     *
     * @param index Index to insert.
     * @param obj Element to insert.
     * @throws IllegalArgumentException Argument is not valid.
     * @since 1.2
     */
    public void set(int index, T obj) {
        if (index == Objects.checkIndex(index, this.array.length)) {
            this.array[index] = obj;
            this.indexElement += 1;
        } else {
            throw new IllegalArgumentException("Argument 'index' : " + index + "is not valid, size : " + this.array.length);
        }
    }

    /**
     * Adds an element to the next position with a null value.
     * If there is no such position or the size of the dynamic array is not enough, then it expands in length by one element.
     *
     * @param obj Element to adding.
     * @since 1.2
     */
    public void add(T obj) {
        if (this.indexElement < this.array.length) {
            if (this.array[indexElement] == null) {
                this.array[indexElement] = obj;
                this.indexElement += 1;
            }
        } else {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
            this.indexElement = this.array.length - 1;
            this.add(obj);
        }
    }

    /**
     * Deleted element by index.
     * After deletion, the dynamic array collapses.
     *
     * @param index Index element to deleting.
     * @throws IllegalArgumentException Argument is not valid.
     * @since 1.2
     */
    public void delete(int index) {
        if (isCorrectIndex(index)) {
            this.array = Stream.concat(Arrays.stream(Arrays.copyOfRange(this.array, 0, index - 1)),
                                       Arrays.stream(Arrays.copyOfRange(this.array, index, this.array.length)))
                               .toArray();
            this.indexElement -= 1;
        } else {
            throw new IllegalArgumentException("Argument 'index' : " + index + " is not valid, size : " + this.array.length);
        }
    }

    /**
     * Deleted first object in the dynamic array object that is equal to the object passed to the argument.
     * Objects are compared using the equals() method.
     *
     * @param obj Object to deleting.
     * @throws NullPointerException Argument 'obj' is null.
     * @since 1.2
     */
    public void delete(T obj) {
        if (obj != null) {
            for (int i = 0; i < this.array.length; i++) {
                if (obj.equals(this.array[i])) {
                    this.delete(i);
                    break;
                }
            }
        } else {
            throw new NullPointerException("Argument 'obj' is null.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int indexIteratorElement;

            @Override
            public boolean hasNext() {
                return indexIteratorElement < getLength() && get(indexIteratorElement) != null;
            }

            @Override
            public T next() {
                return get(indexIteratorElement++);
            }

        };
    }

    private boolean isCorrectLength(int lengthArray) {
        return lengthArray >= 0 && lengthArray < Integer.MAX_VALUE;
    }

    private boolean isNonNull(T[] array) {
        return array != null;
    }

    private boolean isCorrectIndex(int index) {
        boolean resultOfCheck = false;
        if ((index >= 0) && (index < this.array.length)) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

/*
    public static <T> Array<T> create() {
        return new Array<>();
    }

    public static <T> Array<T> create(int lengthArray) {
        return new Array<>(lengthArray);
    }

    public static <T> Array<T> create(T[] array) {
        return new Array<>(array);
    }

    public static <T> Array<T> create(Array<T> array) {
        return new Array<>(array);
    }
*/

}
