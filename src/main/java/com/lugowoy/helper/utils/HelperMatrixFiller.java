package com.lugowoy.helper.utils;

import com.lugowoy.helper.filling.matrix.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillerMatrixDoublePrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillerMatrixIntegerPrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixDoublePrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixIntegerPrimitives;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 02.02.2021.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.8
 */
//TODO write documentation
public class HelperMatrixFiller {

    private static final String MSG_FILLING_IS_NULL = "filling is null";

    public int[][] getArray(
            @NotNull final FillingMatrixIntegerPrimitives filling,
            final int rows, final int columns,
            @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerMatrixIntegerPrimitives(filling).fill(rows, columns,
                                                               lowerBound,
                                                               upperBound);
    }

    public double[][] getArray(
            @NotNull final FillingMatrixDoublePrimitives filling,
            final int rows, final int columns, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerMatrixDoublePrimitives(filling).fill(rows, columns,
                                                              lowerBound,
                                                              upperBound);
    }

    public static Integer[][] getArray(
            @NotNull final FillingMatrixNumbers<Integer> filling,
            final int rows, final int columns,
            @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerMatrixNumbers<>(filling).fill(rows, columns,
                                                       lowerBound, upperBound);
    }

    public static Double[][] getArray(
            @NotNull final FillingMatrixNumbers<Double> filling, final int rows,
            final int columns, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerMatrixNumbers<>(filling).fill(rows, columns,
                                                       lowerBound, upperBound);
    }

}
