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
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @since 1.2
 */
//TODO review documentation
public interface FillingArrayStrings<L extends Number>
        extends FillingArray<String> {

    void fill(@NotNull Array<String> array, @NotNull L lengthString);

    void fill(@NotNull String[] array, @NotNull L lengthString);

    String[] fill(int lengthArray, @NotNull L lengthString);

    void fill(@NotNull Array<String> array, @NotNull L lowerLengthString,
              @NotNull L upperLengthString);

    void fill(@NotNull String[] array, @NotNull L lowerLengthString,
              @NotNull L upperLengthString);

    String[] fill(int lengthArray, @NotNull L lowerLengthString,
                  @NotNull L upperLengthString);

}
