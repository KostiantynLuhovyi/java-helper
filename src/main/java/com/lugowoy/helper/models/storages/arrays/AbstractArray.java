package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Objects;
import java.util.RandomAccess;

import static com.lugowoy.helper.utils.checking.CheckerIndex.MSG_INDEX_IS_OUT_OF_RANGE;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
//todo write doc's
public abstract class AbstractArray implements Model, RandomAccess {

    /**
     * Default length of an array.
     *
     * @since 1.0
     */
    public static final int DEFAULT_LENGTH = 10;

    static final int SIZE_ZERO = 0;

    private int size;

    AbstractArray() {
        this.size = SIZE_ZERO;
    }

    AbstractArray(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        this.size = SIZE_ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractArray)) return false;
        AbstractArray that = (AbstractArray) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public int size() {
        return this.size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    protected void checkIndexToAddByIndex(int index) {
        if (index > this.size() || index < 0) {
            throw new IndexOutOfBoundsException(MSG_INDEX_IS_OUT_OF_RANGE);
        }
    }

}
