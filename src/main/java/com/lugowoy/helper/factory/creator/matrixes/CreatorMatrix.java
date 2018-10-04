package com.lugowoy.helper.factory.creator.matrixes;

import com.lugowoy.helper.factory.creator.Creator;
import com.lugowoy.helper.models.matrixes.Matrix;

/**
 * Created by Konstantin Lugowoy on 04.10.2018.
 */
// todo add doc's
public class CreatorMatrix<T> extends Creator<Matrix<T>> implements CreatingMatrix<T> {

    @Override
    public Matrix<T> create() {
        return new Matrix<>();
    }

    @Override
    public Matrix<T> create(int rows, int column) {
        return new Matrix<>(rows, column);
    }

    @Override
    public Matrix<T> create(T[][] matrix) {
        return new Matrix<>(matrix);
    }

}
