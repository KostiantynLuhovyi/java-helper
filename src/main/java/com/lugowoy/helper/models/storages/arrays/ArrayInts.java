package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.utils.CheckerIndex;
import com.lugowoy.helper.utils.CheckerLengthArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.0
 */
//todo write doc's
public class ArrayInts extends AbstractArray {

    private int[] arrayInts;

    public ArrayInts() {
        this.arrayInts = new int[DEFAULT_LENGTH];
        super.setCursorElement(this.arrayInts.length);
    }

    public ArrayInts(int[] arrayInts) {
        if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = arrayInts.clone();
            super.setCursorElement(this.arrayInts.length);
        }
    }

    public ArrayInts(ArrayInts arrayInts) {
        if (arrayInts != null) {
            this.arrayInts = arrayInts.toArray();
            super.setCursorElement(this.arrayInts.length);
        } else {
            throw new NullPointerException("Object argument is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayInts)) return false;
        if (!super.equals(o)) return false;
        ArrayInts arrayInts = (ArrayInts) o;
        return Arrays.equals(this.arrayInts, arrayInts.arrayInts);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(arrayInts);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayInts [" + Arrays.toString(arrayInts)
                + "], cursorElement:" + super.getCursorElement();
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     * //todo Integer.MAX -> OutOfMemoryError
     *
     * @return the number of elements in this list
     */
    public int size() {
        return this.arrayInts.length;
    }


    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int cursorIteratorElement = 0;

            @Override
            public boolean hasNext() {
                return this.cursorIteratorElement != ArrayInts.this.size();
            }

            @Override
            public Integer next() {
                return ArrayInts.this.get(this.cursorIteratorElement++);
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
                ArrayInts.this.remove(cursorIteratorElement);
            }
        };
    }

    public void forEach(Consumer<Integer> action) {
        Objects.requireNonNull(action);
        Integer integer = null;
        for (int tmpInt : this.arrayInts) {
            integer = tmpInt;
        }
        action.accept(integer);
    }

    public int[] toArray() {
        return arrayInts;
    }

    public int[] toArray(int[] array) {
        if (CheckerLengthArray.checkLengthInArray(array)) {
            if (array.length < this.size()) {
                array = Arrays.copyOf(this.arrayInts, this.size());
            } else {
                System.arraycopy(this.arrayInts, 0, array, 0, this.size());
            }
        }
        return array;
    }

    public void setArray(int[] arrayInts) {
        if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = Arrays.copyOf(arrayInts, arrayInts.length);
        }
    }

    public int get(int index) {
        int result = 0;
        if (CheckerIndex.checkIndex(index)) {
            result = this.arrayInts[index];
        }
        return result;
    }

    public int set(int index, int element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            this.arrayInts[index] = element;
        }
        return element;
    }

    public boolean add(int element) {
        boolean resultAdd = false;
        if (super.getCursorElement() < this.size()) {
            this.arrayInts[super.getCursorElement()] = element;
            super.setCursorElement(super.getCursorElement() + 1);
            resultAdd = true;
        } else {
            int[] tmpArrayInts = new int[this.size() + 1];
            System.arraycopy(this.arrayInts, 0, tmpArrayInts, 0, this.size());
            this.arrayInts = tmpArrayInts;
            this.add(element);
        }
        return resultAdd;
    }

    public void add(int index, int element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            this.arrayInts[index] = element;
        }
    }

    public boolean addAll(int[] arrayInts) {
        boolean resultAddAll = false;
        if (arrayInts != null) {
            if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
                int[] newArrayInts = new int[this.size() + arrayInts.length];
                System.arraycopy(this.arrayInts, 0, newArrayInts, 0, this.size());
                System.arraycopy(arrayInts, 0, newArrayInts, this.size() + 1, arrayInts.length);
                this.arrayInts = newArrayInts;
                super.setCursorElement(this.size());
                resultAddAll = true;
            }
        }
        return resultAddAll;
    }

    public boolean addAll(int index, int[] arrayInts) {
        boolean resultAddAll = false;
        if (CheckerIndex.checkIndex(index, this.size())) {
            if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
                int[] newArrayInts = new int[this.size() + arrayInts.length];
                System.arraycopy(this.arrayInts, 0, newArrayInts, 0, index);
                System.arraycopy(arrayInts, 0, newArrayInts, index, arrayInts.length);
                System.arraycopy(this.arrayInts, index + 1, newArrayInts, index + 1, this.size() - index);
                this.arrayInts = newArrayInts;
                super.setCursorElement(this.size());
                resultAddAll = true;
            }
        }
        return resultAddAll;
    }

    public boolean remove(int element) {
        boolean resultRemove = false;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.arrayInts[i]) {
                this.remove(i);
                resultRemove = true;
                break;
            }
        }
        return resultRemove;
    }

    public double removeByIndex(int index) {
        int resultRemove = 0;
        int[] newArrayInts;
        if (CheckerIndex.checkIndex(index, this.size())) {
            newArrayInts = new int[this.size() - 1];
            resultRemove = this.get(index);
            System.arraycopy(this.arrayInts, 0, newArrayInts, 0, index - 1);
            System.arraycopy(this.arrayInts, index + 1, newArrayInts, index, this.size() - index);
            this.arrayInts = newArrayInts;
            super.setCursorElement(super.getCursorElement() - 1);
        }
        return resultRemove;
    }

    public boolean removeAll(int[] arrayInts) {
        boolean resultRemoveAll = false;
        if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
            Arrays.stream(arrayInts).forEach(this::remove);
            resultRemoveAll = true;
        }
        return resultRemoveAll;
    }

    public void clear() {
        int[] newInts = new int[0];
        System.arraycopy(newInts, 0, this.arrayInts, 0, newInts.length);
    }

    public boolean contains(int element) {
        boolean resultContains = false;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.arrayInts[i]) {
                resultContains = true;
                break;
            }
        }
        return resultContains;
    }

    public boolean containsAll(int[] arrayInts) {
        boolean resultContainsAll = false;
        if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
            for (int i = 0; i < arrayInts.length; i++) {
                for (int j = 0; j < this.size(); j++) {
                    if (arrayInts[i] == this.get(j)) {
                        resultContainsAll = true;
                        break;
                    }
                }
            }
        }
        return resultContainsAll;
    }

    public boolean retainAll(int[] arrayInts) {
        boolean resultRetainAll = false;
        if (CheckerLengthArray.checkLengthInArray(arrayInts)) {
            for (int tmp : arrayInts) {
                if (!this.contains(tmp)) {
                    this.remove(tmp);
                    resultRetainAll = true;
                }
            }
        }
        return resultRetainAll;
    }

    public int indexOf(int element) {
        int resultIndexOf = -1;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.get(i)) {
                resultIndexOf = i;
            }
        }
        return resultIndexOf;
    }

    public int lastIndexOf(int element) {
        int resultLastIndexOf = -1;
        for (int i = this.size() - 1; i > 0; i--) {
            if (element == this.get(i)) {
                resultLastIndexOf = i;
            }
        }
        return resultLastIndexOf;
    }

}
