package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.ValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;
import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerMatrix.*;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.0
 */
//todo write doc's
public class FillingMatrixReadInteger extends FillingMatrixReadValues<Integer> implements FillingMatrixNumbers<Integer> {

    public FillingMatrixReadInteger(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadInteger(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Integer> matrix) {
        if (checkMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixReadIntegers(integers);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix) {
        if (checkMatrix(matrix)) {
            this.fillMatrixReadIntegers(matrix);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        Integer[][] integers = new Integer[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            integers = new Integer[rows][columns];
            this.fillMatrixReadIntegers(integers);
        }
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixReadIntegersFromZeroToBound(integers, bound);
                matrix.setMatrix(integers);
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillMatrixReadIntegersFromZeroToBound(matrix, bound);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        Integer[][] integers = new Integer[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                integers = new Integer[rows][columns];
                this.fillMatrixReadIntegersFromZeroToBound(integers, bound);
            }
        }
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer lowerBound, Integer upperBound) {
        if (checkMatrix(matrix)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
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
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
                }
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer lowerBound, Integer upperBound) {
        Integer[][] integers = new Integer[0][0];
        if (checkRows(rows) && checkRows(columns)) {
            if (isCorrectBounds(lowerBound) & isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    integers = new Integer[rows][columns];
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                }
            }
        }
        return integers;
    }

    private void fillMatrixReadIntegers(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = super.getReader().readInt();
            }
        }
    }

    private void fillMatrixReadIntegersFromZeroToBound(Integer[][] matrix, int bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, INT_ZERO, bound, i, j);
            }
        }
    }

    private void fillMatrixReadIntegersFromLowerBoundToUpperBound(Integer[][] matrix, int lowerBound, int upperBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, lowerBound, upperBound, i, j);
            }
        }
    }

    private void assignReadValue(Integer[][] matrix, int lowerBound, int upperBound, int i, int j) {
        int valueRead = super.getReader().readInt();
        if (isCorrectReadValue(valueRead, lowerBound, upperBound)) {
            matrix[i][j] = valueRead;
        } else {
            String msgEx = "Value read is not a double number or is out of range (from " + lowerBound + " to " + upperBound + ").";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

    private boolean isCorrectReadValue(int valueRead, int lowerBound, int upperBound) {
        return (valueRead >= lowerBound) && (valueRead <= upperBound);
    }

}
