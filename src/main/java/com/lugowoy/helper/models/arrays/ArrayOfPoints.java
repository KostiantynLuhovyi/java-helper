package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.points.Point;

/** Created by Konstantin Lugowoy on 01.08.2017. */

public abstract class ArrayOfPoints<T extends Number> extends Array<Point<T>> {

    public ArrayOfPoints() {
        super();
    }

    public ArrayOfPoints(Point<T>[] array) {
        super(array);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Point<T>[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(Point<T>[] array) {
        super.setArray(array);
    }

    @Override
    public abstract void setArray(int lengthArray);

}
