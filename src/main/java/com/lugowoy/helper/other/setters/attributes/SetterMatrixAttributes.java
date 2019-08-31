package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Matrix;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 04.07.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */
//todo add doc's (class, constants, methods)
public class SetterMatrixAttributes<T> implements SetterAttributes<Matrix<T>> {

    String MSG_ENTER_CONSOLE_ROW = "Enter the number of rows for the matrix : ";
    String MSG_ENTER_CONSOLE_COLUMN = "Enter the number of columns for the matrix : ";

    @Override
    public void setAttributes(Matrix<T> matrix) {
        if (isNonNullMatrix(matrix)) {
            matrix.setRows(Matrix.DEFAULT_ROWS);
            matrix.setColumns(Matrix.DEFAULT_COLUMNS);
        }
    }

    @Override
    public void setAttributes(Matrix<T> matrix, Reading reader) {
        if (isNonNullReader(reader)) {
            if (isNonNullMatrix(matrix)) {
                //todo most likely, need to add a check for the attribute to be in the range of valid values.
                matrix.setRows(reader.readInt());
                matrix.setColumns(reader.readInt());
            }
        }
    }

    public void setAttributes(Matrix<T> matrix, int rows, int columns) {
        if (isNonNullMatrix(matrix)) {
            if ((rows > 0 && rows < Integer.MAX_VALUE) && (columns > 0 && columns < Integer.MAX_VALUE)) {
                matrix.setRows(rows);
                matrix.setColumns(columns);
            } else {
                throw new IllegalArgumentException("The arguments rows or columns is out of range.");
            }
        }
    }

    //todo Is it worth using this method signature. Perhaps it is better to make it strictly sharpened for console input of attributes.
    public void setAttributes(Matrix<T> matrix, Reading reader, OutputStream outputStreamToMsg,
                                                String msgRow, String msgColumn) {
        if (isNonNullMatrix(matrix)) {
            if (isNonNullReader(reader)) {
                if (Objects.nonNull(outputStreamToMsg)) {
                    try {
                        //todo most likely, need to add a check for the attribute to be in the range of valid values.
                        outputStreamToMsg.write(msgRow.getBytes());
                        matrix.setRows(reader.readInt());
                        outputStreamToMsg.write(msgColumn.getBytes());
                        matrix.setColumns(reader.readInt());
                    } catch (IOException ex) {
                        //todo add thoughtful action
                        ex.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("The output is equal null.");
                }
            }
        }
    }

    private static <T> boolean isNonNullMatrix(Matrix<T> matrix) {
        if (Objects.isNull(matrix)) {
            throw new NullPointerException("The matrix is equal null.");
        } else {
            return true;
        }
    }

    private static boolean isNonNullReader(Reading reader) {
        if (Objects.isNull(reader)) {
            throw new NullPointerException("The reader is equal null.");
        } else {
            return true;
        }
    }

}
