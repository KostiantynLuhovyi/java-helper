package com.lugowoy.helper.utils;

/**
 * Thrown when various boundary value is not in the valid range of values.
 * <p> Created by Konstantin Lugowoy on 06.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7.5
 */
public class BoundOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BoundOutOfRangeException(String message) {
        super(message);
    }

}
