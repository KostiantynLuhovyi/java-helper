package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */
//todo Написать документацию. Провести полный рефакторинг.
public class FillerArrayPoints<T extends Number> extends FillerArray<Point<T>> {

    public FillerArrayPoints(Filling<Point<T>[]> filling) {
        super(filling);
    }

    @Override
    public Point<T>[] fill(Point<T>[] array) {
        return super.getFilling().fill(array);
    }

    @Override
    public Point<T>[] fill(int lengthArray) {
        return ((FillingArrayPoints<T>)super.getFilling()).fill(lengthArray);
    }

}
