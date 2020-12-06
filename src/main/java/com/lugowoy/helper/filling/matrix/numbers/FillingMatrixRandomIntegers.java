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
public class FillingMatrixRandomIntegers
        implements FillingMatrixNumbers<Integer> {

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(integers);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        Integer[][] matrix = new Integer[rows][columns];
        this.fillMatrix(matrix);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix,
                     @NotNull final Integer bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(integers, bound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix,
                     @NotNull final Integer bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns,
                            @NotNull final Integer bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[][] matrix = new Integer[rows][columns];
        this.fillMatrixFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(integers, lowerBound,
                                        upperBound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound,
                                        upperBound);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns,
                            @NotNull final Integer lowerBound,
                            @NotNull final Integer upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixFromLowerToUpper(integers, lowerBound,
                                        upperBound);
        return integers;
    }

    private void fillMatrix(final Integer[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final Integer[][] matrix,
                                           final Integer bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.intValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final Integer[][] matrix,
                                            final Integer lowerBound,
                                            final Integer upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (Integer[] integers : matrix) {
            // @formatter:off
            Arrays.setAll(integers, j -> randomNumber.generateInt(lowerBound,
                                                                  upperBound));
            // @formatter:on
        }
    }

}
