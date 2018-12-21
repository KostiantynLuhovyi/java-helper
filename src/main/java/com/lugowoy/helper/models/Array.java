package com.lugowoy.helper.models;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * This class is a model of a dynamic array.
 * <p>Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @param <T> The type of elements stored in the array.
 *
 * @author Konstantin Lugowoy
 * @version 2.1 (1.6)
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @see java.lang.Iterable
 * @since 1.0
 */
//todo Add (where needed) and change documentation of methods.
public class Array<T> implements Model, Iterable<T> {

    // Constants.

    /**
     * Default length of array.
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH_ARRAY = 10;

    // Class attributes.

    private Object[] array;
    private int indexElement;

    // Constructors.

    private Array() {
         this.array = new Object[DEFAULT_LENGTH_ARRAY];
         this.indexElement = 0;
    }

    private Array(T[] array) {
        if (array != null) {
            this.array = array;
            this.indexElement = this.array.length;
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
    }

    private Array(int lengthArray) {
        if (lengthArray >= 0 && lengthArray < Integer.MAX_VALUE) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        } else {
            throw new IllegalArgumentException("Argument 'lengthArray': " + lengthArray + " is not valid.");
        }
    }

    @SuppressWarnings("unchecked")
    private Array(Array<T> array) {
        if (array != null) {
            if (array.getLength() > 0) {
                this.array = Arrays.copyOfRange(array.toArray((T[]) new Object[array.getLength()]), 0, array.getLength());
                this.indexElement = array.indexElement;
            } else {
                throw new ArrayIndexOutOfBoundsException("Array has incorrect length : " + array.getLength() + ".");
            }
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
    }

    // Overridden methods of class Object.

    /**
     * Method overridden from class Object.
     * Implemented for comparison on equality of objects of this class.
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
     * Implemented to display hashcode for an object of this class.
     * @return Object hashcode.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    /**
     * Method overridden from class Object.
     * Implemented to output an object of this class as a string.
     * @return The state of this object as a string.
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    // Class methods.

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

    /**
     * Returns an array that is passed by an argument to a method
     * that contains all the elements encapsulated in the array of the object Array class.
     * <p>If the size of the array passed to the method is less than or equal to the original array,
     * an array of a suitable size will be created at runtime,
     * the elements of the original array will be copied to it and it will be returned by the method.
     * @param tArray An array in which all the data from the array encapsulated in the class object will be copied.
     * @return An array containing data from an array encapsulated in the object class.
     */
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] tArray) {
        if (isNonNull(tArray)) {
            if (tArray.length <= this.array.length) {
                tArray = (T[]) Arrays.copyOf(this.array, this.array.length, tArray.getClass());
            } else {
                tArray = (T[]) Arrays.copyOf(this.array, tArray.length, tArray.getClass());
            }
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
        return tArray;
    }

    public Object[] toArray() {
        return this.array;
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
    public void setArray(T[] array) {
        if (isNonNull(array)) {
            if (isCorrectLength(array.length)) {
                this.array = Arrays.copyOfRange(array, 0, array.length);
                this.indexElement = this.array.length;
            } else {
                throw new ArrayIndexOutOfBoundsException("Array has incorrect length : " + array.length + ".");
            }
        } else {
            throw new NullPointerException("Argument 'array' is null.");
        }
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
    public void setArray(int lengthArray) {
        if (isCorrectLength(lengthArray)) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        } else {
            throw new IllegalArgumentException("Argument 'length' : " + lengthArray + " is not valid.");
        }
    }

    /**
     * Get an object located at a specific index.
     *
     * @param index Index to get the object.
     *
     * @since 1.2
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        T obj = null;
        if (isCorrectIndex(index)) {
            obj = (T) this.array[index];
        }
        return obj;
    }

    /**
     * Sets the object to a position with an index.
     * <p> If the index is larger than the size of the array,
     * then the array will be enlarged, as long as the size of the array will fit the size to insert the object into the index.
     *
     * @param index Index to insert.
     * @param obj The adding (insertion) object.
     *
     * @since 1.2
     */
    public void set(int index, T obj) {
        if ((index >= 0) && (index < this.array.length)) {
            this.array[index] = obj;
            this.indexElement += 1;
        } else {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
            this.indexElement = this.array.length - 1;
            this.set(index, obj);
        }
    }

    /**
     * Adds (inserts) an object to the next position, relative to the previous call of this method and adding an object.
     *
     * @param obj The adding (insertion) object.
     *
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
     * Deleted an object at a specific index.
     * <p> After the object is deleted by the index,
     * the array is collapsed (decreasing in size, where the position of the remote object is).
     *
     * @param index Index of the object to be deleted.
     *
     * @since 1.2
     */
    public void delete(int index) {
        if (isCorrectIndex(index)) {
            this.array = Stream.concat(Arrays.stream(Arrays.copyOfRange(this.array, 0, index - 1)),
                                       Arrays.stream(Arrays.copyOfRange(this.array, index, this.array.length)))
                               .toArray();
            this.indexElement -= 1;
        } else {
            throw new IllegalArgumentException("Argument 'index' : " + index + " is not valid.");
        }
    }

    /**
     * Deleted first object in the array that is equal to the object passed to the argument.
     * Objects are compared using the equals() method.
     *
     * @param obj Object to search for the object to be deleted.
     *
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

    // Implementing an Iterator interface.

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

    // Helper (private) methods.

    private boolean isCorrectLength(int lengthArray) {
        return lengthArray >= 0;
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

    // Methods creators.

    //todo add doc's
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

}
