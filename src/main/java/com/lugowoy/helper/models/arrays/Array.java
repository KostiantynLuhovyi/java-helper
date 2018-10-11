package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.other.DeepCloning;

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
 * @version 1.6
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @see java.lang.Iterable
 * @since 1.0
 */
public class Array<T> implements Model, Iterable<T> {

    /**
     * Default length of array.
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH_ARRAY = 10;

    private Object[] array;

    private int indexArrayElement;

    /**
     * The default constructor that initializes the created object with an array of default length.
     * Array elements are null.
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
     * @param array Array to initialize the object to be created.
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
     * @param lengthArray The length of the array to initialize the object to be created.
     * @since 1.0
     */
    public Array(int lengthArray) {
        this.setCorrectArray(lengthArray);
        this.indexArrayElement = 0;
    }

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

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Array<T> array = new Array<>();
        try {
            array = (Array<T>) super.clone();
            array = DeepCloning.CLONER.deepClone(this);
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return array;
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
        if (tArray != null) {
            if (tArray.length <= this.array.length) {
                tArray = (T[]) Arrays.copyOf(this.array, this.array.length, tArray.getClass());
            } else {
                tArray = (T[]) Arrays.copyOf(this.array, tArray.length, tArray.getClass());
            }
        } else {
            this.toArray((T[]) new Object[DEFAULT_LENGTH_ARRAY]);
        }
        return tArray;
    }

    //todo add doc's
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
        return lengthArray > 0;
    }

    private boolean checkNonNull(T[] array) {
        return array != null;
    }

    private boolean checkIndex(int index) {
        boolean resultOfCheck = false;
        if ((index >= 0) && (index < this.array.length)) {
            resultOfCheck = true;
        }
        return resultOfCheck;
    }

}
