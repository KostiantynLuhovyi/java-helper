package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.matrixes.CheckerFillingMatrix.*;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public class FillingMatrixRandomDoubleNumbers implements FillingMatrixNumbers<Double> {

    @Override
    public void fill(Matrix<Double> matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomDoubleNumbers(doubles);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            this.fillMatrixElementsRandomDoubleNumbers(matrix);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        Double[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Double[rows][columns];
            this.fillMatrixElementsRandomDoubleNumbers(matrix);
        } else {
            matrix = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomDoubleNumbers(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, POSITIVE_DOUBLE_BOUND);
            }
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, POSITIVE_DOUBLE_BOUND);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        Double[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Double[rows][columns];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            matrix = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, POSITIVE_DOUBLE_BOUND);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double startBound, Double endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix, Double startBound, Double endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(matrix, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double startBound, Double endBound) {
        Double[][] doubles;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            doubles = new Double[rows][columns];
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, NEGATIVE_DOUBLE_BOUND, POSITIVE_DOUBLE_BOUND);
        }
        return doubles;
    }

    private void fillMatrixElementsRandomDoubleNumbers(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateDouble();
            }
        }
    }

    private void fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(Double[][] matrix, double bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateDouble(bound);
            }
        }
    }

    private void fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(Double[][] matrix, double startBound, double endBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateDouble(startBound, endBound);
            }
        }
    }

}
