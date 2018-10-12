package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.filling.matrixes.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.DEFAULT_START_BOUND;
import static com.lugowoy.helper.filling.matrixes.CheckerFillingMatrix.*;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 */
//todo add doc's
public class FillingMatrixReadIntegerNumbers extends FillingMatrixReadValues<Integer> implements FillingMatrixNumbers<Integer> {

    public FillingMatrixReadIntegerNumbers(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadIntegerNumbers(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Integer> matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsEnteredIntegerNumbers(integers);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            this.fillMatrixElementsEnteredIntegerNumbers(matrix);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        Integer[][] integers;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            integers = new Integer[rows][columns];
            this.fillMatrixElementsEnteredIntegerNumbers(integers);
        } else {
            integers = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsEnteredIntegerNumbers(integers);
        }
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isPositiveBoundValueAndNonNull(bound) && isCorrectRangeBoundValue(bound)) {
                Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
                matrix.setMatrix(integers);
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isPositiveBoundValueAndNonNull(bound) && isCorrectRangeBoundValue(bound)) {
                this.fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(matrix, bound);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        Integer[][] integers;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            integers = new Integer[rows][columns];
            if (isPositiveBoundValueAndNonNull(bound) && isCorrectRangeBoundValue(bound)) {
                this.fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, Integer.MAX_VALUE);
            }
        } else {
            integers = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, Integer.MAX_VALUE);
        }
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound)) {
                if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                    Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
                    this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
                    matrix.setMatrix(integers);
                }
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound)) {
                if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                    this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
                }
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer startBound, Integer endBound) {
        Integer[][] integers;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            integers = new Integer[rows][columns];
            if ((isCorrectRangeBoundValue(startBound) & isCorrectRangeBoundValue(endBound))
                    && isStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } else {
            integers = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return integers;
    }

    private void fillMatrixElementsEnteredIntegerNumbers(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = super.getReader().readInt();
            }
        }
    }

    private void fillMatrixElementsEnteredIntegerNumbersFromZeroToPositiveBound(Integer[][] matrix, int bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.enterValueToAssign(matrix, DEFAULT_START_BOUND, bound, i, j);
            }
        }
    }

    private void fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(Integer[][] matrix, int startBound, int endBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.enterValueToAssign(matrix, startBound, endBound, i, j);
            }
        }
    }

    private void enterValueToAssign(Integer[][] matrix, int startBound, int endBound, int i, int j) {
        while (true) {
            int value = super.getReader().readInt();
            if (isCorrectEnteredValue(startBound, endBound, value)) {
                matrix[i][j] = value;
                break;
            } else {
                System.out.println("Incorrect entered value. Re-enter : ");
            }
        }
    }

    private boolean isCorrectEnteredValue(int startBound, int endBound, int value) {
        return (value >= startBound) && (value <= endBound);
    }

}
