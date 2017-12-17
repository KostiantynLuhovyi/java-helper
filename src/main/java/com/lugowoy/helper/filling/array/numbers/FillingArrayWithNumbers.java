package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array the numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see FillableArrayWithNumbers
 * @param <T> Type of arrays that is filling the numeric data (values).
 */

public abstract class FillingArrayWithNumbers<T extends Number> extends FillingArray<T> implements FillableArrayWithNumbers<T> {

}
