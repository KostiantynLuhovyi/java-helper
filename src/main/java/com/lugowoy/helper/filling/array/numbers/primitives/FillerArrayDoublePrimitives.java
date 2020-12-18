package com.lugowoy.helper.filling.array.numbers.primitives;

import com.lugowoy.helper.models.arrays.ArrayDoubles;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 18.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.5
 */
//TODO write documentation
public class FillerArrayDoublePrimitives {

    private FillingArrayDoublePrimitives filling;

    public FillerArrayDoublePrimitives(
            @NotNull final FillingArrayDoublePrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

    public void fill(@NotNull final ArrayDoubles array) {
        this.filling.fill(array);
    }

    public void fill(@NotNull final double[] doubles) {
        this.filling.fill(doubles);
    }

    public double[] fill(final int lengthArray) {
        return this.filling.fill(lengthArray);
    }

    public void fill(@NotNull final ArrayDoubles array, final double bound) {
        this.filling.fill(array, bound);
    }

    public void fill(@NotNull final double[] doubles, final double bound) {
        this.filling.fill(doubles, bound);
    }

    public double[] fill(final int lengthArray, final double bound) {
        return this.filling.fill(lengthArray, bound);
    }

    public void fill(@NotNull final ArrayDoubles array, final double lowerBound,
                     final double upperBound) {
        this.filling.fill(array, lowerBound, upperBound);
    }

    public void fill(@NotNull final double[] doubles, final double lowerBound,
                     final double upperBound) {
        this.filling.fill(doubles, lowerBound, upperBound);
    }

    public double[] fill(final int lengthArray, final double lowerBound,
                         final double upperBound) {
        return this.filling.fill(lengthArray, lowerBound, upperBound);
    }

    public FillingArrayDoublePrimitives getFilling() {
        return filling;
    }

    public void setFilling(@NotNull final FillingArrayDoublePrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }
}
