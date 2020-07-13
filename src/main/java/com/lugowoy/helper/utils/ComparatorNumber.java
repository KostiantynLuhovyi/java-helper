package com.lugowoy.helper.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The functional interface provides a functional for comparing numbers greater
 * than, less than, or equal to. Compares the number of types that inherit from
 * the {@link Number} class and implement the {@link Comparable} interface.
 * To use the function, you must declare a reference variable of the {@link
 * ComparatorNumber} type and initialize it with a reference to the static
 * {@link ComparatorNumber#compareNumber(Number, Number)} method of this class.
 * Then, to compare numbers, you must call the {@link
 * ComparatorNumber#compare(Number, Number)} method.
 * <p>
 * Created by Konstantin Lugowoy on 08.07.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see Comparable
 * @since 3.0
 */
@FunctionalInterface
public interface ComparatorNumber {

    /**
     * Compares two numbers. Returns a negative integer, zero, or a positive
     * integer as the first argument is less than, equal to, or greater than
     * the second.
     *
     * @param <T> the type of numbers to compare.
     * @param <V> the type of numbers to compare.
     * @param o1 the first number to be compared.
     * @param o2 the second number to be compared.
     *
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    <T extends Number & Comparable<T>, V extends Number & Comparable<V>> int compare(
            T o1, V o2);

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @param <T> the type of numbers to be compared.
     * @param o1 the first number to be compared.
     * @param o2 the second number to be compared.
     *
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     *
     * @throws NullPointerException if any of the arguments is null.
     * @throws NumberFormatException if any of the arguments does not have a
     * parsable string representation.
     */
    static <T extends Number & Comparable<T>, V extends Number & Comparable<V>> int compareNumber(
            final T o1, final V o2) {
        Objects.requireNonNull(o1, "Number \\'o1\\' is null.");
        Objects.requireNonNull(o2, "Number \\'o2\\' is null.");
        int result;
        if (isSpecialValue(o1) || isSpecialValue(o2)) {
            result = Double.compare(o1.doubleValue(), o2.doubleValue());
        } else {
            result = toBigDecimal(o1).compareTo(toBigDecimal(o2));
        }
        return result;
    }

    private static <T extends Number & Comparable<T>> boolean isSpecialValue(
            final T value) {
        return (isDouble(value) && isSpecialDouble(value))
                || (isFloat(value) && isSpecialFloat(value));
    }

    private static <T extends Number & Comparable<T>> BigDecimal toBigDecimal(
            final T number) {
        BigDecimal resultNumber;
        if (isBigDecimal(number)) {
            resultNumber = (BigDecimal) number;
        } else if (isBigInteger(number)) {
            resultNumber = new BigDecimal((BigInteger) number);
        } else if (isByte(number) || isShort(number) || isInteger(number)
                   || isLong(number)) {
            resultNumber = new BigDecimal(number.longValue());
        } else if (isFloat(number) || isDouble(number)) {
            resultNumber = BigDecimal.valueOf(number.doubleValue());
        } else {
            try {
                resultNumber = new BigDecimal(number.toString());
            } catch (final NumberFormatException e) {
                throw new NumberFormatException(
                        "The given number (\"" + number + "\" of class "
                        + number.getClass().getName()
                        + ") does not have a parsable string representation");
            }
        }
        return resultNumber;
    }

    private static <T extends Number & Comparable<T>> boolean isByte(
            final T value) {
        return value instanceof Byte;
    }

    private static <T extends Number & Comparable<T>> boolean isShort(
            final T value) {
        return value instanceof Short;
    }

    private static <T extends Number & Comparable<T>> boolean isInteger(
            final T value) {
        return value instanceof Integer;
    }

    private static <T extends Number & Comparable<T>> boolean isLong(
            final T value) {
        return value instanceof Long;
    }

    private static <T extends Number & Comparable<T>> boolean isFloat(
            final T value) {
        return value instanceof Float;
    }

    private static <T extends Number & Comparable<T>> boolean isSpecialFloat(
            final T value) {
        return Float.isNaN((Float) value) || Float.isInfinite((Float) value);
    }

    private static <T extends Number & Comparable<T>> boolean isDouble(
            final T value) {
        return value instanceof Double;
    }

    private static <T extends Number & Comparable<T>> boolean isSpecialDouble(
            final T value) {
        return Double.isNaN((Double) value)
                || Double.isInfinite((Double) value);
    }

    private static <T extends Number & Comparable<T>> boolean isBigInteger(
            final T number) {
        return number instanceof BigInteger;
    }

    private static <T extends Number & Comparable<T>> boolean isBigDecimal(
            final T number) {
        return number instanceof BigDecimal;
    }

}
