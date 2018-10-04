package com.lugowoy.helper.models.matrixes;

import com.lugowoy.helper.factory.Factory;
import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.models.arrays.Array;

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
    public void toMatrix(T[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    matrix[i][j] = (T) this.matrix[i][j];
                }
            }
        } else {
            matrix = (T[][]) new Object[this.getRows()][this.getColumns()];
            this.toMatrix(matrix);
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    @SuppressWarnings("unchecked")
    public T getElementMatrix(int indexRow, int indexColumn) {
        if ((indexRow >= 0 && indexRow <= this.getRows())
                && (indexColumn >= 0 && indexColumn <= this.getColumns())) {
            return (T) this.matrix[indexRow][indexColumn];
        } else {
            throw new IllegalArgumentException("Incorrect argument.");
        }
    }

    public void setElementMatrix(int indexRow, int indexColumn, T element) {
        if ((indexRow >= 0 && indexRow <= this.rows) && (indexColumn >= 0 && indexColumn <= this.columns)) {
            this.matrix[indexRow][indexColumn] = element;
        } else {
            throw new IllegalArgumentException("Incorrect argument.");
        }
    }

    public Array<T> getColumnObjectArray(int indexRow) {
        Array<T> array;
        if (indexRow >= 0 && indexRow <= this.getRows()) {
            array = FactoryArray.getFactoryArray(new CreatorArrayUnknown<T>()).create((T[]) this.matrix[indexRow]);
        } else {
            array = FactoryArray.getFactoryArray(new CreatorArrayUnknown<T>()).create(10);
        }
        return array;
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
