package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * This interface is the inheritor of the {@link FillingArray} interface
 * and thereby redefines its contract for filling with object of the {@link String} type of
 * an object of the {@link Array} wrapper class and an classical arrays.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @since 1.2
 */
//todo edit doc's
public interface FillingArrayStrings extends FillingArray<String> {

    /**
     * Fills an object of the {@link Array} class with object of the {@link String} type.
     *
     * @param array The object of the {@link Array} class to be filled with object of the {@link String} type.
     */
    @Override
    void fill(Array<String> array);

    /**
     * Fills an array with object of the {@link String} type.
     *
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    void fill(String[] strings);

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    String[] fill(int lengthArray);

}
