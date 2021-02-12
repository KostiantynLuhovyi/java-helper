package com.lugowoy.helper.utils;

import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.primitives.FillerArrayDoublePrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillerArrayIntegerPrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayDoublePrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayIntegerPrimitives;
import com.lugowoy.helper.filling.array.points.FillerArrayPoints;
import com.lugowoy.helper.filling.array.points.FillingArrayPoints;
import com.lugowoy.helper.filling.array.strings.FillerArrayStrings;
import com.lugowoy.helper.filling.array.strings.FillingArrayStrings;
import com.lugowoy.helper.models.points.Point2D;
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
public class HelperArrayFiller {

    private static final String MSG_FILLING_IS_NULL = "filling is null";

    public int[] getArray(
            @NotNull final FillingArrayIntegerPrimitives filling,
            final int lengthArray, final int lowerBound, final int upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayIntegerPrimitives(filling).fill(lengthArray,
                                                              lowerBound,
                                                              upperBound);
    }

    public double[] getArray(
            @NotNull final FillingArrayDoublePrimitives filling,
            final int lengthArray, final double lowerBound,
            final double upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayDoublePrimitives(filling).fill(lengthArray,
                                                             lowerBound,
                                                             upperBound);
    }

    public Integer[] getArray(
            @NotNull final FillingArrayNumbers<Integer> filling,
            final int lengthArray, @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayNumbers<>(filling).fill(lengthArray, lowerBound,
                                                      upperBound);
    }

    public Double[] getArray(
            @NotNull final FillingArrayNumbers<Double> filling,
            final int lengthArray, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayNumbers<>(filling).fill(lengthArray, lowerBound,
                                                      upperBound);
    }

    public String[] getArray(@NotNull final FillingArrayStrings filling,
                                    final Integer lengthArray,
                                    @NotNull final Integer lowerBound,
                                    @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayStrings(filling).fill(lengthArray, lowerBound,
                                                    upperBound);
    }

    public Point2D<Integer>[] getArray(@NotNull
                                              final FillingArrayPoints<Point2D<Integer>, Integer> filling,
                                              final int lengthArray,
                                              @NotNull final Integer lowerBound,
                                              @NotNull
                                              final Integer upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayPoints<>(filling).fill(lengthArray, lowerBound,
                                                     upperBound);
    }

    public Point2D<Double>[] getArray(
            @NotNull final FillingArrayPoints<Point2D<Double>, Double> filling,
            final int lengthArray, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, MSG_FILLING_IS_NULL);
        return new FillerArrayPoints<>(filling).fill(lengthArray, lowerBound,
                                                     upperBound);
    }

}
