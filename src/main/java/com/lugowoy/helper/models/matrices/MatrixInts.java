package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.apache.commons.lang3.SerializationUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.matrices.AbstractMatrix
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 2.0
 */
//TODO documentation
public class MatrixInts extends AbstractMatrix {

    private int[][] matrix;

    public MatrixInts() {
        matrix = new int[super.getRows()][super.getColumns()];
    }

    public MatrixInts(final int rows, final int columns) {
        super(rows, columns);
        this.matrix = new int[super.getRows()][super.getColumns()];
    }

    public MatrixInts(@NotNull final int[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.copyMatrix(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public MatrixInts(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix.matrix);
        this.copyMatrix(matrix.matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MatrixInts)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final MatrixInts that = (MatrixInts) o;
        return Arrays.equals(this.matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(this.matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(
                this.getClass().getSimpleName() + " [ ");
        for (int i = 0; i < this.matrix.length; i++) {
            stringBuilder.append("[ ");
            for (int j = 0; j < this.matrix[i].length; j++) {
                stringBuilder.append(this.matrix[i][j]).append(" ");
            }
            stringBuilder.append("]\n\t\t ");
        }
        stringBuilder.append(" rows:").append(this.getRows()).append(
                ", columns:").append(this.getColumns()).append(" ]");
        return stringBuilder.toString();
    }

    public void setMatrix(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        this.matrix = new int[rows][columns];
        super.setRows(rows);
        super.setColumns(columns);
    }

    public void setMatrix(@NotNull final int[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.copyMatrix(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public void setMatrix(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix.matrix);
        this.copyMatrix(matrix.matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public void setDeepMatrix(@NotNull final int[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.matrix = SerializationUtils.clone(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public void setDeepMatrix(@NotNull final MatrixInts matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix.matrix);
        this.matrix = SerializationUtils.clone(matrix.matrix);
        super.setRows(matrix.getRows());
        super.setColumns(matrix.getColumns());
    }

    public int[][] toMatrix() {
        return this.matrix;
    }

    public int[][] toMatrix(@NotNull final int[][] matrix) {
        Objects.requireNonNull(matrix, "Matrix is null.");
        for (int i = 0; i < matrix.length; i++) {
            if (i == super.getRows()) {
                break;
            } else {
                matrix[i] = Arrays.copyOf(this.matrix[i],
                                          this.matrix[i].length);
            }
        }
        return matrix;
    }

    public int[][] toDeepMatrix() {
        return SerializationUtils.clone(this.matrix);
    }

    public int[][] toDeepMatrix(@NotNull final int[][] matrix) {
        Objects.requireNonNull(matrix, "Matrix is null.");
        for (int i = 0; i < matrix.length; i++) {
            if (i == super.getRows()) {
                break;
            } else {
                matrix[i] = SerializationUtils.clone(this.matrix[i]);
            }
        }
        return matrix;
    }

    public int[] getRowToArray(final int indexRow) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        return Arrays.copyOf(this.matrix[indexRow], super.getColumns());
    }

    public int[] getRowToArray(@NotNull int[] array, final int indexRow) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        array = Arrays.copyOf(this.matrix[indexRow], super.getColumns());
        return array;
    }

    public ArrayInts getRowToArray(@NotNull final ArrayInts array,
                                   final int indexRow) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        array.setArray(
                Arrays.copyOf(this.matrix[indexRow], super.getColumns()));
        return array;
    }

    public int[] getColumnToArray(final int indexColumn) {
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        int[] array = new int[super.getRows()];
        for (int i = 0; i < super.getRows(); i++) {
            array[i] = this.matrix[i][indexColumn];
        }
        return array;
    }

    public int[] getColumnToArray(@NotNull int[] array, final int indexColumn) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        array = new int[super.getRows()];
        for (int i = 0; i < super.getRows(); i++) {
            array[i] = this.matrix[i][indexColumn];
        }
        return array;
    }

    public ArrayInts getColumnToArray(@NotNull final ArrayInts array,
                                      final int indexColumn) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        for (int i = 0; i < super.getRows(); i++) {
            array.add(this.matrix[i][indexColumn]);
        }
        return array;
    }

    public void setRowFromArray(@NotNull final int[] array,
                                final int indexRow) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        this.matrix[indexRow] = Arrays.copyOf(array, super.getColumns());
    }

    public void setRowFromArray(@NotNull final ArrayInts array,
                                final int indexRow) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        this.matrix[indexRow] = Arrays.copyOf(array.toArray(),
                                              super.getColumns());
    }

    public void setColumnFromArray(@NotNull final int[] array,
                                   final int indexColumn) {
        Objects.requireNonNull(array, "Array is null.");
        CheckerIndex.checkInRange(indexColumn, this.getColumns());
        for (int i = 0; i < super.getRows(); i++) {
            if (i < array.length) {
                this.matrix[i][indexColumn] = array[i];
            } else {
                break;
            }
        }
    }

    public void setColumnFromArray(@NotNull final ArrayInts array,
                                   final int indexColumn) {
        Objects.requireNonNull(array, "Array is null.");
        this.setColumnFromArray(array.toArray(), indexColumn);
    }

    public void compressRow(final int indexRow) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        int[][] tmpMatrix = new int[super.getRows() - 1][super.getColumns()];
        int tmpIndexRow = 0;
        for (int i = 0; i < super.getRows(); i++) {
            for (int j = 0; j < super.getColumns(); j++) {
                if (i == indexRow) {
                    tmpIndexRow = 1;
                    break;
                } else {
                    tmpMatrix[i - tmpIndexRow][j] = this.matrix[i][j];
                }
            }
        }
        this.matrix = tmpMatrix;
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public void compressColumn(final int indexColumn) {
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        int[][] tmpMatrix = new int[super.getRows()][super.getColumns() - 1];
        int tmpIndexColumn = 0;
        for (int i = 0; i < super.getRows(); i++) {
            for (int j = 0; j < super.getColumns(); j++) {
                if (j == indexColumn) {
                    tmpIndexColumn = 1;
                } else {
                    tmpMatrix[i][j - tmpIndexColumn] = this.matrix[i][j];
                }
            }
            tmpIndexColumn = 0;
        }
        this.matrix = tmpMatrix;
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    public int getElement(final int indexRow, final int indexColumn) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        return this.matrix[indexRow][indexColumn];
    }

    public void setElement(final int element, final int indexRow,
                           final int indexColumn) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        this.matrix[indexRow][indexColumn] = element;
    }

    private void copyMatrix(@NotNull final int[][] matrix) {
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    private void checkEqualMatrixLength(@NotNull final int[][] matrix) {
        int firstRow = matrix[0].length;
        int bound = matrix.length;
        for (int i = 0; i < bound; i++) {
            if (firstRow != matrix[i].length) {
                throw new IllegalArgumentException(
                        "Matrix columns have different lengths.");
            }
        }
    }

}
