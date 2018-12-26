package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public class FillerMatrix<T> extends Filler<Matrix<T>> {

    protected FillerMatrix(FillingMatrix<T> filling) {
        super(filling);
    }

    @Override
    public void fill(Matrix<T> matrix) {
        super.fill(matrix);
    }

    public void fill(T[][] matrix) {
        ((FillingMatrix<T>)super.getFilling()).fill(matrix);
    }

    public T[][] fill(int rows, int columns) {
        return ((FillingMatrix<T>)super.getFilling()).fill(rows, columns);
    }

    public static <T> FillerMatrix<T> getFillerMatrix(FillingMatrix<T> fillingMatrix) {
        return new FillerMatrix<>(fillingMatrix);
    }

}
