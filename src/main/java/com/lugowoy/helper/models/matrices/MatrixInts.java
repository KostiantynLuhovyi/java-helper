package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.utils.checking.CheckerIndex;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 2.0
 */
//todo write doc's
public class MatrixInts extends AbstractMatrix {

    private int[][] matrix;

    public MatrixInts() {
        matrix = new int[super.getRows()][super.getRows()];
    }

    public MatrixInts(int rows, int columns) {
        super(rows, columns);
        this.matrix = new int[super.getRows()][super.getColumns()];
    }

    public MatrixInts(int[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            super.setRows(matrix.length);
            super.setColumns(matrix[0].length);
            this.matrix = matrix;
        }
    }

    public MatrixInts(MatrixInts matrixInts) {
        if (CheckerMatrix.checkMatrix(matrixInts)) {
            super.setRows(matrixInts.getRows());
            super.setColumns(matrixInts.getColumns());
            this.matrix = matrixInts.getMatrix();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixInts)) return false;
        if (!super.equals(o)) return false;
        MatrixInts matrixInts = (MatrixInts) o;
        return Arrays.equals(matrix, matrixInts.matrix);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                stringBuilder.append(this.matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setMatrix(int[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.setRows(matrix.length);
            this.setColumns(matrix[0].length);
            this.matrix = matrix;
        }
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int[][] toMatrix(int[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (super.getRows() == matrix.length && super.getColumns() == matrix[0].length) {
                for (int i = 0; i < super.getRows(); i++) {
                    matrix[i] = Arrays.copyOf(this.matrix[i], this.matrix[i].length);
                }
            }
        }
        return matrix;
    }

    public int[][] toAnyMatrix(int[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(this.matrix[i], matrix[i].length);
            }
        }
        return matrix;
    }

    public int[] getRowToArray(int indexRow) {
        int[] array = new int[0];
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            array = Arrays.copyOf(this.matrix[indexRow], this.matrix[indexRow].length);
        }
        return array;
    }

    public int[] getRowToArray(int[] array, int indexRow) {
        if (CheckerArray.checkLengthInArray(array, super.getRows())) {
            if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
                array = Arrays.copyOf(this.matrix[indexRow], this.matrix[indexRow].length);
            }
        }
        return array;
    }

    public int[] getColumnToArray(int indexColumn) {
        int[] array = new int[super.getColumns()];
        if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
            for (int i = 0; i < super.getRows(); i++) {
                if (indexColumn <= this.matrix[i].length) {
                    array[i] = this.matrix[i][indexColumn];
                }
            }
        }
        return array;
    }

    public int[] getColumnToArray(int[] array, int indexColumn) {
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

    public void setRowFromArray(int[] array, int indexRow) {
        if (CheckerArray.checkLengthInArray(array, super.getRows())) {
            if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
                this.matrix[indexRow] = Arrays.copyOf(array, array.length);
            }
        }
    }

    public void setColumnFromArray(int[] array, int indexColumn) {
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
            this.setMatrix(tmpMatrix);
        }
    }

    public void compressColumn(int indexColumn) {
        if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
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
            this.setMatrix(tmpMatrix);
        }
    }

    public int getElement(int indexRow, int indexColumn) {
        int elementValue = 0;
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
                elementValue = this.matrix[indexRow][indexColumn];
            }
        }
        return elementValue;
    }

    public void setElement(int indexRow, int indexColumn, int element) {
        if (CheckerIndex.checkIndex(indexRow, super.getRows())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumns())) {
                this.matrix[indexRow][indexColumn] = element;
            }
        }
    }

}
