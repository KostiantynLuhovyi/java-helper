package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

/**
 * This interface is the inheritor of the {@link FillingArray} interface and
 * thereby redefines its contract for filling with object of the {@link String}
 * type of an object of the {@link Array} wrapper class and an classical
 * arrays.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @since 1.2
 */
//TODO review documentation
public interface FillingArrayStrings extends FillingArray<String> {

    void fill(@NotNull Array<String> array, @NotNull Integer lengthString);

    void fill(@NotNull String[] array, @NotNull Integer lengthString);

    String[] fill(int lengthArray, @NotNull Integer lengthString);

    void fill(@NotNull Array<String> array, @NotNull Integer lowerLengthString,
              @NotNull Integer upperLengthString);

    void fill(@NotNull String[] array, @NotNull Integer lowerLengthString,
              @NotNull Integer upperLengthString);

    String[] fill(int lengthArray, @NotNull Integer lowerLengthString,
                  @NotNull Integer upperLengthString);

}
