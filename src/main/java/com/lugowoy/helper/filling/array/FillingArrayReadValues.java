package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.models.arrays.Array;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * The abstract class encapsulates and provides functionality to fill objects of
 * the {@link Array} class and arrays of reference data types of descendants of
 * the {@link Number} class. The data reading for filling uses objects of {@link
 * Reader} classes (or subclasses).
 * <p> Created by Konstantin Lugowoy on 21-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.FillingReadValues
 */
//TODO review documentation
public abstract class FillingArrayReadValues extends FillingReadValues {

    /**
     * Constructs a new object, initializing the implementation of reading data
     * to fill. The implementation of data reading provided by class objects
     * {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    protected FillingArrayReadValues(@NotNull final Reader reader) {
        super(reader);
    }

}
