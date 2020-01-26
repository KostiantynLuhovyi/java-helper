package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 2.0
 */
//todo write doc's
public class ArrayInts extends AbstractArray {

    private int[] arrayInts;

    public ArrayInts() {
        this.arrayInts = new int[DEFAULT_LENGTH];
    }

    public ArrayInts(int[] arrayInts) {
        if (CheckerArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = Arrays.copyOf(arrayInts, arrayInts.length);
            super.setSize(this.arrayInts.length);
        }
    }

    public ArrayInts(int lengthArray) {
        super(lengthArray);
        this.arrayInts = new int[lengthArray];
    }

    public ArrayInts(ArrayInts arrayInts) {
        if (CheckerArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = Arrays.copyOf(arrayInts.toArray(), arrayInts.size());
            super.setSize(this.arrayInts.length);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayInts)) return false;
        if (!super.equals(o)) return false;
        ArrayInts arrayInts1 = (ArrayInts) o;
        return Arrays.equals(arrayInts, arrayInts1.arrayInts);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(arrayInts);
        return result;
    }

    @Override
    public String toString() {
        Iterator<Integer> it = iterator();
        if ( ! it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            sb.append(it.next());
            if ( ! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    protected ArrayInts clone() throws CloneNotSupportedException {
        ArrayInts arrayInts = (ArrayInts) super.clone();
        arrayInts.setArray(Arrays.copyOf(this.arrayInts, super.size()));
        return arrayInts;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int cursorIteratorElement = 0;

            @Override
            public boolean hasNext() {
                return this.cursorIteratorElement != ArrayInts.super.size();
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
                ArrayInts.this.remove(--this.cursorIteratorElement);
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
        return Arrays.copyOf(this.arrayInts, super.size());
    }

    public int[] toArray(int[] array) {
        if (CheckerArray.checkLengthInArray(array)) {
            array = Arrays.copyOf(this.arrayInts, super.size());
        }
        return array;
    }

    public void setArray(int[] arrayInts) {
        if (CheckerArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = Arrays.copyOf(arrayInts, arrayInts.length);
            super.setSize(this.arrayInts.length);
        }
    }

    public void setArray(int lengthArray) {
        if (CheckerArray.checkLengthArray(lengthArray)) {
            this.arrayInts = new int[lengthArray];
            super.setSize(SIZE_ZERO);
        }
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }

    public int get(int index) {
        Objects.checkIndex(index, super.size());
        return this.arrayInts[index];
    }

    public int set(int index, int element) {
        Objects.checkIndex(index, this.size());
        int oldValue = this.get(index);
        this.arrayInts[index] = element;
        return oldValue;
    }

    public boolean add(int element) {
        if (super.size() == this.arrayInts.length) {
            this.arrayInts = Arrays.copyOf(this.arrayInts, this.arrayInts.length * 2);
        }
        this.arrayInts[super.size()] = element;
        super.setSize(super.size() + 1);
        return true;
    }

    public void add(int index, int element) {
        super.checkIndexToAddByIndex(index);
        if (super.size() == this.arrayInts.length) {
            this.arrayInts = Arrays.copyOf(this.arrayInts, this.arrayInts.length * 2);
        }
        System.arraycopy(this.arrayInts, index, this.arrayInts, index + 1, super.size() - index);
        this.arrayInts[index] = element;
        super.setSize(super.size() + 1);    }

    public boolean addAll(int[] arrayInts) {
        boolean resultAddAll = false;
        if (Objects.nonNull(arrayInts)) {
            if (arrayInts.length != 0) {
                if (arrayInts.length > (this.arrayInts.length - super.size())) {
                    this.arrayInts = Arrays.copyOf(this.arrayInts, (this.arrayInts.length * 2) + arrayInts.length);
                }
                System.arraycopy(arrayInts, 0, this.arrayInts, super.size(), arrayInts.length);
                super.setSize(super.size() + arrayInts.length);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
        }
        return resultAddAll;
    }

    public boolean addAll(int index, int[] arrayInts) {
        super.checkIndexToAddByIndex(index);
        boolean resultAddAll = false;
        if (Objects.nonNull(arrayInts)) {
            if (arrayInts.length != 0) {
                if (arrayInts.length > (this.arrayInts.length - super.size())) {
                    this.arrayInts = Arrays.copyOf(this.arrayInts, (this.arrayInts.length * 2) + arrayInts.length);
                }
                int numMoved = super.size() - index;
                if (numMoved > 0) {
                    System.arraycopy(this.arrayInts, index, this.arrayInts, index + arrayInts.length, numMoved);
                }
                System.arraycopy(arrayInts, 0, this.arrayInts, index, arrayInts.length);
                super.setSize(super.size() + arrayInts.length);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Argument array of integer numbers is null");
        }
        return resultAddAll;
    }

    public boolean remove(int element) {
        boolean resultRemove = false;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayInts[i]) {
                this.removeByIndex(i);
                resultRemove = true;
                break;
            }
        }
        return resultRemove;
    }

    public double removeByIndex(int index) {
        Objects.checkIndex(index, super.size());
        int[] newArray = new int[super.size() - 1];
        int resultRemove = this.get(index);
        System.arraycopy(this.arrayInts, 0, newArray, 0, index);
        System.arraycopy(this.arrayInts, index + 1, newArray, index, super.size() - (index + 1));
        this.arrayInts = newArray;
        super.setSize(super.size() - 1);
        return resultRemove;
    }

    public boolean removeAll(int element) {
        boolean resultRemove = false;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayInts[i]) {
                this.removeByIndex(i);
                resultRemove = true;
            }
        }
        return resultRemove;
    }

    public boolean removeAll(int[] arrayInts) {
        boolean resultRemoveAll = false;
        if (Objects.nonNull(arrayInts)) {
            if (arrayInts.length != 0) {
                for (int i = 0; i < arrayInts.length; i++) {
                    for (int j = 0; j < super.size(); j++) {
                        if (arrayInts[i] == this.arrayInts[j]) {
                            this.remove(j);
                            resultRemoveAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of integer numbers is null.");
        }
        return resultRemoveAll;
    }

    public void clear() {
        this.arrayInts = new int[0];
    }

    public boolean contains(int element) {
        boolean resultContains = false;
        int i = 0;
        while (i < super.size()) {
            if (element == this.arrayInts[i]) {
                resultContains = true;
                break;
            }
            i++;
        }
        return resultContains;
    }

    public boolean containsAll(int[] arrayInts) {
        boolean resultContainsAll = true;
        if (Objects.nonNull(arrayInts)) {
            if (arrayInts.length != 0) {
                for (int i = 0; i < arrayInts.length; i++) {
                    if (!this.contains(arrayInts[i])) {
                        resultContainsAll = false;
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of integer numbers is null.");
        }
        return resultContainsAll;
    }

    public boolean retainAll(int[] arrayInts) {
        boolean resultRetainAll = false;
        if (Objects.nonNull(arrayInts)) {
            if (arrayInts.length != 0) {
                for (int i = 0; i < arrayInts.length; i++) {
                    for (int j = 0; j < super.size(); j++) {
                        if (arrayInts[i] != this.arrayInts[j]) {
                            this.removeByIndex(j);
                            resultRetainAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of integer numbers is null.");
        }
        return resultRetainAll;
    }

    public int indexOf(int element) {
        int resultIndexOf = -1;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayInts[i]) {
                resultIndexOf = i;
            }
        }
        return resultIndexOf;
    }

    public int lastIndexOf(int element) {
        int resultLastIndexOf = -1;
        for (int i = super.size() - 1; i > 0; i--) {
            if (element == this.arrayInts[i]) {
                resultLastIndexOf = i;
            }
        }
        return resultLastIndexOf;
    }

}
