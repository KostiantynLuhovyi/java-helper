package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.2
 */
//TODO write the doc's
public class FillingMatrixRandomIntegers implements FillingMatrixNumbers<Integer> {

    @Override
    public void fill(Matrix<Integer> matrix) {
        CheckerMatrix.checkMatrix(matrix);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomIntegers(integers);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix) {
        CheckerMatrix.checkMatrix(matrix);
        this.fillMatrixRandomIntegers(matrix);
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        Integer[][] matrix = new Integer[rows][columns];
        this.fillMatrixRandomIntegers(matrix);
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomIntegersFromZeroToBound(integers, bound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillMatrixRandomIntegersFromZeroToBound(matrix, bound);
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[][] matrix = new Integer[rows][columns];
        this.fillMatrixRandomIntegersFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixRandomIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillMatrixRandomIntegers(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            Arrays.setAll(integers, j -> GeneratorRandomNumber.generateInt());
        }
    }

    private void fillMatrixRandomIntegersFromZeroToBound(Integer[][] matrix, int bound) {
        for (Integer[] integers : matrix) {
            Arrays.setAll(integers, j -> GeneratorRandomNumber.generateInt(bound));
        }
    }

    private void fillMatrixRandomIntegersFromLowerBoundToUpperBound(Integer[][] matrix, int lowerBound, int upperBound) {
        for (Integer[] integers : matrix) {
            Arrays.setAll(integers, j -> GeneratorRandomNumber.generateInt(lowerBound, upperBound));
        }
    }

}
