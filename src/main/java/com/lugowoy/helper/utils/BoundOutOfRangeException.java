package com.lugowoy.helper.utils;

/**
 * Created by Konstantin Lugowoy on 06.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7.5
 */
//todo write doc's
public class BoundOutOfRangeException extends RuntimeException {

    public static final String MSG_POSITIVE_BOUND = "Bound is positive value";
    public static final String MSG_NEGATIVE_BOUND = "Bound is negative value";
    public static final String MSG_NON_ZERO = "Bound is not zero.";

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
