package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>This class fills an object of class {@link Array} with objects of {@link String} type, which is a wrapper over classical arrays.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @since 1.2
 */
public class FillerArrayStrings extends FillerArray<String> {

    /**
     * Constructor to create a new {@link FillerArrayStrings}
     * and initializes the object encapsulated in parent class to perform the functionality.
     * @param fillingArray The object that implements the {@link FillingArray} interface contract to fill an array.
     */
    public FillerArrayStrings(FillingArray<String> fillingArray) {
        super(fillingArray);
    }

    /**
     * Fills an object of class {@link Array} with object of the {@link String} type.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link Filling} interface contract.
     * @param array The object of class {@link Array} to be filled with object of the {@link String} type.
     */
    @Override
    public void fill(Array<String> array) {
        super.fill(array);
    }

    /**
     * Fills an array with data.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArray} interface contract.
     * @param tArray The array to be filled with data.
     */
    @Override
    public void fill(String[] tArray) {
        super.fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that encapsulated in the object of parent class and
     * contains the implementation of the {@link FillingArray} interface contract.
     * @param lengthArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
     */
    @Override
    public String[] fill(int lengthArray) {
        return super.fill(lengthArray);
    }

}
