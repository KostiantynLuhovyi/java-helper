package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerIndex;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 2.0
 */
//todo write doc's
public class MatrixDoubles extends AbstractMatrix {

    private double[][] matrix;

    public MatrixDoubles() {
        matrix = new double[super.getRows()][super.getRows()];
    }

    public MatrixDoubles(int rows, int columns) {
        super(rows, columns);
        this.matrix = new double[super.getRows()][super.getColumns()];
    }

    public MatrixDoubles(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            super.setRows(matrix.length);
            super.setColumns(matrix[0].length);
            this.matrix = matrix;
        }
    }

    public MatrixDoubles(MatrixDoubles matrixDoubles) {
        if (CheckerMatrix.checkMatrix(matrixDoubles)) {
            super.setRows(matrixDoubles.getRows());
            super.setColumns(matrixDoubles.getColumns());
            this.matrix = matrixDoubles.getMatrix();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixDoubles)) return false;
        if (!super.equals(o)) return false;
        MatrixDoubles that = (MatrixDoubles) o;
        return Arrays.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName() + " [ ");
        for (int i = 0; i < this.matrix.length; i++) {
            stringBuilder.append("[ ");
            for (int j = 0; j < this.matrix[i].length; j++) {
                stringBuilder.append(this.matrix[i][j]).append(" ");
            }
            stringBuilder.append("]\n\t\t\t    ");
        }
        stringBuilder.append("rows:").append(this.getRows()).append(", columns:").append(this.getColumns()).append(" ]");
        return stringBuilder.toString();
    }

    public void setMatrix(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.setRows(matrix.length);
            this.setColumns(matrix[0].length);
            this.matrix = matrix;
        }
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public double[][] toMatrix(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (super.getRows() == matrix.length && super.getColumns() == matrix[0].length) {
                for (int i = 0; i < super.getRows(); i++) {
                    matrix[i] = Arrays.copyOf(this.matrix[i], this.matrix[i].length);
                }
            }
        }
        return matrix;
    }

    public double[][] toAnyMatrix(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(this.matrix[i], matrix[i].length);
            }
        }
        return matrix;
    }

    public double[] getRowToArray(int indexRow) {
        double[] array = new double[0];
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            array = Arrays.copyOf(this.matrix[indexRow], this.matrix[indexRow].length);
        }
        return array;
    }

    public double[] getRowToArray(double[] array, int indexRow) {
        if (CheckerArray.checkLengthInArray(array, super.getRows())) {
            if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
                array = Arrays.copyOf(this.matrix[indexRow], this.matrix[indexRow].length);
            }
        }
        return array;
    }

    public double[] getColumnToArray(int indexColumn) {
        double[] array = new double[super.getColumns()];
        if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
            for (int i = 0; i < super.getRows(); i++) {
                if (indexColumn <= this.matrix[i].length) {
                    array[i] = this.matrix[i][indexColumn];
                }
            }
        }
        return array;
    }

    public double[] getColumnToArray(double[] array, int indexColumn) {
        if (CheckerArray.checkLengthInArray(array, super.getColumns())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
                for (int i = 0; i < super.getRows(); i++) {
                    if (indexColumn <= this.matrix[i].length) {
                        array[i] = this.matrix[i][indexColumn];
                    }
                }
            }
        }
        return array;
    }

    public void setRowFromArray(double[] array, int indexRow) {
        if (CheckerArray.checkLengthInArray(array, super.getRows())) {
            if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
                this.matrix[indexRow] = Arrays.copyOf(array, array.length);
            }
        }
    }

    public void setColumnFromArray(double[] array, int indexColumn) {
        if (CheckerArray.checkLengthInArray(array, super.getRows())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getRows())) {
                for (int i = 0; i < super.getRows(); i++) {
                    this.matrix[i][indexColumn] = array[i];
                }
            }
        }
    }

    public void compressRow(int indexRow) {
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            double[][] tmpMatrix = new double[super.getRows() - 1][super.getColumns()];
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
            this.setMatrix(tmpMatrix);
        }
    }

    public void compressColumn(int indexColumn) {
        if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
            double[][] tmpMatrix = new double[super.getRows()][super.getColumns() - 1];
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
            this.setMatrix(tmpMatrix);
        }
    }

    public double getElement(int indexRow, int indexColumn) {
        double elementValue = 0;
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
                elementValue = this.matrix[indexRow][indexColumn];
            }
        }
        return elementValue;
    }

    public void setElement(int indexRow, int indexColumn, double element) {
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
                this.matrix[indexRow][indexColumn] = element;
            }
        }
    }

}
