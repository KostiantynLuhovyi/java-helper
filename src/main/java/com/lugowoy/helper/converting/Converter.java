package com.lugowoy.helper.converting;

/**
 * Class that is a kind of container that encapsulates a function for performing data conversion in a concrete object.
 * <p>Created by Konstantin on 29-Jan-17.
 *
 * @param <T> The type of object whose data will be converted.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
public class Converter<T> {

    private Converting<T> converting;

    /**
     * Constructors a new object of the {@link Converter} class.
     * The parameter {@link Converter#converting} provides the implementation of the function to perform the conversion.
     *
     * @param converting The parameter provides the implementation of the function to perform the conversion.
     * @since 1.0
     */
    public Converter(Converting<T> converting) {
        this.converting = converting;
    }

    /**
     * Method that performs the conversion of object data passed by a parameter to a method.
     * The method delegates the execution of the function which the object was initialized upon creation.
     *
     * @param t The object passed by the parameter whose data is being converted.
     * @since 1.0
     */
    public void convert(T t) {
        converting.convert(t);
    }

}
