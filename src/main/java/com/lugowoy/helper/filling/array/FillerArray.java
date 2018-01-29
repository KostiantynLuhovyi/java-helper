package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The class is the inheritor of the class {@link Filler}.
 * <p>The class that is a container that encapsulates a specific implementation of a contract declared in the {@link FillingArray} interface
 *  and delegates to it an obligation to perform functionality to fill an array with data.
 * <p> All an objects of the classes that implement the contract of the {@link FillingArray} interface can be encapsulated
 *  and involved in the functionality.
 *
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 *
 * @param <T> The type of data objects stored and filled into an array.
 * */

public class FillerArray<T> extends Filler<Array<T>> implements FillingArray<T> {

    /**
     * Default constructor.
     * The presence of this is absolutely not necessary.
     * Its presence is caused by the need to add more extended constructor variants to the inheritor of this class.
     */
    protected FillerArray() {
    }

    /**
     * Constructor to create a new {@link FillerArray} and initializes the object encapsulated in parent class to perform the functionality.
     *
     * @param fillingArray The object that implements the {@link FillingArray} interface contract to fill an array.
     * */
    protected FillerArray(FillingArray<T> fillingArray) {
        super(fillingArray);
    }

    /**
     * Fills an object of class {@link Array} with data.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link Filling} interface contract
     *  and is encapsulated in the object of parent class.
     *
     * @param array The object of class {@link Array} to be filled with data.
     * @return The object of class {@link Array} filled with data.
     * */
    @Override
    public Array<T> fill(Array<T> array) {
        return super.fill(array);
    }

    /**
     * Fills an array with data.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArray} interface contract
     *  and is encapsulated in the object of parent class.
     *
     * @param tArray The array to be filled with data.
     * @return The array filled with data.
     * */
    @Override
    public T[] fill(T[] tArray) {
        return ((FillingArray<T>)super.getFilling()).fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArray} interface contract
     *  and is encapsulated in the object of parent class.
     * </p>
     *
     * @param lengthArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
     * */
    @Override
    public T[] fill(int lengthArray) {
        return ((FillingArray<T>)super.getFilling()).fill(lengthArray);
    }

    /**
     * Creates a new object of {@link FillerArray} class by calling a single constructor with a parameter
     *  for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param fillingArray The object that implements the {@link FillingArray} interface contract to fill an array with data.
     * @return The created object of this class.
     * */
    public static <T> FillerArray<T> getFillerArray(FillingArray<T> fillingArray) {
        return new FillerArray<>(fillingArray);
    }

}
