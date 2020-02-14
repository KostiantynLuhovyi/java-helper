package com.lugowoy.helper.utils;

/**
 * Class exception.
 * Thrown when various boundary values do not satisfy certain conditions.
 * <p> Created by Konstantin Lugowoy on 14.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.8
 */
public class BoundIncorrectException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BoundIncorrectException(String message) {
        super(message);
    }

}
