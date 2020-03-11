package com.lugowoy.helper.utils;

/**
 * Thrown when the value is out of range.
 * <p> Created by Konstantin Lugowoy on 27.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.8
 */
public class ValueOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ValueOutOfRangeException(String message) {
        super(message);
    }

}
