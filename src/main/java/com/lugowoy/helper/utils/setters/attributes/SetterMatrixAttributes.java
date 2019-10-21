package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Konstantin Lugowoy on 04.07.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.7.4
 */
//todo write doc's
public class SetterMatrixAttributes<T> implements SetterAttributes<Matrix<T>> {

    public static final String MSG_ENTER_CONSOLE_ROW = "Enter the number of rows for the matrix : ";
    public static final String MSG_ENTER_CONSOLE_COLUMN = "Enter the number of columns for the matrix : ";

    @Override
    public void setAttributes(Matrix<T> matrix) {
        if (matrix != null) {
            matrix.setRows(Matrix.DEFAULT_ROWS);
            matrix.setColumns(Matrix.DEFAULT_COLUMNS);
        } else {
            throw new NullPointerException("Matrix is null");
        }
    }

    @Override
    public void setAttributes(Matrix<T> matrix, Reading reader) {
        if (matrix != null) {
            if (reader != null) {
                matrix.setRows(reader.readInt());
                matrix.setColumns(reader.readInt());
            } else {
                throw new NullPointerException("Reader is null.");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    public void setAttributes(Matrix<T> matrix, int rows, int columns) {
        if (matrix != null) {
            //todo add checking value of row and column
            matrix.setRows(rows);
            matrix.setColumns(columns);
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

    public void setAttributes(Matrix<T> matrix, Reading reader, OutputStream outputStreamToMsg,
                              String msgRow, String msgColumn) {
        if (matrix != null) {
            if (reader != null) {
                if (outputStreamToMsg != null) {
                    try (outputStreamToMsg) {
                        outputStreamToMsg.write(msgRow.getBytes());
                        matrix.setRows(reader.readInt());
                        outputStreamToMsg.write(msgColumn.getBytes());
                        matrix.setColumns(reader.readInt());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("Output stream is null.");
                }
            } else {
                throw new NullPointerException("Reader is null.");
            }
        } else {
            throw new NullPointerException("Matrix is null.");
        }
    }

}
