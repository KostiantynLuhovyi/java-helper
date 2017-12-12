package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillingArray;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array with numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayNumbers
 * @param <T> The type of the array and, accordingly, the type of numeric data (values) by which the array will be filled.
 */
//todo Проверить документацию и корректность класса.
public abstract class FillingArrayNumbers<T extends Number> extends FillingArray<T> implements FillableArrayNumbers<T> {
}