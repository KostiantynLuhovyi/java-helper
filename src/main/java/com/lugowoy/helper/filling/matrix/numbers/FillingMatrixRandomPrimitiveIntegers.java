package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 26.11.2019.
 *
 * @version 1.3
 * @since 2.0
 */
//TODO write the doc's
public class FillingMatrixRandomPrimitiveIntegers implements Filling<MatrixInts> {

    @Override
    public void fill(MatrixInts matrixInts) {
        CheckerMatrix.checkMatrix(matrixInts);
        int[][] integers = new int[matrixInts.getRows()][matrixInts.getColumns()];
        this.fillMatrixRandomPrimitiveInts(integers);
        matrixInts.setMatrix(integers);
    }

    public void fill(int[][] matrixInt) {
        CheckerMatrix.checkMatrix(matrixInt);
        this.fillMatrixRandomPrimitiveInts(matrixInt);
    }

    public int[][] fill(int rows, int columns) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        int[][] ints = new int[rows][columns];
        this.fillMatrixRandomPrimitiveInts(ints);
        return ints;
    }

    public void fill(MatrixInts matrixInts, int bound) {
        CheckerMatrix.checkMatrix(matrixInts);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[][] integers = new int[matrixInts.getRows()][matrixInts.getColumns()];
        this.fillMatrixRandomPrimitiveIntsFromZeroToBound(integers, bound);
        matrixInts.setMatrix(integers);
    }

    public void fill(int[][] matrixInt, int bound) {
        CheckerMatrix.checkMatrix(matrixInt);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillMatrixRandomPrimitiveIntsFromZeroToBound(matrixInt, bound);
    }

    public int[][] fill(int rows, int columns, int bound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[][] ints = new int[rows][columns];
        this.fillMatrixRandomPrimitiveIntsFromZeroToBound(ints, bound);
        return ints;
    }

    public void fill(MatrixInts matrixInts, int lowerBound, int upperBound) {
        CheckerMatrix.checkMatrix(matrixInts);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        int[][] ints = new int[matrixInts.getRows()][matrixInts.getColumns()];
        this.fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        matrixInts.setMatrix(ints);
    }

    public void fill(int[][] matrixInt, int lowerBound, int upperBound) {
        CheckerMatrix.checkMatrix(matrixInt);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(matrixInt, lowerBound, upperBound);
    }

    public int[][] fill(int rows, int columns, int lowerBound, int upperBound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        int[][] ints = new int[rows][columns];
        this.fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillMatrixRandomPrimitiveInts(int[][] matrix) {
        this.fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(matrix, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillMatrixRandomPrimitiveIntsFromZeroToBound(int[][] matrix, int bound) {
        this.fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(matrix, ValuesToFilling.INT_ZERO, bound);
    }

    private void fillMatrixRandomPrimitiveIntsFromLowerToUpperBounds(int[][] matrix, int lowerBound, int upperBound) {
        RandomNumber randomNumber = new RandomNumber();
        for (int[] integers : matrix) {
            Arrays.setAll(integers, j -> randomNumber.generateInt(lowerBound, upperBound));
        }
    }

}
