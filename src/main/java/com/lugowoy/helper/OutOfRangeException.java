package com.lugowoy.helper;

/**
 * Thrown when something is out of range.
 *
 * Created by Konstantin Lugowoy on 02.05.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
public class OutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by a call
     * to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later
     * retrieval by the {@link #getMessage()} method.
     */
    public OutOfRangeException(final String message) {
        super(message);
    }

}
