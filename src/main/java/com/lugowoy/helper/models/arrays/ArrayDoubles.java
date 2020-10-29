package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.utils.Capacity;
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
 * @version 2.2
 * @since 2.0
 */
//TODO write doc's
//TODO add methods for working with an object of this class,
// and not with primitive arrays
public final class ArrayDoubles extends AbstractArray {

    private double[] array;

    public ArrayDoubles() {
        super();
        this.array = new double[AbstractArray.DEFAULT_CAPACITY];
    }

    public ArrayDoubles(final double... array) {
        super();
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = SerializationUtils.clone(array);
        super.setSize(this.array.length);
    }

    public ArrayDoubles(final int capacity) {
        super(capacity);
        this.array = new double[capacity];
    }

    public ArrayDoubles(final ArrayDoubles array) {
        super();
        CheckerArray.check(array, Capacity.UPPER.get());
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
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < super.size(); i++) {
            sb.append(this.get(i));
            if (super.size() - i != 1) {
                sb.append(", ");
            }
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

    public double[] toDeepArray() {
        return SerializationUtils.clone(this.array);
    }

    public double[] toArray(double[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        if (array.length < super.size()) {
            array = Arrays.copyOf(this.array, super.size());
        }
        System.arraycopy(this.array, 0, array, 0, super.size());
        return array;
    }

    public double[] toDeepArray(final double[] array) {
        return SerializationUtils.clone(toArray(array));
    }

    public void setArray(final int capacity) {
        CheckerArray.checkLength(capacity, Capacity.UPPER.get());
        this.array = new double[capacity];
        super.setSize(capacity);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setArray(final double... array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = Arrays.copyOf(array, array.length);
        super.setSize(this.array.length);
        super.setModCount(AbstractArray.START_MOD_COUNT);
    }

    public void setDeepArray(final double... array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.array = SerializationUtils.clone(array);
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
        CheckerIndex.checkInRange(index, Capacity.UPPER.get());
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
        CheckerArray.check(array, Capacity.UPPER.get());
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
        CheckerArray.check(array, Capacity.UPPER.get());
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

    public boolean removeAll(final double element) {
        boolean resultRemove = false;
        int indexToRemove;
        while (true) {
            indexToRemove = this.indexOf(element);
            if (indexToRemove == -1) {
                break;
            } else {
                this.removeByIndex(indexToRemove);
                resultRemove = true;
            }
        }
        return resultRemove;
    }

    public boolean removeAll(final double... array) {
        Objects.requireNonNull(array, "Array is null.");
        boolean resultRemoveAll = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < super.size(); j++) {
                if (array[i] == this.get(j)) {
                    this.removeByIndex(j);
                    resultRemoveAll = true;
                }
            }
        }
        return resultRemoveAll;
    }

    public void clear() {
        this.array = new double[0];
    }

    public boolean contains(final double element) {
        return this.indexOf(element) >= 0;
    }

    public boolean containsAll(final double... array) {
        Objects.requireNonNull(array, "Array is null.");
        boolean resultContainsAll = true;
        for (double i : array) {
            if (!this.contains(i)) {
                resultContainsAll = false;
            }
        }
        return resultContainsAll;
    }

    public boolean retainAll(final double... array) {
        Objects.requireNonNull(array, "Array is null.");
        boolean resultRetainAll = false;
        for (int i = super.size() - 1; i >= 0; i--) {
            double val = this.get(i);
            if (!this.contains(val)) {
                this.removeByIndex(i);
                resultRetainAll = true;
            }
        }
        return resultRetainAll;
    }

    public int indexOf(final double element) {
        int resultIndexOf = -1;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.get(i)) {
                resultIndexOf = i;
                break;
            }
        }
        return resultIndexOf;
    }

    public int lastIndexOf(final double element) {
        int resultLastIndexOf = -1;
        for (int i = super.size() - 1; i >= 0; i--) {
            if (element == this.get(i)) {
                resultLastIndexOf = i;
                break;
            }
        }
        return resultLastIndexOf;
    }

    @Override
    protected void ensureCapacity() {
        if (super.size() == this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length << 1);
        }
    }

    @Override
    protected void trimToSize() {
        if (super.size() < this.array.length) {
            this.array = Arrays.copyOf(this.array, super.size());
            super.increaseModCount();
        }
    }

    private boolean isExactlyAdded(final double element) {
        return this.array[super.size()] == element;
    }

}

