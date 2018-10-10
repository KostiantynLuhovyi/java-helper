package com.lugowoy.helper.models.matrixes;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.arrays.CreatorArray;
import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.5
 *
 * This class is a matrix model.
 *
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
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

    private int indexElement;

    {
        this.indexElement = 0;
    }

    /**
     * Constructs a default size matrix.
     * {@link Matrix#DEFAULT_ROWS} and {@link Matrix#DEFAULT_COLUMNS}.
     */
    public Matrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
        this.matrix = new Object[rows][columns];
    }

    /**
     * Constructs a matrix of the size passed to the constructor.
     * @param rows Number of rows in the matrix.
     * @param columns Number of columns in the matrix row.
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Object[rows][columns];
    }

    /**
     * Constructs a matrix by initializing it with a two-dimensional array with the argument passed.
     * @param matrix Two-dimensional array to initialize the matrix.
     */
    public Matrix(T[][] matrix) {
        if (matrix != null && (matrix.length > 0 && matrix[0].length > 0)) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
        } else {
            this.rows = DEFAULT_ROWS;
            this.columns = DEFAULT_COLUMNS;
            this.matrix = new Object[rows][columns];
        }
        this.indexElement = this.columns;
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
    public T getElementMatrix(int indexRow, int indexColumn) {
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
    public void setElementMatrix(int indexRow, int indexColumn, T element) {
        //todo question on exclusion.
        if ((indexRow >= 0 && indexRow <= this.rows) && (indexColumn >= 0 && indexColumn <= this.columns)) {
            this.matrix[indexRow][indexColumn] = element;
        } else {
            throw new IllegalArgumentException("Incorrect argument.");
        }
    }

    /**
     * Returns an array column by row index.
     * @param indexRow Row index.
     */
    public Array<T> getColumnArray(int indexRow) {
        Array<T> array;
        if (indexRow >= 0 && indexRow <= this.getRows()) {
            array = FactoryArray.getFactoryArray(new CreatorArray<T>()).create((T[]) this.matrix[indexRow]);
        } else {
            array = FactoryArray.getFactoryArray(new CreatorArray<T>()).create(10);
        }
        return array;
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
        } else {
            this.rows = DEFAULT_ROWS;
            this.columns = DEFAULT_COLUMNS;
            this.matrix = new Object[rows][columns];
        }
        this.indexElement = this.columns;
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

}
