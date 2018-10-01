package com.lugowoy.helper.converting;

/**
 * Created by Konstantin on 29-Jan-17.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * A functional interface that declares a contract and provides a function to perform the conversion of object data.
 *
 * @param <T> The type of object whose data will be converted by the function.
 */

@FunctionalInterface
public interface Converting<T> {

    /**
     * A method (function) that converts the data of an object passed into a parameter.
     *
     * @param t The object whose data will be subject to conversion.
     * @since 1.0
     */
    void convert(T t);

}
