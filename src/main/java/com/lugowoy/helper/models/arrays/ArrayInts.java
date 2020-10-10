package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerIndex;
import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @since 2.0
 */
//todo write doc's
public final class ArrayInts extends AbstractArray {

    private int[] array;

    public ArrayInts() {
        super();
        this.array = new int[AbstractArray.DEFAULT_CAPACITY];
    }

    public ArrayInts(final int... array) {
        super();
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = SerializationUtils.clone(array);
        super.setSize(this.array.length);
    }

    public ArrayInts(final int capacity) {
        super(capacity);
        this.array = new int[capacity];
    }

    public ArrayInts(final ArrayInts array) {
        super();
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = SerializationUtils.clone(array.array);
        super.setSize(this.array.length);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArrayInts)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final ArrayInts arrayInts = (ArrayInts) o;
        return Arrays.equals(array, arrayInts.array);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < super.size(); i++) {
            sb.append(this.get(i)).append(',').append(' ');
        }
        return sb.append("]").toString();
    }

    @Override
    public ArrayInts clone() {
        ArrayInts cloneArrayInts;
        try {
            cloneArrayInts = (ArrayInts) super.clone();
            cloneArrayInts.setArray(SerializationUtils.clone(this.array));
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return cloneArrayInts;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int cursorIterator = 0;
            private int lastReturned = -1;
            private int expectedModCount = ArrayInts.super.getModCount();

            @Override
            public boolean hasNext() {
                return this.cursorIterator != ArrayInts.super.size();
            }

            @Override
            public Integer next() {
                this.checkModification();
                if (this.cursorIterator >= ArrayInts.super.size()) {
                    throw new NoSuchElementException();
                }
                if (this.cursorIterator >= ArrayInts.this.array.length) {
                    throw new ConcurrentModificationException();
                }
                this.lastReturned = this.cursorIterator;
                this.cursorIterator++;
                return ArrayInts.this.array[this.lastReturned];
            }

            @Override
            public void remove() {
                if (this.lastReturned < 0) {
                    throw new IllegalStateException();
                }
                this.checkModification();
                try {
                    ArrayInts.this.remove(this.lastReturned);
                    this.cursorIterator = this.lastReturned;
                    this.lastReturned = -1;
                    this.expectedModCount = ArrayInts.super.getModCount();
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public void forEachRemaining(
                    final Consumer<? super Integer> action) {
                throw new UnsupportedOperationException("Not realize.");
            }

            private void checkModification() {
                if (this.expectedModCount != ArrayInts.super.getModCount()) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public void forEach(final Consumer<Integer> action) {
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

    public int[] toArray() {
        return Arrays.copyOf(this.array, super.size());
    }

    public int[] toArray(int[] array) {
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        if (array.length < super.size()) {
            array = Arrays.copyOf(this.array, super.size());
        }
        System.arraycopy(this.array, 0, array, 0, super.size());
        return array;
    }

    public void setArray(int[] arrayInts) {
        if (CheckerArray.checkLengthInArray(arrayInts)) {
            this.arrayInts = Arrays.copyOf(arrayInts, arrayInts.length);
            super.setSize(this.arrayInts.length);
        }
    }

    public void setArray(final int capacity) {
        CheckerArray.checkLength(capacity, AbstractArray.UPPER_CAPACITY);
        this.array = new int[capacity];
        super.setSize(capacity);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setArray(final int... array) {
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = Arrays.copyOf(array, array.length);
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }

    public int get(final int index) {
        CheckerIndex.checkInRange(index, super.size());
        return this.array[index];
    }

    public int set(final int index, final int element) {
        CheckerIndex.checkInRange(index, super.size());
        int oldValue = this.get(index);
        this.array[index] = element;
        return oldValue;
    }

    public boolean add(final int element) {
        if (super.size() >= this.array.length) {
            this.ensureCapacity();
        }
        this.array[super.size()] = element;
        boolean additionResult = false;
        if (this.isExactlyAdded(element)) {
            additionResult = true;
            super.increaseSize();
            super.increaseModCount();
        }
        return additionResult;
    }

    public void add(final int index, final int element) {
        CheckerBoundNumber.checkInRange(index, AbstractArray.UPPER_CAPACITY);
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

    public boolean addAll(final int... array) {
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        boolean resultAddAll = false;
        //TODO refactoring this. delete this 'if'
        if (array.length > 0) {
            if (array.length > (this.array.length - super.size())) {
                this.array = Arrays.copyOf(this.array, (this.array.length << 1)
                                                       + array.length);
            }
            System.arraycopy(array, 0, this.array, this.size(), array.length);
            super.increaseSize(array.length);
            super.increaseModCount();
            resultAddAll = true;
        }
        return resultAddAll;
    }

    public boolean addAll(final int index, final int... array) {
        CheckerIndex.checkInRange(index, super.size() + 1);
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        boolean resultAddAll = false;
        //TODO refactoring this. delete this 'if'
        if (array.length > 0) {
            if (array.length > (this.array.length - super.size())) {
                this.array = Arrays.copyOf(this.array, (this.array.length << 1)
                                                       + array.length);
            }
            int numMoved = super.size() - index;
            if (numMoved > 0) {
                System.arraycopy(this.array, index, this.array,
                                 index + array.length, numMoved);
            }
            System.arraycopy(array, 0, this.array, index, array.length);
            super.increaseSize(array.length);
            super.increaseModCount();
            resultAddAll = true;
        }
        return resultAddAll;
    }

    //TODO add methods:
    // addAll(ArrayDoubles array);
    // addAll(int index, ArrayDoubles array);

    public boolean remove(final int element) {
        boolean resultOfRemoving = false;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.get(i)) {
                this.removeByIndex(i);
                resultOfRemoving = true;
                break;
            }
        }
        return resultOfRemoving;
    }

    public int removeByIndex(final int index) {
        Objects.checkIndex(index, super.size());
        int[] newArray = new int[this.array.length - 1];
        int resultRemove = this.get(index);
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index,
                         super.size() - (index + 1));
        this.array = newArray;
        super.decreaseSize();
        super.increaseModCount();
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
