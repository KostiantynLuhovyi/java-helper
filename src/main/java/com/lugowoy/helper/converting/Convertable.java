package com.lugowoy.helper.converting;

/**
 * Created by Konstantin on 29-Jan-17.
 *
 * @author Konstantin Lugowoy
 *
 * <p>
 * Interface declares the contract for the implementation of the convert.
 * </p>
 * @param <T> - Type of object encapsulating the data used to convert.
 */
public interface Convertable<T> {

    /**
     * <p>
     * The method performs the implemented conversion using the data of the object transferred to the parameter.
     * </p>
     * @param t - The data of this object is used for conversion.
     */
    void convert(T t);

}
