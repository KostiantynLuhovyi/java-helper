package com.lugowoy.helper.utils;

/**
 * Created by Konstantin Lugowoy on 17.10.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
//TODO write documentation
public enum Capacity {
    LOWER(0), UPPER(2147483639);

    private final int capacity;

    Capacity(final int capacity) {
        this.capacity = capacity;
    }

    public int get() {
        return this.capacity;
    }

}
