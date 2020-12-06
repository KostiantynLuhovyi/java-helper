package com.lugowoy.helper.converters.array;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 08.11.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
//TODO write documentation
public interface ConverterArrayNumbersToPrimitive {

    static <T extends Number> int[] toIntArray(@NotNull final T[] array) {
        Objects.requireNonNull(array, "Array is null.");
        return Arrays.stream(array).mapToInt(T::intValue).toArray();
    }

    static <T extends Number> double[] toDoubleArray(@NotNull final T[] array) {
        Objects.requireNonNull(array, "Array is null.");
        return Arrays.stream(array).mapToDouble(T::doubleValue).toArray();
    }

}
