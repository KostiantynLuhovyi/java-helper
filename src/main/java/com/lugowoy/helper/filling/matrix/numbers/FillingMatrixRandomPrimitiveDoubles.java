package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 26.11.2019.
 *
 * @version 1.2
 * @since 2.0
 */
//todo write doc's
public class FillingMatrixRandomPrimitiveDoubles implements Filling<MatrixDoubles> {

    @Override
    public void fill(MatrixDoubles matrixDoubles) {
        if (CheckerMatrix.checkMatrix(matrixDoubles)) {
            double[][] doubles = new double[matrixDoubles.getRows()][matrixDoubles.getColumns()];
            this.fillMatrixRandomPrimitiveDoubles(doubles);
            matrixDoubles.setMatrix(doubles);
        }
    }

    public void fill(double[][] matrixDouble) {
        if (CheckerMatrix.checkMatrix(matrixDouble)) {
            this.fillMatrixRandomPrimitiveDoubles(matrixDouble);
        }
    }

    public double[][] fill(int rows, int columns) {
        double[][] doubles = new double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            doubles = new double[rows][columns];
            this.fillMatrixRandomPrimitiveDoubles(doubles);
        }
        return doubles;
    }

    public void fill(MatrixDoubles matrixDoubles, double bound) {
        if (CheckerMatrix.checkMatrix(matrixDoubles)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                double[][] doubles = new double[matrixDoubles.getRows()][matrixDoubles.getColumns()];
                this.fillMatrixRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
                matrixDoubles.setMatrix(doubles);
            }
        }
    }

    public void fill(double[][] matrixDouble, double bound) {
        if (CheckerMatrix.checkMatrix(matrixDouble)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                this.fillMatrixRandomPrimitiveDoublesFromZeroToBound(matrixDouble, bound);
            }
        }
    }

    public double[][] fill(int rows, int columns, double bound) {
        double[][] doubles = new double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                doubles = new double[rows][columns];
                this.fillMatrixRandomPrimitiveDoublesFromZeroToBound(doubles, bound);
            }
        }
        return doubles;
    }

    public void fill(MatrixDoubles matrixDoubles, double lowerBound, double upperBound) {
        if (CheckerMatrix.checkMatrix(matrixDoubles)) {
            double[][] doubles = new double[matrixDoubles.getRows()][matrixDoubles.getColumns()];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomPrimitiveDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    matrixDoubles.setMatrix(doubles);
                }
            }
        }
    }

    public void fill(double[][] matrixDouble, double lowerBound, double upperBound) {
        if (CheckerMatrix.checkMatrix(matrixDouble)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomPrimitiveDoublesFromLowerBoundToUpperBound(matrixDouble, lowerBound, upperBound);
                }
            }
        }
    }

    public double[][] fill(int rows, int columns, double lowerBound, double upperBound) {
        double[][] doubles = new double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    doubles = new double[rows][columns];
                    this.fillMatrixRandomPrimitiveDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillMatrixRandomPrimitiveDoubles(double[][] matrix) {
        for (double[] doubles : matrix) {
            Arrays.parallelSetAll(doubles, j -> GeneratorRandomNumber.generateDouble());
        }
    }

    private void fillMatrixRandomPrimitiveDoublesFromZeroToBound(double[][] matrix, double bound) {
        for (double[] doubles : matrix) {
            Arrays.parallelSetAll(doubles, j -> GeneratorRandomNumber.generateDouble(bound));
        }
    }

    private void fillMatrixRandomPrimitiveDoublesFromLowerBoundToUpperBound(double[][] matrix, double lowerBound, double upperBound) {
        for (double[] doubles : matrix) {
            Arrays.parallelSetAll(doubles, j -> GeneratorRandomNumber.generateDouble(lowerBound, upperBound));
        }
    }

}
