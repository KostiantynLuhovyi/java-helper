package com.lugowoy.helper.factory.creator.matrixes;

import com.lugowoy.helper.factory.creator.Creating;
import com.lugowoy.helper.models.matrixes.Matrix;

/**
 * Created by Konstantin Lugowoy on 04.10.2018.
 */
//todo add doc's
public interface CreatingMatrix<T> extends Creating<Matrix<T>> {

    Matrix<T> create(int rows, int column);

    Matrix<T> create(T[][] matrix);

}
