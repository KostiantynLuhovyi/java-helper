package com.lugowoy.helper.utils;

import com.lugowoy.helper.models.matrices.AbstractMatrix;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 2.0
 */
//todo write doc's
public interface CheckerMatrix {

    int LOWER_ROWS_VALUE = 1;
    int LOWER_COLUMNS_VALUE = 1;
    int UPPER_ROWS_VALUE = Integer.MAX_VALUE;
    int UPPER_COLUMNS_VALUE = Integer.MAX_VALUE;

    static boolean checkMatrix(AbstractMatrix matrix) {
        if (matrix != null) {
            if (matrix.getRowsLength() >= LOWER_ROWS_VALUE && matrix.getRowsLength() <= UPPER_ROWS_VALUE) {
                if (matrix.getColumnsLength() >= LOWER_COLUMNS_VALUE && matrix.getColumnsLength() <= UPPER_COLUMNS_VALUE) {
                    return true;
                } else {
                    throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                               + " - " + UPPER_COLUMNS_VALUE + ").");
                }
            } else {
                throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                     + " - " + UPPER_ROWS_VALUE + ").");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    static <T> boolean checkMatrix(T[][] matrix) {
        if (matrix != null) {
            if (matrix.length >= LOWER_ROWS_VALUE && matrix.length <= UPPER_ROWS_VALUE) {
                if (matrix[0].length >= LOWER_COLUMNS_VALUE && matrix[0].length <= UPPER_COLUMNS_VALUE) {
                    return true;
                } else {
                    throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                               + " - " + UPPER_COLUMNS_VALUE + ").");
                }
            } else {
                throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                     + " - " + UPPER_ROWS_VALUE + ").");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    static boolean checkMatrix(int[][] matrix) {
        if (matrix != null) {
            if (matrix.length >= LOWER_ROWS_VALUE && matrix.length <= UPPER_ROWS_VALUE) {
                if (matrix[0].length >= LOWER_COLUMNS_VALUE && matrix[0].length <= UPPER_COLUMNS_VALUE) {
                    return true;
                } else {
                    throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                               + " - " + UPPER_COLUMNS_VALUE + ").");
                }
            } else {
                throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                     + " - " + UPPER_ROWS_VALUE + ").");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    static boolean checkMatrix(double[][] matrix) {
        if (matrix != null) {
            if (matrix.length >= LOWER_ROWS_VALUE && matrix.length <= UPPER_ROWS_VALUE) {
                if (matrix[0].length >= LOWER_COLUMNS_VALUE && matrix[0].length <= UPPER_COLUMNS_VALUE) {
                    return true;
                } else {
                    throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                               + " - " + UPPER_COLUMNS_VALUE + ").");
                }
            } else {
                throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                     + " - " + UPPER_ROWS_VALUE + ").");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    static boolean checkRows(int rows) {
        if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
            return true;
        } else {
            throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                 + " - " + UPPER_ROWS_VALUE + ").");
        }
    }

    static boolean checkRows(int rows, int upperBoundRows) {
        boolean resultCheckRows = false;
        if (CheckerBound.isCorrectBounds(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)) {
            if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
                resultCheckRows = true;
            } else {
                throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                     + " - " + UPPER_ROWS_VALUE + ").");
            }
        }
        return resultCheckRows;
    }

    static boolean checkRows(int rows, int lowerBoundRows, int upperBoundRows) {
        boolean resultCheckRows = false;
        if (CheckerBound.isCorrectBounds(lowerBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)
                && CheckerBound.isCorrectBounds(upperBoundRows, LOWER_ROWS_VALUE, UPPER_ROWS_VALUE)) {
            if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundRows, upperBoundRows)) {
                if (rows >= LOWER_ROWS_VALUE && rows <= UPPER_ROWS_VALUE) {
                    resultCheckRows = true;
                } else {
                    throw new MatrixRowOutOfRangeException("Matrix getRowsLength value is out of range (" + LOWER_ROWS_VALUE
                                                                                         + " - " + UPPER_ROWS_VALUE + ").");
                }
            }
        }
        return resultCheckRows;
    }

    static boolean checkColumns(int columns) {
        if (columns >= LOWER_COLUMNS_VALUE && columns <= UPPER_COLUMNS_VALUE) {
            return true;
        } else {
            throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                    + " - " + UPPER_COLUMNS_VALUE + ").");
        }
    }

    static boolean checkColumns(int columns, int upperBoundColumns) {
        boolean resultCheckColumns = false;
        if (CheckerBound.isCorrectBounds(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)) {
            if (columns >= LOWER_COLUMNS_VALUE && columns <= UPPER_COLUMNS_VALUE) {
                resultCheckColumns = true;
            } else {
                throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                           + " - " + UPPER_COLUMNS_VALUE + ").");
            }
        }
        return resultCheckColumns;
    }

    static boolean checkColumns(int columns, int lowerBoundColumns, int upperBoundColumns) {
        boolean resultCheckColumns = false;
        if (CheckerBound.isCorrectBounds(lowerBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)
                && CheckerBound.isCorrectBounds(upperBoundColumns, LOWER_COLUMNS_VALUE, UPPER_COLUMNS_VALUE)) {
            if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBoundColumns, upperBoundColumns)) {
                if (columns >= lowerBoundColumns && columns <= upperBoundColumns) {
                    resultCheckColumns = true;
                } else {
                    throw new MatrixColumnOutOfRangeException("Matrix getColumnsLength value is out of range (" + LOWER_COLUMNS_VALUE
                                                                                               + " - " + UPPER_COLUMNS_VALUE + ").");
                }
            }
        }
        return resultCheckColumns;
    }

}
