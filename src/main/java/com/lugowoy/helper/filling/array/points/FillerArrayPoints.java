package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import org.jetbrains.annotations.NotNull;

/**
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>The class that is a container that encapsulates a specific implementation
 * of a contract declared in the {@link FillingArrayPoints} interface and
 * delegates to it an obligation to perform functionality to fills an object of
 * the {@link Array} class and classical array of object of the {@link Point}
 * class with numeric coordinates.
 * <p>Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @param <T> The type of coordinates encapsulated in the object of the {@link
 * Point} class.
 * @author Konstantin Lugowoy
 * @version 1.6
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
//TODO review documentation
public class FillerArrayPoints<T extends Point<V>, V extends Number>
        extends FillerArray<T> {

    /**
     * Constructor to create a new {@link FillerArrayPoints} and initializes the
     * object encapsulated in parent class to perform the functionality.
     *
     * @param filling The object that implements the {@link FillingArrayPoints}
     * interface contract to fill an array.
     */
    public FillerArrayPoints(@NotNull final FillingArrayPoints<T, V> filling) {
        super(filling);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with numerical coordinates in the range from "0" to
     * "boundCoor".
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param array The object of the {@link Array} class to be filled with an
     * object of the {@link Point} class with numerical coordinates.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     */
    public void fill(@NotNull final Array<T> array,
                     @NotNull final V boundCoor) {
        ((FillingArrayPoints<T, V>) super.getFilling()).fill(array, boundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "0" to to "boundCoor".
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param points The array to be filled with objects of the {@link Point}
     * class.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     */
    public void fill(@NotNull final T[] points, @NotNull final V boundCoor) {
        ((FillingArrayPoints<T, V>) super.getFilling()).fill(points, boundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "0" to "boundCoor" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array.
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with numerical coordinates.
     * @param boundCoor The value of the end of the range boundary of numerical
     * values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array of objects of the {@link Point} class
     * with numerical coordinates.
     */
    public T[] fill(final int lengthArray, @NotNull final V boundCoor) {
        return ((FillingArrayPoints<T, V>) super.getFilling()).fill(lengthArray,
                                                                    boundCoor);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link
     * Point} class with numerical coordinates in the range from
     * "lowerBoundCoor" to "upperBoundCoor".
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
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
    public void fill(@NotNull final Array<T> array,
                     @NotNull final V lowerBoundCoor,
                     @NotNull final V upperBoundCoor) {
        ((FillingArrayPoints<T, V>) super.getFilling()).fill(array,
                                                             lowerBoundCoor,
                                                             upperBoundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "lowerBoundCoor" to to "upperBoundCoor".
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
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
    public void fill(@NotNull final T[] points, @NotNull final V lowerBoundCoor,
                     @NotNull final V upperBoundCoor) {
        ((FillingArrayPoints<T, V>) super.getFilling()).fill(points,
                                                             lowerBoundCoor,
                                                             upperBoundCoor);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical
     * coordinates in the range from "lowerBoundCoor" to "upperBoundCoor"
     * parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array.
     * <p>The execution of this method is delegated to the object that
     * encapsulated in the object of parent class and contains the
     * implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param lengthArray The length(size) of the array to be filled with
     * objects of the {@link Point} class with numerical coordinates.
     * @param lowerBoundCoor The value of the start of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @param upperBoundCoor The value of the end of the range boundary of
     * numerical values by which the coordinates of points in the array will be
     * initialized.
     * @return Created and filled array of objects of the {@link Point} class
     * with numerical coordinates.
     */
    public T[] fill(final int lengthArray, @NotNull final V lowerBoundCoor,
                    @NotNull final V upperBoundCoor) {
        return ((FillingArrayPoints<T, V>) super.getFilling()).fill(lengthArray,
                                                                    lowerBoundCoor,
                                                                    upperBoundCoor);
    }

}
