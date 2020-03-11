package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.utils.MatrixColumnOutOfRangeException;
import com.lugowoy.helper.utils.MatrixRowOutOfRangeException;

import java.util.Objects;

/**
 * The class contains functionality for checking various types of matrices and its attributes.
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
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
    public static final int UPPER_COLUMNS_VALUE = Integer.MAX_VALUE - ARRAY_HEADER;

    private static final String MSG_MATRIX_IS_NULL = "Matrix is null.";
    private static final String MSG_MATRIX_ROWS_IS_OUT_OF_RANGE =
            "Matrix rows out of range (" + LOWER_ROWS_VALUE + " - " + UPPER_ROWS_VALUE + ").";
    private static final String MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE =
            "Matrix columns out of range (" + LOWER_COLUMNS_VALUE + " - " + UPPER_COLUMNS_VALUE + ").";

    private CheckerMatrix() {
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes rows and columns in range.
     * Valid values range for matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     * Valid values range for matrix columns from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     *
     * @param matrix the {@code matrix} to check.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws MatrixRowOutOfRangeException if the matrix rows value out of range.
     * @throws MatrixColumnOutOfRangeException if the matrix columns value out of range.
     */
    public static void checkMatrix(AbstractMatrix matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.getRows();
        int matrixColumns = matrix.getColumns();
        if (matrixRows < LOWER_ROWS_VALUE || matrixRows > UPPER_ROWS_VALUE) {
            if (matrixColumns < LOWER_COLUMNS_VALUE || matrixColumns > UPPER_COLUMNS_VALUE) {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes length(size) ("rows" and "columns") in range.
     * Valid values range for matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     * Valid values range for matrix columns from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     *
     * @param matrix the {@code matrix} to check.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws MatrixRowOutOfRangeException if the {@code matrix} rows (length) value out of range.
     * @throws MatrixColumnOutOfRangeException if the {@code matrix} columns (length) value out of range.
     */
    public static <T> void checkMatrix(T[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        if (matrixRows < LOWER_ROWS_VALUE || matrixRows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        } else {
            for (int i = 0; i < matrix.length; i++) {
                int matrixColumns = matrix[i].length;
                if (matrixColumns < LOWER_COLUMNS_VALUE || matrixColumns > UPPER_COLUMNS_VALUE) {
                    throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
                }
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes length(size) ("rows" and "columns") in range.
     * Valid values range for matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     * Valid values range for matrix columns from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     *
     * @param matrix the {@code matrix} to check.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws MatrixRowOutOfRangeException if the {@code matrix} rows (length) value out of range.
     * @throws MatrixColumnOutOfRangeException if the {@code matrix} columns (length) value out of range.
     */
    public static void checkMatrix(int[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        if (matrixRows < LOWER_ROWS_VALUE || matrixRows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        } else {
            for (int i = 0; i < matrix.length; i++) {
                int matrixColumns = matrix[i].length;
                if (matrixColumns < LOWER_COLUMNS_VALUE || matrixColumns > UPPER_COLUMNS_VALUE) {
                    throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
                }
            }
        }
    }

    /**
     * Checks the {@code matrix} for null and that the {@code matrix} attributes length(size) ("rows" and "columns") in range.
     * Valid values range for matrix rows from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     * Valid values range for matrix columns from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     *
     * @param matrix the {@code matrix} to check.
     *
     * @throws NullPointerException if the {@code matrix} null.
     * @throws MatrixRowOutOfRangeException if the {@code matrix} rows (length) value out of range.
     * @throws MatrixColumnOutOfRangeException if the {@code matrix} columns (length) value out of range.
     */
    public static void checkMatrix(double[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        if (matrixRows < LOWER_ROWS_VALUE || matrixRows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        } else {
            for (int i = 0; i < matrix.length; i++) {
                int matrixColumns = matrix[i].length;
                if (matrixColumns < LOWER_COLUMNS_VALUE || matrixColumns > UPPER_COLUMNS_VALUE) {
                    throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
                }
            }
        }
    }

    /**
     * Checks the {@code rows} number value in of the range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@link CheckerMatrix#UPPER_ROWS_VALUE}.
     *
     * @param rows the rows number value to check.
     *
     * @throws MatrixRowOutOfRangeException the rows number value out of the range.
     */
    public static void checkRows(int rows) {
        if (rows < LOWER_ROWS_VALUE || rows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code rows} number value in of the range from {@link CheckerMatrix#LOWER_ROWS_VALUE} to {@code upperBoundRows}.
     *
     * @param rows the rows number value to check.
     *
     * @throws MatrixRowOutOfRangeException the rows number value out of the range.
     */
    public static void checkRows(int rows, int upperBoundRows) {
        CheckerBound.isCorrectBound(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE);
        if (rows < LOWER_ROWS_VALUE || rows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code rows} number value in of the range from {@code lowerBoundRows} to {@code upperBoundRows}.
     *
     * @param rows the rows number value to check.
     *
     * @throws MatrixRowOutOfRangeException the rows number value out of the range.
     */
    public static void checkRows(int rows, int lowerBoundRows, int upperBoundRows) {
        CheckerBound.isCorrectBound(lowerBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE);
        CheckerBound.isCorrectBound(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundRows, upperBoundRows);
        if (rows < LOWER_ROWS_VALUE || rows > UPPER_ROWS_VALUE) {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code columns} number value in of the range
     * from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@link CheckerMatrix#UPPER_COLUMNS_VALUE}.
     *
     * @param columns the columns number value to check.
     *
     * @throws MatrixColumnOutOfRangeException the columns number value out of the range.
     */
    public static void checkColumns(int columns) {
        if (columns < LOWER_COLUMNS_VALUE || columns > UPPER_COLUMNS_VALUE) {
            throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code columns} number value in of the range
     * from {@link CheckerMatrix#LOWER_COLUMNS_VALUE} to {@code upperBoundColumns}.
     *
     * @param columns the columns number value to check.
     *
     * @throws MatrixColumnOutOfRangeException the columns number value out of the range.
     */
    public static void checkColumns(int columns, int upperBoundColumns) {
        CheckerBound.isCorrectBound(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE);
        if (columns < LOWER_COLUMNS_VALUE || columns > UPPER_COLUMNS_VALUE) {
            throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
        }
    }

    /**
     * Checks the {@code columns} number value in of the range from {@code lowerBoundColumns} to {@code upperBoundColumns}.
     *
     * @param columns the columns number value to check.
     *
     * @throws MatrixColumnOutOfRangeException the columns number value out of the range.
     */
    public static void checkColumns(int columns, int lowerBoundColumns, int upperBoundColumns) {
        CheckerBound.isCorrectBound(lowerBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE);
        CheckerBound.isCorrectBound(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundColumns, upperBoundColumns);
        if (columns < lowerBoundColumns || columns > upperBoundColumns) {
            throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
        }
    }

}
