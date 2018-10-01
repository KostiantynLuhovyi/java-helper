package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * The functional interface declares a contract to filling an array of an object of the {@link Point} class
 *  by initializing the coordinates of the points with the numeric values of the array.
 *
 * @param <T> Type of numeric data for initializing the coordinates of objects of the class {@link Point}.
 */

@FunctionalInterface
public interface FillingArrayPointsCoordinatesWithArrayNumbers<T extends Number> {

    /**
     * Fills an array with objects of the {@link Point} class
     *  by initializing the coordinates with values taken from the numeric array passed to the parameter.
     *
     * @param array The numeric array whose values are used
     *              to initialize the coordinates of objects of the {@link Point} class.
     * @return The array filled with objects of the {@link Point} class.
     */
    Point<T>[] fill(T[] array);

}
