package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.fillable.Fillable;

/** Created by Konstantin Lugowoy on 27.07.2017. */

public abstract class Filler<T> implements Fillable<T> {

    private Filling<T> filling;

    public Filler(Filling<T> filling) {
        this.filling = filling;
    }

    @Override
    public abstract T fill(T t);

    public Filling<T> getFilling() {
        return filling;
    }

}
