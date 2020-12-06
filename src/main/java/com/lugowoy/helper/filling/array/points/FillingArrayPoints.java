package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import org.jetbrains.annotations.NotNull;

/**
 * The interface declares a contract to implement the filling of an objects of
 * {@link Array} and classical array objects of the {@link Point} class with
 * coordinates of a numerical type.
 * <p>Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @param <T> Type of numeric coordinates that are encapsulated in the object of
 * the {@link Point} class.
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
//TODO review documentation
public interface FillingArrayPoints<T extends Point<V>, V extends Number>
        extends FillingArray<T> {

    /**
     * Fills an object of the {@link Array} class with objects of the {@link
     * Point} class with numerical coordinates in the range from "0" to
     * "boundCoor".
     *
     * @param array The object of the {@link Array} class to be filled with an
     * object of the {@link Point} class with numerical coordinates.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     */
    void fill(@NotNull Array<T> array, @NotNull V boundCoor);

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "0" to to "boundCoor".
     *
     * @param points The array to be filled with objects of the {@link Point}
     * class.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     */
    void fill(@NotNull T[] points, @NotNull V boundCoor);

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "0" to "boundCoor" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with numerical coordinates.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     */
    T[] fill(int lengthArray, @NotNull V boundCoor);

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with numerical coordinates in the range from "startBound" to
     * "upperBoundCoor".
     *
     * @param array The object of the {@link Array} class to be filled with an
     * object of the {@link Point} class with numerical coordinates.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     */
    void fill(@NotNull Array<T> array, @NotNull V lowerBoundCoor,
              @NotNull V upperBoundCoor);

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "lowerBoundCoor" to to "upperBoundCoor".
     *
     * @param points The array to be filled with objects of the {@link Point}
     * class.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     */
    void fill(@NotNull T[] points, @NotNull V lowerBoundCoor,
              @NotNull V upperBoundCoor);

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "lowerBoundCoor" to "upperBoundCoor"
     * parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with numerical coordinates.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array with objects of the {@link Point} class
     * with numerical coordinates.
     */
    T[] fill(int lengthArray, @NotNull V lowerBoundCoor,
             @NotNull V upperBoundCoor);

}
