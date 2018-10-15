package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;

/**
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>The class that is a container that encapsulates a specific implementation of a contract declared in the {@link FillingArrayPointsArrayNumbers} interface
 *  and delegates to it an obligation to perform functionality to fills an object of the {@link Array} class
 *  and classical array of object of the {@link Point} class with numeric coordinates.
 * <p>Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @param <T> The type of coordinates encapsulated in the object of the {@link Point} class.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *///todo fix doc's
public class FillerArrayPoints<T extends Number> extends FillerArray<Point<T>> {

    /**
     * Constructor to create a new {@link FillerArrayPoints}
     * and initializes the object encapsulated in parent class to perform the functionality.
     *
     * @param fillingArrayPoints The object that implements the {@link FillingArrayPoints} interface contract to fill an array.
     */
    private FillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        super(fillingArrayPoints);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class with numerical coordinates.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link Filling} interface contract.
     *
     * @param array The object of class {@link Array} to be filled
     *              with the objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    public void fill(Array<Point<T>> array) {
        super.fill(array);
    }

    /**
     * Fills an array of objects of the {@link Point} class with numerical coordinates.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArray} interface contract.
     *
     * @param tArray The array to be filled with the objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    public void fill(Point<T>[] tArray) {
        super.fill(tArray);
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numerical coordinates.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArray} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled
     *                    with the objects of the {@link Point} class with numerical coordinates.
     * @return Created and filled array of the objects of the {@link Point} class with numerical coordinates.
     */
    @Override
    public Point<T>[] fill(int lengthOfArray) {
        return super.fill(lengthOfArray);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     * in the range from "0" to "bound".
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param array The object of the {@link Array} class to be filled
     *              with an object of the {@link Point} class with numerical coordinates.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     */
    public void fill(Array<Point<T>> array, T bound) {
        ((FillingArrayPoints<T>)super.getFilling()).fill(array, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to to "bound".
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param points The array to be filled with objects of the {@link Point} class.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     */
    public void fill(Point<T>[] points, T bound) {
        ((FillingArrayPoints<T>)super.getFilling()).fill(points, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter "lengthOfArray" determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled with objects of the {@link Point} class with numerical coordinates.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    public Point<T>[] fill(int lengthOfArray, T bound) {
        return ((FillingArrayPoints<T>)super.getFilling()).fill(lengthOfArray, bound);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     * in the range from "startBound" to "endBound".
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param array      The object of the {@link Array} class to be filled
     *                   with an object of the {@link Point} class with numerical coordinates.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     */
    public void fill(Array<Point<T>> array, T startBound, T endBound) {
        ((FillingArrayPoints<T>)super.getFilling()).fill(array, startBound, endBound);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "startBound" to to "endBound".
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param points     The array to be filled with objects of the {@link Point} class.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     */
    public void fill(Point<T>[] points, T startBound, T endBound) {
        ((FillingArrayPoints<T>)super.getFilling()).fill(points, startBound, endBound);
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numerical coordinates in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter "lengthOfArray" determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class
     * and contains the implementation of the {@link FillingArrayPoints} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled
     *                    with objects of the {@link Point} class with numerical coordinates.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    public Point<T>[] fill(int lengthOfArray, T startBound, T endBound) {
        return ((FillingArrayPoints<T>)super.getFilling()).fill(lengthOfArray, startBound, endBound);
    }

    /**
     * Creates a new object of {@link FillerArrayPoints} class by calling a single constructor with a parameter
     *  for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param fillingArrayPoints The object that implements the {@link FillingArrayPoints} interface contract
     *                             to fill an array with data.
     * @return The created object of this class.
     */
    public static <T extends Number> FillerArrayPoints<T> getFillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        return new FillerArrayPoints<>(fillingArrayPoints);
    }

}
