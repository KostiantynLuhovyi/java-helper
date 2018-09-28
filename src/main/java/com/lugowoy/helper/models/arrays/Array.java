package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.Model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
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

public class Array<T> implements Model, Iterable<T> {

    /**
     * Default length of array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH_ARRAY = 10;

    private Object[] array;

    private int indexArrayElement;

    /**
     * The default constructor that initializes the created object with an array of default length.
     * Array elements are null.
     *
     * @since 1.0
     */
    public Array() {
         this.array = new Object[DEFAULT_LENGTH_ARRAY];
         this.indexArrayElement = 0;
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
    public Array(T[] array) {
        this.setCorrectArray(array);
        this.indexArrayElement = this.array.length;
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
    public Array(int lengthArray) {
        this.setCorrectArray(lengthArray);
        this.indexArrayElement = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Returns an array that is passed by an argument to a method
     * that contains all the elements encapsulated in the array of the object Array class.
     * <p>If the size of the array passed to the method is less than or equal to the original array,
     * an array of a suitable size will be created at runtime,
     * the elements of the original array will be copied to it and it will be returned by the method.
     *
     * @param tArray An array in which all the data from the array encapsulated in the class object will be copied.
     * @return An array containing data from an array encapsulated in the object class.
     */
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] tArray) {
        if (tArray != null) {
            if (tArray.length <= this.array.length) {
                tArray = (T[]) Arrays.copyOf(this.array, this.array.length, tArray.getClass());
            } else if (tArray.length > this.array.length) {
                tArray = (T[]) Arrays.copyOf(this.array, tArray.length, tArray.getClass());
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
            return tArray;
    }

    /**
     * Returns an array containing all the elements that are encapsulated in this array.
     *
     * @return An array containing data from an array encapsulated in the object class.
     */
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.array.length);
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
        this.setCorrectArray(array);
        this.indexArrayElement = this.array.length;
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
        this.setCorrectArray(lengthArray);
        this.indexArrayElement = this.array.length;
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

    /**
     * Adds (inserts) an object to the next position, relative to the previous call of this method and adding an object.
     *
     * @param obj The adding (insertion) object.
     *
     * @since 1.2
     */
    public void add(T obj) {
        if (this.indexArrayElement < this.array.length) {
            if (this.array[indexArrayElement] == null) {
                this.array[indexArrayElement] = obj;
                this.indexArrayElement += 1;
            }
        } else {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
            this.indexArrayElement = this.array.length - 1;
            this.add(obj);
        }
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
            this.indexArrayElement += 1;
        } else {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
            this.indexArrayElement = this.array.length - 1;
            this.set(index, obj);
        }
    }

    /**
     * Get an object located at a specific index.
     *
     * @param index Index to get the object.
     *
     * @since 1.2
     */
    public T get(int index) {
        T obj = null;
        if (checkIndex(index)) {
            obj = (T) this.array[index];
        }
        return obj;
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
        if (checkIndex(index)) {
            this.array = Stream.concat(Arrays.stream(Arrays.copyOfRange(this.array, 0, index - 1)),
                                       Arrays.stream(Arrays.copyOfRange(this.array, index, this.array.length)))
                               .toArray();
            this.indexArrayElement -= 1;
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

    private void setCorrectArray(T[] array) {
        if (checkNonNull(array)) {
            this.array = array;
        } else {
            this.array = new Object[DEFAULT_LENGTH_ARRAY];
        }
    }

    private void setCorrectArray(int lengthArray) {
        if (checkLengthLargerZero(lengthArray)) {
            this.array = new Object[lengthArray];
        } else {
            this.array = new Object[DEFAULT_LENGTH_ARRAY];
        }
    }

    private boolean checkLengthLargerZero(int lengthArray) {
        return lengthArray >= 0;
    }

    private boolean checkNonNull(T[] array) {
        return array != null;
    }

    private boolean checkIndex(int index) {
        boolean resultOfCheck = false;
        if ((index >= 0) && (index < this.array.length)) {
            resultOfCheck = true;
        }/* else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out-of-bounds for length from 0 to "
                                                                            + (this.array.length - 1) + " inclusive ;");
        }*/
        return resultOfCheck;
    }

}
