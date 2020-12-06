package com.lugowoy.helper.filling.matrix;

import com.lugowoy.helper.filling.FillingReadValues;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * <p>Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @since 1.2
 */
//todo write documentation
public abstract class FillingMatrixReadValues extends FillingReadValues {

    public FillingMatrixReadValues(@NotNull final Reader reader) {
        super(reader);
    }

}
