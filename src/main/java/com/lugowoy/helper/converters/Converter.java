package com.lugowoy.helper.converters;

import java.util.Objects;

/**
 * The class provides a container for implementing the functionality to perform
 * data conversion encapsulated in a specific object.
 * <p>
 * Created by Konstantin Lugowoy on 29-Jan-17.
 *
 * @param <T> the type of object encapsulating data for conversion.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 */
public class Converter<T> {

    private Converting<T> converter;

    /**
     * Constructs an object of this class, initializing it with an
     * implementation of the functionality for data conversion.The necessary
     * functionality provide by the class object implementing the contract
     * interface {@link Converting}.
     *
     * @param converter the object providing functionality for data conversion.
     *
     * @throws NullPointerException if the {@code converter} object is null.
     * @since 1.0
     */
    public Converter(final Converting<T> converter) {
        Objects.requireNonNull(converter, "Converter is null.");
        this.converter = converter;
    }

    /**
     * Converts data encapsulated in an object {@code tObj}.
     *
     * @param tObj the object encapsulating data for conversion.
     *
     * @since 1.0
     */
    public void convert(final T tObj) {
        converter.convert(tObj);
    }

    /**
     * Sets the implementation of the functionality for converting data. The
     * necessary functionality provide by the class object implementing the
     * contract interface {@link Converting}.
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
