package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.models.matrices.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.2
 */
//todo edit doc's
public class FillerMatrix<T> extends Filler<Matrix<T>> {

    public FillerMatrix() {
    }

    public FillerMatrix(FillingMatrix<T> filling) {
        super(filling);
    }

    @Override
    public void fill(Matrix<T> matrix) {
        super.fill(matrix);
    }

    public void fill(T[][] matrix) {
        ((FillingMatrix<T>) super.getFilling()).fill(matrix);
    }

    public T[][] fill(int rows, int columns) {
        return ((FillingMatrix<T>) super.getFilling()).fill(rows, columns);
    }

}
