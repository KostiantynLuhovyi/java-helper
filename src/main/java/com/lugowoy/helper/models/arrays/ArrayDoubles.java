package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
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
public final class ArrayDoubles extends AbstractArray {

    private double[] array;

    public ArrayDoubles() {
        super();
        this.array = new double[AbstractArray.DEFAULT_CAPACITY];
    }

    public ArrayDoubles(final double... array) {
        super();
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = SerializationUtils.clone(array);
        super.setSize(this.array.length);
    }

    public ArrayDoubles(final int capacity) {
        super(capacity);
        this.array = new double[capacity];
    }

    public ArrayDoubles(final ArrayDoubles array) {
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
        if (!(o instanceof ArrayDoubles)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final ArrayDoubles that = (ArrayDoubles) o;
        return Arrays.equals(array, that.array);
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
    public ArrayDoubles clone() {
        ArrayDoubles cloneArrayDoubles;
        try {
            cloneArrayDoubles = (ArrayDoubles) super.clone();
            cloneArrayDoubles.setArray(SerializationUtils.clone(this.array));
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return cloneArrayDoubles;
    }

    public Iterator<Double> iterator() {
        return new Iterator<>() {

            private int cursorIterator = 0;
            private int lastReturned = -1;
            private int expectedModCount = ArrayDoubles.super.getModCount();

            @Override
            public boolean hasNext() {
                return this.cursorIterator != ArrayDoubles.super.size();
            }

            @Override
            public Double next() {
                this.checkModification();
                if (this.cursorIterator >= ArrayDoubles.super.size()) {
                    throw new NoSuchElementException();
                }
                if (this.cursorIterator >= ArrayDoubles.this.array.length) {
                    throw new ConcurrentModificationException();
                }
                this.lastReturned = this.cursorIterator;
                this.cursorIterator++;
                return ArrayDoubles.this.array[this.lastReturned];
            }

            @Override
            public void remove() {
                if (this.lastReturned < 0) {
                    throw new IllegalStateException();
                }
                this.checkModification();
                try {
                    ArrayDoubles.this.remove(this.lastReturned);
                    this.cursorIterator = this.lastReturned;
                    this.lastReturned = -1;
                    this.expectedModCount = ArrayDoubles.super.getModCount();
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public void forEachRemaining(
                    final Consumer<? super Double> action) {
                throw new UnsupportedOperationException("Not realize.");
            }

            private void checkModification() {
                if (this.expectedModCount != ArrayDoubles.super.getModCount()) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public void forEach(final Consumer<Double> action) {
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

    public double[] toArray() {
        return Arrays.copyOf(this.array, super.size());
    }

    public double[] toArray(double[] array) {
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        if (array.length < super.size()) {
            array = Arrays.copyOf(this.array, super.size());
        }
        System.arraycopy(this.array, 0, array, 0, super.size());
        return array;
    }

    public void setArray(final int capacity) {
        CheckerArray.checkLength(capacity, AbstractArray.UPPER_CAPACITY);
        this.array = new double[capacity];
        super.setSize(capacity);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setArray(final double... array) {
        CheckerArray.check(array, AbstractArray.UPPER_CAPACITY);
        this.array = Arrays.copyOf(array, array.length);
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }

    public double get(final int index) {
        CheckerIndex.checkInRange(index, super.size());
        return this.array[index];
    }

    public double set(final int index, final double element) {
        CheckerIndex.checkInRange(index, AbstractArray.UPPER_CAPACITY);
        double oldValue = this.get(index);
        this.array[index] = element;
        return oldValue;
    }

    public boolean add(final double element) {
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

    public void add(final int index, final double element) {
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

    public boolean addAll(final double[] array) {
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

    public boolean addAll(final int index, final double[] array) {
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

    public boolean remove(final double element) {
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

    public double removeByIndex(final int index) {
        Objects.checkIndex(index, super.size());
        double[] newArray = new double[this.array.length - 1];
        double resultRemove = this.get(index);
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index,
                         super.size() - (index + 1));
        this.array = newArray;
        super.decreaseSize();
        super.increaseModCount();
        return resultRemove;
    }

    public boolean removeAll(double element) {
        boolean resultRemove = false;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                this.removeByIndex(i);
                resultRemove = true;
            }
        }
        return resultRemove;
    }

    public boolean removeAll(double[] arrayDoubles) {
        boolean resultRemoveAll = false;
        if (Objects.nonNull(arrayDoubles)) {
            if (arrayDoubles.length != 0) {
                for (int i = 0; i < arrayDoubles.length; i++) {
                    for (int j = 0; j < super.size(); j++) {
                        if (arrayDoubles[i] == this.arrayDoubles[j]) {
                            this.remove(j);
                            resultRemoveAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of double numbers is null.");
        }
        return resultRemoveAll;
    }

    public void clear() {
        this.arrayDoubles = new double[0];
    }

    public boolean contains(double element) {
        boolean resultContains = false;
        int i = 0;
        while (i < super.size()) {
            if (element == this.arrayDoubles[i]) {
                resultContains = true;
                break;
            }
            i++;
        }
        return resultContains;
    }

    public boolean containsAll(double[] arrayDoubles) {
        boolean resultContainsAll = true;
        if (Objects.nonNull(arrayDoubles)) {
            if (arrayDoubles.length != 0) {
                for (int i = 0; i < arrayDoubles.length; i++) {
                    if (!this.contains(arrayDoubles[i])) {
                        resultContainsAll = false;
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of double numbers is null.");
        }
        return resultContainsAll;
    }

    public boolean retainAll(double[] arrayDoubles) {
        boolean resultRetainAll = false;
        if (Objects.nonNull(arrayDoubles)) {
            if (arrayDoubles.length != 0) {
                for (int i = 0; i < arrayDoubles.length; i++) {
                    for (int j = 0; j < super.size(); j++) {
                        if (arrayDoubles[i] != this.arrayDoubles[j]) {
                            this.removeByIndex(j);
                            resultRetainAll = true;
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Argument array of double numbers is null.");
        }
        return resultRetainAll;
    }

    public int indexOf(double element) {
        int resultIndexOf = -1;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                resultIndexOf = i;
            }
        }
        return resultIndexOf;
    }

    public int lastIndexOf(double element) {
        int resultLastIndexOf = -1;
        for (int i = super.size() - 1; i > 0; i--) {
            if (element == this.arrayDoubles[i]) {
                resultLastIndexOf = i;
            }
        }
        return resultLastIndexOf;
    }

}

