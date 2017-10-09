package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.Model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.1
 *
 * @see Serializable
 * @see Cloneable
 * @see com.lugowoy.helper.models.Model
 * <p>
 * A class is the root of a hierarchy that implements the subject area to work with a variety of types of arrays.
 * </p>
 * @param <T> The type of array elements that will be stored in the array.
 */
public abstract class Array<T> extends Model implements Serializable, Cloneable {

    public static final int DEFAULT_SIZE_ARRAY = 5;

    /**
     * <p></p>
     * */
    private T[] array;

    /**
     * <p></p>
     * */
    public Array() {
        super();
    }

    /**
     * <p></p>
     * */
    public Array(T[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        if (!super.equals(o)) return false;

        Array<?> array1 = (Array<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getArray(), array1.getArray());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getArray());
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Array[" + Arrays.toString(array) + "]";
    }

    /**
     * <p></p>
     * */
    public T[] getArray() {
        return array;
    }

    /**
     * <p></p>
     * */
    public void setArray(T[] array) {
        this.array = array;
    }

    /**
     * <p></p>
     * */
    public abstract void setArray(int lengthArray);

}
