package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.*;
import com.rits.cloning.Cloner;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a dynamic matrix model.
 * <p>Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.5
 */
//todo edit doc's
public class Matrix<T> implements Model {

    /**
     * Default rows of the matrix.
     */
    public static final int DEFAULT_ROWS = 10;

    /**
     * Default columns of the matrix.
     */
    public static final int DEFAULT_COLUMNS = 10;

    private Object[][] matrix;
    private int rows = 0;
    private int columns = 0;

    /**
     * Constructs a new matrix of the rows and columns.
     */
    public Matrix() {
        this.matrix = new Object[rows][columns];
    }

    /**
     * Constructs a new matrix of rows and columns argument.
     *
     * @param rows    Rows of matrix.
     * @param columns Columns of matrix.
     * @throws MatrixRowOutOfRangeException    the argument {@code rows} value is out of range.
     * @throws MatrixColumnOutOfRangeException the argument {@code columns} value is out of range.
     */
    public Matrix(int rows, int columns) {
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new Object[rows][columns];
        }
    }

    /**
     * Constructs a new matrix by initializing it with the elements of a two-dimensional array passed by the argument.
     *
     * @param matrix Two-dimensional array to initialize the matrix.
     * @throws NullPointerException If argument matrix is null.
     */
    public Matrix(T[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            this.matrix = new Cloner().deepClone(matrix);
        }
    }

    /**
     * Constructs a new matrix.
     * Initializes the matrix with elements of the matrix passed by the argument.
     * Copy constructor.
     *
     * @param matrix Matrix to copy state.
     * @throws NullPointerException If argument matrix is null.
     */
    public Matrix(Matrix<T> matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.rows = matrix.rows();
            this.columns = matrix.columns();
            this.matrix = new Cloner().deepClone(matrix.toMatrix((T[][]) new Object[matrix.rows][matrix.columns]));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return rows() == matrix1.rows() &&
                columns() == matrix1.columns() &&
                Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows(), columns());
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(0);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                stringBuilder.append(this.matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int rows() {
        return this.rows;
    }

    public int columns() {
        return this.columns;
    }

    /**
     * Sets the elements of the matrix are the same as the two-dimensional array passed to the argument.
     *
     * @param matrix Two-dimensional array for matrix initialization.
     * @throws NullPointerException           If argument two-dimensional array is null.
     * @throws LengthArrayOutOfRangeException If argument matrix has incorrect rows or columns length value.
     */
    public void setMatrix(T[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            this.matrix = matrix;
        }
    }

    public Object[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Gets the matrix (two-dimensional array) filled with the elements of the encapsulated matrix.
     *
     * @param matrix Matrix (two-dimensional array) to fill.
     * @return Matrix (two-dimensional array) filled with elements of a matrix.
     * @throws NullPointerException If argument matrix is null.
     */
    public T[][] toMatrix(T[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (this.rows == matrix.length && this.columns == matrix[0].length) {
                for (int i = 0; i < this.rows; i++) {
                    matrix[i] = (T[]) this.matrix[i].clone();
                }
            } else {
                //todo add another exception
                throw new RuntimeException("Matrix sizes do not match.");
            }
        }
        return matrix;
    }

    public void setRows(int rows) {
        if (CheckerMatrix.checkRows(rows)) {
            this.rows = rows;
        }
    }

    public void setColumns(int columns) {
        if (CheckerMatrix.checkColumns(columns)) {
            this.columns = columns;
        }
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param indexRow Index row to get.
     * @return The object of the {@link Array} class filled with elements from the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    public Array<T> getRow(int indexRow) {
        Array<T> array = new Array<>(this.rows);
        if (CheckerIndex.checkIndex(indexRow, this.columns)) {
            array.setArray((T[]) Arrays.copyOfRange(this.matrix[indexRow], 0, this.columns));
        }
        return array;
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param array    One-dimensional array to fill with elements from the matrix row.
     * @param indexRow Index row to get.
     * @return One-dimensional array filled with elements from the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public T[] getRow(T[] array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, this.columns)) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                array = (T[]) Arrays.copyOfRange(this.matrix[indexRow], 0, this.columns);
            }
        }
        return array;
    }

    /**
     * Gets the row of the matrix at the index passed by the argument.
     *
     * @param array    Object of the {@link Array} class to fill with elements from the matrix row.
     * @param indexRow Index row to get.
     * @return Object of the {@link Array} class filled with elements from the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public Array<T> getRow(Array<T> array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, this.columns)) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                for (int i = 0; i < this.columns; i++) {
                    array.add((T) this.matrix[indexRow][i]);
                }
            }
        }
        return array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param indexColumn Index column to get.
     * @return Object of the {@link Array} class filled with elements from the matrix column.
     * @throws IndexOutOfBoundsException If the argument indexColumn is out of range.
     */
    public Array<T> getColumn(int indexColumn) {
        Array<T> array = new Array<>(this.columns);
        if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
            for (int i = 0; i < this.rows; i++) {
                array.add((T) this.matrix[i][indexColumn]);
            }
        }
        return array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param array       One-dimensional array to fill with elements from the matrix column.
     * @param indexColumn Index column to get.
     * @return One-dimensional array filled with elements from the matrix column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public T[] getColumn(T[] array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.rows; i++) {
                    array[i] = (T) this.matrix[i][indexColumn];
                }
            }
        }
        return array;
    }

    /**
     * Gets the column of the matrix at the index passed by the argument.
     *
     * @param array       Object of the {@link Array} class to fill with elements from the matrix column.
     * @param indexColumn Index column to get.
     * @return Object of the {@link Array} class filled with elements from the matrix column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public Array<T> getColumn(Array<T> array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.rows; i++) {
                    array.setArray((T[]) this.matrix[i][indexColumn]);
                }
            }
        }
        return array;
    }

    /**
     * Set (initialize) the matrix row by index, which is passed by the argument
     * to the elements that are stored in the one-dimensional array passed by the argument.
     *
     * @param array    One-dimensional array that are stored elements to set elements of row of the matrix.
     * @param indexRow Index row to get.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public void setRow(T[] array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, this.columns)) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                this.matrix[indexRow] = Arrays.copyOfRange(array, 0, array.length);
            }
        }
    }

    /**
     * Set (initialize) the matrix row by index, which is passed by the argument
     * to the elements that are stored in the object of the {@link Array} class passed by the argument.
     *
     * @param array    Object of the {@link Array} class that are stored elements to set elements of row of the matrix.
     * @param indexRow Index row to get.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public void setRow(Array<T> array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, this.columns)) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                for (int i = 0; i < this.rows; i++) {
                    this.matrix[indexRow][i] = array.get(i);
                }
            }
        }
    }

    /**
     * Set (initialize) the matrix column by index, which is passed by the argument
     * to the elements that are stored in the one-dimensional array passed by the argument.
     *
     * @param array       One-dimensional array that are stored elements to set elements of row of the matrix.
     * @param indexColumn Index column to get.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public void setColumn(T[] array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[i][indexColumn] = array[i];
                }
            }
        }
    }

    /**
     * Set (initialize) the matrix column by index, which is passed by the argument
     * to the elements that are stored in the object of the {@link Array} class passed by the argument.
     *
     * @param array       Object of the {@link Array} class that are stored elements to set elements of column of the matrix.
     * @param indexColumn Index column to get.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     * @throws NullPointerException      If argument array is null.
     */
    public void setColumn(Array<T> array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[i][indexColumn] = array.get(i);
                }
            }
        }
    }

    /**
     * Deletes the matrix row by the index passed by the argument.
     *
     * @param indexRow Index to delete the matrix row.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    public void deleteRow(int indexRow) {
        if (CheckerIndex.checkIndex(indexRow, this.rows)) {
            for (int i = 0; i < this.columns; i++) {
                this.matrix[indexRow][i] = null;
            }
        }
    }

    /**
     * Deletes the matrix column by the index passed by the argument.
     *
     * @param indexColumn Index to delete the matrix column.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     */
    public void deleteColumn(int indexColumn) {
        if (CheckerIndex.checkIndex(indexColumn, this.columns)) {
            for (int i = 0; i < this.rows; i++) {
                this.matrix[i][indexColumn] = null;
            }
        }
    }

    /**
     * Compresses the matrix by removing from it a row at the index passed by the argument.
     *
     * @param indexRow Index row to be deleted during compression.
     * @throws IndexOutOfBoundsException If argument indexRow is out of range.
     */
    public void compressRow(int indexRow) {
        if (CheckerIndex.checkIndex(indexRow, this.rows)) {
            Object[][] objects = new Object[this.rows - 1][this.columns];
            int tmpIndexRow = 0;
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (i == indexRow) {
                        tmpIndexRow = 1;
                        break;
                    } else {
                        objects[i - tmpIndexRow][j] = this.matrix[i][j];
                    }
                }
            }
            this.setMatrix((T[][]) objects);
        }
    }

    /**
     * Compresses the matrix by removing from it a column at the index passed by the argument.
     *
     * @param indexColumn Index row to be deleted during compression.
     * @throws IndexOutOfBoundsException If argument indexColumn is out of range.
     */
    public void compressColumn(int indexColumn) {
        if (CheckerIndex.checkIndex(indexColumn, this.columns)) {
            Object[][] objects = new Object[this.rows][this.columns - 1];
            int tmpIndexColumn = 0;
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (j == indexColumn) {
                        tmpIndexColumn = 1;
                    } else {
                        objects[i][j - tmpIndexColumn] = this.matrix[i][j];
                    }
                }
                tmpIndexColumn = 0;
            }
            this.setMatrix((T[][]) objects);
        }
    }

    /**
     * Gets the matrix element by row index and column index.
     *
     * @param indexRow    Index matrix row.
     * @param indexColumn Index matrix column.
     * @return Element of the matrix indexes passed by the argument.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out of range.
     */
    public T getElement(int indexRow, int indexColumn) {
        T obj = null;
        if (CheckerIndex.checkIndex(indexRow, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.columns)) {
                obj = (T) this.matrix[indexRow][indexColumn];
            }
        }
        return obj;
    }

    /**
     * Sets the matrix element by row index and column index.
     *
     * @param indexRow    Index matrix row.
     * @param indexColumn Index matrix column.
     * @param element     Element to set.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out of range.
     */
    public void setElement(int indexRow, int indexColumn, T element) {
        if (CheckerIndex.checkIndex(indexRow, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.columns)) {
                this.matrix[indexRow][indexColumn] = element;
            }
        }
    }

    /**
     * Deletes matrix element by row and column index.
     * Element stored in the indices is null.
     *
     * @param indexRow    Index matrix row.
     * @param indexColumn Index matrix column.
     * @throws IndexOutOfBoundsException Argument indexRow or indexColumn is out of range.
     */
    public void deleteElement(int indexRow, int indexColumn) {
        if (CheckerIndex.checkIndex(indexRow, this.rows)) {
            if (CheckerIndex.checkIndex(indexColumn, this.columns)) {
                this.matrix[indexRow][indexColumn] = null;
            }
        }
    }

}