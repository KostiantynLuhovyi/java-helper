package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>This class fills an object of class {@link Array} with objects of {@link
 * String} type, which is a wrapper over classical arrays.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @since 1.2
 */
//TODO review documentation
public class FillerArrayStrings extends FillerArray<String> {

    /**
     * Constructor to create a new {@link FillerArrayStrings} and initializes
     * the object encapsulated in parent class to perform the functionality.
     *
     * @param filling The object that implements the {@link FillingArray}
     * interface contract to fill an array.
     */
    public FillerArrayStrings(
            @NotNull final FillingArrayStrings<Integer> filling) {
        super(filling);
    }

    public void fill(@NotNull final Array<String> array,
                     @NotNull final Integer lengthString) {
        ((FillingArrayStrings<Integer>) super.getFilling()).fill(array,
                                                                 lengthString);
    }

    public void fill(@NotNull final String[] array,
                     @NotNull final Integer lengthString) {
        ((FillingArrayStrings<Integer>) super.getFilling()).fill(array,
                                                                 lengthString);
    }

    public String[] fill(final int lengthArray,
                         @NotNull final Integer lengthString) {
        return ((FillingArrayStrings<Integer>) super.getFilling()).fill(
                lengthArray, lengthString);
    }

    final void fill(@NotNull final Array<String> array,
                    @NotNull final Integer lowerLengthString,
                    @NotNull final Integer upperLengthString) {
        ((FillingArrayStrings<Integer>) super.getFilling()).fill(array,
                                                                 lowerLengthString,
                                                                 upperLengthString);
    }

    public void fill(@NotNull final String[] array,
                     @NotNull final Integer lowerLengthString,
                     @NotNull final Integer upperLengthString) {
        ((FillingArrayStrings<Integer>) super.getFilling()).fill(array,
                                                                 lowerLengthString,
                                                                 upperLengthString);
    }

    String[] fill(final int lengthArray,
                  @NotNull final Integer lowerLengthString,
                  @NotNull final Integer upperLengthString) {
        return ((FillingArrayStrings<Integer>) super.getFilling()).fill(
                lengthArray, lowerLengthString, upperLengthString);
    }

}
