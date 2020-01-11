package com.lugowoy.helper.models.storages.arrays;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Objects;
import java.util.RandomAccess;

/**
 * Created by Konstantin Lugowoy on 16.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
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


    private int cursorElement;

    public AbstractArray() {
        this.cursorElement = 0;
    }

    public AbstractArray(int lengthArray) {
        if (CheckerArray.checkLengthArray(lengthArray)) {
            this.cursorElement = lengthArray;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractArray)) return false;
        AbstractArray that = (AbstractArray) o;
        return getCursorElement() == that.getCursorElement();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCursorElement());
    }

    int getCursorElement() {
        return this.cursorElement;
    }

    void setCursorElement(int cursorElement) {
        this.cursorElement = cursorElement;
    }

    public abstract int size();

}
