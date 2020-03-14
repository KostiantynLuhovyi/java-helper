package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * The interface declares a contract to implement the filling of an objects of {@link Array} and classical array
 * objects of the {@link Point} class with coordinates of a numerical type.
 * <p>Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @param <T> Type of numeric coordinates that are encapsulated in the object of the {@link Point} class.
 * @author Konstantin Lugowoy
 * @version 1.1
 */
//TODO edit doc's
public interface FillingArrayPoints<T extends Point, V extends Number> extends FillingArray<T> {

    /**
     * Fills an object of the {@link Array} class with objects of the {@link Point} class with numerical coordinates
     * in the range from "0" to "boundCoordinate".
     *
     * @param array           The object of the {@link Array} class to be filled
     *                        with an object of the {@link Point} class with numerical coordinates.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Array<T> array, V boundCoordinate);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to to "boundCoordinate".
     *
     * @param points          The array to be filled with objects of the {@link Point} class.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(T[] points, V boundCoordinate);

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to "boundCoordinate" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     *
     * @param lengthArray     The length(size) of the array to be filled
     *                        with objects of the {@link Point} class with numerical coordinates.
     * @param boundCoordinate The value of the end of the range boundary
     *                        of numerical values by which the coordinates of points in the array will be initialized.
     */
    T[] fill(int lengthArray, V boundCoordinate);

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     * in the range from "startBound" to "upperBoundCoordinate".
     *
     * @param array                The object of the {@link Array} class to be filled
     *                             with an object of the {@link Point} class with numerical coordinates.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(Array<T> array, V lowerBoundCoordinate, V upperBoundCoordinate);

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "lowerBoundCoordinate" to to "upperBoundCoordinate".
     *
     * @param points               The array to be filled with objects of the {@link Point} class.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     */
    void fill(T[] points, V lowerBoundCoordinate, V upperBoundCoordinate);

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "lowerBoundCoordinate" to "upperBoundCoordinate" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     *
     * @param lengthArray          The length(size) of the array to be filled
     *                             with objects of the {@link Point} class with numerical coordinates.
     * @param lowerBoundCoordinate The value of the start of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @param upperBoundCoordinate The value of the end of the range boundary
     *                             of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array with objects of the {@link Point} class with numerical coordinates.
     */
    T[] fill(int lengthArray, V lowerBoundCoordinate, V upperBoundCoordinate);

}
