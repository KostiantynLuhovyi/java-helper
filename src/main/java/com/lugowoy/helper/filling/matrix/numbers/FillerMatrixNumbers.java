package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillerMatrix;
import com.lugowoy.helper.models.matrices.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.2
 */
//todo edit doc's
public class FillerMatrixNumbers<T extends Number> extends FillerMatrix<T> {

    public FillerMatrixNumbers(FillingMatrixNumbers<T> filling) {
        super(filling);
    }

    @Override
    public void fill(Matrix<T> matrix) {
        super.fill(matrix);
    }

    @Override
    public void fill(T[][] matrix) {
        super.fill(matrix);
    }

    @Override
    public T[][] fill(int rows, int columns) {
        return super.fill(rows, columns);
    }

    public void fill(Matrix<T> matrix, T bound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, bound);
    }

    public void fill(T[][] matrix, T bound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, bound);
    }

    public T[][] fill(int rows, int columns, T bound) {
        return ((FillingMatrixNumbers<T>) super.getFilling()).fill(rows, columns, bound);
    }

    public void fill(Matrix<T> matrix, T lowerBound, T upperBound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, lowerBound, upperBound);
    }

    public void fill(T[][] matrix, T lowerBound, T upperBound) {
        ((FillingMatrixNumbers<T>) super.getFilling()).fill(matrix, lowerBound, upperBound);
    }

    public T[][] fill(int rows, int columns, T lowerBound, T upperBound) {
        return ((FillingMatrixNumbers<T>) super.getFilling()).fill(rows, columns, lowerBound, upperBound);
    }

}
