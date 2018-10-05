package com.lugowoy.helper.filling.matrixes;

import com.lugowoy.helper.filling.FillingReadingValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrixes.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public abstract class FillingMatrixReadingValues<T> extends FillingReadingValues implements FillingMatrix<T> {

    public FillingMatrixReadingValues(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadingValues(Reading reading) {
        super(reading);
    }

    @Override
    public abstract void fill(Matrix<T> matrix);

    @Override
    public abstract void fill(T[][] matrix);

    @Override
    public abstract T[][] fill(int rows, int columns);

}
