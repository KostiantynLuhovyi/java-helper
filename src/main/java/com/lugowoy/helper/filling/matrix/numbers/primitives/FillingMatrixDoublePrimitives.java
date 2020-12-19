package com.lugowoy.helper.filling.matrix.numbers.primitives;

import com.lugowoy.helper.models.matrices.MatrixDoubles;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 19.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.6
 */
//TODO write documentation
public interface FillingMatrixDoublePrimitives {

    void fill(@NotNull MatrixDoubles matrix);

    void fill(@NotNull double[][] matrix);

    double[][] fill(int rows, int columns);

    void fill(@NotNull MatrixDoubles matrix, double bound);

    void fill(@NotNull double[][] matrix, double bound);

    double[][] fill(int rows, int columns, double bound);

    void fill(@NotNull MatrixDoubles matrix, double lowerBound,
              double upperBound);

    void fill(@NotNull double[][] matrix, double lowerBound, double upperBound);

    double[][] fill(int rows, int columns, double lowerBound,
                    double upperBound);

}
