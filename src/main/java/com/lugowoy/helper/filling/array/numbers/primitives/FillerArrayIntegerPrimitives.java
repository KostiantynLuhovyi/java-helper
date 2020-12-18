package com.lugowoy.helper.filling.array.numbers.primitives;

import com.lugowoy.helper.models.arrays.ArrayInts;
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
public class FillerArrayIntegerPrimitives {

    private FillingArrayIntegerPrimitives filling;

    public FillerArrayIntegerPrimitives(
            @NotNull final FillingArrayIntegerPrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

    public void fill(@NotNull final ArrayInts array) {
        this.filling.fill(array);
    }

    public void fill(@NotNull final int[] ints) {
        this.filling.fill(ints);
    }

    public int[] fill(final int lengthArray) {
        return this.filling.fill(lengthArray);
    }

    public void fill(@NotNull final ArrayInts array, final int bound) {
        this.filling.fill(array, bound);
    }

    public void fill(@NotNull final int[] ints, final int bound) {
        this.filling.fill(ints, bound);
    }

    public int[] fill(final int lengthArray, final int bound) {
        return this.filling.fill(lengthArray, bound);
    }

    public void fill(@NotNull final ArrayInts array, final int lowerBound,
                     final int upperBound) {
        this.filling.fill(array, lowerBound, upperBound);
    }

    public void fill(@NotNull final int[] ints, final int lowerBound,
                     final int upperBound) {
        this.filling.fill(ints, lowerBound, upperBound);
    }

    public int[] fill(final int lengthArray, final int lowerBound,
                      final int upperBound) {
        return this.filling.fill(lengthArray, lowerBound, upperBound);
    }

    public FillingArrayIntegerPrimitives getFilling() {
        return filling;
    }

    public void setFilling(@NotNull final FillingArrayIntegerPrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

}
