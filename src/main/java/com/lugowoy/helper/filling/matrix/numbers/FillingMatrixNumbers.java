package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrix;
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
public interface FillingMatrixNumbers<T extends Number>
        extends FillingMatrix<T> {

    void fill(@NotNull Matrix<T> matrix, @NotNull T bound);

    void fill(@NotNull T[][] matrix, @NotNull T bound);

    T[][] fill(int rows, int columns, @NotNull T bound);

    void fill(@NotNull Matrix<T> matrix, @NotNull T lowerBound,
              @NotNull T upperBound);

    void fill(@NotNull T[][] matrix, @NotNull T lowerBound,
              @NotNull T upperBound);

    T[][] fill(int rows, int columns, @NotNull T lowerBound,
               @NotNull T upperBound);

}
