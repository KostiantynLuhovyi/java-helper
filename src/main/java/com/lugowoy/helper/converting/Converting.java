package com.lugowoy.helper.converting;

/**
 * Created by Konstantin on 29-Jan-17.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A functional interface that declares a contract and provides a function to perform the conversion of object data.
 * </p>
 *
 * @param <T> The type of object whose data will be converted by the function.
 */

@FunctionalInterface
public interface Converting<T> {

    /**
     * <p>
     * A method (function) that converts the data of an object passed into a parameter.
     * </p>
     * @since 1.0
     *
     * @param t The object whose data will be subject to conversion.
     */
    void convert(T t);

}
