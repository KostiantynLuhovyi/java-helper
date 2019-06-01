package com.lugowoy.helper.other;

import com.lugowoy.helper.io.reading.Reading;

/**
 * Interface with static functionality for reading and providing data about the length of the array.
 * <p>Created by Konstantin Lugowoy on 02.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.0
 */
public interface LengthArray {

    /**
     * Default length of an array.
     */
    int DEFAULT_LENGTH_ARRAY = 10;

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @return The result of the length of an array.
     * @throws NullPointerException If reader is null.
     * @throws IncorrectLengthValueException If result length array value is incorrect.
     */
    static int readLengthArray(Reading reader) {
        int resultLengthArray;
        isReaderNull(reader);
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        return resultLengthArray;
    }

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @param boundLengthArray An argument whose value indicates the maximum allowable length of the array.
     * @return The result of the length of an array.
     * @throws NullPointerException If reader is null.
     * @throws IncorrectBoundValueException If bound value is incorrect.
     * @throws IncorrectLengthValueException If result length array value is incorrect.
     */
    static int readLengthArray(Reading reader, int boundLengthArray) throws IncorrectLengthValueException {
        int resultLengthArray;
        isReaderNull(reader);
        isBoundValueGreaterZero(boundLengthArray);
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        isLengthValueLessBoundValue(resultLengthArray, boundLengthArray);
        return resultLengthArray;
    }

    /**
     * Read and returns the length of an array.
     *
     * @param reader The object to read the length value.
     * @param minBoundLengthArray An argument whose value indicates the minimum allowable length of the array.
     * @param maxBoundLengthArray An argument whose value indicates the maximum allowable length of the array.
     * @throws NullPointerException If reader is null.
     * @throws IncorrectBoundValueException If bound value is incorrect.
     * @throws IncorrectLengthValueException If result length array value is incorrect.
     */
    static int readLengthArray(Reading reader, int minBoundLengthArray, int maxBoundLengthArray) {
        int resultLengthArray;
        isReaderNull(reader);
        isMaxBoundValueGreaterMinBoundValue(minBoundLengthArray, maxBoundLengthArray);
        isBoundValueGreaterZero(minBoundLengthArray);
        //todo Consider the possibility of adding a method for checking the max bound value less than the max int.
        resultLengthArray = reader.readInt();
        isLengthValueGreaterZero(resultLengthArray);
        isLengthValueGreaterOrEqualMinBoundValue(resultLengthArray, minBoundLengthArray);
        isLengthValueLessOrEqualMaxBoundValue(resultLengthArray, maxBoundLengthArray);
        return resultLengthArray;
    }

    private static void isReaderNull(Reading reader) {
        if (reader == null) {
            throw new NullPointerException("Input is not possible. Reader is : " + null);
        }
    }

    private static void isLengthValueGreaterZero(int lengthValue) {
        if (lengthValue < 0) {
            throw new IncorrectLengthValueException("Incorrect length array : " + lengthValue + ". Value less than 0.");
        }
    }

    private static void isBoundValueGreaterZero(int boundValue) {
        if (boundValue < 0) {
            throw new IncorrectBoundValueException("Incorrect bound value : " + boundValue + ". Bound value less than 0.");
        }
    }

    private static void isLengthValueLessBoundValue(int lengthValue, int boundValue) {
        if (lengthValue > boundValue) {
            throw new IncorrectLengthValueException("Incorrect value of length array. Length array value greater than bound value.");
        }
    }

    private static void isMaxBoundValueGreaterMinBoundValue(int minBoundValue, int maxBoundValue) {
        if (minBoundValue >= maxBoundValue) {
            throw new IncorrectBoundValueException("Incorrect bound values. Min bound value greater or equal than max bound value.");
        }
    }

    private static void isLengthValueLessOrEqualMaxBoundValue(int lengthValue, int maxBoundValue) {
        if (lengthValue > maxBoundValue) {
            throw new IncorrectLengthValueException("Incorrect length array. Length array value greater than max bound value.");
        }
    }

    private static void isLengthValueGreaterOrEqualMinBoundValue(int lengthValue, int minBoundValue) {
        if (lengthValue < minBoundValue) {
            throw new IncorrectLengthValueException("Incorrect length array. Length array value less than min bound value.");
        }
    }

    final class IncorrectLengthValueException extends RuntimeException {

        /**
         * Constructs a new runtime exception with {@code null} as its
         * detail message.  The cause is not initialized, and may subsequently be
         * initialized by a call to {@link #initCause}.
         */
        private IncorrectLengthValueException() {
        }

        /**
         * Constructs a new runtime exception with the specified detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        private IncorrectLengthValueException(String message) {
            super(message);
        }

        /**
         * Constructs a new runtime exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this runtime exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A {@code null} value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        private IncorrectLengthValueException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new runtime exception with the specified cause and a
         * detail message of {@code (cause==null ? null : cause.toString())}
         * (which typically contains the class and detail message of
         * {@code cause}).  This constructor is useful for runtime exceptions
         * that are little more than wrappers for other throwables.
         *
         * @param cause the cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A {@code null} value is
         *              permitted, and indicates that the cause is nonexistent or
         *              unknown.)
         * @since 1.4
         */
        private IncorrectLengthValueException(Throwable cause) {
            super(cause);
        }

        /**
         * Constructs a new runtime exception with the specified detail
         * message, cause, suppression enabled or disabled, and writable
         * stack trace enabled or disabled.
         *
         * @param message            the detail message.
         * @param cause              the cause.  (A {@code null} value is permitted,
         *                           and indicates that the cause is nonexistent or unknown.)
         * @param enableSuppression  whether or not suppression is enabled
         *                           or disabled
         * @param writableStackTrace whether or not the stack trace should
         *                           be writable
         * @since 1.7
         */
        private IncorrectLengthValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    final class IncorrectBoundValueException extends RuntimeException {

        /**
         * Constructs a new runtime exception with {@code null} as its
         * detail message.  The cause is not initialized, and may subsequently be
         * initialized by a call to {@link #initCause}.
         */
        private IncorrectBoundValueException() {
        }

        /**
         * Constructs a new runtime exception with the specified detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        private IncorrectBoundValueException(String message) {
            super(message);
        }

        /**
         * Constructs a new runtime exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this runtime exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A {@code null} value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        private IncorrectBoundValueException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new runtime exception with the specified cause and a
         * detail message of {@code (cause==null ? null : cause.toString())}
         * (which typically contains the class and detail message of
         * {@code cause}).  This constructor is useful for runtime exceptions
         * that are little more than wrappers for other throwables.
         *
         * @param cause the cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A {@code null} value is
         *              permitted, and indicates that the cause is nonexistent or
         *              unknown.)
         * @since 1.4
         */
        private IncorrectBoundValueException(Throwable cause) {
            super(cause);
        }

        /**
         * Constructs a new runtime exception with the specified detail
         * message, cause, suppression enabled or disabled, and writable
         * stack trace enabled or disabled.
         *
         * @param message            the detail message.
         * @param cause              the cause.  (A {@code null} value is permitted,
         *                           and indicates that the cause is nonexistent or unknown.)
         * @param enableSuppression  whether or not suppression is enabled
         *                           or disabled
         * @param writableStackTrace whether or not the stack trace should
         *                           be writable
         * @since 1.7
         */
        private IncorrectBoundValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }

}
