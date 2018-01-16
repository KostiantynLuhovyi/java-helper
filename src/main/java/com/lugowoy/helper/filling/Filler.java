package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class Filler<T> implements Filling<T> {

    private Filling<T> filling;

    protected Filler() {
    }

    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    public T fill(T t) {
        return filling.fill(t);
    }

    protected Filling<T> getFilling() {
        return filling;
    }

}
