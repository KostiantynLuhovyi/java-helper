package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.models.Array;

/**
 * This class is a container (delegates the execution of functionality) for the implementation of the contract declared
 * in the {@link FillingArrayNumbers} interface.
 * This class uses contract implementations declared in the {@link FillingArrayNumbers} interface to perform functionality
 * for filling arrays with numeric data.
 * The methods of this class are delegated to the execution of a specific implementation of the contract declared
 * in the {@link FillingArrayNumbers} interface transferred during the creation of an instance of this class.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> The type of the numerical data stored and filled into an array.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructs a new object initializing it with a concrete implementation of the contract declared
     * in the {@link FillingArrayNumbers} interface.
     * Used superclass constructor.
     *
     * @param fillingArrayNumbers The object realizing the contract declared in the {@link FillingArrayNumbers} interface.
     */
    private FillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        super(fillingArrayNumbers);
    }

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to fill with data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array with numeric data.
     *
     * @param tArray The array to fill with numeric data.
     */
    @Override
    public void fill(T[] tArray) {
        super.fill(tArray);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the lengthArray parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to fill with numeric data.
     * @return Created and filled array with numeric data.
     */
    @Override
    public T[] fill(int lengthArray) {
        return super.fill(lengthArray);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data.
     * @param bound The value of the end bound for filling an object of the {@link Array} class with numeric data.
     */
    public void fill(Array<T> array, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, bound);
    }

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param tArray The array to be filled with numeric data.
     * @param bound  The value of the end bound for filling an array with numeric data.
     */
    public void fill(T[] tArray, T bound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, bound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>Values for filling are used from the range from 0 to the value of the bound parameter.
     *
     * @param lengthArray The length(size) of the array to be filled with numeric data.
     * @param bound       The value of the end bound for filling the array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>Values for filling are used from the range from startBound to the value of the endBound parameters.
     *
     * @param array      The object of the {@link Array} class to be filled with numeric data.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class with numeric data.
     * @param endBound   The value of the end bound for filling an object of the {@link Array} class with numeric data.
     */
    public void fill(Array<T> array, T startBound, T endBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(array, startBound, endBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>Values for filling are used from the range from startBound to the value of the endBound parameters.
     *
     * @param tArray     The array to be filled with numeric data.
     * @param startBound The value of the start bound for filling an array with numeric data.
     * @param endBound   The value of the end bound for filling an array with numeric data.
     */
    public void fill(T[] tArray, T startBound, T endBound) {
        ((FillingArrayNumbers<T>) super.getFilling()).fill(tArray, startBound, endBound);
    }

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
    public T[] fill(int lengthArray, T startBound, T endBound) {
        return ((FillingArrayNumbers<T>) super.getFilling()).fill(lengthArray, startBound, endBound);
    }

    /**
     * Creates a new object of {@link FillerArrayNumbers} class by calling a sole constructor with a parameter
     * for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param fillingArrayNumbers The object that implements the {@link FillingArrayNumbers} interface contract to fill an array with data.
     * @return The created object of this class.
     */
    public static <T extends Number> FillerArrayNumbers<T> getFillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<>(fillingArrayNumbers);
    }

}
