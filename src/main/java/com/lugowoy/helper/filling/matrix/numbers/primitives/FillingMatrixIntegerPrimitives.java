package com.lugowoy.helper.filling.matrix.numbers.primitives;

import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 19.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.6
 */
//TODO write documentation
public interface FillingMatrixIntegerPrimitives {

    void fill(@NotNull MatrixInts matrix);

    void fill(@NotNull int[][] matrix);

    int[][] fill(int rows, int columns);

    void fill(@NotNull MatrixInts matrix, int bound);

    void fill(@NotNull int[][] matrix, int bound);

    int[][] fill(int rows, int columns, int bound);

    void fill(@NotNull MatrixInts matrix, int lowerBound,
              int upperBound);

    void fill(@NotNull int[][] matrix, int lowerBound,
              int upperBound);

    int[][] fill(int rows, int columns, int lowerBound,
                 int upperBound);
    
}
