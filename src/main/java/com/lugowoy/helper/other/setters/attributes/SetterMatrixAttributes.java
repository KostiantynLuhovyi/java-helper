package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Matrix;

import java.io.IOException;
import java.io.OutputStream;

import static com.lugowoy.helper.other.setters.attributes.SetterAttributes.*;

/**
 * Created by LugowoyKonstantin on 04.07.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */

//todo refactoring code
//todo edit doc's

public class SetterMatrixAttributes<T> implements SetterAttributes<Matrix<T>> {

    public static final String MSG_ENTER_CONSOLE_ROW = "Enter the number of rows for the matrix : ";
    public static final String MSG_ENTER_CONSOLE_COLUMN = "Enter the number of columns for the matrix : ";

    @Override
    public void setAttributes(Matrix<T> matrix) {
        if (isNonNullObject(matrix)) {
            matrix.setRows(Matrix.DEFAULT_ROWS);
            matrix.setColumns(Matrix.DEFAULT_COLUMNS);
        }
    }

    @Override
    public void setAttributes(Matrix<T> matrix, Reading reader) {
        if (isNonNullObject(matrix)) {
            if (isNonNullReader(reader)) {
                matrix.setRows(reader.readInt());
                matrix.setColumns(reader.readInt());
            }
        }
    }

    public void setAttributes(Matrix<T> matrix, int rows, int columns) {
        if (isNonNullObject(matrix)) {
            matrix.setRows(rows);
            matrix.setColumns(columns);
        }
    }

    //todo Is it worth using this method signature. Perhaps it is better to make it strictly sharpened for console input of attributes.
    public void setAttributes(Matrix<T> matrix, Reading reader, OutputStream outputStreamToMsg,
                              String msgRow, String msgColumn) {
        if (isNonNullObject(matrix)) {
            if (isNonNullReader(reader)) {
                if (isNonNullOutputStream(outputStreamToMsg)) {
                    try {
                        outputStreamToMsg.write(msgRow.getBytes());
                        matrix.setRows(reader.readInt());
                        outputStreamToMsg.write(msgColumn.getBytes());
                        matrix.setColumns(reader.readInt());
                    } catch (IOException ex) {
                        //todo add thoughtful action
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

}
