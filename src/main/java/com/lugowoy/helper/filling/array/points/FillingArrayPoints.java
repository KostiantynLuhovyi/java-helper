package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * The interface declares a contract to implement the filling of an objects of {@link Array} and classical array
 *  objects of the {@link Point} class with coordinates of a numerical type.
 * <p>Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @param <T> Type of numeric coordinates that are encapsulated in the object of the {@link Point} class.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public interface FillingArrayPoints<T extends Number> extends FillingArray<Point<T>> {

    /**
     * Fills an object of the {@link Array} class with objects of the {@link Point} class with numerical coordinates.
     *
     * @param array The object of the {@link Array} class to be filled
     *              with objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    void fill(Array<Point<T>> array);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates.
     *
     * @param tArray The array to be filled with objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    void fill(Point<T>[] tArray);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with numerical coordinates.
     * @return Created and filled array with objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    Point<T>[] fill(int lengthArray);

    /**
     * Fills an object of the {@link Array} class with objects of the {@link Point} class with numerical coordinates
     *  in the range from "0" to "bound".
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with numerical coordinates.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Array<Point<T>> array, T bound);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to to "bound".
     *
     * @param points The array to be filled with objects of the {@link Point} class.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Point<T>[] points, T bound);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with numerical coordinates.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    Point<T>[] fill(int lengthArray, T bound);

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     *  in the range from "startBound" to "endBound".
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with numerical coordinates.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Array<Point<T>> array, T startBound, T endBound);

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "startBound" to to "endBound".
     *
     * @param points The array to be filled with objects of the {@link Point} class.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Point<T>[] points, T startBound, T endBound);

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with numerical coordinates.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array with objects of the {@link Point} class with numerical coordinates.
     */
    Point<T>[] fill(int lengthArray, T startBound, T endBound);

}
