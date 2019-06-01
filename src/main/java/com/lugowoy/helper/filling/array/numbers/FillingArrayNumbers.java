package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.Array;

/**
 * The interface declares a contract to implement the functionality for filling array with numeric data.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of array and numeric data elements to fill.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public interface FillingArrayNumbers<T extends Number> extends FillingArray<T> {

    /**
     * Fills an object of the {@link Array} class with numeric data.
     *
     * @param array The object of the {@link Array} class to fill.
     */
    @Override
    void fill(Array<T> array);

    /**
     * Fills an array with numeric data.
     *
     * @param tArray The array to fill.
     */
    @Override
    void fill(T[] tArray);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill.
     * @return Created and filled array with numeric data.
     */
    @Override
    T[] fill(int lengthArray);

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data.
     * @param bound The value of the end bound for filling an object with numeric data.
     */
    void fill(Array<T> array, T bound);

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param tArray The array to be filled with numeric data.
     * @param bound  The value of the end bound for filling an array with numeric data.
     */
    void fill(T[] tArray, T bound);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param lengthArray The length(size) of the array to be filled with numeric data.
     * @param bound       The value of the end bound for filling the array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    T[] fill(int lengthArray, T bound);

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from startBound to the value of the endBound parameters.
     *
     * @param array      The object of the {@link Array} class to be filled with numeric data.
     * @param startBound The value of the start bound for filling an object with numeric data.
     * @param endBound   The value of the end bound for filling an object with numeric data.
     */
    void fill(Array<T> array, T startBound, T endBound);

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from startBound to the value of the endBound parameters.
     *
     * @param tArray     The array to be filled with numeric data.
     * @param startBound The value of the start bound for filling an array with numeric data.
     * @param endBound   The value of the end bound for filling an array with numeric data.
     */
    void fill(T[] tArray, T startBound, T endBound);

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from startBound to the value of the endBound parameters.
     *
     * @param lengthArray The length(size) of the array to be filled with numeric data.
     * @param startBound  The value of the start bound for filling an array with numeric data.
     * @param endBound    The value of the end bound for filling an array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    T[] fill(int lengthArray, T startBound, T endBound);

}
