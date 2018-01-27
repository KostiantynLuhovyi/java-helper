package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * <p></p>
 */

public interface FillingArrayPointsWithNumbersCoordinates<T extends Number> {

    /**
     * <p></p>
     *
     * @param array
     * @param endBound
     *
     * @return
     * */
    Array<Point<T>> fill(Array<Point<T>> array, T endBound);

    /**
     * <p></p>
     *
     * @param points
     * @param endBound
     *
     * @return
     * */
    Point<T>[] fill(Point<T>[] points, T endBound);

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param endBound
     *
     * @return
     * */
    Point<T>[] fill(int lengthArray, T endBound);

    /**
     * <p></p>
     *
     * @param array
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    Array<Point<T>> fill(Array<Point<T>> array, T startBound, T endBound);

    /**
     * <p></p>
     *
     * @param points
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    Point<T>[] fill(Point<T>[] points, T startBound, T endBound);

    /**
     * <p></p>
     *
     * @param lengthArray
     * @param startBound
     * @param endBound
     *
     * @return
     * */
    Point<T>[] fill(int lengthArray, T startBound, T endBound);

}
