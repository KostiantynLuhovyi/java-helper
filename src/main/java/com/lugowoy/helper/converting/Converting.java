package com.lugowoy.helper.converting;

/**
 * Created by Konstantin on 29-Jan-17.
 *
 * @author Konstantin Lugowoy
 *
 * <p>
 * Functional interface declares a function to perform the convert.
 * </p>
 * @param <T> - Type of object encapsulating the data used to convert.
 */
@FunctionalInterface
public interface Converting<T> {

    /**
     * <p>
     * The method (function) that performs the conversion.
     * </p>
     * @param t - The data of this object is used for conversion.
     * */
    void convert(T t);

}
