package com.lugowoy.helper.filling.array.numbers.primitives;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayIntegerPrimitives;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * The class provides the functionality to fill the class objects {@link
 * ArrayInts} and arrays of the int type with the read numeric data of the int
 * type.
 * <p>To see the functionality of read numeric data can in the class {@link
 * Reader}.
 * <p>Created by Konstantin Lugowoy on 23.03.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @since 3.0
 */
//TODO review documentation
public class FillingArrayReadPrimitiveIntegers extends FillingArrayReadValues
        implements FillingArrayIntegerPrimitives {

    /**
     * Constructs a new object, initializing the implementation of reading
     * numeric data of the int type to fill the class objects {@link ArrayInts}
     * and arrays of the int type. The implementation of data reading provided
     * by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadPrimitiveIntegers(@NotNull final Reader reader) {
        super(reader);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int
     * type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int[] ints = new int[array.size()];
        this.fillArray(ints);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param ints the array to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final int[] ints) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        this.fillArray(ints);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with the read numeric data of int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public int[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArray(ints);
        return ints;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int
     * type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code bound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code bound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final ArrayInts array, final int bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayFromZeroToBound(ints, bound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code bound}.
     *
     * @param ints the array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code bound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final int[] ints, final int bound) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(ints, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with the read numeric data of int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code bound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link BigDecimal#ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public int[] fill(final int lengthArray, final int bound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayFromZeroToBound(ints, bound);
        return ints;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int
     * type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final ArrayInts array, final int lowerBound,
                     final int upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[] ints = new int[array.size()];
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param ints the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final int[] ints, final int lowerBound,
                     final int upperBound) {
        CheckerArray.check(ints, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type
     * and fills it with the read numeric data of int type.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public int[] fill(final int lengthArray, final int lowerBound,
                      final int upperBound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        int[] ints = new int[lengthArray];
        this.fillArrayFromLowerToUpper(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillArray(final int[] ints) {
        this.fillArrayFromLowerToUpper(ints, Integer.MIN_VALUE,
                                       Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(final int[] ints, final int bound) {
        this.fillArrayFromLowerToUpper(ints, BigDecimal.ZERO.intValue(), bound);
    }

    private void fillArrayFromLowerToUpper(final int[] ints,
                                           final int lowerBound,
                                           final int upperBound) {
        int valueRead = 0;
        for (int i = 0; i < ints.length; i++) {
            while (super.getReader().hasNextInt()) {
                valueRead = super.getReader().nextInt();
                CheckerNumber.check(valueRead, lowerBound, upperBound);
            }
            ints[i] = valueRead;
        }
    }

}
