package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * The class is the root of the class hierarchy encapsulating the interface to implementation
 *                                                                                    of the object's filling with data.
 * </p>
 * @see com.lugowoy.helper.filling.Fillable
 * @param <T> Type of object that is filling with data.
 */

public abstract class Filling<T> implements Fillable<T> {

    /**
     * <p>
     * The method fills with the object data.
     * </p>
     * @param t The object to fill it with data.
     * @return A reference to the object filled with data.
     */
    @Override
    public abstract T fill(T t);

}
