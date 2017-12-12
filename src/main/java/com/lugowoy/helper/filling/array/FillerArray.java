package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filler;
import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillableArray;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * A class that is a certain container that receives and uses an implementation of the functional
 *  that fills the array with data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @param <T> The type of the array and, accordingly, the type of data (values) by which the array will be filled.
 */
//todo Проверить документацию, корректность и при необходимости провести рефакторинг.
public abstract class FillerArray<T> extends Filler<T[]> implements FillableArray<T> {

    /**
     * <p>
     * Constructor with parameter.
     * The parameter accepts an object encapsulating the implementation of the interface for filling the object with data (values).
     * </p>
     * @param filling A reference to the object encapsulating the implementation of the interface to fill the array with data (values).
     */
    public FillerArray(Filling<T[]> filling) {
        super(filling);
    }

}