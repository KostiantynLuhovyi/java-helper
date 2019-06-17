package com.lugowoy.helper.models;

import com.lugowoy.helper.other.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * The class implements the array model.
 * (own implementation of java.util.ArrayList)
 * <p>Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @param <T> Type of elements (objects) stored in an array (an object of this class).
 * @author Konstantin Lugowoy
 * @version 2.3
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @see java.lang.Iterable
 * @since 1.0
 */
public class Array<T> implements Model, Iterable<T> {

    /**
     * Default length of an array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH = 10;

    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = Integer.MAX_VALUE;

    private Object[] array;
    private int indexElement;

    /**
     * Constructs a new array object of default size(10).
     * <p>The control index is equal to 0.
     */
    public Array() {
        this.array = new Object[DEFAULT_LENGTH];
        this.indexElement = 0;
    }

    /**
     * Constructs a new array object initialized by the elements of the array passed in by the argument.
     * The length of the array is equal to the dimension of the array passed in by the argument.
     * <p>The control index is equal to the index of the last (length of the array) element of the array.
     *
     * @param array Array of elements to initialize.
     * @throws NullPointerException           Argument array is null.
     * @throws LengthArrayOutOfRangeException If the argument array has a length outside the range.
     */
    public Array(T[] array) {
        if (Objects.nonNull(array)) {
            if (CheckerLengthArray.checkLengthArray(array)) {
                this.array = array;
                this.indexElement = this.array.length;
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Constructs a new array object with the length passed in by the argument.
     * The value of the argument must be in the range of values from {@link Array#MIN_LENGTH} to {@link Array#MAX_LENGTH}.
     * <p>The control index is equal to 0.
     *
     * @param lengthArray Length value of an array.
     * @throws LengthValueOutOfRangeException If the array length argument is out of range.
     */
    public Array(int lengthArray) {
        if (CheckerLength.checkLength(lengthArray)) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        }
    }

    /**
     * Constructs a new array object.
     * Initialize the elements with elements from the array object passed in by the argument.
     * Copy constructor.
     * <p>The control index is equal to control index of the object passed by argument.
     *
     * @param array The object of the {@link Array} class to copy state.
     * @throws NullPointerException           Argument array is null.
     * @throws LengthArrayOutOfRangeException If the array passed to the argument is out of range.
     */
    public Array(Array<T> array) {
        if (Objects.nonNull(array)) {
            if (CheckerLengthArray.checkLengthArray(array)) {
                T[] tmpArray = array.toArray((T[]) new Object[array.getLength()]);
                int from = 0;
                this.array = Arrays.copyOfRange(tmpArray, from, array.getLength());
                this.indexElement = array.indexElement;
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Argument array is null."));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array<?> array1 = (Array<?>) o;
        return indexElement == array1.indexElement &&
                Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(indexElement);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" +
                "array=" + Arrays.toString(array) +
                ", indexElement=" + indexElement +
                ']';
    }

    /**
     * Returns the length of an array object.
     *
     * @return Length of an array.
     * @since 1.2
     */
    public int getLength() {
        return this.array.length;
    }

    /**
     * Gets an array (passed in argument) filled with elements of the encapsulated array object.
     * <p>The size of the array passed to the argument is not important
     * (but only more than {@link Array#MIN_LENGTH} and less than {@link Integer#MAX_VALUE}),
     * so the array with the length as in an array is returned.
     *
     * @param array Array to fill.
     * @return Array filled with elements of an array object.
     * @throws NullPointerException           If argument array is null.
     * @throws LengthArrayOutOfRangeException If the array passed to the argument has an incorrect length.
     */
    public T[] toArray(T[] array) {
        if (Objects.nonNull(array)) {
            if (CheckerLengthArray.checkLengthArray(array)) {
                array = (T[]) Arrays.copyOf(this.array, this.array.length, array.getClass());
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Argument array is null."));
        }
        return array;
    }

    /**
     * Gets an array containing the elements of an array object.
     *
     * @return Array containing the elements of an array object.
     */
    public Object[] toArray() {
        return this.array;
    }

    /**
     * Sets an array object with the elements of the array passed in by the argument.
     * The control index is equal to an array object length.
     *
     * @param array Array with elements to initialize.
     * @throws NullPointerException           If argument array is null.
     * @throws LengthArrayOutOfRangeException If the argument array has a length outside the range.
     * @since 1.0
     */
    public void setArray(T[] array) {
        if (Objects.nonNull(array)) {
            if (CheckerLengthArray.checkLengthArray(array)) {
                this.array = Arrays.copyOfRange(array, 0, array.length);
                this.indexElement = this.array.length;
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Argument array is null."));
        }
    }

    /**
     * Sets the new length of an array object, thereby resetting all previously data in it.
     * Array elements are null.
     * The control index is equal to 0.
     *
     * @param lengthArray New length of an array.
     * @throws LengthValueOutOfRangeException If the array length argument is out of range.
     * @since 1.1
     */
    public void setArray(int lengthArray) {
        if (CheckerLength.checkLength(lengthArray)) {
            this.array = new Object[lengthArray];
            this.indexElement = 0;
        }
    }

    /**
     * Get element by index from an array.
     *
     * @param index Index to get the element.
     * @throws IndexOutOfBoundsException If the index argument is out of range.
     * @since 1.2
     */
    public T get(int index) {
        T obj = null;
        if (CheckerIndex.checkIndex(index)) {
            obj = (T) this.array[index];
        }
        return obj;
    }

    /**
     * Set the element to position by index.
     *
     * @param index Index to insert.
     * @param obj   Element to insert.
     * @throws IndexOutOfBoundsException If the index argument is out of range.
     * @since 1.2
     */
    public void set(int index, T obj) {
        if (CheckerIndex.checkIndex(index)) {
            this.array[index] = obj;
            this.indexElement += 1;
        }
    }

    /**
     * Add an element to the next position with a null value.
     * If there is no such position or the size of an array is not enough, then it expands in length by one element.
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
     * After deletion an array collapses.
     *
     * @param index Index element to deleting.
     * @throws IndexOutOfBoundsException If the index argument is out of range.
     * @since 1.2
     */
    public void delete(int index) {
        if (CheckerIndex.checkIndex(index)) {
            this.array = Stream.concat(Arrays.stream(Arrays.copyOfRange(this.array, 0, index - 1)),
                    Arrays.stream(Arrays.copyOfRange(this.array, index, this.array.length)))
                    .toArray();
            this.indexElement -= 1;
        }
    }

    /**
     * Deleted first object in an array object that is equal to the object passed to the argument.
     * Objects are compared using the equals() method.
     *
     * @param obj Object to deleting.
     * @throws NullPointerException If argument obj is null.
     * @since 1.2
     */
    public void delete(T obj) {
        if (Objects.nonNull(obj)) {
            for (int i = 0; i < this.array.length; i++) {
                if (obj.equals(this.array[i])) {
                    this.delete(i);
                    break;
                }
            }
        } else {
            throw new NullPointerException("Argument obj is null.");
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
