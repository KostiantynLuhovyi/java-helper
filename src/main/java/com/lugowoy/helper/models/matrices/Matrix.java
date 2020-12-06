package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import com.lugowoy.helper.utils.MatrixColumnOutOfRangeException;
import com.lugowoy.helper.utils.MatrixRowOutOfRangeException;
import org.apache.commons.lang3.SerializationUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a dynamic matrix model.
 * <p>Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 2.7
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.matrices.AbstractMatrix
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.5
 */
//TODO review documentation
public class Matrix<T> extends AbstractMatrix {

    private Object[][] matrix;

    /**
     * Constructs a new matrix of the getRows and getColumns.
     */
    public Matrix() {
        this.matrix = new Object[super.getRows()][super.getColumns()];
    }

    /**
     * Constructs a new matrix of getRows and getColumns argument.
     *
     * @param rows Rows of matrix.
     * @param columns Columns of matrix.
     * @throws MatrixRowOutOfRangeException the argument {@code getRows} value
     * is out of range.
     * @throws MatrixColumnOutOfRangeException the argument {@code getColumns}
     * value is out of range.
     */
    public Matrix(final int rows, final int columns) {
        super(rows, columns);
        this.matrix = new Object[super.getRows()][super.getColumns()];
    }

    /**
     * Constructs a new matrix by initializing it with the elements of a
     * two-dimensional array passed by the argument.
     *
     * @param matrix Two-dimensional array to initialize the matrix.
     * @throws NullPointerException If argument matrix is null.
     */
    public Matrix(@NotNull final T[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.copyMatrix(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    /**
     * Constructs a new matrix. Initializes the matrix with elements of the
     * matrix passed by the argument. Copy constructor.
     *
     * @param matrix Matrix to copy state.
     * @throws NullPointerException If argument matrix is null.
     */
    @SuppressWarnings("unchecked")
    public Matrix(@NotNull final Matrix<T> matrix) {
        CheckerMatrix.check(matrix, Capacity.LOWER.get(), Capacity.UPPER.get());
        //this check has no logic
        this.checkEqualMatrixLength((T[][]) matrix.matrix);
        this.copyMatrix((T[][]) matrix.matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matrix)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Matrix<?> that = (Matrix<?>) o;
        return Arrays.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    /**
     * Returns a string representation of the object. In general, the {@code
     * toString} method returns a string that "textually represents" this
     * object. The result should be a concise but informative representation
     * that is easy for a person to read. It is recommended that all subclasses
     * override this method.
     * <p>
     * The {@code toString} method for class {@code Object} returns a string
     * consisting of the name of the class of which the object is an instance,
     * the at-sign character `{@code @}', and the unsigned hexadecimal
     * representation of the hash code of the object. In other words, this
     * method returns a string equal to the value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
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
        this.matrix = new Object[rows][columns];
        super.setRows(rows);
        super.setColumns(columns);
    }

    /**
     * Sets the elements of the matrix are the same as the two-dimensional array
     * passed to the argument.
     *
     * @param matrix Two-dimensional array for matrix initialization.
     * @throws NullPointerException If argument two-dimensional array is null.
     * @throws LengthOutOfRangeException If argument matrix has incorrect
     * getRows or getColumns length value.
     */
    public void setMatrix(@NotNull final T[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.copyMatrix(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    @SuppressWarnings("unchecked")
    public void setMatrix(@NotNull final Matrix<T> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength((T[][]) matrix.matrix);
        this.copyMatrix((T[][]) matrix.matrix);
        super.setRows(matrix.getRows());
        super.setColumns(matrix.getColumns());
    }

    public void setDeepMatrix(@NotNull final T[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength(matrix);
        this.matrix = SerializationUtils.clone(matrix);
        super.setRows(this.matrix.length);
        super.setColumns(this.matrix[0].length);
    }

    @SuppressWarnings("unchecked")
    public void setDeepMatrix(@NotNull final Matrix<T> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.checkEqualMatrixLength((T[][]) matrix.matrix);
        this.matrix = SerializationUtils.clone(matrix.matrix);
        super.setRows(matrix.getRows());
        super.setColumns(matrix.getColumns());
    }

    public Object[][] toMatrix() {
        return this.matrix;
    }

    /**
     * Gets the matrix (two-dimensional array) filled with the elements of the
     * encapsulated matrix.
     *
     * @param matrix Matrix (two-dimensional array) to fill.
     * @return Matrix (two-dimensional array) filled with elements of a matrix.
     * @throws NullPointerException If argument matrix is null.
     */
    @SuppressWarnings("unchecked")
    public T[][] toMatrix(@NotNull final T[][] matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.length; i++) {
            if (i == super.getRows()) {
                break;
            } else {
                matrix[i] = (T[]) Arrays.copyOf(this.matrix[i],
                                                this.matrix[i].length);
            }
        }
        return matrix;
    }

    @SuppressWarnings("unchecked")
    public Object[][] toDeepMatrix() {
        return SerializationUtils.clone(this.matrix);
    }

    @SuppressWarnings("unchecked")
    public T[][] toDeepMatrix(@NotNull final T[][] matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.length; i++) {
            if (i == super.getRows()) {
                break;
            } else {
                matrix[i] = (T[]) SerializationUtils.clone(this.matrix[i]);
            }
        }
        return matrix;
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param indexRow Index row to get.
     * @return The object of the {@link Array} class filled with elements from
     * the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    @SuppressWarnings("unchecked")
    public T[] getRowToArray(final int indexRow) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        return (T[]) Arrays.copyOf(this.matrix[indexRow], super.getColumns());
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param array One-dimensional array to fill with elements from the matrix
     * row.
     * @param indexRow Index row to get.
     * @return One-dimensional array filled with elements from the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException If argument array is null.
     */
    @SuppressWarnings("unchecked")
    public T[] getRowToArray(@NotNull T[] array, final int indexRow) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        array = (T[]) Arrays.copyOf(this.matrix[indexRow], super.getColumns());
        return array;
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param array Object of the {@link Array} class to fill with elements from
     * the matrix row.
     * @param indexRow Index row to get.
     * @return Object of the {@link Array} class filled with elements from the
     * matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException If argument array is null.
     */
    @SuppressWarnings("unchecked")
    public Array<T> getRowToArray(@NotNull final Array<T> array,
                                  final int indexRow) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        array.setArray(
                (T[]) Arrays.copyOf(this.matrix[indexRow], super.getColumns()));
        return array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param indexColumn Index column to get.
     * @return Object of the {@link Array} class filled with elements from the
     * matrix column.
     * @throws IndexOutOfBoundsException If the argument indexColumn is out of
     * range.
     */
    @SuppressWarnings("unchecked")
    public T[] getColumnToArray(final int indexColumn) {
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        Object[] array = new Object[super.getRows()];
        for (int i = 0; i < super.getRows(); i++) {
            array[i] = this.matrix[i][indexColumn];
        }
        return (T[]) array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param array One-dimensional array to fill with elements from the matrix
     * column.
     * @param indexColumn Index column to get.
     * @return One-dimensional array filled with elements from the matrix
     * column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     * @throws NullPointerException If argument array is null.
     */
    @SuppressWarnings("unchecked")
    public T[] getColumnToArray(@NotNull T[] array, final int indexColumn) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        array = (T[]) new Object[super.getRows()];
        for (int i = 0; i < super.getRows(); i++) {
            array[i] = (T) this.matrix[i][indexColumn];
        }
        return array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param array Object of the {@link Array} class to fill with elements from
     * the matrix column.
     * @param indexColumn Index column to get.
     * @return Object of the {@link Array} class filled with elements from the
     * matrix column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     * @throws NullPointerException If argument array is null.
     */
    @SuppressWarnings("unchecked")
    public Array<T> getColumnToArray(@NotNull final Array<T> array,
                                     final int indexColumn) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        for (int i = 0; i < super.getRows(); i++) {
            array.add((T) this.matrix[i][indexColumn]);
        }
        return array;
    }

    /**
     * Set (initialize) the matrix row by index, which is passed by the argument
     * to the elements that are stored in the one-dimensional array passed by
     * the argument.
     *
     * @param array One-dimensional array that are stored elements to set
     * elements of row of the matrix.
     * @param indexRow Index row to get.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException If argument array is null.
     */
    public void setRowFromArray(@NotNull final T[] array, final int indexRow) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        this.matrix[indexRow] = Arrays.copyOf(array, super.getColumns());
    }

    /**
     * Set (initialize) the matrix row by index, which is passed by the argument
     * to the elements that are stored in the object of the {@link Array} class
     * passed by the argument.
     *
     * @param array Object of the {@link Array} class that are stored elements
     * to set elements of row of the matrix.
     * @param indexRow Index row to get.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException If argument array is null.
     */
    public void setRowFromArray(@NotNull final Array<T> array,
                                final int indexRow) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexRow, super.getRows());
        this.matrix[indexRow] = Arrays.copyOf(array.toArray(),
                                              super.getColumns());
    }

    /**
     * Set (initialize) the matrix column by index, which is passed by the
     * argument to the elements that are stored in the one-dimensional array
     * passed by the argument.
     *
     * @param array One-dimensional array that are stored elements to set
     * elements of row of the matrix.
     * @param indexColumn Index column to get.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     * @throws NullPointerException If argument array is null.
     */
    public void setColumnFromArray(@NotNull final T[] array,
                                   final int indexColumn) {
        Objects.requireNonNull(array, "Array is null");
        CheckerIndex.checkInRange(indexColumn, this.getColumns());
        for (int i = 0; i < super.getRows(); i++) {
            if (i < array.length) {
                this.matrix[i][indexColumn] = array[i];
            } else {
                break;
            }
        }
    }

    /**
     * Set (initialize) the matrix column by index, which is passed by the
     * argument to the elements that are stored in the object of the {@link
     * Array} class passed by the argument.
     *
     * @param array Object of the {@link Array} class that are stored elements
     * to set elements of column of the matrix.
     * @param indexColumn Index column to get.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     * @throws NullPointerException If argument array is null.
     */
    @SuppressWarnings("unchecked")
    public void setColumnFromArray(@NotNull final Array<T> array,
                                   final int indexColumn) {
        Objects.requireNonNull(array, "Array is null");
        this.setColumnFromArray((T[]) array.toArray(), indexColumn);
    }

    /**
     * Deletes the matrix row by the index passed by the argument.
     *
     * @param indexRow Index to delete the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    public void deleteRow(final int indexRow) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        for (int i = 0; i < super.getColumns(); i++) {
            this.matrix[indexRow][i] = null;
        }
    }

    /**
     * Deletes the matrix column by the index passed by the argument.
     *
     * @param indexColumn Index to delete the matrix column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     */
    public void deleteColumn(final int indexColumn) {
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        for (int i = 0; i < super.getRows(); i++) {
            this.matrix[i][indexColumn] = null;
        }
    }

    /**
     * Compresses the matrix by removing from it a row at the index passed by
     * the argument.
     *
     * @param indexRow Index row to be deleted during compression.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    public void compressRow(final int indexRow) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        Object[][] tmpMatrix =
                new Object[super.getRows() - 1][super.getColumns()];
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

    /**
     * Compresses the matrix by removing from it a column at the index passed by
     * the argument.
     *
     * @param indexColumn Index row to be deleted during compression.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of
     * range.
     */
    public void compressColumn(final int indexColumn) {
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        Object[][] tmpMatrix =
                new Object[super.getRows()][super.getColumns() - 1];
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

    /**
     * Gets the matrix element by row index and column index.
     *
     * @param indexRow Index matrix row.
     * @param indexColumn Index matrix column.
     * @return Element of the matrix indexes passed by the argument.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out
     * of range.
     */
    @SuppressWarnings("unchecked")
    public T getElement(final int indexRow, final int indexColumn) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        return (T) this.matrix[indexRow][indexColumn];
    }

    /**
     * Sets the matrix element by row index and column index.
     *
     * @param indexRow Index matrix row.
     * @param indexColumn Index matrix column.
     * @param element Element to set.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out
     * of range.
     */
    public void setElement(final T element, final int indexRow,
                           final int indexColumn) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        this.matrix[indexRow][indexColumn] = element;
    }

    /**
     * Deletes matrix element by row and column index. Element stored in the
     * indices is null.
     *
     * @param indexRow Index matrix row.
     * @param indexColumn Index matrix column.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out
     * of range.
     */
    public void deleteElement(final int indexRow, final int indexColumn) {
        CheckerIndex.checkInRange(indexRow, super.getRows());
        CheckerIndex.checkInRange(indexColumn, super.getColumns());
        this.matrix[indexRow][indexColumn] = null;
    }

    private void copyMatrix(@NotNull final T[][] matrix) {
        this.matrix = new Object[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    private void checkEqualMatrixLength(@NotNull final T[][] matrix) {
        int firstRow = matrix[0].length;
        int bound = matrix.length;
        for (int i = 0; i < bound; i++) {
            if (firstRow != matrix[i].length) {
                throw new IllegalArgumentException(
                        "Matrix columns have different lengths");
            }
        }
    }

}