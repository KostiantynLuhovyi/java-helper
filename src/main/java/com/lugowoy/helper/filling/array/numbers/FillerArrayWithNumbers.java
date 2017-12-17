package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * A class that is a certain container that receives and uses an implementation of the functional
 *  that fills the array the numeric data (values).
 * </p>
 * @param <T> Type of arrays that is filling the numeric data (values).
 */

public class FillerArrayWithNumbers<T extends Number> extends FillerArray<T> implements FillableArrayWithNumbers<T> {

    /**
     * <p>
     * Creates an object initializing its specific implementation of the functionality to filling the array the numeric data (values).
     * </p>
     * @param filling An object encapsulating the implementation of filling the array the numeric data (values).
     */
    public FillerArrayWithNumbers(Filling<T[]> filling) {
        super(filling);
    }

    /**
     * <p>
     * The method fills the array the numeric data (values).
     * </p>
     * @param array The array to fill the numeric data (values).
     * @return An array filled the numeric data (values).
     */
    @Override
    public T[] fill(T[] array) {
        return super.filling.fill(array);
    }

    /**
     * <p>
     * The method fills the array the numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return An array created and filled the numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArrayWithNumbers<T>)super.filling).fill(lengthArray);
    }

    /**
     * <p>
     * The method fills the array the numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the numeric data (values).
     */
    @Override
    public T[] fill(T[] array, T bound) {
        return ((FillingArrayWithNumbers<T>)super.filling).fill(array, bound);
    }

    /**
     * <p>
     * The method fills array the numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled the numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayWithNumbers<T>)super.filling).fill(lengthArray, bound);
    }

    /**
     * <p>
     * The method fills an array the numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the numeric data (values).
     */
    @Override
    public T[] fill(T[] array, T minBound, T maxBound) {
        return ((FillingArrayWithNumbers<T>)super.filling).fill(array, minBound, maxBound);
    }

    /**
     * <p>
     * The method fills array the numeric data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled the numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray, T minBound, T maxBound) {
        return ((FillingArrayWithNumbers<T>)super.filling).fill(lengthArray, minBound, maxBound);
    }

}
