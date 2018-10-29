package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.filling.matrixes.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.START_BOUND;
import static com.lugowoy.helper.filling.matrixes.CheckerFillingMatrix.*;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 */
//todo add doc's
public class FillingMatrixReadDoubleNumbers extends FillingMatrixReadValues<Double> implements FillingMatrixNumbers<Double> {

    public FillingMatrixReadDoubleNumbers(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadDoubleNumbers(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Double> matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsEnteredDoubleNumbers(doubles);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        Double[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Double[rows][columns];
            this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        } else {
            matrix = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsEnteredDoubleNumbers(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, Integer.MAX_VALUE);
            }
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(matrix, Integer.MAX_VALUE);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        Double[][] matrix;
        if (checkMatrixRows(rows) && checkMatrixColumns(columns)) {
            matrix = new Double[rows][columns];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(matrix, bound);
            } else {
                this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(matrix, Integer.MAX_VALUE);
            }
        } else {
            matrix = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(matrix, Integer.MAX_VALUE);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double startBound, Double endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(doubles, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix, Double startBound, Double endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        if (checkNonNullMatrix(matrix)) {
            if ((isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))
                                && isStartBoundValueLessThanEndBoundValue(startBound, endBound)) {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
            } else {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(matrix, Integer.MIN_VALUE, Integer.MIN_VALUE);
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
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(doubles, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } else {
            doubles = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_ROWS];
            this.fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(doubles, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return doubles;
    }

    private void fillMatrixElementsEnteredDoubleNumbers(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = super.getReader().readDouble();
            }
        }
    }

    private void fillMatrixElementsEnteredDoubleNumbersFromZeroToPositiveBound(Double[][] matrix, double bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.enterValueToAssign(matrix, START_BOUND, bound, i, j);
            }
        }
    }

    private void fillMatrixElementsEnteredIntegerNumbersFromStartBoundToEndBound(Double[][] matrix, double startBound, double endBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.enterValueToAssign(matrix, startBound, endBound, i, j);
            }
        }
    }

    private void enterValueToAssign(Double[][] matrix, double startBound, double endBound, int i, int j) {
        while (true) {
            double value = super.getReader().readDouble();
            if (isCorrectEnteredValue(startBound, endBound, value)) {
                matrix[i][j] = value;
                break;
            } else {
                System.out.println("Incorrect entered value. Re-enter : ");
            }
        }
    }

    private boolean isCorrectEnteredValue(double startBound, double endBound, double value) {
        return (value >= startBound) && (value <= endBound);
    }

}
