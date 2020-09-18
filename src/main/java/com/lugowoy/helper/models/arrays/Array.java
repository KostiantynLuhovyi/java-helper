package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerIndex;

import java.util.*;
import java.util.function.Consumer;

import static com.lugowoy.helper.utils.checking.CheckerIndex.checkIndex;

/**
 * The class represents a description of a dynamic array data structure. Array
 * elements can be of any reference data type. Inherits from class {@link
 * AbstractArray}. Implements the contract declared in interface {@link List}.
 * <p>
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 4.4
 * @since 1.0
 */
public class Array<T> extends AbstractArray implements List<T> {

    private Object[] array;

    /**
     * Constructs an object of this class, thereby creating a dynamic array of
     * capacity {@link AbstractArray#DEFAULT_CAPACITY}.
     */
    public Array() {
        super();
        this.array = new Object[DEFAULT_CAPACITY];
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
     *
     * @throws NullPointerException if the {@code array} is null.
     * @throws LengthOutOfRangeException if the size(length) of the array out of
     * range ​​from {@link AbstractArray#LOWER_CAPACITY} to {@link
     * AbstractArray#UPPER_CAPACITY}.
     */
    @SafeVarargs
    public Array(final T... array) {
        super();
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = Arrays.copyOf(array, array.length);
        super.setSize(this.array.length);
    }

    /**
     * Constructs an object of this class, thereby creating a dynamic array of
     * the {@code capacity} value.
     *
     * @param capacity an array capacity value.
     *
     * @throws LengthOutOfRangeException if the {@code capacity} value out of
     * range from {@link AbstractArray#LOWER_CAPACITY} to {@link
     * AbstractArray#UPPER_CAPACITY}.
     */
    public Array(final int capacity) {
        super();
        this.array = new Object[capacity];
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
     *
     * @throws NullPointerException if the {@code array} is null.
     * @throws LengthOutOfRangeException if the size(length) value of the array
     * out of range ​​from {@link AbstractArray#LOWER_CAPACITY} to {@link
     * AbstractArray#UPPER_CAPACITY}.
     */
    public Array(final Array<T> array) {
        super();
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = Arrays.copyOf(array.toArray(), array.size());
        this.setSize(this.array.length);
    }

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
            cloneArray.setArray((T[]) Arrays.copyOf(this.array, super.size()));
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

    private class IteratorArray implements Iterator<T> {

        private int cursorIterator = 0;
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
            return (T) Array.this.array[this.cursorIterator++];
        }

        @Override
        public void remove() {
            if (this.cursorIterator < 0) {
                throw new IllegalStateException();
            }
            this.checkModification();
            try {
                Array.this.remove(--this.cursorIterator);
                this.expectedModCount = Array.super.getModCount();
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(final Consumer<? super T> action) {
            //TODO not realize
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
     *
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
        return SerializationUtils.clone(this.toArray());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        CheckerArray.check(a, AbstractArray.UPPER_CAPACITY);
        if (a.length < super.size()) {
            a = (E[]) Arrays.copyOf(this.array, super.size(), a.getClass());
        }
        System.arraycopy(this.array, 0, a, 0, super.size());
        return a;
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toDeepArray(E[] a) {
        CheckerArray.check(a, AbstractArray.UPPER_CAPACITY);
        if (a.length < super.size()) {
            a = (E[]) SerializationUtils.clone(
                    Arrays.copyOf(this.array, super.size(), a.getClass()));
        }
        System.arraycopy(this.array, 0, a, 0, super.size());
        return SerializationUtils.clone(a);
    }

    public void setArray(final int size) {
        CheckerArray.checkLength(size, AbstractArray.UPPER_CAPACITY);
        this.array = new Object[size];
        super.setSize(size);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setArray(final T... t) {
        CheckerArray.check(t, AbstractArray.UPPER_CAPACITY);
        this.array = Arrays.copyOf(t, t.length);
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setDeepArray(final T... t) {
        CheckerArray.check(t, AbstractArray.UPPER_CAPACITY);
        this.array = SerializationUtils.clone(t);
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
     *
     * @return the element at the specified position in this list
     *
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
     *
     * @return the element previously at the specified position
     *
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
     *
     * @return {@code true} (as specified by {@link Collection#add})
     *
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
            this.expandArray();
        }
        this.array[super.size()] = t;
        boolean additionResult = false;
        if (this.isExactlyAdded(t)) {
            additionResult = true;
            super.setSize(super.size() + 1);
            super.setModCount(super.getModCount() + 1);
        }
        return additionResult;
    }

    private boolean isExactlyAdded(final T t) {
        return this.array[super.size()].equals(t);
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     *
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
        CheckerBoundNumber.checkInRange(index, AbstractArray.UPPER_CAPACITY);
        CheckerIndex.checkInRange(index, super.size() + 1);
        if (super.size() >= this.array.length) {
            this.expandArray();
        }
        System.arraycopy(this.array, index, this.array, index + 1,
                         super.size() - index);
        this.array[index] = element;
        super.setSize(super.size() + 1);
        super.setModCount(super.getModCount() + 1);
    }

    private void expandArray() {
        this.array = Arrays.copyOf(this.array, this.array.length << 1);
        super.setSize(super.size());
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
     *
     * @return {@code true} if this list changed as a result of the call
     *
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
        boolean resultAddAll = false;
        if (Objects.nonNull(c)) {
            if (!c.isEmpty()) {
                if (c.size() > (this.array.length - super.size())) {
                    this.array = Arrays.copyOf(this.array,
                                               (this.array.length << 1) + c.size());
                }
                System.arraycopy(c.toArray(), 0, this.array, this.size(), c.size());
                super.setSize(super.size() + c.size());
                super.setModCount(super.getModCount() + 1);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
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
     *
     * @return {@code true} if this list changed as a result of the call
     *
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
        CheckerIndex.checkInRange(index, super.size() + 1);
        boolean resultAddAll = false;
        if (Objects.nonNull(c)) {
            if (!c.isEmpty()) {
                if (c.size() > (this.array.length - super.size())) {
                    this.array = Arrays.copyOf(this.array,
                                               (this.array.length * 2) + c
                                                       .size());
                }
                int numMoved = super.size() - index;
                if (numMoved > 0) {
                    System.arraycopy(this.array, index, this.array,
                                     index + c.size(), numMoved);
                }
                System.arraycopy(c.toArray(), 0, this.array, index, c.size());
                super.setSize(super.size() + c.size());
                super.setModCount(super.getModCount() + 1);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Collection argument is null");
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
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this list
     */
    @Override
    public boolean remove(Object o) {
        boolean resultRemove = false;
        if (Objects.nonNull(o)) {
            int size = super.size();
            for (int i = 0; i < size; i++) {
                if (Objects.equals(o, this.array[i])) {
                    this.remove(i);
                    resultRemove = true;
                    break;
                }
            }
        }
        return resultRemove;
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
     *                                       is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, super.size());
        Object[] newArray = new Object[super.size() - 1];
        T resultRemove = this.get(index);
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index, super.size() - (index + 1));
        this.array = newArray;
        super.setSize(super.size() - 1);
        return resultRemove;
    }

    public boolean removeAll(Object o) {
        boolean resultRemove = false;
        if (Objects.nonNull(o)) {
            Iterator<T> iterator = this.iterator();
            while (iterator.hasNext()) {
                T tmpObj = iterator.next();
                if (Objects.equals(tmpObj, o)) {
                    iterator.remove();
                    resultRemove = true;
                }
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
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean resultRemoveAll = false;
        if (Objects.nonNull(c)) {
            if (!c.isEmpty()) {
                Object[] tmpArray = c.toArray();
                int sizeCollection = c.size();
                for (int i = 0; i < sizeCollection; i++) {
                    for (int j = 0; j < super.size(); j++) {
                        if (Objects.equals(tmpArray[i], this.array[j])) {
                            this.remove(j);
                            resultRemoveAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
        }
        return resultRemoveAll;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
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
     *                            is incompatible with this list
     *                            (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public boolean contains(Object o) {
        boolean resultContains = false;
        int i = 0;
        while (i < super.size()) {
            if (Objects.equals(o, this.array[i])) {
                resultContains = true;
                break;
            }
            i++;
        }
        return resultContains;
    }

    /**
     * Returns {@code true} if this list contains all of the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return {@code true} if this list contains all of the elements of the
     * specified collection
     * @throws ClassCastException   if the types of one or more elements
     *                              in the specified collection are incompatible with this
     *                              list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     *                              or more null elements and this list does not permit null
     *                              elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>),
     *                              or if the specified collection is null
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean resultContainsAll = true;
        if (Objects.nonNull(c)) {
            if (!c.isEmpty()) {
                Object[] tmpArrayOfCollection = c.toArray();
                for (Object o : tmpArrayOfCollection) {
                    if (!this.contains(o)) {
                        resultContainsAll = false;
                    }
                }
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
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
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean resultRetainAll = false;
        if (Objects.nonNull(c)) {
            if (!c.isEmpty()) {
                for (Object o : c) {
                    for (int i = 0; i < super.size(); i++) {
                        if (!Objects.equals(o, this.array[i])) {
                            this.remove(o);
                            resultRetainAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
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
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int indexOf(Object o) {
        int resultIndexOf = -1;
        for (int i = 0; i < super.size(); i++) {
            if (Objects.equals(o, this.get(i))) {
                resultIndexOf = i;
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
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int lastIndexOf(Object o) {
        int resultLastIndexOf = -1;
        for (int i = super.size() - 1; i > 0; i--) {
            if (Objects.equals(o, this.get(i))) {
                resultLastIndexOf = i;
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
        return new ArrayList<>(new Array<>((T[]) this.array)).listIterator();
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
     *              list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return new ArrayList<>(new Array<>((T[]) this.array)).listIterator(index);
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     * <p>
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for {@code indexOf} and
     * {@code lastIndexOf}, and all of the algorithms in the
     * {@code Collections} class can be applied to a subList.<p>
     * <p>
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   ({@code fromIndex < 0 || toIndex > size ||
     *                                   fromIndex > toIndex})
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return (List<T>) new ArrayList<>(new Array<>(this.array)).subList(fromIndex, toIndex);
    }

    //todo add constructor (see in ArrayList class) : Array(Collection<?> c);
    //todo add methods (see in ArrayList class) :
    // trimToSize();
    // ensureCapacity(int minCapacity);
    // replaceAll(UnaryOperator<E>);
    // sort(Comparator<? super E>);
    // spliterator();
    // toArray(IntFunction<T[]>);
    // removeIf(Predicate);
    // stream();
    // parallelStream();

}
