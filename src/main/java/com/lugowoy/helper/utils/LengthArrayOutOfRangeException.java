package com.lugowoy.helper.utils;

/**
 * Class exception.
 * Thrown out when the various numerical values associated with the length of the array does not satisfy certain tests.
 * <p> Created by Konstantin Lugowoy on 18.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 2.0
 */
public class LengthArrayOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LengthArrayOutOfRangeException(String message) {
        super(message);
    }

}
