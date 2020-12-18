package com.lugowoy.helper.filling.array.numbers.primitives;

import com.lugowoy.helper.models.arrays.ArrayInts;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 18.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.5
 */
//TODO write documentation
public interface FillingArrayIntegerPrimitives {

    void fill(@NotNull ArrayInts array);

    void fill(@NotNull int[] ints);

    int[] fill(int lengthArray);

    void fill(@NotNull ArrayInts array, int bound);

    void fill(@NotNull int[] ints, int bound);

    int[] fill(int lengthArray, int bound);

    void fill(@NotNull ArrayInts array, int lowerBound, int upperBound);

    void fill(@NotNull int[] ints, int lowerBound, int upperBound);

    int[] fill(int lengthArray, int lowerBound, int upperBound);

}
