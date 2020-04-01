package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @since 1.2
 */
//TODO write the doc's
public class FillingMatrixRandomDoubles implements FillingMatrixNumbers<Double> {

    @Override
    public void fill(Matrix<Double> matrix) {
        CheckerMatrix.checkMatrix(matrix);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomDoubles(doubles);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix) {
        CheckerMatrix.checkMatrix(matrix);
        this.fillMatrixRandomDoubles(matrix);
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixRandomDoubles(matrix);
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomDoublesFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillMatrixRandomDoublesFromZeroToBound(matrix, bound);
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixRandomDoublesFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixRandomDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillMatrixRandomDoublesFromLowerToUpperBounds(matrix, lowerBound, upperBound);
    }

    @Override
    public Double[][] fill(int rows, int columns, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[][] doubles = new Double[rows][columns];
        this.fillMatrixRandomDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillMatrixRandomDoubles(Double[][] matrix) {
        this.fillMatrixRandomDoublesFromLowerToUpperBounds(matrix, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillMatrixRandomDoublesFromZeroToBound(Double[][] matrix, double bound) {
        this.fillMatrixRandomDoublesFromLowerToUpperBounds(matrix, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillMatrixRandomDoublesFromLowerToUpperBounds(Double[][] matrix, double lowerBound, double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (Double[] doubles : matrix) {
            Arrays.setAll(doubles, j -> randomNumber.generateDouble(lowerBound, upperBound));
        }
    }

}
