package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 25.06.2019.
 * @version 1.3
 * @since 1.7.2
 */
//todo add doc's
public class MatrixAttributes {

    public static final String MSG_ENTER_CONSOLE_ROW = "Enter the number of rows for the matrix : ";
    public static final String MSG_ENTER_CONSOLE_COLUMN = "Enter the number of columns for the matrix : ";

    private int rows;
    private int columns;

    public MatrixAttributes() {
        this.rows = 1;
        this.columns = 2;
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

    public void setMatrixAttributes(Reading reader) {
        if (Objects.nonNull(reader)) {
            this.rows = reader.readInt();
            this.columns = reader.readInt();
        } else {
            throw new NullPointerException("The reader is equal null.");
        }
    }

    public void setMatrixAttributes(Reading reader, OutputStream outputMsg,
                                    String msgRow, String msgColumn) {
        if (Objects.nonNull(reader)) {
            try {
                outputMsg.write(msgRow.getBytes());
                this.rows = reader.readInt();
                outputMsg.write(msgColumn.getBytes());
                this.columns = reader.readInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new NullPointerException("The reader is equal null.");
        }
    }

    public void setMatrixAttributes(int rows, int columns) {
        if ((rows > 0 && rows < Integer.MAX_VALUE) && (columns > 0 && columns < Integer.MAX_VALUE)) {
            this.rows = rows;
            this.columns = columns;
        } else {
            throw new IllegalArgumentException("The arguments rows or columns is incorrect.");
        }
    }

}
