package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import org.apache.commons.lang3.SerializationUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

/**
 * The class represents a description of a dynamic array data structure. Array
 * elements can be of any reference data type. Inherits from class {@link
 * AbstractArray}. Implements the contract declared in interface {@link List}.
 * <p>
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 5.1
 * @since 1.0
 */
//TODO revision of documentation
public class Array<T> extends AbstractArray implements List<T> {

    private Object[] array;

    /**
     * Constructs an object of this class, thereby creating a dynamic array of
     * capacity {@link AbstractArray#DEFAULT_CAPACITY}.
     */
    public Array() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an object of this class, thereby creating a dynamic array of
     * the {@code capacity} value.
     *
     * @param capacity an array capacity value.
     * @throws LengthOutOfRangeException if the {@code capacity} value out of
     * range from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    public Array(final int capacity) {
        super(capacity);
        this.array = new Object[capacity];
        super.setSize(this.array.length);
    }

    /**
     * Constructs an object of this class, thereby creating a dynamic array by
     * initializing it with the elements of the {@code array} passed as argument.
     * To copy elements, call the {@link Arrays#copyOf} method. The capacity of
     * the generated array is the same as the length of the {@code array}
     * argument.
     *
     * @param array an array containing elements to initialize the
     * generated array.
     * @throws NullPointerException if the {@code array} is null.
     * @throws LengthOutOfRangeException if the size(length) of the array out of
     * range ​​from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    @SafeVarargs
    public Array(final T... array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = Arrays.copyOf(array, array.length);
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    /**
     * Copy constructor. Constructs an object of this class, thereby creating a
     * dynamic array by initializing it with the elements of the {@code array}
     * passed as argument. To copy elements, call the {@link Arrays#copyOf}
     * method. The capacity of the generated array is the same as the length of
     * the {@code array} argument.
     *
     * @param array an array containing elements to initialize the
     * generated array.
     * @throws NullPointerException if the {@code array} is null.
     * @throws LengthOutOfRangeException if the size(length) value of the array
     * out of range ​​from {@link Capacity#LOWER} to {@link Capacity#UPPER}.
     */
    public Array(final Array<T> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = Arrays.copyOf(array.array, array.size());
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    //TODO add constructor with Collection object parameter.

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Array)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        Iterator<T> iterator = this.iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            T t = iterator.next();
            sb.append(t == this ? "(this Collection)" : t);
            if (!iterator.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked") //possibly unchecked cast
    @Override
    public Array<T> clone() {
        Array<T> cloneArray;
        try {
            cloneArray = (Array<T>) super.clone();
            cloneArray.setArray((T) SerializationUtils.clone(this.array));
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return cloneArray;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over elements.
     */
    @Override
    public @NotNull Iterator<T> iterator() {
        return new IteratorArray();
    }

    private final class IteratorArray implements Iterator<T> {

        private int cursorIterator = 0;
        private int lastReturned = -1;
        private int expectedModCount = Array.super.getModCount();

        private IteratorArray() {
            super();
        }

        @Override
        public boolean hasNext() {
            return this.cursorIterator != Array.super.size();
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            this.checkModification();
            if (this.cursorIterator >= Array.super.size()) {
                throw new NoSuchElementException();
            }
            if (this.cursorIterator >= Array.this.array.length) {
                throw new ConcurrentModificationException();
            }
            this.lastReturned = this.cursorIterator;
            this.cursorIterator++;
            return (T) Array.this.array[this.lastReturned];
        }

        @Override
        public void remove() {
            if (this.lastReturned < 0) {
                throw new IllegalStateException();
            }
            this.checkModification();
            try {
                Array.this.remove(this.lastReturned);
                this.cursorIterator = this.lastReturned;
                this.lastReturned = -1;
                this.expectedModCount = Array.super.getModCount();
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(final Consumer<? super T> action) {
            throw new UnsupportedOperationException("Not realize.");
        }

        private void checkModification() {
            if (this.expectedModCount != Array.super.getModCount()) {
                throw new ConcurrentModificationException();
            }
        }

    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action the action to be performed for each element.
     * @throws NullPointerException if the specified action is null.
     * @throws NullPointerException if the element is null.
     * @since 1.8
     */
    @Override
    public void forEach(final Consumer<? super T> action) {
        Objects.requireNonNull(action, "Action is null.");
        final int expectedModCount = super.getModCount();
        final int size = super.size();
        for (int i = 0; i < size; i++) {
            if (expectedModCount == super.getModCount()) {
                action.accept(this.get(i));
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return an array containing all of the elements in this list in
     * proper sequence
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, super.size());
    }

    public Object[] toDeepArray() {
        return SerializationUtils.clone(this.array);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        CheckerArray.check(a, Capacity.UPPER.get());
        if (a.length < super.size()) {
            a = (E[]) Arrays.copyOf(this.array, super.size(), a.getClass());
        }
        System.arraycopy(this.array, 0, a, 0, super.size());
        return a;
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toDeepArray(final E[] a) {
        return SerializationUtils.clone(this.toArray(a));
    }

    public void setArray(final int capacity) {
        CheckerArray.checkLength(capacity, Capacity.UPPER.get());
        this.array = new Object[capacity];
        super.setSize(capacity);
        super.setModCount(START_MOD_COUNT);
    }

    public void setArray(final T... t) {
        CheckerArray.check(t, Capacity.UPPER.get());
        this.array = Arrays.copyOf(t, t.length);
        super.setSize(this.array.length);
        super.setModCount(START_MOD_COUNT);
    }

    public void setArray(final Array<T> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = Arrays.copyOf(array.array, array.size());
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setDeepArray(final T... t) {
        CheckerArray.check(t, Capacity.UPPER.get());
        this.array = SerializationUtils.clone(t);
        super.setSize(this.array.length);
        super.setModCount(START_MOD_COUNT);
    }

    public void setDeepArray(final Array<T> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = SerializationUtils.clone(array.toArray());
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return super.size() == 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index >= size()})
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(final int index) {
        CheckerIndex.checkInRange(index, super.size());
        return (T) this.array[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this list
     * @throws ClassCastException if the class of the specified element
     * prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     * this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     * element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index >= size()})
     */
    @Override
    public T set(final int index, final T element) {
        CheckerIndex.checkInRange(index, super.size());
        T oldElement = this.get(index);
        this.array[index] = element;
        return oldElement;
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param t element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the {@code add} operation
     * is not supported by this list
     * @throws ClassCastException if the class of the specified element
     * prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     * list does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     * prevents it from being added to this list
     */
    @Override
    public boolean add(final T t) {
        if (super.size() >= this.array.length) {
            this.ensureCapacity();
        }
        this.array[super.size()] = t;
        boolean additionResult = false;
        if (this.isExactlyAdded(t)) {
            additionResult = true;
            super.increaseSize();
            super.increaseModCount();
        }
        return additionResult;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the {@code add} operation
     * is not supported by this list
     * @throws ClassCastException if the class of the specified element
     * prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     * this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     * element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range from
     * ({@code index >= 0 || index > super.size()})
     */
    @Override
    public void add(final int index, final T element) {
        CheckerIndex.checkInRange(index, super.size() + 1);
        if (super.size() >= this.array.length) {
            this.ensureCapacity();
        }
        System.arraycopy(this.array, index, this.array, index + 1,
                         super.size() - index);
        this.array[index] = element;
        super.increaseSize();
        super.increaseModCount();
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     * is not supported by this list
     * @throws ClassCastException if the class of an element of the specified
     * collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one
     * or more null elements and this list does not permit null
     * elements, or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     * specified collection prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    public boolean addAll(final Collection<? extends T> c) {
        Objects.requireNonNull(c, "Collection argument is null.");
        boolean resultAddAll = false;
        if (!c.isEmpty()) {
            if (c.size() > (this.array.length - super.size())) {
                this.array = Arrays.copyOf(this.array,
                                           (this.array.length << 1) + c.size());
            }
            System.arraycopy(c.toArray(), 0, this.array, this.size(), c.size());
            super.increaseSize(c.size());
            super.increaseModCount();
            resultAddAll = true;
        }
        return resultAddAll;
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the
     * specified collection
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     * is not supported by this list
     * @throws ClassCastException if the class of an element of the specified
     * collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one
     * or more null elements and this list does not permit null
     * elements, or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     * specified collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index > size()})
     */
    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        Objects.requireNonNull(c, "Collection argument is null.");
        CheckerIndex.checkInRange(index, super.size() + 1);
        boolean resultAddAll = false;
        if (!c.isEmpty()) {
            if (c.size() > (this.array.length - super.size())) {
                this.array = Arrays.copyOf(this.array,
                                           (this.array.length << 1) + c.size());
            }
            int numMoved = super.size() - index;
            if (numMoved > 0) {
                System.arraycopy(this.array, index, this.array,
                                 index + c.size(), numMoved);
            }
            System.arraycopy(c.toArray(), 0, this.array, index, c.size());
            super.increaseSize(c.size());
            super.increaseModCount();
            resultAddAll = true;
        }
        return resultAddAll;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     * is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     * list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation
     * is not supported by this list
     */
    @Override
    public boolean remove(final Object o) {
        Objects.requireNonNull(o, "Object argument is null.");
        boolean resultOfRemoving = false;
        for (int i = 0; i < super.size(); i++) {
            if (Objects.equals(o, this.get(i))) {
                this.remove(i);
                resultOfRemoving = true;
                break;
            }
        }
        return resultOfRemoving;
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code remove} operation
     * is not supported by this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index >= size()})
     */
    @Override
    public T remove(final int index) {
        Objects.checkIndex(index, super.size());
        Object[] newArray = new Object[this.array.length - 1];
        T resultRemove = this.get(index);
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index,
                         super.size() - (index + 1));
        this.array = newArray;
        super.decreaseSize();
        super.increaseModCount();
        return resultRemove;
    }

    public boolean removeAll(final Object o) {
        Objects.requireNonNull(o, "Object argument is null.");
        boolean resultRemove = false;
        int indexToRemove;
        while (true) {
            indexToRemove = this.indexOf(o);
            if (indexToRemove == -1) {
                break;
            } else {
                this.remove(indexToRemove);
                resultRemove = true;
            }
        }
        return resultRemove;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code removeAll} operation
     * is not supported by this list
     * @throws ClassCastException if the class of an element of this list
     * is incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     * specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     * or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(@NotNull final Collection<?> c) {
        Objects.requireNonNull(c, "Collection argument is null.");
        int sizeToCheckResult = super.size();
        if (!c.isEmpty()) {
            Object[] tmpArray = c.toArray();
            for (int i = 0; i < c.size(); i++) {
                this.removeAll(tmpArray[i]);
                sizeToCheckResult--;
            }
        }
        return super.size() != sizeToCheckResult;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     * is not supported by this list
     */
    @Override
    public void clear() {
        this.array = new Object[0];
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     * is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }

    /**
     * Returns {@code true} if this list contains all of the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return {@code true} if this list contains all of the elements of the
     * specified collection
     * @throws ClassCastException if the types of one or more elements
     * in the specified collection are incompatible with this
     * list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     * or more null elements and this list does not permit null
     * elements
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     * or if the specified collection is null
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(@NotNull final Collection<?> c) {
        Objects.requireNonNull(c, "Collection argument is null.");
        boolean resultContainsAll = true;
        if (!c.isEmpty()) {
            for (Object o : c) {
                if (!this.contains(o)) {
                    resultContainsAll = false;
                }
            }
        }
        return resultContainsAll;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code retainAll} operation
     * is not supported by this list
     * @throws ClassCastException if the class of an element of this list
     * is incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     * specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     * or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(@NotNull final Collection<?> c) {
        boolean resultRetainAll = false;
        Objects.requireNonNull(c, "Collection argument is null.");
        if (!c.isEmpty()) {
            for (int i = super.size() - 1; i >= 0; i--) {
                Object obj = this.get(i);
                if (!c.contains(obj)) {
                    this.remove(i);
                    resultRetainAll = true;
                }
            }
        }
        return resultRetainAll;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     * is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     * list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int indexOf(final Object o) {
        int resultIndexOf = -1;
        if (o == null) {
            for (int i = 0; i < super.size(); i++) {
                if (this.get(i) == null) {
                    resultIndexOf = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < super.size(); i++) {
                if (o.equals(this.get(i))) {
                    resultIndexOf = i;
                    break;
                }
            }
        }
        return resultIndexOf;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     * is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     * list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int lastIndexOf(final Object o) {
        int resultLastIndexOf = -1;
        if (o == null) {
            for (int i = super.size() - 1; i >= 0; i--) {
                if (this.get(i) == null) {
                    resultLastIndexOf = i;
                    break;
                }
            }
        } else {
            for (int i = super.size() - 1; i >= 0; i--) {
                if (this.get(i).equals(o)) {
                    resultLastIndexOf = i;
                    break;
                }
            }
        }
        return resultLastIndexOf;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     * sequence)
     */
    @Override
    public ListIterator<T> listIterator() {
        return new ArrayList<T>(new Array<>((T[]) this.array)).listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param index index of the first element to be returned from the
     * list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ArrayList<T>(new Array<>((T[]) this.array)).listIterator(
                index);
    }

    //TODO: documentation
    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        CheckerIndex.checkInRange(fromIndex, START_SIZE, super.size());
        CheckerIndex.checkInRange(toIndex, START_SIZE, super.size());
        Array<T> list = new Array<>();
        if (CheckerBoundNumber.isLowerLessUpper(fromIndex, toIndex)) {
            for (int i = fromIndex, j = 0; i < toIndex; i++, j++) {
                list.add(this.get(i));
            }
        }
        return list;
    }

    //TODO documentation
    public void ensureCapacity() {
        if (super.size() == this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length << 1);
        }
    }

    //TODO documentation
    public void trimToSize() {
        if (super.size() < this.array.length) {
            this.array = Arrays.copyOf(this.array, super.size());
            super.increaseModCount();
        }
    }

    private boolean isExactlyAdded(final T t) {
        return this.array[super.size()].equals(t);
    }

}
