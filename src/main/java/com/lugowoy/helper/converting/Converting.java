package com.lugowoy.helper.converting;

/**
 * This is a functional interface declared a contract to perform data conversion in a specific object.
 * <p>Created by Konstantin Lugowoy on 29-Jan-17.
 *
 * @param <T> Type of object encapsulating data for conversion.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
@FunctionalInterface
public interface Converting<T> {

    /**
     * Function for converting data encapsulated in the object obtained in the {@code t} argument.
     *
     * @param t The object encapsulating data for conversion.
     * @since 1.0
     */
    void convert(T t);

}
