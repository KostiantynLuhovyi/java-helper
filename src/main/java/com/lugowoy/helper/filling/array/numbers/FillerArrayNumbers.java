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
 *  that fills the array with numeric data (values).
 * </p>
 */
//todo Проверить документацию, корректность и при необходимости провести рефакторинг.
public class FillerArrayNumbers<T extends Number> extends FillerArray<T> implements FillableArrayNumbers<T> {

    /**
     * <p>
     * Constructor with parameter.
     * The parameter accepts an object encapsulating the implementation of the interface
     *  for filling the array with numeric data (values).
     * </p>
     * @param filling A reference to the object encapsulating the implementation of the interface
     *                to fill the array with numeric data (values).
     */
    public FillerArrayNumbers(Filling<T[]> filling) {
        super(filling);
    }

    /**
     * <p>
     * The method fills the array with numeric data (values).
     * </p>
     * @param array The array to fill with numeric data (values).
     * @return A reference to an array filled with numeric data (values).
     */
    @Override
    public T[] fill(T[] array) {
        return super.getFilling().fill(array);
    }

    /**
     * <p>
     * The method fills the array with numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return A reference to the array created and filled with numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray);
    }

    /**
     * <p>
     * The method fills the array with numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with numeric data (values).
     */
    @Override
    public T[] fill(T[] array, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, bound);
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
     * @return A reference to an array filled with numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray, T bound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * <p>
     * The method fills an array the numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with numeric data (values).
     */
    @Override
    public T[] fill(T[] array, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(array, minBound, maxBound);
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
     * @return A reference to an array filled with numeric data (values).
     */
    @Override
    public T[] fill(int lengthArray, T minBound, T maxBound) {
        return ((FillingArrayNumbers<T>)super.getFilling()).fill(lengthArray, minBound, maxBound);
    }

}
