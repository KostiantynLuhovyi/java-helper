package com.lugowoy.helper.io.reading;

import java.util.Objects;

/**
 * Functional interface that performs the function of checking the read data for correctness.
 * <p>Created by LugowoyKonstantin on 29.07.2017.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface CheckerReading {

    /**
     * A string constant that defines a regular expression for a positive integer number.
     *
     * @since 1.0
     */
    String REGEX_POSITIVE_INTEGER_NUMBER = "\\d+?";

    /**
     * A string constant that defines a regular expression for a negative integer number.
     *
     * @since 1.0
     */
    String REGEX_NEGATIVE_INTEGER_NUMBER = "-\\d+?";

    /**
     * A string constant that defines a regular expression for a positive real number.
     *
     * @since 1.0
     */
    String REGEX_POSITIVE_REAL_NUMBER = "\\d+?[.]\\d+?";

    /**
     * A string constant that defines a regular expression for a negative real number.
     *
     * @since 1.0
     */
    String REGEX_NEGATIVE_REAL_NUMBER = "-\\d+?[.]\\d+?";

    /**
     * Checking the read data (string) for correctness.
     *
     * @param value Data to check.
     * @return Result of checking.
     * @since 1.0
     */
    boolean isCorrectData(String value);

    /**
     * Checking the read data is indeed an integer number and is included in a range of byte type values.
     *
     * @param numberValue Data to checking.
     * @return Result of checking.
     * @throws NullPointerException If argument numberValue is null.
     * @since 1.0
     */
    static boolean isByteNumber(String numberValue) {
        boolean result = false;
        if (Objects.nonNull(numberValue)) {
            if (isCorrectNumber(numberValue, REGEX_POSITIVE_INTEGER_NUMBER, REGEX_NEGATIVE_INTEGER_NUMBER)) {
                byte value = Byte.parseByte(numberValue);
                if (value > Byte.MIN_VALUE && value < Byte.MAX_VALUE) {
                    result = true;
                } else {
                    throw new IncorrectValueRangeException("Incorrect value in range.");
                }
            }
        } else {
            throw new NullPointerException("Argument numberValue is null.");
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of short type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isShortNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Short.parseShort(numberValue) >= (Short.MIN_VALUE + 1)) && (Short.parseShort(numberValue) <= (Short.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of integer type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isIntegerNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Integer.parseInt(numberValue) >= (Integer.MIN_VALUE + 1)) && (Integer.parseInt(numberValue) <= (Integer.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of long type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isLongNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Long.parseLong(numberValue) >= (Long.MIN_VALUE + 1)) && (Long.parseLong(numberValue) <= (Long.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed a real number and is included in a range of float type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isFloatNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                    || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
                if ((Float.parseFloat(numberValue) >= Float.MIN_VALUE) || (Float.parseFloat(numberValue) <= Float.MAX_VALUE)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed a real number and is included in a range of double type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isDoubleNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                    || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
                if ((Double.parseDouble(numberValue) >= Double.MIN_VALUE) || (Double.parseDouble(numberValue) <= Double.MAX_VALUE)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that verifies that the read data is indeed a single character.
     *
     * @param characterValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isOnlyCharacter(final String characterValue) {
        boolean result = false;
        if (characterValue != null) {
            if (characterValue.length() == 1) {
                if (Character.isDefined(characterValue.charAt(0))) {
                    result = true;
                }
            }
        }
        return result;
    }

    private static boolean isCorrectNumber(String numberValue, String regexPositiveNumber, String regexNegativeNumber) {
        if (numberValue.matches(regexPositiveNumber) || numberValue.matches(regexNegativeNumber)) {
            return true;
        } else {
            throw new NumberFormatException("Incorrect number value.");
        }
    }

    /**
     * The class exception that notifies that a value is not within the range of values.
     * <p>Created by LugowoyKonstantin on 05.06.2019.
     *
     * @author LugowoyKonstantin
     * @version 1.0
     * @since 1.6.6
     */
    //todo It may be worth putting this exception class in the .../helper/other package for general use in a project.
    final class IncorrectValueRangeException extends RuntimeException {

        /**
         * Constructs a new runtime exception with {@code null} as its
         * detail message.  The cause is not initialized, and may subsequently be
         * initialized by a call to {@link #initCause}.
         */
        public IncorrectValueRangeException() {
        }

        /**
         * Constructs a new runtime exception with the specified detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public IncorrectValueRangeException(String message) {
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
        public IncorrectValueRangeException(String message, Throwable cause) {
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
        public IncorrectValueRangeException(Throwable cause) {
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
        public IncorrectValueRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

}
