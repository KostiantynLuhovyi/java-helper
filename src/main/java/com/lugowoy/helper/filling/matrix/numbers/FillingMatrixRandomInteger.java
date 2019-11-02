package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerMatrix.*;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.2
 */
//todo write doc's
public class FillingMatrixRandomInteger implements FillingMatrixNumbers<Integer> {

    @Override
    public void fill(Matrix<Integer> matrix) {
        if (checkMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixRandomIntegers(integers);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix) {
        if (checkMatrix(matrix)) {
            this.fillMatrixRandomIntegers(matrix);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        Integer[][] matrix = new Integer[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            matrix = new Integer[rows][columns];
            this.fillMatrixRandomIntegers(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        if (checkMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillMatrixRandomIntegersFromZeroToBound(integers, bound);
                matrix.setMatrix(integers);
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillMatrixRandomIntegersFromZeroToBound(matrix, bound);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        Integer[][] matrix = new Integer[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                matrix = new Integer[rows][columns];
                this.fillMatrixRandomIntegersFromZeroToBound(matrix, bound);
            }
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer lowerBound, Integer upperBound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
                    this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    matrix.setMatrix(integers);
                }
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer lowerBound, Integer upperBound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
                }
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer lowerBound, Integer upperBound) {
        Integer[][] integers = new Integer[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(columns)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    integers = new Integer[rows][columns];
                }
            }
        }
        return integers;
    }

    private void fillMatrixRandomIntegers(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt());
        }
    }

    private void fillMatrixRandomIntegersFromZeroToBound(Integer[][] matrix, int bound) {
        for (Integer[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt(bound));
        }
    }

    private void fillMatrixRandomIntegersFromLowerBoundToUpperBound(Integer[][] matrix, int lowerBound, int upperBound) {
        for (Integer[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt(lowerBound, upperBound));
        }
    }

}
