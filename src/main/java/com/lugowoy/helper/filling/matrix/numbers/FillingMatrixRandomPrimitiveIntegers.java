package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.models.matrices.MatrixInts;
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
public class FillingMatrixRandomPrimitiveIntegers
        implements Filling<MatrixInts> {

    @Override
    public void fill(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        int[][] integers = new int[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(integers);
        matrix.setMatrix(integers);
    }

    public void fill(@NotNull final int[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    public int[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        int[][] ints = new int[rows][columns];
        this.fillMatrix(ints);
        return ints;
    }

    public void fill(@NotNull final MatrixInts matrix, final int bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[][] integers = new int[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(integers, bound);
        matrix.setMatrix(integers);
    }

    public void fill(@NotNull final int[][] matrix, final int bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    public int[][] fill(final int rows, final int columns, final int bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[][] ints = new int[rows][columns];
        this.fillMatrixFromZeroToBound(ints, bound);
        return ints;
    }

    public void fill(@NotNull final MatrixInts matrix, final int lowerBound,
                     final int upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[][] ints = new int[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(ints, lowerBound, upperBound);
        matrix.setMatrix(ints);
    }

    public void fill(@NotNull final int[][] matrix, final int lowerBound,
                     final int upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    public int[][] fill(final int rows, final int columns, final int lowerBound,
                        final int upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[][] ints = new int[rows][columns];
        this.fillMatrixFromLowerToUpper(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillMatrix(final int[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final int[][] matrix,
                                           final int bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.intValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final int[][] matrix,
                                            final int lowerBound,
                                            final int upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (int[] integers : matrix) {
            // @formatter:off
            Arrays.setAll(integers, j -> randomNumber.generateInt(lowerBound,
                                                                  upperBound));
            // @formatter:on
        }
    }

}
