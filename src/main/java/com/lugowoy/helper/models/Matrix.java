package com.lugowoy.helper.models;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class is a matrix model.
 * <p>Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.5
 */
public class Matrix<T> implements Model {

    /**
     * Constant provides a default value of rows of the matrix.
     */
    public static final int DEFAULT_ROWS = 10;
    /**
     * Constant provides a default value of columns of the matrix.
     */
    public static final int DEFAULT_COLUMNS = 10;

    private int rows;
    private int columns;

    private Object[][] matrix;

    private Matrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
        this.matrix = new Object[rows][columns];
    }

    private Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Object[rows][columns];
    }

    private Matrix(T[][] matrix) {
        if (matrix != null && (matrix.length > 0 && matrix[0].length > 0)) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            this.matrix = matrix;
        } else {
            this.rows = DEFAULT_ROWS;
            this.columns = DEFAULT_COLUMNS;
            this.matrix = new Object[rows][columns];
        }
    }

    /**
     * Method overridden from class Object.
     * Implemented for comparison on equality of objects of this class.
     * @param o Object reference for comparison.
     * @return The result of the comparison of objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return getRows() == matrix1.getRows() &&
                getColumns() == matrix1.getColumns() &&
                Arrays.equals(matrix, matrix1.matrix);
    }

    /**
     * Method overridden from class Object.
     * Implemented to display hashcode for an object of this class.
     * @return Object hashcode.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(getRows(), getColumns());
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    /**
     * Method overridden from class Object.
     * Implemented to output an object of this class as a string.
     * @return The state of this object as a string.
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

    /**
     * Returns the matrix element by row index and column index.
     * @param indexRow Matrix row index.
     * @param indexColumn Matrix column index.
     */
    @SuppressWarnings("unchecked")
    public T getElement(int indexRow, int indexColumn) {
        //todo question on exclusion.
        if ((indexRow >= 0 && indexRow <= this.getRows())
                && (indexColumn >= 0 && indexColumn <= this.getColumns())) {
            return (T) this.matrix[indexRow][indexColumn];
        } else {
            throw new IllegalArgumentException("Incorrect argument.");
        }
    }

    /**
     * Sets the matrix element by row index and column index.
     * @param indexRow Matrix row index.
     * @param indexColumn Matrix column index.
     * @param element Element to set.
     */
    public void setElement(int indexRow, int indexColumn, T element) {
        //todo question on exclusion.
        if ((indexRow >= 0 && indexRow <= this.rows) && (indexColumn >= 0 && indexColumn <= this.columns)) {
            this.matrix[indexRow][indexColumn] = element;
        } else {
            throw new IllegalArgumentException("Incorrect argument.");
        }
    }

    //todo new method. add doc's.
    public void deleteElement(int indexRow, int indexColumn) {
        if ((indexRow >= 0 && indexRow <= this.rows) && (indexColumn >= 0 && indexColumn <= this.columns)) {
            this.matrix[indexRow][indexColumn] = null;
        }
    }

    //todo new method. add doc's.
    public void deleteRow(int indexRow) {
        if (indexRow >= 0 && indexRow <= this.rows) {
            for (int i = 0; i < this.columns; i++) {
                this.matrix[indexRow][i] = null;
            }
        }
    }

    //todo new method. add doc's.
    public void deleteColumn(int indexColumn) {
        if (indexColumn >= 0 && indexColumn <= this.columns) {
            for (int i = 0; i < this.rows; i++) {
                this.matrix[i][indexColumn] = null;
            }
        }
    }

    /**
     * Returns an array column by row index.
     * @param indexColumn Row index.
     */
    //todo new method. add checks. add doc's.
    @SuppressWarnings("unchecked")
    public Array<T> getColumn(int indexColumn) {
        Array<T> array = Array.create(this.columns);
        if (indexColumn >= 0 && indexColumn <= this.rows) {
            for (int i = 0; i < this.rows; i++) {
                array.add((T) this.matrix[i][indexColumn]);
            }

        }
        return array;
    }

    //todo new method. add checks. add doc's.
    @SuppressWarnings("unchecked")
    public T[] getColumn(T[] array, int indexColumn) {
        if (indexColumn >= 0 && indexColumn <= this.rows) {
            if (array != null) {
                for (int i = 0; i < this.rows; i++) {
                    array[i] = (T) this.matrix[i][indexColumn];
                }
            }
        }
        return array;
    }

    //todo new method. add checks. add doc's.
    @SuppressWarnings("unchecked")
    public Array<T> getColumn(Array<T> array, int indexColumn) {
        if (indexColumn >= 0 && indexColumn <= this.rows) {
            if (array != null) {
                for (int i = 0; i < this.rows; i++) {
                    array.add((T) this.matrix[i][indexColumn]);
                }
            }
        }
        return array;
    }

    //todo new method. add checks. add doc's.
    @SuppressWarnings("unchecked")
    public Array<T> getRow(int indexRow) {
        Array<T> array = Array.create(this.rows);
        if (indexRow >= 0 && indexRow <= this.columns) {
            for (int i = 0; i < this.columns; i++) {
                array.add((T) this.matrix[indexRow][i]);
            }
        }
        return array;
    }

    //todo new method. add doc's.
    @SuppressWarnings("unchecked")
    public T[] getRow(T[] array, int indexRow) {
        if (indexRow >= 0 && indexRow <= this.columns) {
            if (array != null) {
                for (int i = 0; i < this.columns; i++) {
                    array[i] = (T) this.matrix[indexRow][i];
                }
            }
        }
        return array;
    }

    //todo new method. add doc's.
    @SuppressWarnings("unchecked")
    public Array<T> getRow(Array<T> array, int indexRow) {
        if (indexRow >= 0 && indexRow <= this.columns) {
            if (array != null) {
                for (int i = 0; i < this.columns; i++) {
                    array.add((T) this.matrix[indexRow][i]);
                }
            }
        }
        return array;
    }

    //todo new method. add doc's.
    //todo check the lengths to avoid ArrayIndexOutOfBoundsException.
    public void setColumn(T[] array, int indexRow) {
        if (array != null) {
            if (indexRow >= 0 && indexRow <= this.rows) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[indexRow][i] = array[i];
                }
            }
        }
    }

    //todo new method. add doc's.
    //todo check the lengths to avoid ArrayIndexOutOfBoundsException.
    public void setColumn(Array<T> array, int indexRow) {
        if (array != null) {
            if (indexRow >= 0 && indexRow <= this.rows) {
                for (int i = 0; i < this.columns; i++) {
                    this.matrix[indexRow][i] = array.get(i);
                }
            }
        }
    }

    //todo new method. add doc's.
    //todo check the lengths to avoid ArrayIndexOutOfBoundsException.
    public void setRow(T[] array, int indexColumn) {
        if (array != null) {
            if (indexColumn >= 0 && indexColumn <= this.columns) {
                for (int i = 0; i < this.rows; i++) {
                    this.matrix[i][indexColumn] = array[i];
                }
            }
        }
    }

    //todo new method. add doc's.
    //todo check the lengths to avoid ArrayIndexOutOfBoundsException.
    public void setRow(Array<T> array, int indexColumn) {
        if (array != null) {
            if (indexColumn >= 0 && indexColumn <= this.columns) {
                for (int i = 0; i < this.rows; i++) {
                    this.matrix[i][indexColumn] = array.get(i);
                }
            }
        }
    }

    /**
     * Sets the value of the matrix by a two-dimensional array with the argument passed.
     * @param matrix Two-dimensional array for matrix initialization.
     */
    public void setMatrix(T[][] matrix) {
        if (matrix != null && (matrix.length > 0 && matrix[0].length > 0)) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            this.matrix = matrix;
        } /*else {
            this.rows = DEFAULT_ROWS;
            this.columns = DEFAULT_COLUMNS;
            this.matrix = new Object[rows][columns];
        }*/
    }

    //todo new method. add doc's. (not quadratic (4/5))
    /* Write an algorithm that implements this functionality using the so-called bubble sort method (permutation of elements using the third variable)
     * and compare the execution speed with this implementation. */
    @SuppressWarnings("unchecked")
    public void compressRow(int indexRow) {
        if (indexRow >= 0 && indexRow <= this.rows) {
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

    //todo new method. add doc's. (not quadratic (4/5))
    /* Write an algorithm that implements this functionality using the so-called bubble sort method (permutation of elements using the third variable)
     * and compare the execution speed with this implementation. */
    @SuppressWarnings("unchecked")
    public void compressColumn(int indexColumn) {
        if (indexColumn >= 0 && indexColumn <= this.columns) {
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
     * Returns the number of rows in the matrix.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns the number of columns in the matrix.
     */
    public int getColumns() {
        return this.columns;
    }

    //todo add doc's

    @SuppressWarnings("unchecked")
    public T[][] getMatrix(T[][] matrix) {
        if (matrix != null) {
            if (matrix.length <= this.rows) {
                for (int i = 0; i < this.matrix.length; i++) {
                    matrix[i] = (T[]) Arrays.copyOf(this.matrix[i], this.matrix[i].length);
                }
            }
        }
        return matrix;
    }

    public static <T> Matrix<T> create() {
        return new Matrix<>();
    }

    public static <T> Matrix<T> create(int rows, int columns) {
        return new Matrix<>(rows, columns);
    }

    public static <T> Matrix<T> create(T[][] matrix) {
        return new Matrix<>(matrix);
    }

}
