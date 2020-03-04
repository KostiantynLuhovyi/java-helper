package com.lugowoy.helper.utils;

/**
 * Class exception.
 * Thrown when comparisons of various boundary values do not satisfy certain conditions.
 * <p> Created by Konstantin Lugowoy on 19.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.0
 */
public class BoundCompareException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BoundCompareException(String message) {
        super(message);
    }

}