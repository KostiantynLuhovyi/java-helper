package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 * This interface is the inheritor of the {@link FillingArray} interface
 *  and thereby redefines its contract for filling with object of the {@link String} type of
 *  an object of the {@link Array} wrapper class and an classical arrays.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */

public abstract class FillingArrayStrings implements FillingArray<String> {

    /**
     * A constant that stores the default value of the start string length.
     *
     * @since 1.3
     * */
    static final int DEFAULT_START_LENGTH_STRING = 0;

    /**
     * A constant that stores the default value of the minimum string length.
     *
     * @since 1.3
     * */
    static final int DEFAULT_MIN_LENGTH_STRING = 1;

    /**
     * A constant that stores the default length of a string.
     *
     * @since 1.3
     * */
    static final int DEFAULT_STRING_LENGTH = 10;

    /**
     * Fills an object of the {@link Array} class with object of the {@link String} type.
     *
     * @param array The object of the {@link Array} class to be filled with object of the {@link String} type.
     */
    @Override
    public abstract void fill(Array<String> array);

    /**
     * Fills an array with object of the {@link String} type.
     *
     * @param strings The array to be filled with object of the {@link String} type.
     */
    @Override
    public abstract void fill(String[] strings);

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public abstract String[] fill(int lengthArray);

}
