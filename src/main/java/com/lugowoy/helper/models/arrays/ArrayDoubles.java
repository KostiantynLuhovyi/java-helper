package com.lugowoy.helper.models.arrays;

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
 * @version 1.7
 * @since 2.0
 */
//todo write doc's
public class ArrayDoubles extends AbstractArray {

    private double[] arrayDoubles;

    public ArrayDoubles() {
        this.arrayDoubles = new double[DEFAULT_LENGTH];
    }

    public ArrayDoubles(double[] arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles, arrayDoubles.length);
            super.setSize(this.arrayDoubles.length);
        }
    }

    public ArrayDoubles(int lengthArray) {
        super(lengthArray);
        this.arrayDoubles = new double[lengthArray];
    }

    public ArrayDoubles(ArrayDoubles arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles.toArray(), arrayDoubles.size());
            super.setSize(this.arrayDoubles.length);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayDoubles)) return false;
        if (!super.equals(o)) return false;
        ArrayDoubles that = (ArrayDoubles) o;
        return Arrays.equals(arrayDoubles, that.arrayDoubles);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(arrayDoubles);
        return result;
    }

    @Override
    public String toString() {
        Iterator<Double> it = iterator();
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
    protected ArrayDoubles clone() throws CloneNotSupportedException {
        ArrayDoubles arrayDoubles = (ArrayDoubles) super.clone();
        arrayDoubles.setArray(Arrays.copyOf(this.arrayDoubles, super.size()));
        return arrayDoubles;
    }

    public Iterator<Double> iterator() {
        return new Iterator<>() {

            private int cursorIteratorElement = 0;

            @Override
            public boolean hasNext() {
                return this.cursorIteratorElement != ArrayDoubles.super.size();
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
                ArrayDoubles.this.remove(--this.cursorIteratorElement);
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
        return Arrays.copyOf(this.arrayDoubles, super.size());
    }

    public double[] toArray(double[] array) {
        if (CheckerArray.checkLengthInArray(array)) {
            array = Arrays.copyOf(this.arrayDoubles, super.size());
        }
        return array;
    }

    public void setArray(double[] arrayDoubles) {
        if (CheckerArray.checkLengthInArray(arrayDoubles)) {
            this.arrayDoubles = Arrays.copyOf(arrayDoubles, arrayDoubles.length);
            super.setSize(this.arrayDoubles.length);
        }
    }

    public void setArray(int lengthArray) {
        if (CheckerArray.checkLengthArray(lengthArray)) {
            this.arrayDoubles = new double[lengthArray];
            super.setSize(SIZE_ZERO);
        }
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }

    public double get(int index) {
        CheckerIndex.checkIndex(index, this.size());
        return this.arrayDoubles[index];
    }

    public double set(int index, double element) {
        Objects.checkIndex(index, this.size());
        double oldValue = this.get(index);
        this.arrayDoubles[index] = element;
        return oldValue;
    }

    public boolean add(double element) {
        if (super.size() == this.arrayDoubles.length) {
            this.arrayDoubles = Arrays.copyOf(this.arrayDoubles, this.arrayDoubles.length * 2);
        }
        this.arrayDoubles[super.size()] = element;
        super.setSize(super.size() + 1);
        return true;
    }

    public void add(int index, double element) {
        super.checkIndexToAddByIndex(index);
        if (super.size() == this.arrayDoubles.length) {
            this.arrayDoubles = Arrays.copyOf(this.arrayDoubles, this.arrayDoubles.length * 2);
        }
        System.arraycopy(this.arrayDoubles, index, this.arrayDoubles, index + 1, super.size() - index);
        this.arrayDoubles[index] = element;
        super.setSize(super.size() + 1);
    }

    public boolean addAll(double[] arrayDoubles) {
        boolean resultAddAll = false;
        if (Objects.nonNull(arrayDoubles)) {
            if (arrayDoubles.length != 0) {
                if (arrayDoubles.length > (this.arrayDoubles.length - super.size())) {
                    this.arrayDoubles = Arrays.copyOf(this.arrayDoubles, (this.arrayDoubles.length * 2) + arrayDoubles.length);
                }
                System.arraycopy(arrayDoubles, 0, this.arrayDoubles, super.size(), arrayDoubles.length);
                super.setSize(super.size() + arrayDoubles.length);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Collection argument is null.");
        }
        return resultAddAll;
    }

    public boolean addAll(int index, double[] arrayDoubles) {
        super.checkIndexToAddByIndex(index);
        boolean resultAddAll = false;
        if (Objects.nonNull(arrayDoubles)) {
            if (arrayDoubles.length != 0) {
                if (arrayDoubles.length > (this.arrayDoubles.length - super.size())) {
                    this.arrayDoubles = Arrays.copyOf(this.arrayDoubles, (this.arrayDoubles.length * 2) + arrayDoubles.length);
                }
                int numMoved = super.size() - index;
                if (numMoved > 0) {
                    System.arraycopy(this.arrayDoubles, index, this.arrayDoubles, index + arrayDoubles.length, numMoved);
                }
                System.arraycopy(arrayDoubles, 0, this.arrayDoubles, index, arrayDoubles.length);
                super.setSize(super.size() + arrayDoubles.length);
                resultAddAll = true;
            }
        } else {
            throw new NullPointerException("Argument array of double numbers is null");
        }
        return resultAddAll;
    }

    public boolean remove(double element) {
        boolean resultRemove = false;
        for (int i = 0; i < super.size(); i++) {
            if (element == this.arrayDoubles[i]) {
                this.removeByIndex(i);
                resultRemove = true;
                break;
            }
        }
        return resultRemove;
    }

    public double removeByIndex(int index) {
        Objects.checkIndex(index, super.size());
        double[] newArray = new double[super.size() - 1];
        double resultRemove = this.get(index);
        System.arraycopy(this.arrayDoubles, 0, newArray, 0, index);
        System.arraycopy(this.arrayDoubles, index + 1, newArray, index, super.size() - (index + 1));
        this.arrayDoubles = newArray;
        super.setSize(super.size() - 1);
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

