package com.lugowoy.helper.models.matrixes;

import com.lugowoy.helper.models.Model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 01.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.4
 *
 *
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 */

public class Matrix<T> implements Model {

    /***/
    private static final int DEFAULT_ROWS = 10;
    /***/
    private static final int DEFAULT_COLUMNS = 10;

    private int rows;
    private int columns;

    private Object[][] matrix;

    private int indexElement;

    {
        this.indexElement = 0;
    }

    public Matrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
        this.matrix = new Object[rows][columns];
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Object[rows][columns];
    }

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

    @SuppressWarnings("unchecked")
    public void toMatrix(T[][] matrix) throws IllegalArgumentException {
        if (matrix != null) {
            if (matrix.length <= this.matrix.length && matrix[0].length <= this.matrix[0].length) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i] = (T[]) Arrays.copyOf(this.matrix[i], this.matrix[i].length, this.matrix.getClass());
                }
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i] = (T[]) Arrays.copyOf(this.matrix[i], matrix[i].length, this.matrix.getClass());
                }
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument matrix is null."));
        }
    }

    public Object[][] toMatrix() {
        Object[][] objects = new Object[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            objects[i] = Arrays.copyOf(this.matrix[i], this.matrix[i].length, this.matrix.getClass());
        }
        return objects;
    }

/*    public void add(T obj) {
    }*/

    public void set(int indexRows, int indexColumn, T obj) {
        if (indexRows <= this.matrix.length && indexColumn <= this.matrix[0].length) {
            this.matrix[indexRows][indexColumn] = obj;
        } else {
            this.matrix = new Object[DEFAULT_ROWS][DEFAULT_COLUMNS];
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setMatrix(T[][] matrix) {
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

}
