package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrix;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */

//todo refactoring code
//todo edit doc's

public interface FillingMatrixNumbers<T extends Number> extends FillingMatrix<T> {

    @Override
    void fill(Matrix<T> matrix);

    @Override
    void fill(T[][] matrix);

    @Override
    T[][] fill(int rows, int columns);

    void fill(Matrix<T> matrix, T bound);

    void fill(T[][] matrix, T bound);

    T[][] fill(int rows, int columns, T bound);

    void fill(Matrix<T> matrix, T startBound, T endBound);

    void fill(T[][] matrix, T startBound, T endBound);

    T[][] fill(int rows, int columns, T startBound, T endBound);

}
