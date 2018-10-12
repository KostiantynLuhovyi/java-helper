package com.lugowoy.helper.filling.matrixes.numbers;

import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public class FillingMatrixRandomIntegerNumbers implements FillingMatrixNumbers<Integer> {

    @Override
    public void fill(Matrix<Integer> matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        //todo add relevant checks.
        if (matrix != null) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomIntegerNumbers(integers);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix) {
        //todo add a "else" code block, use an exception or leave it like this.
        //todo add relevant checks.
        if (matrix != null) {
            this.fillMatrixElementsRandomIntegerNumbers(matrix);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        //todo add relevant checks.
        Integer[][] matrix;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
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
        //todo add relevant checks.
        if (matrix != null && (bound >= 0 && bound < Integer.MAX_VALUE)) {
            Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(integers, bound);
            matrix.setMatrix(integers);
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        //todo add a "else" code block, use an exception or leave it like this.
        //todo add relevant checks.
        if (matrix != null && (bound >= 0 && bound < Integer.MAX_VALUE)) {
            this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, bound);
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        //todo add relevant checks.
        Integer[][] matrix;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
            matrix = new Integer[rows][columns];
            this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, bound);
        } else {
            matrix = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomIntegerNumbersFromZeroToPositiveBound(matrix, bound);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        //todo add relevant checks.
        if (matrix != null && ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE))) {
            if (startBound < endBound) {
                Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
                matrix.setMatrix(integers);
            }
        }
    }

    @Override
    public void fill(Integer[][] matrix, Integer startBound, Integer endBound) {
        //todo add a "else" code block, use an exception or leave it like this.
        //todo add relevant checks.
        if (matrix != null && ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE))) {
            if (startBound < endBound) {
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(matrix, startBound, endBound);
            }
        }
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer startBound, Integer endBound) {
        //todo add relevant checks.
        Integer[][] integers = null;
        if ((rows >= 0 && rows < Integer.MAX_VALUE) && (columns >= 0 && columns < Integer.MAX_VALUE)) {
            if ((startBound >= 0 && startBound < Integer.MAX_VALUE) && (endBound > 0 && endBound < Integer.MAX_VALUE)
                    && startBound < endBound) {
                integers = new Integer[rows][columns];
                this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            }
        } else {
            integers = new Integer[Matrix.DEFAULT_ROWS][Matrix.DEFAULT_COLUMNS];
            this.fillMatrixElementsRandomIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
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
