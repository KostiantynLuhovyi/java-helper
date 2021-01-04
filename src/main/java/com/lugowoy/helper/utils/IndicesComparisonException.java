package com.lugowoy.helper.utils;

/**
 * <p>Created by Konstantin Lugowoy on 04.01.2021.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Throwable
 * @see java.lang.Exception
 * @see java.lang.RuntimeException
 * @since 3.0.7
 */
public class IndicesComparisonException extends RuntimeException {

    public IndicesComparisonException() {
        super();
    }

    public IndicesComparisonException(final String message) {
        super(message);
    }

    public IndicesComparisonException(final String message,
                                      final Throwable cause) {
        super(message, cause);
    }

    public IndicesComparisonException(final Throwable cause) {
        super(cause);
    }

    public IndicesComparisonException(final String message,
                                      final Throwable cause,
                                      final boolean enableSuppression,
                                      final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
