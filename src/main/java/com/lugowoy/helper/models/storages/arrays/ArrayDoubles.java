package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerIndex;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @since 2.0
 */
//todo write doc's
public class ArrayDoubles extends AbstractArray {

    private double[] arrayDoubles;

    public ArrayDoubles() {
        this.arrayDoubles = new double[DEFAULT_LENGTH];
        super.setCursorElement(this.size());
    }

    public ArrayDoubles(double[] arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles, arrayDoubles.length);
            super.setCursorElement(this.size());
        }
    }

    public ArrayDoubles(int lengthArray) {
        super(lengthArray);
        this.arrayDoubles = new double[lengthArray];
    }

    public ArrayDoubles(ArrayDoubles arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles.toArray(), arrayDoubles.size());
            super.setCursorElement(this.size());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayDoubles)) return false;
        if (!super.equals(o)) return false;
        ArrayDoubles arrayDoubles = (ArrayDoubles) o;
        return Arrays.equals(this.arrayDoubles, arrayDoubles.arrayDoubles);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(arrayDoubles);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayDoubles [ " + Arrays.toString(arrayDoubles) + " , cursorElement:" + super.getCursorElement() + " ]";
    }

    @Override
    public int size() {
        return this.arrayDoubles.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterator<Double> iterator() {
        return new Iterator<>() {

            private int cursorIteratorElement = 0;

            @Override
            public boolean hasNext() {
                return this.cursorIteratorElement != ArrayDoubles.this.size();
            }

            @Override
            public Double next() {
                return ArrayDoubles.this.get(this.cursorIteratorElement++);
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
                ArrayDoubles.this.remove(cursorIteratorElement);
            }
        };
    }

    public void forEach(Consumer<Double> action) {
        Objects.requireNonNull(action);
        Double aDouble = null;
        for (double tmpDouble : this.arrayDoubles) {
            aDouble = tmpDouble;
        }
        action.accept(aDouble);
    }

    public double[] toArray() {
        return Arrays.copyOf(this.arrayDoubles, this.size());
    }

    public double[] toArray(double[] array) {
        if (CheckerArray.checkLengthInArray(array)) {
            array = Arrays.copyOf(this.arrayDoubles, this.size());
        }
        return array;
    }

    public void setArray(double[] arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles, arrayDoubles.length);
            super.setCursorElement(this.size());
        }
    }

    public void setArray(int lengthArray) {
        if (CheckerArray.checkLengthArray(lengthArray)) {
            this.arrayDoubles = new double[lengthArray];
            super.setCursorElement(this.size());
        }
    }

    public double get(int index) {
        double result = 0;
        if (CheckerIndex.checkIndex(index, this.size())) {
            result = this.arrayDoubles[index];
        }
        return result;
    }

    public double set(int index, double element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            this.arrayDoubles[index] = element;
        }
        return element;
    }

    public boolean add(double element) {
        boolean resultAdd = false;
        if (super.getCursorElement() < this.size()) {
            this.arrayDoubles[super.getCursorElement()] = element;
            super.setCursorElement(this.size());
            resultAdd = true;
        } else {
            double[] tmpArrayDoubles = new double[this.size() + 1];
            System.arraycopy(this.arrayDoubles, 0, tmpArrayDoubles, 0, this.size());
            this.arrayDoubles = tmpArrayDoubles;
            this.add(element);
        }
        return resultAdd;
    }

    public void add(int index, double element) {
        if (CheckerIndex.checkIndex(index, this.size())) {
            double[] newArrayDoubles = new double[this.size() + 1];
            System.arraycopy(this.arrayDoubles, 0, newArrayDoubles, 0, index + 1);
            this.arrayDoubles[index] = element;
            System.arraycopy(this.arrayDoubles, index, newArrayDoubles, index + 1, this.size() - index);
            this.setArray(newArrayDoubles);
        }
    }

    public boolean addAll(double[] arrayDoubles) {
        boolean resultAddAll = false;
        if (arrayDoubles != null) {
            if (CheckerArray.checkLengthInArray(arrayDoubles)) {
                double[] newArrayDoubles = new double[this.size() + arrayDoubles.length];
                System.arraycopy(this.arrayDoubles, 0, newArrayDoubles, 0, this.size());
                System.arraycopy(arrayDoubles, 0, newArrayDoubles, this.size(), arrayDoubles.length);
                this.arrayDoubles = newArrayDoubles;
                super.setCursorElement(this.size());
                resultAddAll = true;
            }
        }
        return resultAddAll;
    }

    public boolean addAll(int index, double[] arrayDoubles) {
        boolean resultAddAll = false;
        if (CheckerIndex.checkIndex(index, this.size())) {
            if (CheckerArray.checkLengthInArray(arrayDoubles)) {
                double[] newArrayDoubles = new double[this.size() + arrayDoubles.length];
                System.arraycopy(this.arrayDoubles, 0, newArrayDoubles, 0, index);
                System.arraycopy(arrayDoubles, 0, newArrayDoubles, index, arrayDoubles.length);
                System.arraycopy(this.arrayDoubles, index, newArrayDoubles, arrayDoubles.length + index, this.size() - index);
                this.arrayDoubles = newArrayDoubles;
                super.setCursorElement(this.size());
                resultAddAll = true;
            }
        }
        return resultAddAll;
    }

    public boolean remove(double element) {
        boolean resultRemove = false;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                this.removeByIndex(i);
                resultRemove = true;
                break;
            }
        }
        return resultRemove;
    }

    public double removeByIndex(int index) {
        double resultRemove = 0.0;
        double[] newArrayDoubles;
        if (CheckerIndex.checkIndex(index, this.size())) {
            newArrayDoubles = new double[this.size() - 1];
            resultRemove = this.get(index);
            System.arraycopy(this.arrayDoubles, 0, newArrayDoubles, 0, index);
            System.arraycopy(this.arrayDoubles, index + 1, newArrayDoubles, index, this.size() - (index + 1));
            this.arrayDoubles = newArrayDoubles;
            super.setCursorElement(super.getCursorElement() - 1);
        }
        return resultRemove;
    }

    public boolean removeAll(double element) {
        boolean resultRemove = false;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                this.removeByIndex(i);
                resultRemove = true;
            }
        }
        return resultRemove;
    }

    public boolean removeAll(double[] arrayDoubles) {
        boolean resultRemoveAll = false;
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            Arrays.stream(arrayDoubles).forEach(this::remove);
            resultRemoveAll = true;
        }
        return resultRemoveAll;
    }

    public void clear() {
        this.arrayDoubles = new double[0];
    }

    public boolean contains(double element) {
        boolean resultContains = false;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                resultContains = true;
                break;
            }
        }
        return resultContains;
    }

    public boolean containsAll(double[] arrayDoubles) {
        boolean resultContainsAll = true;
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            for (int i = 0; i < arrayDoubles.length; i++) {
                if (!this.contains(arrayDoubles[i])) {
                    resultContainsAll = false;
                }
            }
        }
        return resultContainsAll;
    }

    public boolean retainAll(double[] arrayDoubles) {
        boolean resultRetainAll = false;
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            for (double tmp : arrayDoubles) {
                if (!this.contains(tmp)) {
                    this.remove(tmp);
                    resultRetainAll = true;
                }
            }
        }
        return resultRetainAll;
    }

    public int indexOf(double element) {
        int resultIndexOf = -1;
        for (int i = 0; i < this.size(); i++) {
            if (element == this.get(i)) {
                resultIndexOf = i;
            }
        }
        return resultIndexOf;
    }

    public int lastIndexOf(double element) {
        int resultLastIndexOf = -1;
        for (int i = this.size() - 1; i > 0; i--) {
            if (element == this.get(i)) {
                resultLastIndexOf = i;
            }
        }
        return resultLastIndexOf;
    }

}

