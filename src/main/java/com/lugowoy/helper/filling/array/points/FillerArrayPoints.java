package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 */

public class FillerArrayPoints<T extends Number> extends FillerArray<Point<T>> implements FillingArrayPoints<T> {

    private FillingArrayPoints<T> fillingArrayPoints;

    private FillerArrayPoints() {
    }

    protected FillerArrayPoints(Filling<Array<Point<T>>> filling) {
        super(filling);
    }

    private FillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        this.fillingArrayPoints = fillingArrayPoints;
    }

    @Override
    public Point<T>[] fill(T[] array) {
        return fillingArrayPoints.fill(array);
    }

    public static <T extends Number> FillerArrayPoints<T> getFillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        return new FillerArrayPoints<>(fillingArrayPoints);
    }

}
