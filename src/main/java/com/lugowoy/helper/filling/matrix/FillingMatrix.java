package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.Matrix;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.2
 */
//TODO write documentation
public interface FillingMatrix<T> extends Filling<Matrix<T>> {

    void fill(@NotNull T[][] matrix);

    T[][] fill(int rows, int columns);

}
