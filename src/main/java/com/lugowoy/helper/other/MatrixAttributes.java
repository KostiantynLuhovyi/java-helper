package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 25.06.2019.
 * @version 1.1
 * @since 1.7.2
 */
// add doc's
public class MatrixAttributes {

    private int rows = 1;
    private int columns = 1;

    private MatrixAttributes() {
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public static MatrixAttributes getInstanceMatrixAttributes(Reading reader) {
        if (Objects.nonNull(reader)) {
            MatrixAttributes matrixAttributes = new MatrixAttributes();
            matrixAttributes.setRows(readMatrixRow(reader));
            matrixAttributes.setColumns(readMatrixColumn(reader));
            return matrixAttributes;
        } else {
            throw new NullPointerException("The reader is equal null.");
        }
    }

    public static MatrixAttributes getInstanceMatrixAttributes(int rows, int columns) {
        if ((rows > 0 && rows < Integer.MAX_VALUE) && (columns > 0 && columns < Integer.MAX_VALUE)) {
            MatrixAttributes matrixAttributes = new MatrixAttributes();
            matrixAttributes.setRows(rows);
            matrixAttributes.setColumns(columns);
            return matrixAttributes;
        } else {
            throw new IllegalArgumentException("The arguments rows or columns is incorrect.");
        }
    }

    private static int readMatrixRow(Reading reader) {
        System.out.println("Enter the number of rows for the matrix : ");
        return reader.readInt();
    }

    private static int readMatrixColumn(Reading reader) {
        System.out.println("Enter the number of columns for the matrix : ");
        return reader.readInt();
    }

}
