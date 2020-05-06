package com.lugowoy.helper.checkers;

import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.MatrixColumnOutOfRangeException;
import com.lugowoy.helper.models.matrices.MatrixRowOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The class is provides functionality for checking various types of matrices
 * and its attributes.
 * <p>
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 2.0
 */
public final class CheckerMatrix {

    /**
     * The lower value of the rows in the matrix.
     */
    public static final int LOWER_ROWS_VALUE = 0;
    /**
     * The lower value of the columns in the matrix.
     */
    public static final int LOWER_COLUMNS_VALUE = 0;

    private static final int ARRAY_HEADER = 8;

    /**
     * The upper value of the rows in the matrix.
     */
    public static final int UPPER_ROWS_VALUE = Integer.MAX_VALUE - ARRAY_HEADER;
    /**
     * The upper value of the columns in the matrix.
     */
    public static final int UPPER_COLUMNS_VALUE =
            Integer.MAX_VALUE - ARRAY_HEADER;

    private static final String MSG_MATRIX_IS_NULL = "Matrix is null.";

    private CheckerMatrix() {
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * rows and columns in range. Valid values range for matrix rows from {@link
     * CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     * Valid values range for matrix columns from {@link
     * CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     * But for verification, the parameters {@code upperBoundRows} and {@code
     * upperBoundColumns} used as the upper boundary values ​​for the rows and
     * columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE} value.
     * @throws MatrixRowOutOfRangeException if the rows value of the matrix out
     * of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns value of the
     * matrix out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to
     * {@code upperBoundColumns}.
     */
    public static void check(@NotNull final AbstractMatrix matrix,
                             final int upperBoundRows,
                             final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        int matrixRows = matrix.getRows();
        int matrixColumns = matrix.getColumns();
        if (matrixRows < LOWER_ROWS_VALUE || matrixRows > upperBoundRows) {
            if (matrixColumns < LOWER_COLUMNS_VALUE
                    || matrixColumns > upperBoundColumns) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range (" + LOWER_COLUMNS_VALUE
                                + " - " + upperBoundColumns + ").");
            }
        } else {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range (" + LOWER_ROWS_VALUE + " - "
                            + upperBoundRows + ").");
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE}. Valid values range for matrix columns
     * from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE}. But for verification, the parameters
     * {@code upperBoundRows} and {@code upperBoundColumns} used as the upper
     * boundary values ​​for the rows and columns of the matrix, respectively.
     *
     * @param <T> the type of the matrix.
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE} value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to
     * {@code upperBoundColumns}.
     */
    public static <T> void check(@NotNull final T[][] matrix,
                                 final int upperBoundRows,
                                 final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        int matrixRows = matrix.length;
        if (matrixRows > upperBoundRows) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range (" + LOWER_ROWS_VALUE + " - "
                            + upperBoundRows + ").");
        }
        for (final T[] tArr : matrix) {
            int matrixColumns = tArr.length;
            if (matrixColumns > upperBoundColumns) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range (" + LOWER_COLUMNS_VALUE
                                + " - " + upperBoundColumns + ").");
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE}. Valid values range for matrix columns
     * from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE}. But for verification, the parameters
     * {@code upperBoundRows} and {@code upperBoundColumns} used as the upper
     * boundary values ​​for the rows and columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE} value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to
     * {@code upperBoundColumns}.
     */
    public static void checkMatrix(@NotNull final int[][] matrix,
                                   final int upperBoundRows,
                                   final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        int matrixRows = matrix.length;
        if (matrixRows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range (" + LOWER_ROWS_VALUE + " - "
                            + upperBoundRows + ").");
        }
        for (final int[] ints : matrix) {
            int matrixColumns = ints.length;
            if (matrixColumns > UPPER_COLUMNS_VALUE) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range (" + LOWER_COLUMNS_VALUE
                                + " - " + upperBoundColumns + ").");
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes
     * length(size) ("rows" and "columns") in range. Valid values range for
     * matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE}. Valid values range for matrix columns
     * from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE}. But for verification, the parameters
     * {@code upperBoundRows} and {@code upperBoundColumns} used as the upper
     * boundary values ​​for the rows and columns of the matrix, respectively.
     *
     * @param matrix the {@code matrix} to check.
     * @param upperBoundRows the upper bound value of rows of the matrix.
     * @param upperBoundColumns the upper bound value of columns of the matrix.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws BoundOutOfRangeException if the {@code upperBoundRows} value out
     * of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE} value.
     * @throws BoundOutOfRangeException if the {@code upperBoundColumns} value
     * out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE} value.
     * @throws MatrixRowOutOfRangeException if the rows(length) value of the
     * matrix out of range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@code
     * upperBoundRows}.
     * @throws MatrixColumnOutOfRangeException if the columns(length) value of
     * the matrix out of range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to
     * {@code upperBoundColumns}.
     */
    public static void checkMatrix(@NotNull final double[][] matrix,
                                   final int upperBoundRows,
                                   final int upperBoundColumns) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        CheckerBoundNumber.checkInRange(upperBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        int matrixRows = matrix.length;
        if (matrixRows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range (" + LOWER_ROWS_VALUE + " - "
                            + upperBoundRows + ").");
        }
        for (final double[] doubles : matrix) {
            int matrixColumns = doubles.length;
            if (matrixColumns > UPPER_COLUMNS_VALUE) {
                throw new MatrixColumnOutOfRangeException(
                        "Matrix columns out of range (" + LOWER_COLUMNS_VALUE
                                + " - " + upperBoundColumns + ").");
            }
        }
    }

    /**
     * Checks the {@code rows} value in range from {@code lowerBoundRows} to
     * {@code upperBoundRows}.
     *
     * @param rows the rows value of the matrix to check.
     * @param lowerBoundRows the lower bound value of rows of the matrix to
     * check.
     * @param upperBoundRows the upper bound value of rows of the matrix to
     * check.
     *
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link
     * CheckerMatrix#UPPER_ROWS_VALUE} value.
     * @throws BoundsComparisonException if the {@code lowerBoundRows} value
     * greater or not equal than the {@code upperBoundRows} value.
     * @throws MatrixRowOutOfRangeException the {@code rows} value out of the
     * range.
     */
    public static void checkRows(final int rows, final int lowerBoundRows,
                                 final int upperBoundRows) {
        CheckerBoundNumber.checkInRange(lowerBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundRows, LOWER_ROWS_VALUE,
                                        UPPER_ROWS_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundRows,
                                                      upperBoundRows);
        if (rows < lowerBoundRows || rows > upperBoundRows) {
            throw new MatrixRowOutOfRangeException(
                    "Matrix rows out of range (" + lowerBoundRows + " - "
                            + upperBoundRows + ").");
        }
    }

    /**
     * Checks the {@code columns} value in range from {@code lowerBoundColumns}
     * to {@code upperBoundColumns}.
     *
     * @param columns the columns value of the matrix to check.
     * @param lowerBoundColumns the lower bound value of columns of the matrix
     * to check.
     * @param upperBoundColumns the upper bound value of columns of the matrix
     * to check.
     *
     * @throws BoundOutOfRangeException if the any of boundary values out of
     * range from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link
     * CheckerMatrix#UPPER_COLUMNS_VALUE} value.
     * @throws BoundsComparisonException if the {@code lowerBoundColumns} value
     * greater or not equal than the {@code upperBoundColumns} value.
     * @throws MatrixColumnOutOfRangeException the {@code columns} value out of
     * the range.
     */
    public static void checkColumns(final int columns,
                                    final int lowerBoundColumns,
                                    final int upperBoundColumns) {
        CheckerBoundNumber.checkInRange(lowerBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        CheckerBoundNumber.checkInRange(upperBoundColumns, LOWER_COLUMNS_VALUE,
                                        UPPER_COLUMNS_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBoundColumns,
                                                      upperBoundColumns);
        if (columns < lowerBoundColumns || columns > upperBoundColumns) {
            throw new MatrixColumnOutOfRangeException(
                    "Matrix columns out of range (" + lowerBoundColumns + " - "
                            + upperBoundColumns + ").");
        }
    }

}
