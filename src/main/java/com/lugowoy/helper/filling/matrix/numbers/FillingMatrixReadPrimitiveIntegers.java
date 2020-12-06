package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * <p>Created by Konstantin Lugowoy on 22.11.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.matrix.FillingMatrixReadValues
 * @since 3.0
 */
//TODO write documentation
public class FillingMatrixReadPrimitiveIntegers
        extends FillingMatrixReadValues {

    public FillingMatrixReadPrimitiveIntegers(final @NotNull Reader reader) {
        super(reader);
    }

    public void fill(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        int[][] ints = new int[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(ints);
        matrix.setMatrix(ints);
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
        int[][] matrix = new int[rows][columns];
        this.fillMatrix(matrix);
        return matrix;
    }

    public void fill(@NotNull final MatrixInts matrix, final int bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[][] ints = new int[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(ints, bound);
        matrix.setMatrix(ints);
    }

    public void fill(@NotNull final int[][] matrix, final int bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    public int[][] fill(final int rows, final int columns, final int bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkRows(columns, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[][] matrix = new int[rows][columns];
        this.fillMatrixFromZeroToBound(matrix, bound);
        return matrix;
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
        int valueRead = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (super.getReader().hasNextInt()) {
                    valueRead = super.getReader().nextInt();
                    CheckerNumber.check(valueRead, lowerBound, upperBound);
                }
                matrix[i][j] = valueRead;
            }
        }
    }

}
