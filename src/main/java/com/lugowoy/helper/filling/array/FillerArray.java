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
 * A class that is a certain container that encapsulating and uses an implementation of the functional that fills the array with data.
 * </p>
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @param <T> Type of arrays that is filling with data (values).
 */

public abstract class FillerArray<T> extends Filler<T[]> implements FillableArray<T> {

    /**
     * <p>
     * Creates an object initializing its specific implementation of the functionality to filling the arrays with data (values).
     * </p>
     * @param filling An object encapsulating the implementation of filling the array with data (values).
     */
    public FillerArray(Filling<T[]> filling) {
        super(filling);
    }

}
