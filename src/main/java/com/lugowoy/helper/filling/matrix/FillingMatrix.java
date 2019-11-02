package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.2
 */
//todo edit doc's
public interface FillingMatrix<T> extends Filling<Matrix<T>> {

    @Override
    void fill(Matrix<T> matrix);

    void fill(T[][] matrix);

    T[][] fill(int rows, int columns);

}
