package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * The interface declares a contract to implement the filling of the object with data.
 * </p>
 * @param <T> Type of object that is filling with data.
 */
//todo Проверить документацию и корректность интерфейса.
public interface Fillable<T> {

     /**
     * <p>
     * The method fills with the object data.
     * </p>
     * @param t The object to fill it with data.
     * @return A reference to the object filled with data.
     */
    T fill(T t);

}