package com.lugowoy.helper.utils;

/**
 * Created by Konstantin Lugowoy on 18.10.2019.
 *
 * @since 2.0
 */
//todo write doc's
public class LengthArrayOutOfRangeException extends RuntimeException {

    private static final String MSG_EXCEPTION = "Length array is out of range (0 - " + (Integer.MAX_VALUE - 8) + ").";

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public LengthArrayOutOfRangeException() {
        super(MSG_EXCEPTION);
    }

}
