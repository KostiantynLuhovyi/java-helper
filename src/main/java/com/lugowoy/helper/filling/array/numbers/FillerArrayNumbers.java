package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.Array;

/**
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>The class that is a container that encapsulates a specific implementation of a contract declared in the {@link FillingArrayNumbers} interface
 *  and delegates to it an obligation to perform functionality to fill a array with numeric data.
 * <p>This class fills in numeric data objects of class {@link Array}, which is a wrapper over classical arrays.
 * It is also possible to fill in numerical data with classical arrays.
 * <p>The numeric data must be the inheritance of the base class {@link Number}.
 * <p>Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @param <T> The type of the numerical data stored and filled into an array.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 */
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> {

    /**
     * Constructor to create a new {@link FillerArrayNumbers} and initializes the object encapsulated in parent class to perform the functionality.
     *
     * @param fillingArrayNumbers The object that implements the {@link FillingArrayNumbers} interface contract to fill an array with numeric data.
     */
    private FillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        super(fillingArrayNumbers);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link Filling} interface contract.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data.
     */
    @Override
    public void fill(Array<T> array) {
        super.fill(array);
    }

    /**
     * Fills an array with data.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArray} interface contract.
     *
     * @param tArray The array to be filled with data.
     */
    @Override
    public void fill(T[] tArray) {
        super.fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArray} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
     */
    @Override
    public T[] fill(int lengthOfArray) {
        return super.fill(lengthOfArray);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>The object of the {@link Array} class is filled with numeric data in the range from "0" to the value of the "bound" parameter.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data.
     * @param bound The value of the end bound for filling an object of the {@link Array} class with numeric data.
     */
    public void fill(Array<T> array, T bound) {
        ((FillingArrayNumbers<T>)super.getFilling()).fill(array, bound);
    }

    /**
     * Fills an array with numeric data.
     * <p>An array is filled with numeric data in the range from "0" to the value of the "bound" parameter.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param tArray The array to be filled with numeric data.
     * @param bound The value of the end bound for filling an array with numeric data.
     */
    public void fill(T[] tArray, T bound) {
        ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, bound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The array is filled with numeric data in the range from "0" to the value of the "bound" parameter.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled with numeric data.
     * @param bound The value of the end bound for filling the array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    public T[] fill(int lengthOfArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthOfArray, bound);
    }

    /**
     * Fills an object of the {@link Array} class with numeric data.
     * <p>The object of the {@link Array} class is filled with numeric data in the range from the value "startBound" to the value of the "endBound" parameters.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param array The object of the {@link Array} class to be filled with numeric data.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class with numeric data.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class with numeric data.
     */
    public void fill(Array<T> array, T startBound, T endBound) {
        ((FillingArrayNumbers<T>)super.getFilling()).fill(array, startBound, endBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is filled with numeric data in the range from the value "startBound" to the value of the "endBound" parameters.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param tArray The array to be filled with numeric data.
     * @param startBound The value of the start bound for filling an array with numeric data.
     * @param endBound The value of the end bound for filling an array with numeric data.
     */
    public void fill(T[] tArray, T startBound, T endBound) {
        ((FillingArrayNumbers<T>)super.getFilling()).fill(tArray, startBound, endBound);
    }

    /**
     * Fills an array with numeric data.
     * <p>The array is created based on the "lengthOfArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The array is filled with numeric data in the range from the value "startBound" to the value of the "endBound" parameters.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArrayNumbers} interface contract.
     *
     * @param lengthOfArray The length(size) of the array to be filled with numeric data.
     * @param startBound The value of the start bound for filling an array with numeric data.
     * @param endBound The value of the end bound for filling an array with numeric data.
     * @return Created and filled an array with numeric data.
     */
    public T[] fill(int lengthOfArray, T startBound, T endBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthOfArray, startBound, endBound);
    }

    /**
     * Creates a new object of {@link FillerArrayNumbers} class by calling a single constructor with a parameter
     *  for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param fillingArrayNumbers The object that implements the {@link FillingArrayNumbers} interface contract to fill an array with data.
     * @return The created object of this class.
     */
    public static <T extends Number> FillerArrayNumbers<T> getFillerArrayNumbers(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<>(fillingArrayNumbers);
    }

}
