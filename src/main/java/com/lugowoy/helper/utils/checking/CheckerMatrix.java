package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.utils.MatrixColumnOutOfRangeException;
import com.lugowoy.helper.utils.MatrixRowOutOfRangeException;

import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 2.0
 */
//todo write doc's
public final class CheckerMatrix {

    public static final int LOWER_ROWS_VALUE = 0;
    public static final int LOWER_COLUMNS_VALUE = 0;

    private static final int ARRAY_HEADER = 8;

    public static final int UPPER_ROWS_VALUE = Integer.MAX_VALUE - ARRAY_HEADER;
    public static final int UPPER_COLUMNS_VALUE = Integer.MAX_VALUE - ARRAY_HEADER;

    private static final String MSG_MATRIX_IS_NULL = "Matrix must not be null.";
    private static final String MSG_MATRIX_ROWS_IS_OUT_OF_RANGE = "Matrix rows value is out of range (" + LOWER_ROWS_VALUE
                                                                                                + " - " + UPPER_ROWS_VALUE + ").";
    private static final String MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE = "Matrix columns value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                                      + " - " + UPPER_COLUMNS_VALUE + ").";

    private CheckerMatrix() {
    }

    public static boolean checkMatrix(final AbstractMatrix matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.getRows();
        int matrixColumns = matrix.getColumns();
        if (matrixRows >= LOWER_ROWS_VALUE && matrixRows <= UPPER_ROWS_VALUE) {
            if (matrixColumns >= LOWER_COLUMNS_VALUE && matrixColumns <= UPPER_COLUMNS_VALUE) {
                return true;
            } else {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    public static <T> boolean checkMatrix(final T[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        if (matrixRows >= LOWER_ROWS_VALUE && matrixRows <= UPPER_ROWS_VALUE) {
            if (matrixColumns >= LOWER_COLUMNS_VALUE && matrixColumns <= UPPER_COLUMNS_VALUE) {
                return true;
            } else {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    public static boolean checkMatrix(final int[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        if (matrixRows >= LOWER_ROWS_VALUE && matrixRows <= UPPER_ROWS_VALUE) {
            if (matrixColumns >= LOWER_COLUMNS_VALUE && matrixColumns <= UPPER_COLUMNS_VALUE) {
                return true;
            } else {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    public static boolean checkMatrix(final double[][] matrix) {
        Objects.requireNonNull(matrix, MSG_MATRIX_IS_NULL);
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        if (matrixRows >= LOWER_ROWS_VALUE && matrixRows <= UPPER_ROWS_VALUE) {
            if (matrixColumns >= LOWER_COLUMNS_VALUE && matrixColumns <= UPPER_COLUMNS_VALUE) {
                return true;
            } else {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    public static boolean checkRows(final int rows) {
        if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
            return true;
        } else {
            throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
        }
    }

    public static boolean checkRows(final int rows, final int upperBoundRows) {
        boolean resultCheckRows = false;
        if (CheckerBound.isCorrectBound(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)) {
            if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
                resultCheckRows = true;
            } else {
                throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
            }
        }
        return resultCheckRows;
    }

    public static boolean checkRows(final int rows, final int lowerBoundRows, final int upperBoundRows) {
        boolean resultCheckRows = false;
        if (CheckerBound.isCorrectBound(lowerBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)
                && CheckerBound.isCorrectBound(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)) {
            if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundRows, upperBoundRows)) {
                if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
                    resultCheckRows = true;
                } else {
                    throw new MatrixRowOutOfRangeException(MSG_MATRIX_ROWS_IS_OUT_OF_RANGE);
                }
            }
        }
        return resultCheckRows;
    }

    public static boolean checkColumns(final int columns) {
        if (columns >= LOWER_COLUMNS_VALUE && columns <= UPPER_COLUMNS_VALUE) {
            return true;
        } else {
            throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
        }
    }

    public static boolean checkColumns(final int columns, final int upperBoundColumns) {
        boolean resultCheckColumns = false;
        if (CheckerBound.isCorrectBound(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)) {
            if (columns >= LOWER_COLUMNS_VALUE && columns <= UPPER_COLUMNS_VALUE) {
                resultCheckColumns = true;
            } else {
                throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
            }
        }
        return resultCheckColumns;
    }

    public static boolean checkColumns(final int columns, final int lowerBoundColumns, final int upperBoundColumns) {
        boolean resultCheckColumns = false;
        if (CheckerBound.isCorrectBound(lowerBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)
                && CheckerBound.isCorrectBound(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)) {
            if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundColumns, upperBoundColumns)) {
                if (columns >= lowerBoundColumns && columns <= upperBoundColumns) {
                    resultCheckColumns = true;
                } else {
                    throw new MatrixColumnOutOfRangeException(MSG_MATRIX_COLUMNS_IS_OUT_OF_RANGE);
                }
            }
        }
        return resultCheckColumns;
    }

}
