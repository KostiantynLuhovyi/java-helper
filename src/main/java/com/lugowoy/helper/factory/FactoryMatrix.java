package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.matrixes.CreatingMatrix;
import com.lugowoy.helper.models.matrixes.Matrix;

/**
 * Created by Konstantin Lugowoy on 04.10.2018.
 */
//todo add doc's
public class FactoryMatrix<T> extends Factory<Matrix<T>> {

    public FactoryMatrix(CreatingMatrix<T> creating) {
        super(creating);
    }

    public Matrix<T> create(int rows, int column) {
        return ((CreatingMatrix<T>) super.getCreating()).create(rows, column);
    }

    public Matrix<T> create(T[][] matrix) {
        return ((CreatingMatrix<T>) super.getCreating()).create(matrix);
    }

    public static <T> FactoryMatrix<T> getFactoryMatrix(CreatingMatrix<T> creatingMatrix) {
        return new FactoryMatrix<>(creatingMatrix);
    }

}
