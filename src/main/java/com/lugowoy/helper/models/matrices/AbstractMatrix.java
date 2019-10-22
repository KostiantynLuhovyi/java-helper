package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.utils.CheckerMatrix;

import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 22.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.0
 */
//todo write doc's
public class AbstractMatrix implements Model {

    /**
     * Default getRowsLength of the matrix.
     */
    public static final int DEFAULT_ROWS = 10;

    /**
     * Default getColumnsLength of the matrix.
     */
    public static final int DEFAULT_COLUMNS = 10;

    private int rows;
    private int columns;

    public AbstractMatrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
    }

    public AbstractMatrix(int rows, int columns) {
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            this.rows = rows;
            this.columns = columns;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMatrix)) return false;
        AbstractMatrix that = (AbstractMatrix) o;
        return rows == that.rows &&
                columns == that.columns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns);
    }

    public void setRowsLength(int rows) {
        if (CheckerMatrix.checkRows(rows)) {
            this.rows = rows;
        }
    }

    public int getRowsLength() {
        return this.rows;
    }

    public void setColumnsLength(int columns) {
        if (CheckerMatrix.checkColumns(columns)) {
            this.columns = columns;
        }
    }

    public int getColumnsLength() {
        return this.columns;
    }



}
