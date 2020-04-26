package com.lugowoy.helper.converters;

/**
 * This is a functional interface declared a contract to perform data
 * conversion in a specific object.
 * <p>
 * Created by Konstantin Lugowoy on 29-Jan-17.
 *
 * @param <T> the type of object encapsulating data for conversion.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
@FunctionalInterface
public interface Converting<T> {

    /**
     * Converts data encapsulated in an object {@code tObj}.
     *
     * @param t the object encapsulating data for conversion.
     *
     * @since 1.0
     */
    void convert(T t);

}
