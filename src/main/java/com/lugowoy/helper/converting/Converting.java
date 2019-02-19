package com.lugowoy.helper.converting;

/**
 * Functional interface declared a contract to perform the conversion of object data.
 * <p>Created by Konstantin on 29-Jan-17.
 *
 * @param <T> Type parameter for converting.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
@FunctionalInterface
public interface Converting<T> {

    /**
     * Function to converts the data of an object passed by parameter.
     *
     * @param t Parameter to converting.
     * @since 1.0
     */
    void convert(T t);

}
