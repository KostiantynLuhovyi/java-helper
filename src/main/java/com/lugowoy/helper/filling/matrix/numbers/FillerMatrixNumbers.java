package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillerMatrix;
import com.lugowoy.helper.models.matrices.Matrix;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.2
 */
//TODO write documentation
public class FillerMatrixNumbers<T extends Number> extends FillerMatrix<T> {

    public FillerMatrixNumbers(@NotNull final FillingMatrixNumbers<T> filling) {
        super(filling);
    }

    public void fill(@NotNull final Matrix<T> matrix, @NotNull final T bound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, bound);
    }

    public void fill(@NotNull T[][] matrix, final T bound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, bound);
    }

    public T[][] fill(final int rows, final int columns,
                      @NotNull final T bound) {
        return ((FillingMatrixNumbers<T>) super.getFilling()).fill(rows,
                                                                   columns,
                                                                   bound);
    }

    public void fill(@NotNull final Matrix<T> matrix,
                     @NotNull final T lowerBound, @NotNull final T upperBound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, lowerBound,
                                                            upperBound);
    }

    public void fill(@NotNull final T[][] matrix, @NotNull final T lowerBound,
                     @NotNull final T upperBound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, lowerBound,
                                                            upperBound);
    }

    public T[][] fill(final int rows, final int columns,
                      @NotNull final T lowerBound,
                      @NotNull final T upperBound) {
        return ((FillingMatrixNumbers<T>) super.getFilling()).fill(rows,
                                                                   columns,
                                                                   lowerBound,
                                                                   upperBound);
    }

}
