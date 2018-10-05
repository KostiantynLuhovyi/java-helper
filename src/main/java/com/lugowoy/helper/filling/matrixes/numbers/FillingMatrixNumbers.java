package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.filling.matrixes.FillingMatrix;
import com.lugowoy.helper.models.matrixes.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
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
