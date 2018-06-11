package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 *
 *
 * */
//todo Fix and add doc's;
public abstract class FillingArrayStrings implements FillingArray<String> {

    /**
     * Fills an object of the {@link Array} class with data.
     *
     * @param array The object of the {@link Array} class to be filled with data.
     */
    @Override
    public abstract void fill(Array<String> array);

    /**
     * Fills an array with data.
     *
     * @param tArray The array to be filled with data.
     */
    @Override
    public abstract void fill(String[] tArray);

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with data.
     * @return Created and filled array with data.
     */
    @Override
    public abstract String[] fill(int lengthArray);

}
