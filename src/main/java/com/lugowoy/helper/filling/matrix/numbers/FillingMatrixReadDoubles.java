package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_ZERO;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.2
 */
//TODO write the doc's
public class FillingMatrixReadDoubles extends FillingMatrixReadValues<Double> implements FillingMatrixNumbers<Double> {

    public FillingMatrixReadDoubles(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadDoubles(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Double> matrix) {
        CheckerMatrix.checkMatrix(matrix);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixElementsEnteredDoubleNumbers(doubles);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix) {
        CheckerMatrix.checkMatrix(matrix);
        this.fillMatrixElementsEnteredDoubleNumbers(matrix);
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixReadDoublesFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillMatrixReadDoublesFromZeroToBound(matrix, bound);
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkRows(columns);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixReadDoublesFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(Double[][] matrix, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
    }

    @Override
    public Double[][] fill(int rows, int columns, Double lowerBound, Double upperBound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Double[][] doubles = new Double[rows][columns];
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
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

    private void fillMatrixReadIntegersFromLowerBoundToUpperBound(Double[][] matrix, double lowerBound,
                                                                  double upperBound) {
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
            String msgEx = "Value not a double number or out of range (" + lowerBound + " - " + upperBound + ").";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

    private boolean isCorrectReadValue(double valueRead, double lowerBound, double upperBound) {
        return (valueRead >= lowerBound) && (valueRead <= upperBound);
    }

}
