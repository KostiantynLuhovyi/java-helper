package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.matrixes.CheckerFillingMatrix;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.matrixes.CheckerFillingMatrix.*;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public class FillingMatrixRandomIntegerNumbers implements FillingMatrixNumbers<Integer> {

    @Override
    public void fill(Matrix<Integer> matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomIntegerNumbers(integers);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            this.fillMatrixElementsRandomIntegerNumbers(matrix);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        Integer[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Integer[rows][columns];
            this.fillMatrixElementsRandomIntegerNumbers(matrix);
        } else {
            matrix = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomIntegerNumbers(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
            }
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, POSITIVE_INTEGER_BOUND);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        Integer[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Integer[rows][columns];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, POSITIVE_INTEGER_BOUND);
            }
        } else {
            matrix = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, POSITIVE_INTEGER_BOUND);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
            }
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(matrix, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer startBound, Integer endBound) {
        //todo add relevant checks.
        Integer[][] integers;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            integers = new Integer[rows][columns];
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(columns))
                                && isStartBoundValueGreatestThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND);
        }
        return integers;
    }

    private void fillMatrixElementsRandomIntegerNumbers(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateInt();
            }
        }
    }

    private void fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(Integer[][] matrix, int bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateInt(bound);
            }
        }
    }

    private void fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(Integer[][] matrix, int startBound, int endBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = GeneratorRandomNumber.generateInt(startBound, endBound);
            }
        }
    }

}
