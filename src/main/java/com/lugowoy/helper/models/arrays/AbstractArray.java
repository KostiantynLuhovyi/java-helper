package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.Model;

import java.util.Objects;
import java.util.RandomAccess;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
//todo write doc's
public abstract class AbstractArray implements Model, RandomAccess {

    private static final int ARRAY_HEADER = 8;

    /**
     * The lower boundary value of the size(length) of an array.
     */
    public static final int LOWER_SIZE = 0;

    /**
     * The upper boundary value of the size(length) of an array.
     */
    public static final int UPPER_SIZE = Integer.MAX_VALUE - ARRAY_HEADER;

    /**
     * The default size of an array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH = 10;

    static final int LOWER_SIZE = 0;

    private int size;

    AbstractArray() {
        this.size = DEFAULT_LENGTH;
    }

    AbstractArray(final int lengthArray) {
        CheckerArray.checkLength(lengthArray);
        this.size = LOWER_SIZE;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation on non-null
     * object references:
     * <ul>
     *  <li>It is <i>reflexive</i>: for any non-null reference value
     *  {@code x}, {@code x.equals(x)} should return {@code true}.
     *  <li>It is <i>symmetric</i>: for any non-null reference values
     *  {@code x} and {@code y}, {@code x.equals(y)} should return {@code true}
     *  if and only if {@code y.equals(x)} returns {@code true}.
     *  <li>It is <i>transitive</i>: for any non-null reference values
     *  {@code x}, {@code y}, and {@code z}, if {@code x.equals(y)} returns
     *  {@code true} and {@code y.equals(z)} returns {@code true}, then
     *  {@code x.equals(z)} should return {@code true}.
     *  <li>It is <i>consistent</i>: for any non-null reference values
     *  {@code x} and {@code y}, multiple invocations of {@code x.equals(y)}
     *  consistently return {@code true} or consistently return {@code false},
     *  provided no information used in {@code equals} comparisons on the
     *  objects is modified.
     *  <li>For any non-null reference value {@code x}, {@code x.equals(null)}
     *  should return {@code false}.
     * </ul>
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param o the reference object with which to compare.
     *
     * @return {@code true} if this object is the same as the obj argument;
     * {@code false} otherwise.
     *
     * @see #hashCode()
     * @see java.util.HashMap
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
        return size == that.size;
    }

    /**
     * Returns a hash code value for the object. This method is supported for
     * the benefit of hash tables such as those provided by {@link
     * java.util.HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method must
     * consistently return the same integer, provided no information used in
     * {@code equals} comparisons on the object is modified. This integer need
     * not remain consistent from one execution of an application to another
     * execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of the two
     * objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link java.lang.Object#equals(java.lang.Object)}
     * method, then calling the {@code hashCode} method on each of the two
     * objects must produce distinct integer results.  However, the programmer
     * should be aware that producing distinct integer results for unequal
     * objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined
     * by class {@code Object} does return distinct integers for
     * distinct objects. (The hashCode may or may not be implemented
     * as some function of an object's memory address at some point
     * in time.)
     *
     * @return a hash code value for this object.
     *
     * @see Objects#hashCode(Object)
     * @see java.lang.Object#equals(java.lang.Object)
     * @see java.lang.System#identityHashCode
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }

    public int size() {
        return this.size;
    }

    protected void setSize(final int size) {
        CheckerArray.checkLength(size);
        this.size = size;
    }

}
