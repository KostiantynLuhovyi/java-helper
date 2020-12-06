package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * <p>Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 1.2
 */
//TODO write documentation
public class FillingMatrixRandomDoubles
        implements FillingMatrixNumbers<Double> {

    @Override
    public void fill(@NotNull final Matrix<Double> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(doubles);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    @Override
    public Double[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrix(matrix);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Double> matrix,
                     @NotNull final Double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix,
                     @NotNull final Double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    @Override
    public Double[][] fill(final int rows, final int columns,
                           @NotNull final Double bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Double> matrix,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    @Override
    public Double[][] fill(final int rows, final int columns,
                           @NotNull final Double lowerBound,
                           @NotNull final Double upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[][] doubles = new Double[rows][columns];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillMatrix(final Double[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final Double[][] matrix,
                                           final Double bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.doubleValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final Double[][] matrix,
                                            final Double lowerBound,
                                            final Double upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (Double[] doubles : matrix) {
            // @formatter:off
            Arrays.setAll(doubles, j -> randomNumber.generateDouble(lowerBound,
                                                                    upperBound));
            // @formatter:on
        }
    }

}
