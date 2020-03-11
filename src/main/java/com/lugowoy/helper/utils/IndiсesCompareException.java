package com.lugowoy.helper.utils;

/**
 * Thrown when comparisons of various indices values do not satisfy certain conditions.
 * <p> Created by Konstantin Lugowoy on 10.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.7.2
 */
public class IndiсesCompareException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
    public IndiсesCompareException(String message) {
        super(message);
    }

}
