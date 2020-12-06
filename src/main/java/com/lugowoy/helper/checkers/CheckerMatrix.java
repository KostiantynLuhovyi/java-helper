package com.lugowoy.helper.checkers;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.MatrixColumnOutOfRangeException;
import com.lugowoy.helper.utils.MatrixRowOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class is provides functionality for checking various types of matrices
 * and its attributes.
 * <p>
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @since 2.0
 */
//TODO review documentation
public final class CheckerMatrix {

    private static final String MSG_MATRIX_IS_NULL = "Matrix is null";

    private CheckerMatrix() {
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * rows and columns in range. Valid values range for matrix rows from {@link
     * Capacity#LOWER}(inclusive) to {@link Capacity#UPPER} (inclusive). Valid
     * values range for matrix columns from {@link Capacity#LOWER}(inclusive) to
     * {@link Capacity#UPPER}(inclusive). But for verification, the parameters
     * {@code upperBoundRows} and {@code upperBoundColumns} used as the upper
     * boundary values ​​for the rows and columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     * @throws NullPointerException if the {@code matrix} is {@code null}.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}
     * value.
     * @throws MatrixRowOutOfRangeException if the rows value of the matrix out
     * of range from {@link Capacity#LOWER} to {@code upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns value of the
     * matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundColumns}.
     */
    public static void check(@NotNull final AbstractMatrix matrix,
                             final int upperBoundRows,
                             final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerMatrix.checkUpperMatrixBoundsInRange(upperBoundRows,
                                                    upperBoundColumns);
        int matrixRows = matrix.getRows();
        int matrixColumns = matrix.getColumns();
        if (matrixRows < Capacity.LOWER.get() || matrixRows > upperBoundRows) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range from " + Capacity.LOWER.get()
                    + " to " + upperBoundRows);
        }
        if (matrixColumns < Capacity.LOWER.get()
                || matrixColumns > upperBoundColumns) {
            throw new MatrixColumnOutOfRangeException(
                    "Matrix columns out of range from " + Capacity.LOWER.get()
                    + " to " + upperBoundColumns);
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link Capacity#LOWER}(inclusive) to {@link
     * Capacity#UPPER}(inclusive). Valid values range for matrix columns from
     * {@link Capacity#LOWER}(inclusive) to {@link Capacity#UPPER}(inclusive).
     * But for verification, the parameters {@code upperBoundRows} and {@code
     * upperBoundColumns} used as the upper boundary values ​​for the rows and
     * columns of the matrix, respectively.
     *
     * @param <T> the type of the matrix.
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}
     * value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundColumns}.
     */
    public static <T> void check(@NotNull final T[][] matrix,
                                 final int upperBoundRows,
                                 final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerMatrix.checkUpperMatrixBoundsInRange(upperBoundRows,
                                                    upperBoundColumns);
        int matrixRows = matrix.length;
        if (matrixRows > upperBoundRows) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range from " + Capacity.LOWER.get()
                    + " to " + upperBoundRows);
        }
        for (final T[] tArr : matrix) {
            int matrixColumns = tArr.length;
            if (matrixColumns > upperBoundColumns) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range from " + Capacity.LOWER
                                .get() + " to " + upperBoundColumns);
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link Capacity#LOWER}(inclusive) to {@link
     * Capacity#UPPER}(inclusive). Valid values range for matrix columns from
     * {@link Capacity#LOWER}(inclusive) to {@link Capacity#UPPER}(inclusive).
     * But for verification, the parameters {@code upperBoundRows} and {@code
     * upperBoundColumns} used as the upper boundary values ​​for the rows and
     * columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}
     * value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundColumns}.
     */
    public static void check(@NotNull final int[][] matrix,
                             final int upperBoundRows,
                             final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerMatrix.checkUpperMatrixBoundsInRange(upperBoundRows,
                                                    upperBoundColumns);
        int matrixRows = matrix.length;
        if (matrixRows > Capacity.LOWER.get()) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range from " + Capacity.LOWER.get()
                    + " to " + upperBoundRows);
        }
        for (final int[] ints : matrix) {
            int matrixColumns = ints.length;
            if (matrixColumns > Capacity.UPPER.get()) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range from " + Capacity.LOWER
                                .get() + " to " + upperBoundColumns);
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link Capacity#LOWER}(inclusive) to {@link
     * Capacity#UPPER}(inclusive). Valid values range for matrix columns from
     * {@link Capacity#LOWER}(inclusive) to {@link Capacity#UPPER}(inclusive).
     * But for verification, the parameters {@code upperBoundRows} and {@code
     * upperBoundColumns} used as the upper boundary values ​​for the rows and
     * columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link Capacity#LOWER} to {@link Capacity#UPPER}
     * value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link Capacity#LOWER} to {@code
     * upperBoundColumns}.
     */
    public static void check(@NotNull final double[][] matrix,
                             final int upperBoundRows,
                             final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerMatrix.checkUpperMatrixBoundsInRange(upperBoundRows,
                                                    upperBoundColumns);
        int matrixRows = matrix.length;
        if (matrixRows > Capacity.UPPER.get()) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range from " + Capacity.LOWER.get()
                    + " to " + upperBoundRows);
        }
        for (final double[] doubles : matrix) {
            int matrixColumns = doubles.length;
            if (matrixColumns > Capacity.UPPER.get()) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range from " + Capacity.LOWER
                                .get() + " to " + upperBoundColumns);
            }
        }
    }

    /**
     * Checks the {@code rows} value in range from {@code
     * lowerBoundRows}(inclusive) to {@code upperBoundRows}(inclusive).
     *
     * @param rows the rows value of the matrix to check.
     * @param lowerBoundRows the lower bound value of rows of the matrix to
     * check.
     * @param upperBoundRows the upper bound value of rows of the matrix to
     * check.
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundsComparisonException if the {@code lowerBoundRows} value
     * greater or not equal than the {@code upperBoundRows} value.
     * @throws MatrixRowOutOfRangeException the {@code rows} value out of the
     * range.
     */
    public static void checkRows(final int rows, final int lowerBoundRows,
                                 final int upperBoundRows) {
        CheckerMatrix.checkBounds(lowerBoundRows, upperBoundRows);
        if (rows < lowerBoundRows || rows > upperBoundRows) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range from " + lowerBoundRows + " to "
                    + upperBoundRows);
        }
    }

    /**
     * Checks the {@code columns} value in range from {@code
     * lowerBoundColumns}(inclusive) to {@code upperBoundColumns}(inclusive).
     *
     * @param columns the columns value of the matrix to check.
     * @param lowerBoundColumns the lower bound value of columns of the matrix
     * to check.
     * @param upperBoundColumns the upper bound value of columns of the matrix
     * to check.
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link Capacity#LOWER} to {@link Capacity#UPPER} value.
     * @throws BoundsComparisonException if the {@code lowerBoundColumns} value
     * greater or not equal than the {@code upperBoundColumns} value.
     * @throws MatrixColumnOutOfRangeException the {@code columns} value out of
     * the range.
     */
    public static void checkColumns(final int columns,
                                    final int lowerBoundColumns,
                                    final int upperBoundColumns) {
        CheckerMatrix.checkBounds(lowerBoundColumns, upperBoundColumns);
        if (columns < lowerBoundColumns || columns > upperBoundColumns) {
            throw new MatrixColumnOutOfRangeException(
                    "Matrix columns out of range from " + lowerBoundColumns
                    + " to " + upperBoundColumns);
        }
    }

    private static void checkUpperMatrixBoundsInRange(final int upperRows,
                                                      final int upperColumns) {
        CheckerBoundNumber.checkInRange(upperRows, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(upperColumns, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
    }

    private static void checkBounds(final int lowerBound,
                                    final int upperBound) {
        CheckerBoundNumber.checkInRange(lowerBound, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(upperBound, Capacity.LOWER.get(),
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrNotEqualUpper(lowerBound,
                                                         upperBound);
    }

}
