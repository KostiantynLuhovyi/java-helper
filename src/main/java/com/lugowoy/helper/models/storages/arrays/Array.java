package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.utils.checking.CheckerIndex;
import com.lugowoy.helper.utils.checking.CheckerLengthArray;
import com.rits.cloning.Cloner;

import java.util.*;
import java.util.function.Consumer;

/**
 * <p>Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 2.6
 * @since 1.0
 */
//todo edit doc's
public class Array<T> extends AbstractArray implements List<T> {

    private Object[] array;

    public Array() {
        this.array = new Object[DEFAULT_LENGTH];
        super.setCursorElement(this.array.length);
    }

    public Array(T[] array) {
        if (CheckerLengthArray.checkLengthInArray(array)) {
            this.array = array;
            super.setCursorElement(this.array.length);
        }
    }

    public Array(T[] array, boolean flagDeepCopy) {
        if (CheckerLengthArray.checkLengthInArray(array)) {
            if (flagDeepCopy) {
                this.array = new Cloner().deepClone(array);
            } else {
                this.array = array;
            }
            super.setCursorElement(this.array.length);
        }
    }

    public Array(int lengthArray) {
        if (CheckerLengthArray.checkLengthArray(lengthArray)) {
            this.array = new Object[lengthArray];
            super.setCursorElement(this.array.length);
        }
    }

    public Array(Array<T> array) {
        if (CheckerLengthArray.checkLengthInArray(array)) {
            this.array = array.toArray();
            super.setCursorElement(this.array.length);
        }
    }

    public Array(Array<T> array, boolean flagDeepCopy) {
        if (CheckerLengthArray.checkLengthInArray(array)) {
            if (flagDeepCopy) {
                this.array = new Cloner().deepClone(array.toArray());
            } else {
                this.array = array.toArray();
            }
            super.setCursorElement(this.array.length);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        if (!super.equals(o)) return false;
        Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [" + Arrays.toString(array)
                + "], cursorElement:" + super.getCursorElement();
    }


    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return this.array.length;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int cursorIteratorElement = 0;

            @Override
            public boolean hasNext() {
                return cursorIteratorElement != size();
            }

            @Override
            public T next() {
                return get(cursorIteratorElement++);
            }

            /**
             * Removes from the underlying collection the last element returned
             * by this iterator (optional operation).  This method can be called
             * only once per call to {@link #next}.
             * <p>
             * The behavior of an iterator is unspecified if the underlying collection
             * is modified while the iteration is in progress in any way other than by
             * calling this method, unless an overriding class has specified a
             * concurrent modification policy.
             * <p>
             * The behavior of an iterator is unspecified if this method is called
             * after a call to the {@link #forEachRemaining forEachRemaining} method.
             *
             * @throws UnsupportedOperationException if the {@code remove}
             *                                       operation is not supported by this iterator
             * @throws IllegalStateException         if the {@code next} method has not
             *                                       yet been called, or the {@code remove} method has already
             *                                       been called after the last call to the {@code next}
             *                                       method
             * @implSpec The default implementation throws an instance of
             * {@link UnsupportedOperationException} and performs no other action.
             */
            @Override
            public void remove() {
                Array.this.remove(cursorIteratorElement);
            }
        };
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
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        T res = null;
        for (T t : this) {
            res = t;
        }
        action.accept(res);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must
     * allocate a new array even if this list is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     * @see Arrays#asList(Object[])
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size());
    }

    public Object[] toDeepArray() {
        return new Cloner().deepClone(this.array);
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array
     * immediately following the end of the list is set to {@code null}.
     * (This is useful in determining the length of the list <i>only</i> if
     * the caller knows that the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose {@code x} is a list known to contain only strings.
     * The following code can be used to dump the list into a newly
     * allocated array of {@code String}:
     *
     * <pre>{@code
     *     String[] y = x.toArray(new String[0]);
     * }</pre>
     * <p>
     * Note that {@code toArray(new Object[0])} is identical in function to
     * {@code toArray()}.
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @throws ArrayStoreException  if the runtime type of the specified array
     *                              is not a supertype of the runtime type of every element in
     *                              this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <V> V[] toArray(V[] a) {
        if (CheckerLengthArray.checkLengthInArray(a)) {
            if (a.length < this.size()) {
                a = (V[]) Arrays.copyOf(this.array, this.size());
            } else {
                System.arraycopy(this.array, 0, a, 0, this.size());
            }
        }
        return a;
    }

    public void setArray(T[] t) {
        if (CheckerLengthArray.checkLengthInArray(t)) {
            this.array = Arrays.copyOf(t, t.length);
        }
    }

    public void setArray(T[] t, boolean flagDeepCopy) {
        if (CheckerLengthArray.checkLengthInArray(t)) {
            if (flagDeepCopy) {
                this.array = new Cloner().deepClone(t);
            }
        }
    }

    @Override
    public void setArray(int lengthArray) {
        if (CheckerLengthArray.checkLengthArray(lengthArray)) {
            this.array = new Object[lengthArray];
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    @Override
    public T get(int index) {
        T resultGet = null;
        if (CheckerIndex.checkIndex(index, this.size())) {
            resultGet = (T) this.array[index];
        }
        return resultGet;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code set} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    @Override
    public T set(int index, T element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            this.array[index] = element;
        }
        return element;
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
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    @Override
    public boolean add(T t) {
        boolean resultAdd = false;
        if (super.getCursorElement() < this.size()) {
            this.array[super.getCursorElement()] = t;
            super.setCursorElement(super.getCursorElement() + 1);
            resultAdd = true;
        } else {
            Object[] tmpArray = new Object[this.size() + 1];
            System.arraycopy(this.array, 0, tmpArray, 0, this.size());
            this.array = tmpArray;
            this.add(t);
        }
        return resultAdd;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the {@code add} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    @Override
    public void add(int index, T element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            this.array[index] = element;
        }
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
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one
     *                                       or more null elements and this list does not permit null
     *                                       elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean resultAddAll = false;
        if (c != null) {
            if (!c.isEmpty()) {
                int collectionSize = c.size();
                Object[] newArray = new Object[this.size() + collectionSize];
                System.arraycopy(this.array, 0, newArray, 0, this.size());
                Object[] arrayOfCollection = c.toArray();
                System.arraycopy(arrayOfCollection, 0, newArray, this.size() + 1, arrayOfCollection.length);
                this.array = newArray;
                super.setCursorElement(this.size());
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
     *              specified collection
     * @param c     collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one
     *                                       or more null elements and this list does not permit null
     *                                       elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean resultAddAll = false;
        if (CheckerIndex.checkIndex(index, this.size())) {
            if (c != null) {
                if (!c.isEmpty()) {
                    int collectionSize = c.size();
                    Object[] newArray = new Object[this.size() + collectionSize];
                    System.arraycopy(this.array, 0, newArray, 0, index);
                    Object[] arrayOfCollection = c.toArray();
                    System.arraycopy(arrayOfCollection, 0, newArray, index, arrayOfCollection.length);
                    System.arraycopy(this.array, index + 1, newArray, index + 1, this.size() - index);
                    this.array = newArray;
                    super.setCursorElement(this.size());
                    resultAddAll = true;
                }
            } else {
                throw new NullPointerException("Collection argument is null.");
            }
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
        if (o != null) {
            for (int i = 0; i < this.array.length; i++) {
                if (o.equals(this.array[i])) {
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
        T resultRemove = null;
        Object[] newArray;
        if (CheckerIndex.checkIndex(index, this.size())) {
            newArray = new Object[this.size() - 1];
            resultRemove = this.get(index);
            System.arraycopy(this.array, 0, newArray, 0, index - 1);
            System.arraycopy(this.array, index + 1, newArray, index, this.size() - index);
            this.array = newArray;
            super.setCursorElement(super.getCursorElement() - 1);
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
        if (c != null) {
            if (!c.isEmpty()) {
                Object[] tmpCollectionArray = c.toArray();
                Arrays.stream(tmpCollectionArray).forEach(this::remove);
                resultRemoveAll = true;
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
        Object[] objects = new Object[0];
        System.arraycopy(objects, 0, this.array, 0, objects.length);
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
        for (int i = 0; i < this.size(); i++) {
            if (Objects.equals(o, this.array[i])) {
                resultContains = true;
                break;
            }
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
        boolean resultContainsAll = false;
        if (c != null) {
            if (!c.isEmpty()) {
                Object[] tmpArrayOfCollection = c.toArray();
                for (int i = 0; i < tmpArrayOfCollection.length; i++) {
                    for (int j = 0; j < this.size(); j++) {
                        if (Objects.equals(tmpArrayOfCollection[i], this.get(j))) {
                            resultContainsAll = true;
                            break;
                        }
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
        if (c != null) {
            if (!c.isEmpty()) {
                for (Object o : c) {
                    if (!this.contains(o)) {
                        this.remove(o);
                        resultRetainAll = true;
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
        for (int i = 0; i < this.size(); i++) {
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
        for (int i = this.size() - 1; i > 0; i--) {
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
