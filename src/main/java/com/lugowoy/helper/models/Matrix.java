package com.lugowoy.helper.models;

import com.lugowoy.helper.other.CheckerIndex;
import com.lugowoy.helper.other.CheckerLengthArray;
import com.lugowoy.helper.other.LengthArrayOutOfRangeException;
import com.lugowoy.helper.other.LengthValueOutOfRangeException;
import com.rits.cloning.Cloner;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a dynamic matrix model.
 * <p>Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.5
 */
public class Matrix<T> implements Model {

    /**
     * Default rows of the matrix.
     */
    public static final int DEFAULT_ROWS = 10;
    /**
     * Default columns of the matrix.
     */
    public static final int DEFAULT_COLUMNS = 10;

    private static final int MAX_MATRIX_LENGTH = Integer.MAX_VALUE;

    private int rows;
    private int columns;
    private Object[][] matrix;

    /**
     * Constructs a new matrix of {@link Matrix#DEFAULT_ROWS} rows and {@link Matrix#DEFAULT_COLUMNS} columns.
     */
    public Matrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
        this.matrix = new Object[rows][columns];
    }

    /**
     * Constructs a new matrix of rows and columns argument.
     *
     * @param rows    Rows of matrix.
     * @param columns Columns of matrix.
     * @throws LengthValueOutOfRangeException If the argument rows or columns value is out of range.
     */
    public Matrix(int rows, int columns) {
        if (rows > 0 && rows < MAX_MATRIX_LENGTH) {
            if (columns > 0 && columns < MAX_MATRIX_LENGTH) {
                this.rows = rows;
                this.columns = columns;
                this.matrix = new Object[rows][columns];
            } else {
                throw new LengthValueOutOfRangeException("The argument columns value is out of range.");
            }
        } else {
            throw new LengthValueOutOfRangeException("The argument row value is out of range.");
        }
    }

    /**
     * Constructs a new matrix by initializing it with the elements of a two-dimensional array passed by the argument.
     *
     * @param matrix Two-dimensional array to initialize the matrix.
     * @throws NullPointerException           If argument matrix is null.
     * @throws LengthArrayOutOfRangeException If argument matrix has incorrect rows or columns length value.
     */
    public Matrix(T[][] matrix) {
        if (matrix != null) {
            if (CheckerLengthArray.checkLengthArray(matrix) && CheckerLengthArray.checkLengthArray(matrix[0])) {
                this.rows = matrix.length;
                this.columns = matrix[0].length;
                this.matrix = new Cloner().deepClone(matrix);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Argument matrix is null."));
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
        if (Objects.nonNull(matrix)) {
            this.rows = matrix.getRows();
            this.columns = matrix.getColumns();
            T[][] tmpMatrix = matrix.getMatrix((T[][]) new Object[matrix.getRows()][matrix.getColumns()]);
            this.matrix = new Cloner().deepClone(tmpMatrix);
        } else {
            throw new NullPointerException("Argument matrix is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return getRows() == matrix1.getRows() &&
                getColumns() == matrix1.getColumns() &&
                Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getRows(), getColumns());
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

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

    /**
     * Sets the elements of the matrix are the same as the two-dimensional array passed to the argument.
     *
     * @param matrix Two-dimensional array for matrix initialization.
     * @throws NullPointerException           If argument two-dimensional array is null.
     * @throws LengthArrayOutOfRangeException If argument matrix has incorrect rows or columns length value.
     */
    public void setMatrix(T[][] matrix) {
        if (matrix != null) {
            if (CheckerLengthArray.checkLengthArray(matrix) && CheckerLengthArray.checkLengthArray(matrix)) {
                this.rows = matrix.length;
                this.columns = matrix[0].length;
                this.matrix = matrix;
            }
        } else {
            throw new NullPointerException("Argument matrix is null.");
        }
    }

    /**
     * Gets the matrix (two-dimensional array) filled with the elements of the encapsulated matrix.
     *
     * @param matrix Matrix (two-dimensional array) to fill.
     * @return Matrix (two-dimensional array) filled with elements of a matrix.
     * @throws NullPointerException If argument matrix is null.
     */
    public T[][] getMatrix(T[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < this.matrix.length; i++) {
                matrix[i] = (T[]) Arrays.copyOfRange(this.matrix, 0, this.matrix[i].length);
            }
        } else {
            throw new NullPointerException("Argument matrix is null.");
        }
        return matrix;
    }

    //todo add doc's
    public int getRows() {
        return this.rows;
    }

    //todo add doc's
    public int getColumns() {
        return this.columns;
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                array = (T[]) Arrays.copyOfRange(this.matrix[indexRow], 0, this.columns);
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                for (int i = 0; i < this.columns; i++) {
                    array.add((T) this.matrix[indexRow][i]);
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.rows; i++) {
                    array[i] = (T) this.matrix[i][indexColumn];
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.rows; i++) {
                    array.setArray((T[]) this.matrix[i][indexColumn]);
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                this.matrix[indexRow] = Arrays.copyOfRange(array, 0, array.length);
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexRow, this.columns)) {
                for (int i = 0; i < this.rows; i++) {
                    this.matrix[indexRow][i] = array.get(i);
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[i][indexColumn] = array[i];
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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
        if (array != null) {
            if (CheckerIndex.checkIndex(indexColumn, this.rows)) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[i][indexColumn] = array.get(i);
                }
            }
        } else {
            throw new NullPointerException("Argument array is null.");
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

    //todo Write an algorithm that implements this functionality using the so-called bubble sort method (permutation of elements using the third variable)
    //     and compare the execution speed with this implementation.

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

    //todo Write an algorithm that implements this functionality using the so-called bubble sort method (permutation of elements using the third variable)
    //     and compare the execution speed with this implementation. */

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

/*
    public static <T> Matrix<T> create() {
        return new Matrix<>();
    }

    public static <T> Matrix<T> create(int rows, int columns) {
        return new Matrix<>(rows, columns);
    }

    public static <T> Matrix<T> create(T[][] matrix) {
        return new Matrix<>(matrix);
    }

    public static <T> Matrix<T> create(Matrix<T> matrix) {
        return new Matrix<>(matrix);
    }
*/


}