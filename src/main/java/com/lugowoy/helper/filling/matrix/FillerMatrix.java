package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filler;
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
public class FillerMatrix<T> extends Filler<Matrix<T>> {

    public FillerMatrix(@NotNull final FillingMatrix<T> filling) {
        super(filling);
    }

    public void fill(@NotNull final T[][] matrix) {
        ((FillingMatrix<T>) super.getFilling()).fill(matrix);
    }

    public T[][] fill(final int rows, final int columns) {
        return ((FillingMatrix<T>) super.getFilling()).fill(rows, columns);
    }

}
