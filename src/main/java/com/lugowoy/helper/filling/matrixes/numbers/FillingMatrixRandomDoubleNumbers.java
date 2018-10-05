package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.models.matrixes.Matrix;
import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public class FillingMatrixRandomDoubleNumbers implements FillingMatrixNumbers<Double> {

    @Override
    public void fill(Matrix<Double> matrix) {
        if (matrix != null) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomDoubleNumbers(doubles);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix) {
        if (matrix != null) {
            this.fillMatrixElementsRandomDoubleNumbers(matrix);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        Double[][] matrix;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
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
        if (matrix != null && (bound >= 0 && bound < Integer.MAX_VALUE)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        if (matrix != null && (bound >= 0 && bound < Integer.MAX_VALUE)) {
            this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, bound);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        Double[][] matrix;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
            matrix = new Double[rows][columns];
            this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, bound);
        } else {
            matrix = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomDoubleNumbersFromZeroToPositiveBound(matrix, bound);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double startBound, Double endBound) {
        if (matrix != null && ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE))) {
            if (startBound < endBound) {
                Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
                matrix.setMatrix(doubles);
            }
        }
    }

    @Override
    public void fill(Double[][] matrix, Double startBound, Double endBound) {
        if (matrix != null && ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE))) {
            if (startBound < endBound) {
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double startBound, Double endBound) {
        Double[][] doubles = null;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
            if ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE) 
                    && startBound < endBound) {
                doubles = new Double[rows][columns];
                this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            }
        } else {
            doubles = new Double[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
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
