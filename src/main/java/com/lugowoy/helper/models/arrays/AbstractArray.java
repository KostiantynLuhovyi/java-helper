package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.utils.LengthOutOfRangeException;

import java.util.Objects;
import java.util.RandomAccess;

/**
 * The abstract class describing the root for the hierarchy of classes
 * representing dynamic arrays for storing various objects.<br>The class
 * contains a size attribute that is used to determine the length of a
 * dynamic array. There are also accessor methods (public getter and
 * protected setter) to this attribute.
 * <p>
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 2.0
 */
public abstract class AbstractArray implements Model, RandomAccess {

    private static final int ARRAY_HEADER = 8;

    /**
     * The lower boundary value of the capacity of an array.
     */
    public static final int LOWER_CAPACITY = 0;

    /**
     * The upper boundary value of the capacity of an array.
     */
    public static final int UPPER_CAPACITY = Integer.MAX_VALUE - ARRAY_HEADER;

    /**
     * The default size of an array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_CAPACITY = 10;

    private int size;
    private int modCount = 0;

    //TODO change documentation
    /**
     * Constructs an object of an array (for the heir class), with size(length)
     * {@link AbstractArray#DEFAULT_SIZE}.
     */
    AbstractArray() {
    }

    //TODO change documentation
    /**
     * Constructs an object of an array (for the heir class) by initializing it
     * with the size(length) of the {@code size} argument. The argument {@code
     * size} must range (inclusive, respectively) from {@link
     * AbstractArray#LOWER_SIZE} to {@link AbstractArray#UPPER_SIZE}.
     *
     * @param size the size(length) of the created array.
     *
     * @throws LengthOutOfRangeException if the {@code size} value out of range
     * ​​from {@link AbstractArray#LOWER_SIZE} to {@link AbstractArray#UPPER_SIZE}.
     */
    AbstractArray(final int size) {
        CheckerArray.checkLength(size, AbstractArray.UPPER_SIZE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractArray)) {
            return false;
        }
        final AbstractArray that = (AbstractArray) o;
        return size == that.size && getModCount() == that.getModCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, getModCount());
    }

    /**
     * Gets the size of an array.
     *
     * @return the size of an array.
     */
    public int size() {
        return this.size;
    }

    /**
     * Sets the size of an array.<br>The argument {@code size} must range
     * (inclusive, respectively) from {@link AbstractArray#LOWER_SIZE} to {@link
     * AbstractArray#UPPER_SIZE}.
     *
     * @param size the size of an array.
     *
     * @throws LengthOutOfRangeException if the {@code size} value out of range
     * from {@link AbstractArray#LOWER_SIZE} to {@link AbstractArray#UPPER_SIZE}.
     */
    protected void setSize(final int size) {
        CheckerArray.checkLength(size);
        this.size = size;
    }

    /**
     * Gets the value of the modification count.
     *
     * @return the value of the modification count.
     */
    protected int getModCount() {
        return this.modCount;
    }

    /**
     * Set the value of the modification count. The {@code newModCount} value
     * must be positive.
     *
     * @param newModCount the value of the new modification count.
     *
     * @throws IllegalArgumentException if the {@code newModCount} argument
     * is negative.
     */
    protected void setModCount(final int newModCount) {
        if (newModCount >= 0) {
            this.modCount = newModCount;
        } else {
            throw new IllegalArgumentException(
                    "The new modification count value must be positive.");
        }
    }

}
