package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */

//todo refactoring code
//todo edit doc's

public interface FillingMatrix<T> extends Filling<Matrix<T>> {

    @Override
    void fill(Matrix<T> matrix);

    void fill(T[][] matrix);

    T[][] fill(int rows, int columns);

}
