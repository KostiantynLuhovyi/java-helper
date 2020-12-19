package com.lugowoy.helper.filling.matrix.numbers.primitives;

import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 19.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.6
 */
//TODO write documentation
public class FillerMatrixIntegerPrimitives {

    private FillingMatrixIntegerPrimitives filling;

    public FillerMatrixIntegerPrimitives(
            @NotNull final FillingMatrixIntegerPrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

    public void fill(@NotNull final MatrixInts matrix) {
        this.filling.fill(matrix);
    }

    public void fill(@NotNull final int[][] matrix) {
        this.filling.fill(matrix);
    }

    public int[][] fill(final int rows, final int columns) {
        return this.filling.fill(rows, columns);
    }

    public void fill(@NotNull final MatrixInts matrix, final int bound) {
        this.filling.fill(matrix, bound);
    }

    public void fill(@NotNull final int[][] matrix, final int bound) {
        this.filling.fill(matrix, bound);
    }

    public int[][] fill(final int rows, final int columns, final int bound) {
        return this.filling.fill(rows, columns, bound);
    }

    public void fill(@NotNull final MatrixInts matrix, final int lowerBound,
              final int upperBound) {
        this.filling.fill(matrix, lowerBound, upperBound);
    }

    public void fill(@NotNull final int[][] matrix, final int lowerBound,
              final int upperBound) {
        this.filling.fill(matrix, lowerBound, upperBound);
    }

    public int[][] fill(final int rows, final int columns, final int lowerBound,
                 final int upperBound) {
        return this.filling.fill(rows, columns, lowerBound, upperBound);
    }

    public FillingMatrixIntegerPrimitives getFilling() {
        return filling;
    }

    public void setFilling(@NotNull final FillingMatrixIntegerPrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }
}
