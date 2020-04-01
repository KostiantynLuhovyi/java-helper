package com.lugowoy.helper.utils;

/**
 * Thrown when the value of the string length is out of range.
 * <p> Created by Konstantin Lugowoy on 01.04.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0
 */
public class LengthStringOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
    public LengthStringOutOfRangeException(String message) {
        super(message);
    }

}
