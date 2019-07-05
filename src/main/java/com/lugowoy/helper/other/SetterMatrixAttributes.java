package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Matrix;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 04.07.2019.
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's
public interface SetterMatrixAttributes {

    String MSG_ENTER_CONSOLE_ROW = "Enter the number of rows for the matrix : ";
    String MSG_ENTER_CONSOLE_COLUMN = "Enter the number of columns for the matrix : ";

    static <T> void setMatrixAttributes(Matrix<T> matrix, Reading reader) {
        if (Objects.nonNull(reader)) {
            if (Objects.nonNull(matrix)) {
                matrix.setRows(reader.readInt());
                matrix.setColumns(reader.readInt());
            } else {
                throw new NullPointerException("The matrix is equal null.");
            }
        } else {
            throw new NullPointerException("The reader is equal null.");
        }
    }

    static <T> void setMatrixAttributes(Matrix<T> matrix, Reading reader, OutputStream outputMsg,
                                        String msgRow, String msgColumn) {
        if (Objects.nonNull(reader)) {
            if (Objects.nonNull(matrix)) {
                if (Objects.nonNull(outputMsg)) {
                    try {
                        outputMsg.write(msgRow.getBytes());
                        matrix.setRows(reader.readInt());
                        outputMsg.write(msgColumn.getBytes());
                        matrix.setColumns(reader.readInt());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("The output is equal null.");
                }
            } else {
                throw new NullPointerException("The matrix is equal null.");
            }
        } else {
            throw new NullPointerException("The reader is equal null.");
        }
    }

    static <T> void setMatrixAttributes(Matrix<T> matrix, int rows, int columns) {
        if (Objects.nonNull(matrix)) {
            if ((rows > 0 && rows < Integer.MAX_VALUE) && (columns > 0 && columns < Integer.MAX_VALUE)) {
                matrix.setRows(rows);
                matrix.setColumns(columns);
            } else {
                throw new IllegalArgumentException("The arguments rows or columns is out of range.");
            }
        } else {
            throw new NullPointerException("The matrix is equal null.");
        }
    }

}
