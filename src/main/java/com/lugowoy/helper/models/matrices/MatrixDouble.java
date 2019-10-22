package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.utils.CheckerIndex;
import com.lugowoy.helper.utils.CheckerLengthArray;
import com.lugowoy.helper.utils.CheckerMatrix;
import com.rits.cloning.Cloner;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 21.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.0
 */
//todo write doc's
public class MatrixDouble extends AbstractMatrix {

    private double[][] matrix;

    public MatrixDouble() {
        matrix = new double[super.getRowsLength()][super.getRowsLength()];
    }

    public MatrixDouble(int rows, int columns) {
        super(rows, columns);
        this.matrix = new double[super.getRowsLength()][super.getColumnsLength()];
    }

    public MatrixDouble(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            super.setRowsLength(matrix.length);
            super.setColumnsLength(matrix[0].length);
            this.matrix = new Cloner().deepClone(matrix);
        }
    }

    public MatrixDouble(MatrixDouble matrixDouble) {
        if (CheckerMatrix.checkMatrix(matrixDouble)) {
            super.setRowsLength(matrixDouble.getRowsLength());
            super.setColumnsLength(matrixDouble.getColumnsLength());
            this.matrix = new Cloner().deepClone(matrix);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixDouble)) return false;
        if (!super.equals(o)) return false;
        MatrixDouble that = (MatrixDouble) o;
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
        StringBuilder stringBuilder = new StringBuilder("Matrix (doubles) : \n");
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                stringBuilder.append(this.matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setMatrix(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.setRowsLength(matrix.length);
            this.setColumnsLength(matrix[0].length);
            this.matrix = matrix;
        }
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public double[][] toMatrix(double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (super.getRowsLength() == matrix.length && super.getColumnsLength() == matrix[0].length) {
                for (int i = 0; i < super.getRowsLength(); i++) {
                    matrix[i] = this.matrix[i].clone();
                }
            } else {
                //todo add another exception
                throw new RuntimeException("Matrix sizes do not match.");
            }
        }
        return matrix;
    }

    public double[] getRowToArray(int indexRow) {
        double[] array = new double[0];
        if (CheckerIndex.checkIndex(indexRow, super.getColumnsLength())) {
            array = Arrays.copyOfRange(this.matrix[indexRow], 0, super.getColumnsLength());
        }
        return array;
    }

    public double[] getRowToArray(double[] array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, super.getColumnsLength())) {
            if (CheckerIndex.checkIndex(indexRow, super.getColumnsLength())) {
                array = Arrays.copyOfRange(this.matrix[indexRow], 0, super.getColumnsLength());
            }
        }
        return array;
    }

    public double[] getColumnToArray(int indexColumn) {
        double[] array = new double[super.getColumnsLength()];
        if (CheckerIndex.checkIndex(indexColumn, super.getRowsLength())) {
            for (int i = 0; i < super.getRowsLength(); i++) {
                array[i] = this.matrix[i][indexColumn];
            }
        }
        return array;
    }

    public double[] getColumnToArray(double[] array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, super.getRowsLength())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getRowsLength())) {
                for (int i = 0; i < super.getRowsLength(); i++) {
                    array[i] = this.matrix[i][indexColumn];
                }
            }
        }
        return array;
    }

    public void setRowFromArray(double[] array, int indexRow) {
        if (CheckerLengthArray.checkLengthInArray(array, super.getColumnsLength())) {
            if (CheckerIndex.checkIndex(indexRow, super.getColumnsLength())) {
                this.matrix[indexRow] = Arrays.copyOfRange(array, 0, array.length);
            }
        }
    }

    public void setColumnFromArray(double[] array, int indexColumn) {
        if (CheckerLengthArray.checkLengthInArray(array, super.getRowsLength())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getRowsLength())) {
                for (int i = 0; i < super.getColumnsLength(); i++) {
                    this.matrix[i][indexColumn] = array[i];
                }
            }
        }
    }

    public void compressRow(int indexRow) {
        if (CheckerIndex.checkIndex(indexRow, super.getRowsLength())) {
            double[][] tmpMatrix = new double[super.getRowsLength() - 1][super.getColumnsLength()];
            int tmpIndexRow = 0;
            for (int i = 0; i < super.getRowsLength(); i++) {
                for (int j = 0; j < super.getColumnsLength(); j++) {
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
        if (CheckerIndex.checkIndex(indexColumn, super.getColumnsLength())) {
            double[][] tmpMatrix = new double[super.getRowsLength()][super.getColumnsLength() - 1];
            int tmpIndexColumn = 0;
            for (int i = 0; i < super.getRowsLength(); i++) {
                for (int j = 0; j < super.getColumnsLength(); j++) {
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
        if (CheckerIndex.checkIndex(indexRow, super.getRowsLength())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumnsLength())) {
                elementValue = this.matrix[indexRow][indexColumn];
            }
        }
        return elementValue;
    }

    public void setElement(double element, int indexRow, int indexColumn) {
        if (CheckerIndex.checkIndex(indexRow, super.getRowsLength())) {
            if (CheckerIndex.checkIndex(indexColumn, super.getColumnsLength())) {
                this.matrix[indexRow][indexColumn] = element;
            }
        }
    }

}
