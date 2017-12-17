package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillableArray;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array with data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @param <T> Type of arrays that is filling with data (values).
 */

public abstract class FillingArray<T> extends Filling<T[]> implements FillableArray<T> {

}
