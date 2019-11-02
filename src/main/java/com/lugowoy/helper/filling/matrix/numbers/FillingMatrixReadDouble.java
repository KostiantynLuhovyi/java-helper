package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.ValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.DOUBLE_ZERO;
import static com.lugowoy.helper.utils.checking.CheckerBound.isCorrectBounds;
import static com.lugowoy.helper.utils.checking.CheckerBound.isLowerBoundLessOrEqualThanUpperBound;
import static com.lugowoy.helper.utils.checking.CheckerMatrix.*;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.2
 */
//todo write doc's
public class FillingMatrixReadDouble extends FillingMatrixReadValues<Double> implements FillingMatrixNumbers<Double> {

    public FillingMatrixReadDouble(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadDouble(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Double> matrix) {
        if (checkMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsEnteredDoubleNumbers(doubles);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix) {
        if (checkMatrix(matrix)) {
            this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        Double[][] matrix = new Double[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            matrix = new Double[rows][columns];
            this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixReadDoublesFromZeroToBound(doubles, bound);
                matrix.setMatrix(doubles);
            }
        }
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                this.fillMatrixReadDoublesFromZeroToBound(matrix, bound);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        Double[][] matrix = new Double[0][0];
        if (checkRows(rows) && checkRows(columns)) {
            if (isCorrectBounds(bound, Integer.MAX_VALUE)) {
                matrix = new Double[rows][columns];
                this.fillMatrixReadDoublesFromZeroToBound(matrix, bound);
            }
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double lowerBound, Double upperBound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    matrix.setMatrix(doubles);
                }
            }
        }
    }

    @Override
    public void fill(Double[][] matrix, Double lowerBound, Double upperBound) {
        if (checkMatrix(matrix)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
                }
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double lowerBound, Double upperBound) {
        Double[][] doubles = new Double[0][0];
        if (checkRows(rows) && checkColumns(columns)) {
            if (isCorrectBounds(lowerBound) && isCorrectBounds(upperBound)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    doubles = new Double[rows][columns];
                    this.fillMatrixReadIntegersFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillMatrixElementsEnteredDoubleNumbers(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, Integer.MIN_VALUE, Integer.MAX_VALUE, i, j);
            }
        }
    }

    private void fillMatrixReadDoublesFromZeroToBound(Double[][] matrix, double bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, DOUBLE_ZERO, bound, i, j);
            }
        }
    }

    private void fillMatrixReadIntegersFromLowerBoundToUpperBound(Double[][] matrix, double lowerBound, double upperBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, lowerBound, upperBound, i, j);
            }
        }
    }

    private void assignReadValue(Double[][] matrix, double lowerBound, double upperBound, int i, int j) {
        double valueRead = super.getReader().readDouble();
        if (isCorrectReadValue(valueRead, lowerBound, upperBound)) {
            matrix[i][j] = valueRead;
        } else {
            String msgEx = "Value read is not a double number or is out of range (from " + lowerBound + " to " + upperBound + ").";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

    private boolean isCorrectReadValue(double valueRead, double lowerBound, double upperBound) {
        return (valueRead >= lowerBound) && (valueRead <= upperBound);
    }

}
