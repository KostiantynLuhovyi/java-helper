package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.MatrixInt;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 26.11.2019.
 */
//todo write doc's
public class FillingMatrixRandomPrimitiveIntegers implements Filling<MatrixInt> {

    @Override
    public void fill(MatrixInt matrixInt) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            int[][] integers = new int[matrixInt.getRows()][matrixInt.getColumns()];
            this.fillMatrixRandomPrimitiveInts(integers);
            matrixInt.setMatrix(integers);
        }
    }

    public void fill(int[][] matrixInt) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            this.fillMatrixRandomPrimitiveInts(matrixInt);
        }
    }

    public int[][] fill(int rows, int columns) {
        int[][] ints = new int[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            ints = new int[rows][columns];
            this.fillMatrixRandomPrimitiveInts(ints);
        }
        return ints;
    }

    public void fill(MatrixInt matrixInt, int bound) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            int[][] integers = new int[matrixInt.getRows()][matrixInt.getColumns()];
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                this.fillMatrixRandomPrimitiveIntsFromZeroToBound(integers, bound);
                matrixInt.setMatrix(integers);
            }
        }
    }

    public void fill(int[][] matrixInt, int bound) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                this.fillMatrixRandomPrimitiveIntsFromZeroToBound(matrixInt, bound);
            }
        }
    }

    public int[][] fill (int rows, int columns, int bound) {
        int[][] ints = new int[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE)) {
                ints = new int[rows][columns];
                this.fillMatrixRandomPrimitiveIntsFromZeroToBound(ints, bound);
            }
        }
        return ints;
    }

    public void fill(MatrixInt matrixInt, int lowerBound, int upperBound) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    int[][] ints = new int[matrixInt.getRows()][matrixInt.getColumns()];
                    this.fillMatrixRandomPrimitiveIntsFromLowerBoundToUpperBound(ints, lowerBound, upperBound);
                    matrixInt.setMatrix(ints);
                }
            }
        }
    }

    public void fill(int[][] matrixInt, int lowerBound, int upperBound) {
        if (CheckerMatrix.checkMatrix(matrixInt)) {
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomPrimitiveIntsFromLowerBoundToUpperBound(matrixInt, lowerBound, upperBound);
                }
            }
        }
    }

    public int[][] fill(int rows, int columns, int lowerBound, int upperBound) {
        int[][] ints = new int[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && CheckerBound.isCorrectBound(columns, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomPrimitiveIntsFromLowerBoundToUpperBound(ints, lowerBound, upperBound);
                    ints = new int[rows][columns];
                }
            }
        }
        return ints;
    }

    private void fillMatrixRandomPrimitiveInts(int[][] matrix) {
        for (int[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt());
        }
    }

    private void fillMatrixRandomPrimitiveIntsFromZeroToBound(int[][] matrix, int bound) {
        for (int[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt(bound));
        }
    }

    private void fillMatrixRandomPrimitiveIntsFromLowerBoundToUpperBound(int[][] matrix, int lowerBound, int upperBound) {
        for (int[] integers : matrix) {
            Arrays.parallelSetAll(integers, j -> GeneratorRandomNumber.generateInt(lowerBound, upperBound));
        }
    }

}
