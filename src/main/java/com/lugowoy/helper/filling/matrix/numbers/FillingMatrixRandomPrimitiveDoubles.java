package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * <p>Created by Konstantin Lugowoy on 26.11.2019.
 *
 * @version 1.4
 * @since 2.0
 */
//TODO write documentation
public class FillingMatrixRandomPrimitiveDoubles
        implements Filling<MatrixDoubles> {

    @Override
    public void fill(@NotNull final MatrixDoubles matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(doubles);
        matrix.setMatrix(doubles);
    }

    public void fill(@NotNull final double[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    public double[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        double[][] doubles = new double[rows][columns];
        this.fillMatrix(doubles);
        return doubles;
    }

    public void fill(@NotNull final MatrixDoubles matrix, final double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    public void fill(@NotNull final double[][] matrix, final double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    public double[][] fill(final int rows, final int columns,
                           final double bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[][] doubles = new double[rows][columns];
        this.fillMatrixFromZeroToBound(doubles, bound);
        return doubles;
    }

    public void fill(@NotNull final MatrixDoubles matrix,
                     final double lowerBound, final double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    public void fill(@NotNull final double[][] matrix, final double lowerBound,
                     final double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    public double[][] fill(final int rows, final int columns,
                           final double lowerBound, final double upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[][] doubles = new double[rows][columns];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillMatrix(final double[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final double[][] matrix,
                                           final double bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.doubleValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final double[][] matrix,
                                            final double lowerBound,
                                            final double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (double[] doubles : matrix) {
            // @formatter:off
            Arrays.setAll(doubles, j -> randomNumber.generateDouble(lowerBound,
                                                                    upperBound));
            // @formatter:on
        }
    }

}
