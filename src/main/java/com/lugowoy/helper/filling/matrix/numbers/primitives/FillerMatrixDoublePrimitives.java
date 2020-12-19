package com.lugowoy.helper.filling.matrix.numbers.primitives;

import com.lugowoy.helper.models.matrices.MatrixDoubles;
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
public class FillerMatrixDoublePrimitives {

    private FillingMatrixDoublePrimitives filling;

    public FillerMatrixDoublePrimitives(@NotNull final FillingMatrixDoublePrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

    public void fill(@NotNull final MatrixDoubles matrix) {
        this.filling.fill(matrix);
    }

    public void fill(@NotNull final double[][] matrix) {
        this.filling.fill(matrix);
    }

    public double[][] fill(final int rows, final int columns) {
        return this.filling.fill(rows, columns);
    }

    public void fill(@NotNull final MatrixDoubles matrix, final double bound) {
        this.filling.fill(matrix, bound);
    }

    public void fill(@NotNull final double[][] matrix, final double bound) {
        this.filling.fill(matrix, bound);
    }

    public double[][] fill(final int rows, final int columns, final double bound) {
        return this.filling.fill(rows, columns, bound);
    }

    public void fill(@NotNull final MatrixDoubles matrix, final double lowerBound,
              final double upperBound) {
        this.filling.fill(matrix, lowerBound, upperBound);
    }

    public void fill(@NotNull final double[][] matrix, final double lowerBound,
              final double upperBound) {
        this.filling.fill(matrix, lowerBound, upperBound);
    }

    public double[][] fill(final int rows, final int columns, final double lowerBound,
                    final double upperBound) {
        return this.filling.fill(rows, columns, lowerBound, upperBound);
    }

    public FillingMatrixDoublePrimitives getFilling() {
        return filling;
    }

    public void setFilling(@NotNull final FillingMatrixDoublePrimitives filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

}
