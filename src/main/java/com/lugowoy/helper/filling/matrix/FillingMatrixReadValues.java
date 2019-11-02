package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.2
 */
//todo edit doc's
public abstract class FillingMatrixReadValues<T> extends FillingReadValues implements FillingMatrix<T> {

    public FillingMatrixReadValues(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadValues(Reading reading) {
        super(reading);
    }

    @Override
    public abstract void fill(Matrix<T> matrix);

    @Override
    public abstract void fill(T[][] matrix);

    @Override
    public abstract T[][] fill(int rows, int columns);

}
