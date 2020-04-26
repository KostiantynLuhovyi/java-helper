package com.lugowoy.helper.converting;

import java.util.Objects;

/**
 * This class is a container that takes a specific implementation of functionality to perform data conversion in a specific object.
 * <p>Created by Konstantin Lugowoy on 29-Jan-17.
 *
 * @param <T> Type of object encapsulating data for conversion.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
public class Converter<T> {

    private Converting<T> converting;

    /**
     * Constructors a new object of the {@link Converter} class.
     * The {@code converting} argument provides a specific implementation of the data conversion functionality.
     *
     * @param converting The specific implementation of functionality for data conversion.
     * @since 1.0
     */
    public Converter(Converting<T> converting) {
        this.converting = converting;
    }

    /**
     * Converting data encapsulated in an object obtained in {@code t} argument.
     *
     * @param t The object encapsulating data for conversion.
     * @since 1.0
     */
    public void convert(T t) {
        converting.convert(t);
    }

    /**
     * Sets the implementation of the functionality for converting data.
     * The necessary functionality provide by the class object implementing
     * the contract interface {@link Converting}.
     *
     * @param converter the object providing functionality for data conversion.
     *
     * @throws NullPointerException if the {@code converter} object is null.
     * @since 3.0
     */
    public void setConverter(final Converting<T> converter) {
        Objects.requireNonNull(converter, "Converter is null.");
        this.converter = converter;
    }

}
